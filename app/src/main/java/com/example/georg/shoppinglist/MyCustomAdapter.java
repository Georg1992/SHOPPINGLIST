package com.example.georg.shoppinglist;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

public class MyCustomAdapter extends BaseAdapter implements ListAdapter {
    //this adapter is used to view the listView in AddItemActivity. This class take to use the
    //custom_layout layout, which includes 2 buttons(add and delete), one textEdit and one listView.
    //By using this, we can make sure that every item of the listView in AddItemActivity will have
    //those 2 buttons and one textEdit (where user can enter input).
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
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //this class use the layout of custom_layout by using this syntax.
            view = inflater.inflate(R.layout.custom_layout, null);
        }
        //Handle TextView and display Items from Category
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(category.getItem(i).getName());

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.deleteFromList_button);
        Button addBtn = (Button)view.findViewById(R.id.add_btn);
        final EditText editAmount = (EditText)view.findViewById(R.id.editAmount);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //remove item from that category
                    category.getItems().remove(i);
                    notifyDataSetChanged();
                    if (category.getItems().size() > 0) {
                        SharedPreferences prefRemove = context.getSharedPreferences("savedList", Context.MODE_PRIVATE);
                        SharedPreferences.Editor prefEditor = prefRemove.edit();
                        prefEditor.remove(category.getCode() + category.getItem(i).getName());
                        prefEditor.commit();
                    }
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //add item on the savedItem list
                Item newItem = new Item(category.getItem(i).getName());
                if (editAmount == null) {
                } else {
                    String amount = editAmount.getText().toString();
                    int amountNumber = Integer.parseInt(amount);
                    newItem = new Item(category.getItem(i).getName(), amountNumber);
                    editAmount.setText("");
                }

                    ItemListHub.getInstance().addItemToList(newItem);
                    notifyDataSetChanged();

                    SharedPreferences prefPut = context.getSharedPreferences("savedList", Context.MODE_PRIVATE);
                    SharedPreferences.Editor prefEditor = prefPut.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(newItem);
                    prefEditor.putString("ShoppingList" + newItem.getName(), json);
                    //prefEditor.putString(category.getItem(i).getName(), category.getItem(i).getName());
                    prefEditor.commit();
            }
        });

        return view;
    }

}