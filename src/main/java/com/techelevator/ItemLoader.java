package com.techelevator;

import java.util.Scanner;

public class ItemLoader {

    public static void fillSlots(Scanner readFile) {

        // Loop through text file - create array for each line (split by pipe)
        while (readFile.hasNextLine()) {

            // Create slotItem array for line being read
            String[] slotItem = readFile.nextLine().split("\\|");

            // Create new slot object for a slot to fill with this info
            Slot slotToFill = new Slot(slotItem[0], 5);
            //
            if (slotItem[3].equals("Chip")){
                Chips newChip = new Chips(slotItem[1], Double.parseDouble(slotItem[2]));
                slotToFill.fillSlot(newChip);
            }else if (slotItem[3].equals("Candy")){
                Candy newCandy = new Candy (slotItem[1], Double.parseDouble(slotItem[2]));
                slotToFill.fillSlot(newCandy);
            } else if (slotItem[3].equals("Drink")) {
                Drink newDrink = new Drink (slotItem[1], Double.parseDouble(slotItem[2]));
                slotToFill.fillSlot(newDrink);
            } else if (slotItem[3].equals("Gum")) {
                Gum newGum = new Gum (slotItem[1], Double.parseDouble(slotItem[2]));
                slotToFill.fillSlot(newGum);
            }

            // Update inventory with new filled slot
            Inventory.updateInventory(slotToFill);
        }

    }

}
