package com.example.georg.shoppinglist;

import java.util.ArrayList;

public class Category {
    private ArrayList<Item> items;

    public Category() {
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public Item getItem(int i) {
        return this.items.get(i);
    }
}
