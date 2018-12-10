package com.example.georg.shoppinglist;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter implements ListAdapter {
    private Category category;
    private Context context;



    public MyCustomAdapter(Category category, Context context) {
        this.category = category;
        this.context = context;
    }

    @Override
    public int getCount() {
        return category.getItems().size();
    }

    @Override
    public Object getItem(int pos) {
        return category.getItems().get(pos);
    }

    @Override
    public long getItemId(int pos) {
        //return list.get(pos).getId();
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_layout, null);
        }
        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(category.getItems().get(position).getName());

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);
        Button addBtn = (Button)view.findViewById(R.id.add_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                    category.getItems().remove(position); //or some other task
                    notifyDataSetChanged();
                    if (category.getItems().size() > 0) {
                        SharedPreferences prefRemove = context.getSharedPreferences("savedList", Context.MODE_PRIVATE);
                        SharedPreferences.Editor prefEditor = prefRemove.edit();
                        prefEditor.remove(category.getCode() + category.getItems().get(position).getName());
                        prefEditor.commit();
                    }
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    ItemListHub.getInstance().addItemToList(category.getItems().get(position));
                    notifyDataSetChanged();
                    SharedPreferences prefPut = context.getSharedPreferences("savedList", Context.MODE_PRIVATE);
                    SharedPreferences.Editor prefEditor = prefPut.edit();
                    prefEditor.putString(category.getItems().get(position).getName(), category.getItems().get(position).getName());
                    prefEditor.commit();
            }
        });

        return view;
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("savedList", Context.MODE_PRIVATE);
    }

    public static void deletePrefs(Context context, String key) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.remove(key);
        editor.commit();
    }



}