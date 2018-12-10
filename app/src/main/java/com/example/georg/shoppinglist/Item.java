package com.example.georg.shoppinglist;

import android.support.annotation.NonNull;

public class Item {
    private String name;
    private int amount;

    private Item(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    Item(String name) {
        this(name, 0);
    }
    public String getName(){return this.name;}
    public int getAmount(){return this.amount;}
    @NonNull
    @Override
    public String toString(){return this.name;}

}



