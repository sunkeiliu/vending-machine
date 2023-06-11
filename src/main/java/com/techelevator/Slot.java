package com.techelevator;

import com.techelevator.FoodItems.FoodItem;

public class Slot {

    private String slotID;
    private int stock = 5;
    private FoodItem foodItem;

    private int amountSold;

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

    public int getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(int amountSold) {
        this.amountSold = amountSold;
    }

    public boolean dispenseItem() {

        if (isSoldOut()) {
            System.out.println("Item chosen is OUT OF STOCK. \n");
            return false;
        }
        else if (Calculator.getBalance() < foodItem.getPrice()) {
            System.out.println("INSUFFICIENT FUNDS \n");
            return false;
        }
        else {
            Calculator.purchaseItem(foodItem.getPrice());
            stock -= 1;
            amountSold++;

            String purchaseLog = String.format("Item: %s Cost: $%.2f Remaining Balance: $%.2f", foodItem.getName(), foodItem.getPrice(), Calculator.getBalance());
            String fullResponse = purchaseLog + "\n" + foodItem.print();

            System.out.println(fullResponse);
            return true;
        }

    }

    public boolean isSoldOut() {
        return stock == 0;
    }
}
