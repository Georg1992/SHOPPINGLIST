package com.example.georg.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Show Log";
    protected static final String KEY_USER = "com.example.ShoppingList";
    private ListView lv;
    private Category items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configSwitchButton(); //Temporary switch activity method


        lv = (ListView) findViewById(R.id.categoryListView);

        lv.setAdapter(new ArrayAdapter<Category>(
                this,
                android.R.layout.simple_list_item_1,
                ItemListHub.getInstance().getCategories()
        ));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long d) {


                Log.d(TAG, "onItemClick(" + i + ")");
                Intent nextActivity = new Intent(MainActivity.this, AddItemsActivity.class);
                nextActivity.putExtra(KEY_USER, i);
                startActivity(nextActivity);
            }
        });

        //Log.d(TAG, "Activity created");
    }


    public void configSwitchButton() {
        Button SwitchButton = (Button) findViewById(R.id.savedLists);
      SwitchButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(MainActivity.this, Saved_Lists.class));
          }
          //Temporary switch activity method

      });
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
