package com.example.georg.shoppinglist;

import java.util.ArrayList;

public class ItemAdapter {
    private ArrayList<Item> items;

    public ItemAdapter() {
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public Item getItem(int i) {
        return this.items.get(i);
    }
}
