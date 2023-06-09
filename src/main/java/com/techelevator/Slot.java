package com.techelevator;

import com.techelevator.FoodItems.FoodItem;

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
        if (isSoldOut()) {
            System.out.println("Item chosen is OUT OF STOCK. \n");
        }
        else if (Calculator.getBalance() < foodItem.getPrice()) {
            System.out.println("INSUFFICIENT FUNDS \n");
        }
        else {
            Calculator.purchaseItem(foodItem.getPrice());
            String purchaseLog = String.format("Item: %s Cost: $%.2f Remaining Balance: $%.2f", foodItem.getName(), foodItem.getPrice(), Calculator.getBalance());
            System.out.println(purchaseLog);
            foodItem.print();
            stock -= 1;
        }

    }

    public boolean isSoldOut() {
        return stock == 0;
    }
}
