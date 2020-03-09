package com.example.canteensystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageFragment extends Fragment {
    private RecyclerView mrecylerview;
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager mlayoutmanager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ArrayList<Item> item = new ArrayList<>();
//        item.add(new Item(R.drawable.ic_add_box_black_24dp, "Line1", "Line2"));
//        item.add(new Item(R.drawable.ic_add_box_black_24dp, "Line1", "Line2"));
//        item.add(new Item(R.drawable.ic_add_box_black_24dp, "Line1", "Line2"));
//
//        mrecylerview = container.findViewById(R.id.recylerview);
//        mrecylerview.setHasFixedSize(true);
//        mlayoutmanager = new LinearLayoutManager(container.getContext());
//        madapter = new EAdapter(item);
//        mrecylerview.setLayoutManager(mlayoutmanager);
//        mrecylerview.setAdapter(madapter);
//
////    return inflater.inflate(R.layout.fragment_message, mrecylerview, false);
        return inflater.inflate(R.layout.fragment_message, container,false);



    }
}
