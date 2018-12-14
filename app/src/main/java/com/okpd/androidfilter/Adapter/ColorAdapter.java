package com.okpd.androidfilter.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.okpd.androidfilter.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewholder> {

    Context context;
    List<Integer> colorList;
    ColorAdapterListener listener;

    public ColorAdapter(Context context, ColorAdapterListener listener) {
        this.context = context;
        this.colorList = genColorList();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ColorViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.color_item,parent,false);
        return new ColorViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewholder holder, int position) {
        holder.color_section.setCardBackgroundColor(colorList.get(position));
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ColorViewholder extends RecyclerView.ViewHolder {

        public CardView color_section;

        public ColorViewholder(@NonNull View itemView) {
            super(itemView);
            color_section = (CardView)itemView.findViewById(R.id.color_section);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onColorSelected(colorList.get(getAdapterPosition()));
                }
            });
        }
    }


    private List<Integer> genColorList() {
        List<Integer> colorList = new ArrayList<>();

        colorList.add(Color.parseColor("#761119"));
        colorList.add(Color.parseColor("#94b7bc"));
        colorList.add(Color.parseColor("#333333"));
        colorList.add(Color.parseColor("#ff3333"));
        colorList.add(Color.parseColor("#666666"));
        colorList.add(Color.parseColor("#da7b93"));
        colorList.add(Color.parseColor("#ffa500"));
        colorList.add(Color.parseColor("#ffc0cb"));
        colorList.add(Color.parseColor("#c70151"));
        colorList.add(Color.parseColor("#195d76"));
        colorList.add(Color.parseColor("#b989a0"));
        colorList.add(Color.parseColor("#122f3c"));
        colorList.add(Color.parseColor("#587887"));
        colorList.add(Color.parseColor("#0b3e5f"));
        colorList.add(Color.parseColor("#020e13"));
        colorList.add(Color.parseColor("#021d2f"));
        colorList.add(Color.parseColor("#041f33"));
        colorList.add(Color.parseColor("#052836"));
        colorList.add(Color.parseColor("#03314a"));
        colorList.add(Color.parseColor("#05121f"));
        colorList.add(Color.parseColor("#0d6eb8"));
        colorList.add(Color.parseColor("#b40037"));

        return colorList;
    }

    public interface ColorAdapterListener{
        void onColorSelected(int color);
    }
}
