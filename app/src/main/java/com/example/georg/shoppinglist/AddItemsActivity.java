package com.example.georg.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Scanner;
import static com.example.georg.shoppinglist.MainActivity.KEY_USER;

public class AddItemsActivity extends AppCompatActivity {
    ListView lv;
    public Bundle b;
    public int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        b = getIntent().getExtras();
        //int i= b.getInt(KEY_USER,0);
        i = b.getInt(MainActivity.KEY_USER,0);

        lv = (ListView) (findViewById(R.id.itemInCategory));
        lv.setAdapter(new ArrayAdapter<Item>(
                this,
                android.R.layout.simple_list_item_1,
                ItemListHub.getInstance().getCategory(i).getItems()
        ));
    }
    public void addToList(View view){
        //Scanner reader = new Scanner(System.in);
        EditText itemName =  findViewById(R.id.itemName);
        String name = itemName.getText().toString();
        //EditText amount =  findViewById(R.id.amount);
        if (name.length() > 0) {
            //int d = Integer.parseInt(amount.getText().toString());
            Item newItem = new Item(name);
            //ItemListHub.getInstance().getItems().add(newItem);
            ItemListHub.getInstance().getCategory(i).addItem(newItem);
            //amount.setText(null);
            SharedPreferences prefPut = getSharedPreferences("savedList", Activity.MODE_PRIVATE);
            SharedPreferences.Editor prefEditor = prefPut.edit();
            prefEditor.putString(ItemListHub.getInstance().getCategory(i).getCode() + newItem.getName(), newItem.getName());
            prefEditor.commit();
            itemName.setText("");
        }
    }
}
