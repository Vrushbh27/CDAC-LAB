package com.bankexceptions;

import com.bank.hdfc.BankAccount;
import com.bankingservice.AccountType;

public class ValidationRules {
    private static final double MIN_BALANCE = 100;

    // Duplicate account validation
    public static void validateDuplicate(BankAccount[] accounts, String accountNum) throws BankException {
        for (BankAccount b : accounts) {
            if (b != null && b.getAccountNo().equals(accountNum)) {
                throw new BankException("Error!!! Duplicate Account Number: " + accountNum);
            }
        }
    }

    // Mobile number validation
    public static void validateMobile(String mobileNo) throws BankException {
        if (mobileNo == null || !mobileNo.matches("\\d{10}")) {
            throw new BankException("Invalid Mobile Number! Must be exactly 10 digits.");
        }
    }

    // Account type validation
    public static AccountType validateAccountType(String type) throws BankException {
        try {
            return AccountType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BankException("Invalid Account Type! Allowed values: SAVINGS, CURRENT");
        }
    }

    // Minimum balance validation for savings
    public static void validateSavingsBalance(double balance) throws BankException {
        if (balance < MIN_BALANCE) {
            throw new BankException("Savings Account requires a minimum balance of $" + MIN_BALANCE);
        }
    }

    // Overdraft limit validation for current account
    public static void validateOverdraftLimit(double odLimit) throws BankException {
        if (odLimit < 0) {
            throw new BankException("Overdraft limit must be >= 0");
        }
    }
}
