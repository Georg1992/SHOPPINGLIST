package com.example.georg.shoppinglist;

public class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String returnName() {
        return this.name;
    }

    public int returnQuantity() {
        return this.quantity;
    }
}
