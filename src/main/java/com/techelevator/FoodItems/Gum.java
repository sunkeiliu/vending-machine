package com.techelevator.FoodItems;

public class Gum extends FoodItem{

    public Gum(String name, double price) {
        super(name, price);
    }

    @Override
    public void print() {
        System.out.println("Chew Chew, Yum! \n");

    }
}
