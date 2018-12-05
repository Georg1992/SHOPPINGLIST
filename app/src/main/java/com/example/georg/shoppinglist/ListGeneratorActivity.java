package com.example.georg.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import  java.util.ArrayList;

public class ListGeneratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_generator);

        ListView listview =  findViewById(R.id.itemListView);

        listview.setAdapter(new ArrayAdapter<Item>(
                this,
                android.R.layout.simple_list_item_1,
                ItemListHub.getInstance().getItems()));

        Intent intent = getIntent();

    }
}
