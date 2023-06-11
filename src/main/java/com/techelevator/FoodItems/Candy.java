package com.techelevator.FoodItems;

public class Candy extends FoodItem{
    public Candy(String name, double price) {
        super(name, price);
    }

    @Override
    public String print() {
        return "Munch Munch, Yum! \n";
    }
}
