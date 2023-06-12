package com.techelevator;

import com.techelevator.Exceptions.CurrencyInputException;
import com.techelevator.Exceptions.MenuInputException;
import com.techelevator.Exceptions.SlotInputException;
import com.techelevator.FoodItems.FoodItem;
import com.techelevator.util.ConsoleUtility;

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

		// Create Sales Report Object
		SalesReport salesReport = new SalesReport();

		// Create new log.txt file or blank the existing one
		File outputFile = new File("Log.txt");
		try (PrintWriter writer = new PrintWriter(outputFile)) {

		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}

		// Load inventory from .csv read file
		File file = new File("vendingmachine.csv");

		// Read the input file and load the inventory
		try (Scanner readFile = new Scanner(file)){
			ItemLoader.loadItems(readFile, inventory);
		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}

		// Create new SalesReport.txt file
		salesReport.initializeSalesReport(inventory);

		// FIRST MENU SELECTION
		while (true) {
			// Display first menu options
			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");
			System.out.print("Select Option: ");

			String userChoiceFirst = "";

			// User selects first menu option
			try {
				userChoiceFirst = userInput.nextLine();
				validateMenu1Input(userChoiceFirst);
				System.out.print("\n");
			} catch (MenuInputException e) {
				ConsoleUtility.printError(e.getMessage());
				continue;
			}

			// If user selects "(1) Display Vending Machine Items"
			if (userChoiceFirst.equals("1")) {
				inventory.printInventory();
				System.out.print("\n");
				continue;

			// If user selects "(3) Exit"
			} else if (userChoiceFirst.equals("3")) {
				// If user wants to exit vending machine, print the full log
				break;
			}

			// If user selects "(4) Generate Sales Report" (HIDDEN OPTION)
			else if (userChoiceFirst.equals("4")) {
				salesReport.printSalesLog(inventory);
				continue;
			}

			// SECOND MENU SELECTION - IF USER SELECTS "(2) PURCHASE"
			while (true) {
				// Display second menu options
				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Transaction");
				System.out.print("Select Option: ");

				String userChoiceSecond = "";

				// User selects second menu option
				try {
					userChoiceSecond = userInput.nextLine();
					validateMenu2Input(userChoiceSecond);
					System.out.print("\n");
				} catch (MenuInputException e) {
					ConsoleUtility.printError(e.getMessage());
					continue;
				}

				// IF USER SELECTED TO LOAD MONEY
				if (userChoiceSecond.equals("1")) {
					System.out.print("Amount to load: ");

					// Prompt user for currency amount to load
					try {
						String userChoiceThird= userInput.nextLine();
						validateCurrencyInput(userChoiceThird);
						double moneyToLoad = Double.parseDouble(userChoiceThird);
						Calculator.feedMoney(moneyToLoad);
						Calculator.printStatement();
						System.out.print("\n");
						logger.addToLog("FEED MONEY:", moneyToLoad, Calculator.getBalance());

					} catch (CurrencyInputException e){
						ConsoleUtility.printError((e.getMessage() + "\n"));
					}

				// IF USER SELECTED TO PURCHASE ITEM
				} else if (userChoiceSecond.equals("2")) {
					inventory.printProducts();
					System.out.print("\n");

					// Ask user for slot ID
					System.out.print("Select Product: ");
					try {
						String slotId = userInput.nextLine();
						validateSlotInput(slotId, inventory);

						Slot slotChosen = inventory.getInventory().get(slotId);
						boolean wasDispensed = slotChosen.dispenseItem();

						FoodItem foodSelected = slotChosen.getFoodItem();
						if (wasDispensed) {
							// Add a line to logger for purchase info
							logger.addToLog(foodSelected.getName(), slotId, foodSelected.getPrice(), Calculator.getBalance());

							// Update sales report with purchase of item (add 1 to items purchase)
							salesReport.addToSalesReport(foodSelected.getName());
						}

					} catch (SlotInputException e) {
						ConsoleUtility.printError(e.getMessage());
					}

				// IF USER SELECTED TO FINISH TRANSACTION
				} else if (userChoiceSecond.equals("3")) {

					// Before returning change, store current balance in variable
					double changeToReturn = Calculator.getBalance();

					// Return change and print to console
					System.out.println(Calculator.returnChange());

					// Add to logger, using previously stored variable to represent the change that was returned
					logger.addToLog("GIVE CHANGE:", changeToReturn, Calculator.getBalance());
					break;

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
	public void validateMenu1Input(String input) throws MenuInputException {
		if (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4"))) {
			throw new MenuInputException();
		}
	}

	public void validateMenu2Input(String input) throws MenuInputException {
		if (!(input.equals("1") || input.equals("2") || input.equals("3"))) {
			throw new MenuInputException();
		}
	}

	// Let's create another method for validateCurrencyInput that checks that the user is feeding a real bill amount (0.05, 0.10, 0.25, 1.00, 5.00)
	// Throw a custom currencyException is any other input is provided
	public void validateCurrencyInput(String input) throws CurrencyInputException {
		if (!(input.equals(".25") || input.equals("1") || input.equals("5"))){
			throw new CurrencyInputException();
		}
	}

	public void validateSlotInput(String input, Inventory inventory) throws SlotInputException {
		if (!inventory.getInventory().containsKey(input)) {
			throw new SlotInputException();
		}
	}




}
