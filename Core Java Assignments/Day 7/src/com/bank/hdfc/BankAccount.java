// Assignments
// Q1. Basic Inheritance
// Create a class BankAccount with:
// Fields: accountNumber (int), balance (double) , customer name (String) , phone number (String)
// Add suitable constructor
// Methods:
// deposit(double amount)
// withdraw(double amount) (should not allow negative balance by default)
// getAccountSummary() - returns complete details of the account , in string format
// getBalance() - returns account balance.
// Create subclasses:
// SavingAccount -> add interestRate field and method applyInterest().
// CurrentAccount ->  add overdraftLimit field and method useOverdraftFacility().
// SavingAccount -> should not allow any negative balance in  withdraw operation .It should fail in such case.
// CurrentAccount -> should  allow any negative balance, in withdraw operation .It should not fail till it exceeds the overdraft limit. After overdraft limit is exceeded then withdraw operation should fail.
// Task: Write a TestBanking class , with main() that creates one saving and one current account, performs deposits and withdrawals, and prints account summary.
// You can hard code the values (no need to add Scanner today !)
package com.bank.hdfc;

import com.BankingExceptions.InSufficientBalanceException;

public class BankAccount {

    // Data Members
    private static long nextAccNum = 86989; // shared counter for all accounts
    private long accountNum;                // unique per account
    private double balance;
    private String name;
    private String mobileNo;

    // Default Constructor
    public BankAccount() {
    }

    // Parameterized Constructor
    public BankAccount(double b, String name, String mb) {
        this.accountNum = ++nextAccNum;  // generate unique account number
        this.balance = b;
        this.name = name;
        this.mobileNo = mb;
    }

    // Setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String phone) {
        if (phone.length() == 11) {
            this.mobileNo = phone; 
        }else {
            System.out.println("Invalid Mobile Number...");
        }
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public long getAccountNo() {
        return this.accountNum; // return instance account number
    }

    public Double getBalance() {
        return balance;
    }

    public String getMobile() {
        return mobileNo;
    }

    // deposit(double amount)
    public double Deposit(double amount) {
        return this.balance += amount;
    }

    //withdraw(double amount) (should not allow negative balance by default)
    // public void Withdraw(double amount) throws InSufficientBalanceException {
    //     if (balance >= amount) {
    //         balance -= amount;
    //         System.out.println("Amount Withdrawn: " + amount + " | Remaining Balance: " + balance);
    //     } else {
    //         System.out.println("Insufficient Balance!!!");
    //     }
    // }

    public String Withdraw(double amount) throws InSufficientBalanceException {
    if (balance < amount) {
        throw new InSufficientBalanceException("Insufficient Balance. Available: " + balance);
    }
    balance -= amount;
    return "Withdrawal Successful. Remaining Balance: " + balance;
}


    // getAccountSummary() - returns complete details of the account, in string format
    public String getAccountSummary() {
        return "Account Holder Name: " + getName()
                + "\nAccount Number: " + getAccountNo()
                + "\nMobile Number: " + getMobile()
                + "\nAccount Balance: " + getBalance();
    }
}
