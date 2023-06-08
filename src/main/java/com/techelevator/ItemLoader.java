package com.techelevator;

import java.util.Scanner;

public class ItemLoader {

    public static void fillSlots(Scanner readFile) {

        // Loop through text file - create array for each line (split by pipe)
        while (readFile.hasNextLine()) {

            // Create slotItem array for line being read
            String[] slotItem = readFile.nextLine().split("\\|");

            // Create new slot object for a slot to fill with this info
            Slot slotToFill = new Slot();

            // Fill slot object with this info
            slotToFill.fillSlot(slotItem);

            // Update inventory with new filled slot
            Inventory.updateInventory(slotToFill);
        }

    }

}
