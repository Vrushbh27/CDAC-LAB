package com.bank.hdfc;

// Super Class or Parent Class
public class BankAccount {
    // Data Members
    private String accountNum;   // unique per account
    private double balance;
    private String name;
    private String mobileNo;

    // Default Constructor
    public BankAccount() {}

    // Parameterized Constructor
    public BankAccount(String accountNum, double b, String name, String mb) {
        this.accountNum = accountNum;
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
        if (phone.length() == 10) {
            this.mobileNo = phone;
        } else {
            System.out.println("Invalid Mobile Number...");
        }
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getAccountNo() {
        return this.accountNum;
    }

    public Double getBalance() {
        return balance;
    }

    public String getMobile() {
        return mobileNo;
    }

    // deposit(double amount)
    public double deposit(double amount) {
        this.balance += amount;
        return this.balance;
    }

    // withdraw(double amount) (should not allow negative balance by default)
    public String withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return "Amount Withdrawn: " + amount + " | Remaining Balance: " + balance;
        } else {
            return "Insufficient Balance.";
        }
    }

    // getAccountSummary()
    public String getAccountSummary() {
        return "Account Holder Name: " + getName() +
                "\nAccount Number: " + getAccountNo() +
                "\nMobile Number: " + getMobile() +
                "\nAccount Balance: " + getBalance();
    }
}
