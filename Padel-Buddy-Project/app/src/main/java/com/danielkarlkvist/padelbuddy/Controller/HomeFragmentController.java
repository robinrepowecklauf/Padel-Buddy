package com.danielkarlkvist.padelbuddy.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.danielkarlkvist.padelbuddy.ExampleAdapter;
import com.danielkarlkvist.padelbuddy.ExampleItem;
import com.danielkarlkvist.padelbuddy.R;

import java.util.ArrayList;

public class HomeFragmentController extends Fragment {

    private RecyclerView homeRecyclerView;
    private RecyclerView.Adapter homeRecyclerViewAdapter;
    private RecyclerView.LayoutManager homeRecyclerViewLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        //Example RecycleView
        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 1", "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 3", "Line 4"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 5", "Line 6"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 7", "Line 8"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 9", "Line 10"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 11", "Line 12"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 13", "Line 14"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 15", "Line 16"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 17", "Line 18"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 19", "Line 20"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 21", "Line 22"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 23", "Line 24"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 25", "Line 26"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 27", "Line 28"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 29", "Line 30"));

        homeRecyclerView = rootView.findViewById(R.id.recyclerView);
        homeRecyclerView.setHasFixedSize(true);
        homeRecyclerViewLayoutManager = new LinearLayoutManager(getActivity());    //getActivity instead of this when used in fragment?
        homeRecyclerViewAdapter = new ExampleAdapter(exampleList);

        homeRecyclerView.setLayoutManager(homeRecyclerViewLayoutManager);
        homeRecyclerView.setAdapter(homeRecyclerViewAdapter);

        return rootView;
    }
}
