package com.techelevator.FoodItems;

public class Drink extends FoodItem{

    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public String print() {
        return "Glug Glug, Yum! \n";
    }
}
