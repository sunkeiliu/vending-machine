package com.techelevator;

public class Calculator {

    private static double balance = 0;

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double updatedBalance) {
        balance = updatedBalance;
    }

    public static void feedMoney(double moneyInserted) {
        balance += moneyInserted;
    }

    public static void purchaseItem(double itemCost) {
        balance -= itemCost;
    }

    public static double[] returnChange() {
        double changeToReturn = balance;
        int quartersCounter = 0;
        int dimesCounter = 0;
        int nickelsCounter = 0;

        double quarter = 0.25;
        double dime = 0.10;
        double nickel = 0.05;

        while (changeToReturn > 0){
            while (changeToReturn >= 0.25){
                changeToReturn -= quarter;
                quartersCounter++;
            }
            while (changeToReturn >= 0.10){
                changeToReturn -= dime;
                dimesCounter++;
            }
            while (changeToReturn >= 0.05){
                changeToReturn -= nickel;
                nickelsCounter++;
            }
        }
        System.out.println("Change returned: " + quartersCounter + " quarters," + dimesCounter + " dimes," + nickelsCounter + " nickels.");
        balance = 0;
        return new double[] {changeToReturn, balance};
    }

    public static void printStatement() {
        System.out.println(String.format("Current money provided: $%.2f", balance));
    }

}
