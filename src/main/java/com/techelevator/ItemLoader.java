package com.techelevator;

import java.util.Scanner;

public class ItemLoader {

    public static void loadItems(Scanner readFile) {

        /*
        Each cycle of the "while" loop creates one slotItem array
        This slotItem array has:
            a slot id at index 0
            a food name at index 1
            a food price at index 2
            a product type at index 3
        We need that slot id to create a new Slot object
        We need the product type to create a new FoodItem object
            we need to first determine which FoodItem class to create (chips, candy, drink, gum)
        Once we know which FoodItem object to create, we can create the object and pass the food name and food price into the constructor
        Once we have finished creating a new Slot and a new FoodItem, add the new Slot to the overall Inventory
        */

        // Create a new inventory
        Inventory inventory = new Inventory();

        // Loop through text file - create array for each line (split by pipe)
        while (readFile.hasNextLine()) {

            // Create slotItem array for line being read
            String[] slotItem = readFile.nextLine().split("\\|");

            // Assign contents of slotItem array to local variables
            String id = slotItem[0];
            String foodName = slotItem[1];
            Double foodPrice = Double.parseDouble(slotItem[2]);
            String foodType = slotItem[3];

            // Create new slot object for a slot to fill with this info
            Slot slotToFill = new Slot(id);

            if (foodType.equals("Chip")){
                Chips newChip = new Chips(foodName, foodPrice);
                slotToFill.fillSlot(newChip);

            } else if (foodType.equals("Candy")){
                Candy newCandy = new Candy (foodName, foodPrice);
                slotToFill.fillSlot(newCandy);

            } else if (foodType.equals("Drink")) {
                Drink newDrink = new Drink (foodName, foodPrice);
                slotToFill.fillSlot(newDrink);

            } else if (foodType.equals("Gum")) {
                Gum newGum = new Gum (foodName, foodPrice);
                slotToFill.fillSlot(newGum);
            }

            // Update inventory with new filled slot
            inventory.updateInventory(slotToFill);
        }

    }

}
