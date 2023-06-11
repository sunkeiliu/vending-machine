package com.techelevator;

import java.math.BigDecimal;

public class Calculator {

    private static double balance = 0;
    public static double totalAmount = 0;

    public static double getBalance() {
        return balance;
    }

    public static double getTotalAmount() {
        return totalAmount;
    }

    public static void setTotalAmount(double newAmount) {
        totalAmount = newAmount;
    }

    public static void setBalance(double updatedBalance) {
        balance = updatedBalance;
    }

    public static void feedMoney(double moneyInserted) {
        balance += moneyInserted;
    }

    public static void purchaseItem(double itemCost) {
        totalAmount += itemCost;
        balance -= itemCost;
    }

    public static String returnChange() {
        BigDecimal changeToReturn = BigDecimal.valueOf(balance);

        int quartersCounter = 0;
        int dimesCounter = 0;
        int nickelsCounter = 0;

        BigDecimal quarter = BigDecimal.valueOf(.25);
        BigDecimal dime = BigDecimal.valueOf(.10);
        BigDecimal nickel = BigDecimal.valueOf(.05);
        BigDecimal nearZero = BigDecimal.valueOf(0.001);

        while (changeToReturn.compareTo(nearZero) == 1) {

            while (changeToReturn.compareTo(quarter) == 1 || changeToReturn.compareTo(quarter) == 0) {
                changeToReturn = changeToReturn.subtract(quarter);
                quartersCounter++;
            }
            while (changeToReturn.compareTo(dime) == 1 || changeToReturn.compareTo(dime) == 0) {
                changeToReturn = changeToReturn.subtract(dime);
                dimesCounter++;
            }
            while (changeToReturn.compareTo(nickel) == 1 || changeToReturn.compareTo(nickel) == 0) {
                changeToReturn = changeToReturn.subtract(nickel);
                nickelsCounter++;
            }
        }
        setBalance(0);
        String response = "Change returned: " + quartersCounter + " quarter(s), " + dimesCounter + " dime(s), " + nickelsCounter + " nickel(s). \n";
        return response;
    }

    public static void printStatement() {
        System.out.println(String.format("Current money provided: $%.2f", balance));
    }

}
