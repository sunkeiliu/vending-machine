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

    private PrintWriter writer;
    private List<String> logEntries = new ArrayList<>();

    public Logger (PrintWriter writer) {
        this.writer = writer;
    }

    // Add log entry for Feed Money and Return Change
    public void addToLog(String action, double[] transactionData) {
        LocalDateTime rightNow = LocalDateTime.now();
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        String nowString = rightNow.format(myFormatter);

        double transactionAmount = transactionData[0];
        double updatedBalance = transactionData[1];

        String entry = String.format("%s %s %d %d", nowString, action, transactionAmount, updatedBalance);
        logEntries.add(entry);
    }

    // Add log entry for purchased item
    public void addToLog(String productName, String slotId, double[] transactionData) {
        LocalDateTime rightNow = LocalDateTime.now();
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        String nowString = rightNow.format(myFormatter);

        double transactionAmount = transactionData[0];
        double updatedBalance = transactionData[1];

        String entry = String.format("%s %s %s %d %d", nowString, productName, slotId, transactionAmount, updatedBalance);
        logEntries.add(entry);
    }

    // Print all logger entries to output file
    public void printLog(){
        File newFile = new File ("Log.txt");
        boolean append = newFile.exists() ? true : false;
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
