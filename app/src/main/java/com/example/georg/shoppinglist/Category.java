package com.example.georg.shoppinglist;

import java.util.ArrayList;

public class Category {
    private ArrayList<Item> items;
    private String name;
    private String code;

    public Category(String name, String code) {
        this.items = new ArrayList<Item>();
        this.code = code;
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public Item getItem(int i) {
        return this.items.get(i);
    }

    public void removeItem(int i) {
        this.items.remove(i);
    }

    public int size() {
        return this.items.size();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
