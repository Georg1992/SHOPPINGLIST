package com.example.georg.shoppinglist;

import java.util.Scanner;

public class Item {
    private String name;
    private int amount;

    public Item(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    public Item(String name) {
        this(name, 0);
    }
    public String getName(){return this.name;}
    public int getAmount(){return this.amount;}
    public String toString(){return this.name;}

}



