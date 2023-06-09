package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineCLI {

	// Use this for keyboard input - it is initialized in the constructor
	private Scanner userInput;

	public VendingMachineCLI(Scanner userInput) {
		this.userInput = userInput;
	}

	public void run() {
		// Create inventory
		Inventory inventory = new Inventory();

		// Load inventory from .csv read file
		File file = new File("vendingmachine.csv");

		try (Scanner readFile = new Scanner(file)){
			ItemLoader.loadItems(readFile, inventory);
		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}

		String userChoice = "";

		while (!userChoice.equals("3")){
			// Display menu options
			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");

			// User selects menu option
			userChoice = userInput.nextLine();

			// Check menu selection
			if (userChoice.equals("1")) {
				inventory.printInventory();
				System.out.println("\n");
			} else if (userChoice.equals("3")) {
				return;
			}



		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VendingMachineCLI cli = new VendingMachineCLI(input);
		cli.run();
	}
}
