package com.techelevator.FoodItems;

public class Chips extends FoodItem{

    public Chips(String name, double price) {
        super(name, price);
    }

    @Override
    public String print() {
        return "Crunch Crunch, Yum! \n";
    }
}
