package com.techelevator.FoodItems;

public class Chips extends FoodItem{

    public Chips(String name, double price) {
        super(name, price);
    }

    @Override
    public void print() {
        System.out.println("Crunch Crunch, Yum! \n");
    }
}
