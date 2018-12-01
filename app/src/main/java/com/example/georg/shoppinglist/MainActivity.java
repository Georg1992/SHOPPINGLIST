package com.example.georg.shoppinglist;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Show Log";
    private static final String KEY_USER = "com.example.ShoppingList";
    private ListView lv;
    private ItemAdapter items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.mainListView);

        SharedPreferences prefGet = getSharedPreferences(KEY_USER, Activity.MODE_PRIVATE);
        items = (ItemAdapter) prefGet.getStringSet(KEY_USER, null);

        lv.setAdapter(new ArrayAdapter<Item>(
                this,
                android.R.layout.simple_list_item_1,
                (List<Item>) items
        ));

        Log.d(TAG, "Activity created");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activity restarted");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefPut = getSharedPreferences(KEY_USER, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.put
        Log.d(TAG, "Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity destroyed");
    }
}
