package com.bank.hdfc;

public class CurrentAccount extends BankAccount {
    private double overDraftLimit;

    // Default Constructor
    public CurrentAccount() {
        super();
    }

    // Parameterized Constructor
    public CurrentAccount(String accountNum, double b, String name, String mb, double overDraftLimit) {
        super(accountNum, b, name, mb);
        this.overDraftLimit = overDraftLimit;
    }

    // Setter
    public void setOverDraftLimit(double amount) {
        this.overDraftLimit = amount;
    }

    // Getter
    public double getOverDraftLimit() {
        return this.overDraftLimit;
    }

    // Withdraw
    @Override
    public String withdraw(double amount) {
        if (super.getBalance() + getOverDraftLimit() >= amount) {
            setBalance(getBalance() - amount);
            return "Amount Withdrawn: " + amount + " | Remaining Balance: " + getBalance();
        } else {
            return "OverDraft Limit Exceeded";
        }
    }

    @Override
    public String getAccountSummary() {
        return "----------Account Summary-----------\n" +
                super.getAccountSummary() +
                "\nAccount Type: Current\nOver Draft Limit: " + overDraftLimit;
    }

    @Override
    public AccountType getAccountType()
    {
        return AccountType.CURRENT;
    }
}
