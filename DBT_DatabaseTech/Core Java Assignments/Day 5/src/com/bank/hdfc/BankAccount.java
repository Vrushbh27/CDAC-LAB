package com.bank.hdfc;

// Super Class or Parent Class
public class BankAccount {
    // Data Members
    private static long nextAccNum = 86989; // shared counter for all accounts
    private long accountNum;                // unique per account
    private double balance;
    private String name;
    private long mobileNo;

    // Default Constructor
    public BankAccount() {}

    // Parameterized Constructor
    public BankAccount(double b, String name, long mb) {
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

    public void setMobile(long phone) {
        this.mobileNo = phone;
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

    public long getMobile() {
        return mobileNo;
    }

    // deposit(double amount)
    public double Deposit(double amount) {
        return this.balance += amount;
    }

    // withdraw(double amount) (should not allow negative balance by default)
    public String Withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return "Amount Withdrawn: " + amount + " | Remaining Balance: " + balance;
        } else {
            return "Insufficient Balance.";
        }
    }

    // getAccountSummary() - returns complete details of the account, in string format
    @Override
    public String toString() {
        return "Account Holder Name: " + getName() +
                "\nAccount Number: " + getAccountNo() +
                "\nMobile Number: " + getMobile() +
                "\nAccount Balance: " + getBalance();
    }
}
