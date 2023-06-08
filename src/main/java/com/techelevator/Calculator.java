package com.techelevator;

public class Calculator {

    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double[] feedMoney(double moneyInserted) {
        balance += moneyInserted;
        return new double[] {moneyInserted, balance};
    }

    public double[] purchaseItem(double itemCost) {
        balance -= itemCost;
        return new double[] {itemCost, balance};
    }

    public double[] returnChange() {
        double changeToReturn = balance;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        // Write code to determine how many quarters, dimes and nickels are necessary
        // Should minimize total number of coins required.

        balance = 0;
        return new double[] {changeToReturn, balance};
    }

    public void printStatement() {
        System.out.println("Current Money Provided: " + balance);
    }

}
