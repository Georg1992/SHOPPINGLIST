package com.example.georg.shoppinglist;

import android.support.annotation.NonNull;

public class Item {
    private String name;
    private int amount;

    Item(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    Item(String name) {
        //the default amount of item is 1
        this(name, 1);
    }

    public String getName(){return this.name;}
    public int getAmount(){return this.amount;}
    @NonNull
    @Override
    public String toString(){return this.name + ": " + this.amount;}

}



