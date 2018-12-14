package com.okpd.androidfilter;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.okpd.androidfilter.Adapter.ColorAdapter;
import com.okpd.androidfilter.Adapter.FontAdapter;
import com.okpd.androidfilter.Interface.AddTextFragmentListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTextFragment extends BottomSheetDialogFragment implements ColorAdapter.ColorAdapterListener, FontAdapter.FontAdapterListener {


    int colorSelected = Color.parseColor("#000000"); // Default color of text is black

    AddTextFragmentListener listener;

    EditText edt_add_text;
    RecyclerView recycler_color,recycler_font;
    Button btn_done;

    Typeface typefaceSelected = Typeface.DEFAULT;

    public void setListener(AddTextFragmentListener listener) {
        this.listener = listener;
    }

    public AddTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_add_text, container, false);

        edt_add_text = (EditText)itemView.findViewById(R.id.edt_add_text);
        btn_done = (Button)itemView.findViewById(R.id.btn_done);
        recycler_color = (RecyclerView) itemView.findViewById(R.id.recycler_color);
        recycler_color.setHasFixedSize(true);
        recycler_color.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        recycler_font = (RecyclerView) itemView.findViewById(R.id.recycler_font);
        recycler_font.setHasFixedSize(true);
        recycler_font.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        ColorAdapter colorAdapter = new ColorAdapter(getActivity(),this);
        recycler_color.setAdapter(colorAdapter);

        FontAdapter fontAdapter = new FontAdapter(getContext(),this);
        recycler_font.setAdapter(fontAdapter);

        //Event
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAddTextButtonClick(typefaceSelected,edt_add_text.getText().toString(),colorSelected);
            }
        });

        return  itemView;
    }

    static  AddTextFragment instance;

    public static AddTextFragment getInstance() {
        if(instance == null)
            instance = new AddTextFragment();
        return instance;
    }

    @Override
    public void onColorSelected(int color) {
        colorSelected = color; // Set color when user select
    }

    @Override
    public void onFontSelected(String fontName) {
        typefaceSelected = Typeface.createFromAsset(getContext().getAssets(),new StringBuilder("fonts/")
                .append(fontName).toString());
    }
}
