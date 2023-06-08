package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Slot> inventory = new HashMap<>();

    public Map<String, Slot> getInventory() {
        return inventory;
    }

    public void updateInventory(Slot slot) {
        inventory.put(slot.getSlotID(), slot);
    }

    public void printInventory() {

    }
}
