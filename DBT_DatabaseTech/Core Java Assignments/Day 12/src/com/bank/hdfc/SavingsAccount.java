package com.bank.hdfc;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Default Constructor
    public SavingsAccount() {
        super();
    }

    // Parameterized Constructor
    public SavingsAccount(String accountNum, double b, String name, String mb, double ir) {
        super(accountNum, b, name, mb);
        this.interestRate = ir;
    }

    // Set Interest Rate
    public void setInterest(double interest) {
        this.interestRate = interest;
    }

    // Get InterestRate
    public double getInterestRate() {
        return this.interestRate;
    }

    // Apply Interest
    public String applyInterestRate() {
        return "Interest on your amount is: " + ((super.getBalance() * getInterestRate()) / 100) +
                " with rate of Interest " + getInterestRate() + "% per year.";
    }

    // Overriding Withdraw Method
    @Override
    public String withdraw(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            return "Amount Withdrawn: " + amount + " | Remaining Balance: " + getBalance();
        } else {
            return "Withdrawal failed! Savings Account cannot go negative.";
        }
    }

    @Override
    public String getAccountSummary() {
        return "----------Account Summary-----------\n" +
                super.getAccountSummary() +
                "\nAccount Type: Savings\n" +
                applyInterestRate();
    }

    @Override
    public AccountType getAccountType()
    {
        return AccountType.SAVINGS;
    }
}
