package com.example.georg.shoppinglist;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Category {
    private ArrayList<Item> items;
    private String name;
    private String code;

    Category(String name, String code) {
        this.items = new ArrayList<>();
        this.code = code;
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }
    //While creating several default categories in Global ItemListHub Class, each category will be
    //a given code-number, which can be used for naming the key in sharedPreferences data saving later

    public Item getItem(int i) {
        if (!this.items.isEmpty()) {
            return this.items.get(i);
        } else {
            return null;
        }
    }

    public void removeItem(int i) {
        if (!this.items.isEmpty()) {
            this.items.remove(i);
        }
    }

    public int size() {
        return this.items.size();
    }

    ArrayList<Item> getItems() {
        return this.items;
    }

    void addItem(Item item) {
        this.items.add(item);
    }
}
