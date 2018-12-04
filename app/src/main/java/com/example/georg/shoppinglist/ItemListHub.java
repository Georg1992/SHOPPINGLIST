package com.example.georg.shoppinglist;

import java.util.ArrayList;

public class ItemListHub {
    private static final ItemListHub ourInstance = new ItemListHub();
    private ArrayList<Category> categories;

    public static ItemListHub getInstance() {
        return ourInstance;
    }

    private ItemListHub() {
        this.categories = new ArrayList<Category>();
        categories.add(new Category("Food"));
        categories.add(new Category("Cleaning"));
        categories.add(new Category("Pets"));
        categories.add(new Category("Clothes"));
        categories.add(new Category("Recipes"));
        categories.add(new Category("Other"));
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }

    public Category getCategory(int i) {
        return categories.get(i);
    }

}
