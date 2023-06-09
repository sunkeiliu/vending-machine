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

		// Create calculator
		Calculator calculator = new Calculator();

		// Load inventory from .csv read file
		File file = new File("vendingmachine.csv");

		try (Scanner readFile = new Scanner(file)){
			ItemLoader.loadItems(readFile, inventory);
		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}

		while (true) {
			// Display first menu options
			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");

			// User selects first menu option
			String userChoiceFirst = userInput.nextLine();

			// 	WE NEED TO ADD EXCEPTION HANDLING FOR USER SELECTION
			// Check menu selection
			if (userChoiceFirst.equals("1")) {
				inventory.printInventory();
				System.out.println("\n");
			} else if (userChoiceFirst.equals("3")) {
				break;
			}

			while (true) {
				// Display second menu options
				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Transaction");

				// User selects second menu option
				String userChoiceSecond = userInput.nextLine();

				// Check menu selection

				// Ask Yoav what loading money looks like
				if (userChoiceSecond.equals("1")) {
					System.out.print("Amount to load: ");
					double moneyToLoad = Double.parseDouble(userInput.nextLine());
					calculator.feedMoney(moneyToLoad);
					calculator.printStatement();

				} else if (userChoiceSecond.equals("2")) {
					inventory.printProducts();
					System.out.println("\n");

					// Ask user for slot ID
					String slotId = userInput.nextLine();
					Slot slotChosen = inventory.getInventory().get(slotId);
				}
			}

		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VendingMachineCLI cli = new VendingMachineCLI(input);
		cli.run();
	}
}
