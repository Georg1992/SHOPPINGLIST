package com.example.georg.shoppinglist;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class Saved_Lists extends ListActivity {

    private TextView YourLists;

    private ListView SavedLists;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_saved__lists);




    }
}
