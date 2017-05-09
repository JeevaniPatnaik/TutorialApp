package com.jeevani.tutorialapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jeevani on 5/9/2017.
 */

public class CurrentTopics extends Fragment implements GlobalUtils.ItemClikListener, GlobalUtils.ButtonClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private TopicListAdapter customerListAdapter;

    private Integer[] images = {R.drawable.c_img,R.drawable.java_img,R.drawable.android_img};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("HOME");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.current_appointments, container, false);
        View view = inflater.inflate(R.layout.activity_current_topics, container, false);
        initialiseView(view, this.getActivity());
        return view;
    }

    void initialiseView(View v, Context ctx) {

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getActivity(),3);   //In a row, 3 cards will appear
        mRecyclerView.setLayoutManager(mLayoutManager);

        customerListAdapter = new TopicListAdapter(getActivity(),images);
        mRecyclerView.setAdapter(customerListAdapter);
        customerListAdapter.setOnItemClikListener(CurrentTopics.this);
    }

    @Override
    public void onItemClick(View view, int itemType, int position) {
        //Intent intent = new Intent(getActivity(), ExpandableList.class);
        Intent intent = new Intent(getActivity(), TopicLists.class);
        startActivity(intent);
    }

    @Override
    public void onButtonClick(View view, int position) {
        //startActivity(new Intent(getActivity(), AddAppointment.class));
    }
}
