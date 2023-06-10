package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SalesReport {

    private List<String> salesReportEntries = new ArrayList<>();

    public void addToSalesReport(String productName, int amountSold){
        String entry = String.format("%s $%.2f", productName, amountSold);
        System.out.print("**TOTAL SALES**" + );
        salesReportEntries.add(entry);
        printSalesLog(entry);
    }

    public void printSalesLog(String entry){
        File newFile = new File ("SalesReport.txt");
        boolean append = newFile.exists();
        try(PrintWriter writer =
         new PrintWriter(new FileOutputStream(newFile, append))){
            writer.println(entry);
        }catch (IOException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
