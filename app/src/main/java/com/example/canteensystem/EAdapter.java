package com.example.canteensystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EAdapter extends RecyclerView.Adapter<EAdapter.ExampleViewHolder>{
    private  ArrayList<Item> mexamplelist;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView mtv1;
        public TextView mtv2;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            mtv1 = itemView.findViewById(R.id.tv1);
            mtv2 = itemView.findViewById(R.id.tv2);

        }
    }

    public EAdapter(ArrayList<Item> elist){
        mexamplelist = elist;

    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ExampleViewHolder evh  = new ExampleViewHolder(view);
        return  evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Item currentitem = mexamplelist.get(position);
        holder.image.setImageResource(currentitem.getmImage());
        holder.mtv1.setText(currentitem.getText1());;
        holder.mtv2.setText(currentitem.getText2());
    }

    @Override
    public int getItemCount() {
        return mexamplelist.size();
    }
}
