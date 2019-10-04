package com.danielkarlkvist.padelbuddy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.danielkarlkvist.padelbuddy.Controller.HomeFragmentController;

import org.junit.Test;

public class HomeFragmentControllerTest {

    private RecyclerView homeRecyclerView;
    private RecyclerView.Adapter homeRecyclerViewAdapter;
    private RecyclerView.LayoutManager homeRecyclerViewLayoutManager;

    @Test
    public void testOnCreateView(){
        HomeFragmentController hfc = new HomeFragmentController();

    }

}
