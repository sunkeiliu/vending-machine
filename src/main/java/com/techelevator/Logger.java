package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    private List<String> logEntries = new ArrayList<>();

    // Determine current date/time and convert to String
    public String getDateString() {
        LocalDateTime rightNow = LocalDateTime.now();
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        return rightNow.format(myFormatter);

    }


    // Add log entry for Feed Money and Return Change
    public void addToLog(String action, double transactionAmount, double updatedBalance) {
        String nowString = getDateString();

        String entry = String.format("%s %s $%.2f $%.2f", nowString, action, transactionAmount, updatedBalance);
        logEntries.add(entry);
    }

    // Add log entry for purchased item (Overloaded Method)
    public void addToLog(String productName, String slotId, double transactionAmount, double updatedBalance) {
        String nowString = getDateString();

        String entry = String.format("%s %s %s $%.2f $%.2f", nowString, productName, slotId, transactionAmount, updatedBalance);
        logEntries.add(entry);
    }

    // Print all logger entries to output file
    public void printLog(){
        File newFile = new File ("Log.txt");
        boolean append = newFile.exists();
        try (PrintWriter writer =
        new PrintWriter(new FileOutputStream(newFile, append))){
            for (String entry : logEntries){
                writer.println(entry);
            }
        } catch (IOException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
