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

public class SavedListAdapter extends BaseAdapter implements ListAdapter {
    //This adapter is used to view the listView in ListGeneratorActivity. This class take to use the
    //saved_list_layout layout, which includes one button one listView.
    //By using this, we can make sure that every item of the listView in AddItemActivity will have
    //that Delete button.
    private ArrayList<Item> list;
    private Context context;

    public SavedListAdapter(ArrayList<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int pos) {
        return this.list.get(pos);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //this class use the layout of saved_list_layout by using this syntax.
            view = inflater.inflate(R.layout.saved_list_layout, null);
        }
        //Handle TextView and display Items from Category
        TextView savedItemsText = (TextView)view.findViewById(R.id.savedItem_List);
        savedItemsText.setText(this.list.get(i).toString());

        //Handle buttons and add onClickListeners
        Button deleteButton = (Button)view.findViewById(R.id.deleteFromList_button);

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //remove item from that category
                list.remove(i);
                notifyDataSetChanged();
                if (list.size() > 0) {
                    SharedPreferences prefRemove = context.getSharedPreferences("savedList", Context.MODE_PRIVATE);
                    SharedPreferences.Editor prefEditor = prefRemove.edit();
                    prefEditor.remove("ShoppingList" + list.get(i).getName());
                    prefEditor.commit();
                }
            }
        });

        return view;
    }

}