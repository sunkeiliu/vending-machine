package com.techelevator;

import com.techelevator.Exceptions.MenuInputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

		// Create a logger
		Logger logger = new Logger();

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

			String userChoiceFirst = "";

			// User selects first menu option
			try {
				userChoiceFirst = userInput.nextLine();
				validateMenuInput(userChoiceFirst);
			} catch (MenuInputException e) {
				System.out.println(e.getMessage());
				continue;
			}

			// Check menu selection
			if (userChoiceFirst.equals("1")) {
				inventory.printInventory();
				System.out.println("\n");
			} else if (userChoiceFirst.equals("3")) {
				// If user wants to exit vending machine, print the full log
				logger.printLog();
				break;
			}


			while (true) {
				// Display second menu options
				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Transaction");

				String userChoiceSecond = "";

				// User selects second menu option
				try {
					userChoiceSecond = userInput.nextLine();
					validateMenuInput(userChoiceSecond);
				} catch (MenuInputException e) {
					System.out.println(e.getMessage());
					continue;
				}

				// Create a printWriter that we can use for the logger


				// Check menu selection
				if (userChoiceSecond.equals("1")) {
					System.out.print("Amount to load: ");
					double moneyToLoad = Double.parseDouble(userInput.nextLine());
					Calculator.feedMoney(moneyToLoad);
					Calculator.printStatement();
					logger.addToLog("FEED MONEY: ", moneyToLoad, Calculator.getBalance());

				} else if (userChoiceSecond.equals("2")) {
					inventory.printProducts();
					System.out.println("\n");

					// Ask user for slot ID
					System.out.print("Select Product: ");
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

	// Let's create a method for validateMenuInput that simply checks if the user correctly inputs 1, 2, or 3
	// Throw a custom inputException if any other input is provided
	public void validateMenuInput(String input) throws MenuInputException {
		if (!(input.equals("1") || input.equals("2") || input.equals("3"))) {
			throw new MenuInputException();
		}
	}

	// Let's create another method for validateCurrencyInput that checks that the user is feeding a real bill amount (0.05, 0.10, 0.25, 1.00, 5.00)
	// Throw a custom currencyException is any other input is provided


}
