package com.example.georg.shoppinglist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListGeneratorActivity extends AppCompatActivity {
    //this Activity is to generate the saved Items list.
    //this activity is enabled when user goes shopping and starts using this list.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_generator);

        Intent intent = getIntent();
        ListView listview =  findViewById(R.id.itemListView);
        SavedListAdapter adapter = new SavedListAdapter(ItemListHub.getInstance().getItems(),this);
        listview.setAdapter(adapter);

    }

}
