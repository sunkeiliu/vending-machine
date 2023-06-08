package com.techelevator;

public class Slot {

    private String slotID;
    private int stock = 5;
    private FoodItem foodItem;

    //private boolean soldOut;boolean soldOut

    public Slot(String slotID) {
        this.slotID = slotID;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void fillSlot(FoodItem foodItem){
        this.foodItem = foodItem;
    }

    public void dispenseItem() {
        if (isSoldOut()){
            System.out.println("Item chosen is OUT OF STOCK.");
        } else {
            stock -= 1;
        }

    }

    public boolean isSoldOut() {
        if (stock == 0) {
            return true;
        } else {
            return false;
        }
    }
}
