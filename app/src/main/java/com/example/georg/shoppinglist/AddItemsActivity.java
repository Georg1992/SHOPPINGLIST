package com.example.georg.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Scanner;

import static com.example.georg.shoppinglist.MainActivity.KEY_USER;

public class AddItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        Bundle b= getIntent().getExtras();
        int i=b.getInt(KEY_USER,0);
    }
    public void addToList(View view){
        //Scanner reader = new Scanner(System.in);
        EditText itemName =  findViewById(R.id.itemName);
        EditText amount =  findViewById(R.id.amount);

        int d = Integer.parseInt(amount.getText().toString());
        ItemListHub.getInstance().getItems().add(new Item(itemName.getText().toString(),d));
        itemName.setText("");
        amount.setText(null);

    }

    public void previewList(View view){
        Intent nextActivity = new Intent( this, ListGeneratorActivity.class);
        //nextActivity.putExtra(KEY_USER);
        startActivity(nextActivity);
    }
}
