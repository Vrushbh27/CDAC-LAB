package com.bank.hdfc;

// Super Class or Parent Class
public class BankAccount {
    // Data Members
    private static long nextAccNum = 86989; // shared counter for all accounts
    private long accountNum;                // unique per account
    private double balance;
    private String name;
    private String mobileNo;

    // Default Constructor
    public BankAccount() {}

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
        if(phone.length() == 11)
        this.mobileNo = phone;
        else{
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
    public String getAccountSummary() {
        return "Account Holder Name: " + getName() +
                "\nAccount Number: " + getAccountNo() +
                "\nMobile Number: " + getMobile() +
                "\nAccount Balance: " + getBalance();
    }
}
