package com.techelevator.FoodItems;

public class Gum extends FoodItem{

    public Gum(String name, double price) {
        super(name, price);
    }

    @Override
    public String print() {
        return "Chew Chew, Yum! \n";

    }
}
