package com.techelevator;

import com.techelevator.FoodItems.FoodItem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {

    private Map<String, Slot> inventory = new TreeMap<>();

    public Map<String, Slot> getInventory() {
        return inventory;
    }

    public void updateInventory(Slot slot) {
        inventory.put(slot.getSlotID(), slot);
    }

    public void printInventory() {
        for (Map.Entry<String, Slot> slotEntry : inventory.entrySet()){
            Slot slot = slotEntry.getValue();
            String name = slot.getFoodItem().getName();
            int stock = slot.getStock();
            System.out.println(name + ": " + stock);
        }
    }
}
