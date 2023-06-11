package com.techelevator.Exceptions;

import com.techelevator.util.ConsoleUtility;

public class CurrencyInputException extends Exception {

    public CurrencyInputException(){
        super ("Machine only accepts quarters, $1 bills, or $5 bills.");
    }
}
