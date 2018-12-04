package com.example.georg.shoppinglist;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class ItemListActivity extends ListActivity {

        //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
        ArrayList<String> listItems=new ArrayList<String>();

        //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
        ArrayAdapter<String> adapter;



        @Override
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            setContentView(R.layout.activity_item_list);

            adapter=new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    listItems);
            setListAdapter(adapter);

            Button BackButton = (Button) findViewById(R.id.button2);
            BackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ItemListActivity.this, MainActivity.class));
                }
            });

            toCategories();

        }
        public void toCategories(){


}

        public void addItems(View v) {

            listItems.add("Clicked");
            adapter.notifyDataSetChanged();
        }




  
    }

