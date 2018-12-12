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
        //this global class makes sure that it is able to return 2 arrayLists when it is called.
        //First, the list of Categories.
        //Second, the list of saved Items (shopping list)
        this.items = new ArrayList<Item>();
        this.categories = new ArrayList<Category>();
        categories.add(new Category("FOOD", "0000"));
        categories.add(new Category("SNACKS", "1111"));
        categories.add(new Category("CLOTHES", "2222"));
        categories.add(new Category("PETS", "3333"));
        categories.add(new Category("PERSONAL HYGIENE", "4444"));
        categories.add(new Category("OTHER", "5555"));
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
        if (!this.items.isEmpty()) {
            return items.get(i);
        } else {
            return null;
        }
    }

    public void addItemToList(Item item) {
        this.items.add(item);
    }





}
