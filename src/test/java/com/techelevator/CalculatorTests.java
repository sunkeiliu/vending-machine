package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests {

    @Test
    public void feedMoneyTest() {
        // Arrange
        Calculator.setBalance(0);
        double expectedBalance = 5.00;

        // Act
        Calculator.feedMoney(5);
        double newBalance = Calculator.getBalance();

        // Assert
        Assert.assertEquals(expectedBalance, newBalance, 0);
    }

    @Test
    public void purchaseItemTestBalance() {
        // Arrange
        Calculator.setBalance(5.00);
        double expectedBalance = 3.50;

        // Act
        Calculator.purchaseItem(1.50);
        double newBalance = Calculator.getBalance();

        // Assert
        Assert.assertEquals(expectedBalance, newBalance, 0);
    }

    @Test
    public void purchaseItemTesTotalAmount() {
        // Arrange
        Calculator.setTotalAmount(5.00);
        double expectedBalance = 6.50;

        // Act
        Calculator.purchaseItem(1.50);
        double newBalance = Calculator.getTotalAmount();

        // Assert
        Assert.assertEquals(expectedBalance, newBalance, 0);
    }

    @Test
    public void returnChangeTest() {
        // Arrange
        Calculator.setBalance(1.15);
        String expectedResponse = "Change returned: 4 quarter(s), 1 dime(s), 1 nickel(s). \n";

        // Act
        String response = Calculator.returnChange();

        // Assert
        Assert.assertEquals(expectedResponse, response);
    }

}
