package com.example.georg.shoppinglist;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;


public class AddItemsActivity extends AppCompatActivity {
    ListView lv;
    public Bundle b;
    public int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
        //getSupportActionBar().setTitle("Add Items To List");

        b = getIntent().getExtras();
        i = b.getInt(MainActivity.KEY_USER,0);

        lv = (ListView) (findViewById(R.id.itemInCategory));

        MyCustomAdapter adapter = new MyCustomAdapter(ItemListHub.getInstance().getCategory(i), this);
        lv.setAdapter(adapter);
    }
    public void addToCategory(View view){
       //add Item to Category

        EditText itemName =  findViewById(R.id.itemName);
        String name = itemName.getText().toString();
        if (name.length() > 0) {
            Item newItem = new Item(name);
            ItemListHub.getInstance().getCategory(i).addItem(newItem);

            //save the added item into corresponding Category, via sharedPreferences. The key of the item will
            //be categoryCode + itemName. The value is itemName.

            SharedPreferences prefPut = getSharedPreferences("savedList", Activity.MODE_PRIVATE);
            SharedPreferences.Editor prefEditor = prefPut.edit();
            prefEditor.putString(ItemListHub.getInstance().getCategory(i).getCode() + newItem.getName(), newItem.getName());
            prefEditor.commit();
            itemName.setText("");
        }
    }
}
