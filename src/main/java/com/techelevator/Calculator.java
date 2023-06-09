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
        int quartersCounter = 0;
        int dimesCounter = 0;
        int nickelsCounter = 0;

        double quarters = 0.25;
        double dimes = 0.10;
        double nickels = 0.05;

        while (changeToReturn > 0){
            while (changeToReturn >= 0.25){
                changeToReturn -= quarters;
                quartersCounter++;
            }
            while (changeToReturn >= 0.10){
                changeToReturn -= dimes;
                dimesCounter++;
            }
            while (changeToReturn >= 0.05){
                changeToReturn -= nickels;
                nickelsCounter++;
            }
        }
        System.out.println("Change returned: " + quartersCounter + " quarters," + dimesCounter + " dimes," + nickelsCounter + " nickels.");
        balance = 0;
        return new double[] {changeToReturn, balance};
    }

    public void printStatement() {
        System.out.println("Current Money Provided: " + balance);
    }

}
