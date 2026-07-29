package com.bank.hdfc;

// Super Class or Parent Class
public class BankAccount {
    // Data Members
   // private static long nextAccNum = 86989;
    private String accountNum;              
    private double balance;
    private String name;
    private String mobileNo;

    // Default Constructor
    public BankAccount() {}

    // Parameterized Constructor
    public BankAccount(String accountNum,double b, String name, String mb) {
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
        if(phone.length() == 11)
        this.mobileNo = phone;
        else
        System.out.println("Invalid Mobile Number..........");
    }

    public void setAccountNo(String accountNum)
    {
        if(accountNum.length() <=14 && accountNum.length() >=1)
          this.accountNum = accountNum;
        else
        System.out.println("Enter Valid Account Number");
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
            System.out.println();
        return "Account Holder Name: " + getName() +
                "\nAccount Number: " + getAccountNo() +
                "\nMobile Number: " + getMobile() +
                "\nAccount Balance: " + getBalance();
    }
    
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;                // same reference
    if (obj == null || getClass() != obj.getClass()) return false; // null or diff class

    BankAccount obj = new BankAccount();      // safe cast
    return this.getAccountNo() == obj.getAccountNo(); // compare unique field
}

}
