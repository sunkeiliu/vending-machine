package com.techelevator.FoodItems;

public class Drink extends FoodItem{

    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public void print() {
        System.out.println("Glug Glug, Yum! \n");
    }
}
