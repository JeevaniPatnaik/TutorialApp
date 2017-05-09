package com.jeevani.tutorialapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jeevani on 5/9/2017.
 */

public class ExpandableList extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        expandableListView = (ExpandableListView) findViewById(R.id.exList);
        initData();
        expandableListAdapter = new ExpandListAdapter(this,listDataHeader,listHashMap);
        expandableListView.setAdapter(expandableListAdapter);

    }

    private void initData(){

        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("Introduction");
        listDataHeader.add("Class");
        listDataHeader.add("Object");
        listDataHeader.add("Inheritance");
        listDataHeader.add("Encapsulation");
        listDataHeader.add("Abstraction");
        listDataHeader.add("Polymerphism");
        listDataHeader.add("Interface");
        listDataHeader.add("Abstract Class");
        listDataHeader.add("Packages");

        /*List<String> stringList1 = new ArrayList<>();
        stringList1.add("Expandable Introduction");

        List<String> stringList = new ArrayList<>();
        stringList.add("1.1. Introduction");
        stringList.add("1.2. Introduction");
        stringList.add("1.3. Introduction");
        stringList.add("1.4. Introduction");

        List<String> stringList2 = new ArrayList<>();
        stringList2.add("2.1. Introduction");
        stringList2.add("2.2. Introduction");
        stringList2.add("2.3. Introduction");
        stringList2.add("2.4. Introduction");

        listHashMap.put(listDataHeader.get(0),stringList1);
        listHashMap.put(listDataHeader.get(1),stringList);
        listHashMap.put(listDataHeader.get(2),stringList2);*/


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

    }
}
