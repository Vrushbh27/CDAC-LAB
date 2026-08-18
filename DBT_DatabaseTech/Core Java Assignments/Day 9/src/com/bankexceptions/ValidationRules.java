package com.bankexceptions;

public class ValidationRules {
    public static void validate(String accountNum1, String accountNum2) throws BankException {
        if (accountNum1.equals(accountNum2)) {
            throw new BankException("Error!!! Duplicate Account!");
        }
    }
}
