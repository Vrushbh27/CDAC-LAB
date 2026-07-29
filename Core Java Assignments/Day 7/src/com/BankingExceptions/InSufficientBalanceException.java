package com.BankingExceptions;

public class InSufficientBalanceException extends Exception {

    //Constructor
    public InSufficientBalanceException(String Message) {
        super(Message);
    }

}
