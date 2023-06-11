package com.techelevator;

import com.techelevator.FoodItems.Candy;
import org.junit.Assert;
import org.junit.Test;

public class SlotTests {

    @Test
    public void dispenseItemTestHappyPath() {
        // Arrange
        Slot testSlot = new Slot("A1");
        Candy testCandy = new Candy("Test Candy", 3.50);
        testSlot.fillSlot(testCandy);
        Calculator.setBalance(5);
        boolean expectedResult = true;

        // Act
        boolean result = testSlot.dispenseItem();

        // Assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void dispenseItemTestSoldOut() {
        // Arrange
        Slot testSlot = new Slot("X1");
        testSlot.setStock(0);
        boolean expectedResult = false;

        // Act
        boolean result = testSlot.dispenseItem();

        // Assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void dispenseItemTestInsufficientFunds() {
        // Arrange
        Slot testSlot = new Slot("A1");
        Candy testCandy = new Candy("Test Candy", 3.20);
        testSlot.fillSlot(testCandy);
        Calculator.setBalance(3.10);
        boolean expectedResult = false;

        // Act
        boolean result = testSlot.dispenseItem();

        // Assert
        Assert.assertEquals(expectedResult, result);
    }

}
