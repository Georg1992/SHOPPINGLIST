package com.example.georg.shoppinglist;

import java.util.ArrayList;

public class Category {
    private ArrayList<Item> items;
    private String name;

    public Category(String name) {
        this.items = new ArrayList<Item>();
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public Item getItem(int i) {
        return this.items.get(i);
    }

    public String toString() {
        return this.name;
    }
}
