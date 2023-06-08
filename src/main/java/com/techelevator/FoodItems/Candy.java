package com.techelevator.FoodItems;

public class Candy extends FoodItem{
    public Candy(String name, double price) {
        super(name, price);
    }

    @Override
    public void print() {
        System.out.println("Munch Munch, Yum!");
    }
}
