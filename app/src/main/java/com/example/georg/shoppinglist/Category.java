package com.example.georg.shoppinglist;

import java.util.ArrayList;

public class Category {
    private ArrayList<Item> items;
    private String name;
    private int code;

    public Category(String name, int code) {
        this.items = new ArrayList<Item>();
        this.code = code;
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public int getCode() {
        return this.code;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
