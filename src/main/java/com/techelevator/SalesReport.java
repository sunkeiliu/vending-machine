package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class SalesReport {

    private double totalSales = 0;
    private Map<String, Integer> salesReportEntries = new HashMap<>();

    public Map<String, Integer> getSalesReportEntries() {
        return salesReportEntries;
    }

    public void initializeSalesReport(Inventory inventory) {
        for (Map.Entry<String, Slot> inventoryEntry : inventory.getInventory().entrySet()) {
            String itemName = inventoryEntry.getValue().getFoodItem().getName();
            salesReportEntries.put(itemName, 0);
        }
    }

    public void addToSalesReport(String productName){
        salesReportEntries.put(productName, salesReportEntries.get(productName) + 1);
    }

    public void printSalesLog(Inventory inventory){
        File newFile = new File ("SalesReport.txt");
        double totalSales = getTotalSales();
        try(PrintWriter writer = new PrintWriter(newFile)) {
            for (Map.Entry<String, Slot> inventoryEntry : inventory.getInventory().entrySet()) {
                String foodItem = inventoryEntry.getValue().getFoodItem().getName();
                writer.println(foodItem + "|" + getSalesReportEntries().get(foodItem));
            }
            writer.println(String.format("\n**TOTAL SALES** $%.2f", totalSales));
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public double getTotalSales() {
        return Calculator.getTotalAmount();
    }
}
