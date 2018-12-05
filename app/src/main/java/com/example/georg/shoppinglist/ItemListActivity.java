package com.example.georg.shoppinglist;

import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class ItemListActivity extends ListActivity {

        //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
        ArrayList<String> listItems=new ArrayList<String>();

        //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
        ArrayAdapter<String> adapter;

         private static Button AddButton;

         private EditText result;


        @Override
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);

            setContentView(R.layout.activity_item_list);

            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, listItems);
            setListAdapter(adapter);


           // result = (EditText) findViewById(R.id.editTextDialogUserInput);


            Button BackButton = (Button) findViewById(R.id.button2);
            BackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ItemListActivity.this, MainActivity.class));
                }
            });

            onClickAlert();


        }








public void onClickAlert(){

    AddButton = findViewById(R.id.addBtn);
    AddButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           LayoutInflater li = LayoutInflater.from(ItemListActivity.this);
            //final View promptsView = li.inflate(R.layout.popup, null);

            AlertDialog.Builder a_builder = new AlertDialog.Builder(ItemListActivity.this);



            a_builder.setMessage("Add Item")
                    //.setView(promptsView)

                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                           addItems();
                           dialog.cancel();


                            //final EditText userInput = (EditText) promptsView
                              //      .findViewById(R.id.editTextDialogUserInput);

                        }
                    });

            AlertDialog alert = a_builder.create();

            alert.show();

            }


    });

}

    public void addItems() {

        //String getInput = result.getText().toString(); //CRASHES WHEN TRYING TO ADD USER INPUT TO THE ARRAYLIST
        String getInput = "potato";

        listItems.add(getInput);
        adapter.notifyDataSetChanged();


        }


  
    }

