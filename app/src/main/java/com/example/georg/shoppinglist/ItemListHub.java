package com.example.georg.shoppinglist;

import java.util.ArrayList;

public class ItemListHub {
    private static final ItemListHub ourInstance = new ItemListHub();
    private ArrayList<Category> categories;
    private ArrayList<Item> items;

    public static ItemListHub getInstance() {
        return ourInstance;
    }

    public ItemListHub() {
        this.items = new ArrayList<Item>();
        items.add(new Item("food", 90));
        this.categories = new ArrayList<Category>();
        categories.add(new Category("F00D"));
        categories.add(new Category("CLEANING"));
        categories.add(new Category("PETS"));
        categories.add(new Category("CLOTHES"));
        categories.add(new Category("RECIPES"));
        categories.add(new Category("OTHER"));
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }

    public Category getCategory(int i) {
        return categories.get(i);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public Item getItem(int i) {
        return items.get(i);
    }





}
