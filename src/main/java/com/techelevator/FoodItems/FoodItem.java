package com.techelevator.FoodItems;

public abstract class FoodItem {

    private String name;
    private double price;

    public FoodItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public abstract void print();

}
