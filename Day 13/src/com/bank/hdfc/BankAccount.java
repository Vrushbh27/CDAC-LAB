package com.bank.hdfc;

// Super Class or Parent Class

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankAccount implements Comparable<BankAccount> {
    // Data Members
    private String accountNum;   // unique per account
    private double balance;
    private String name;
    private String mobileNo;
   
    //dob Extra Added
    private LocalDate birthDate;

    // Default Constructor
    public BankAccount() {}

    // Parameterized Constructor
    public BankAccount(String accountNum, double b, String name, String mb, String dob) {
        this.accountNum = accountNum;
        this.balance = b;
        this.name = name;
        this.mobileNo = mb;
        //Special Updates for dob
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dob, formatter);
        this.birthDate = date;
    }

    public BankAccount(String accountNum)
    {
        this.accountNum = accountNum;
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

    public void setDob(String dob)
    {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dob, formatter);
        this.birthDate = date;
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

    public LocalDate getDob()
    {
        return this.birthDate;
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
               "\n Account Holder Birth Date: "+getDob()+
                "\nAccount Number: " + getAccountNo() +
                "\nMobile Number: " + getMobile() +
                "\nAccount Balance: " + getBalance();
    }

    //Get AccountTyepe
    public AccountType getAccountType()
     {
         return null;
     }

     // to Sort the two Accounts
      @Override
       public int compareTo(BankAccount other) {
        return this.accountNum.compareTo(other.accountNum);
    }
}
