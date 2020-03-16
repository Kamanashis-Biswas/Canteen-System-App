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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MessageFragment extends Fragment {

    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager mlayoutmanager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = (View)inflater.inflate(R.layout.fragment_message, container, false);

       ArrayList<LItem> item = new ArrayList<>();
       item.add(new LItem(R.drawable.ic_android, "Line 1", "LIne 2"));
       item.add(new LItem(R.drawable.ic_android, "Line 1", "LIne 2"));
       item.add(new LItem(R.drawable.ic_android, "Line 1", "LIne 2"));
       item.add(new LItem(R.drawable.ic_android, "Line 1", "LIne 2"));

        RecyclerView recyclerView = view.findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        madapter = new EAdapter(item);
        recyclerView.setAdapter(madapter);
        return view;


    }


}
