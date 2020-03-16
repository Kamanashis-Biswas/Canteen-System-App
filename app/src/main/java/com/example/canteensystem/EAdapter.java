package com.example.canteensystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EAdapter extends RecyclerView.Adapter<EAdapter.ExampleViewHolder> {
    private ArrayList<LItem> eitem = new ArrayList<>();

    public static  class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView mimageview;
        public TextView mtv1;
        public TextView mtv2;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mimageview = itemView.findViewById(R.id.imageview);
            mtv1 = itemView.findViewById(R.id.tv1);
            mtv2 = itemView.findViewById(R.id.tv2);
        }
    }


    public EAdapter(ArrayList<LItem> litem){
        eitem = litem;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.litem, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        LItem citem = eitem.get(position);
        holder.mimageview.setImageResource(citem.getMimageresouce());
        holder.mtv1.setText(citem.getMtext1());
        holder.mtv2.setText(citem.getMtext2());
    }

    @Override
    public int getItemCount() {
        return eitem.size();
    }
}
