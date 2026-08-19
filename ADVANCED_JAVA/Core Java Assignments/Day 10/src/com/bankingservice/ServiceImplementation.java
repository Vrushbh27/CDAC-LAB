package com.bankingservice;

import com.bank.hdfc.*;
import com.bankexceptions.BankException;
import com.bankexceptions.ValidationRules;
import java.util.Scanner;

public class ServiceImplementation implements BankingServices {

    private BankAccount[] accounts = new BankAccount[100];
    private int index = 0;

    @Override
    public void openSavingsAccount() throws BankException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Holder's Name: ");
        String name = sc.next();

        System.out.println("Enter Mobile Number: ");
        String phone = sc.next();
        ValidationRules.validateMobile(phone);

        System.out.println("Enter Account Number: ");
        String accountNum = sc.next();
        ValidationRules.validateDuplicate(accounts, accountNum);

        System.out.println("Enter Balance (min $100): ");
        double balance = sc.nextDouble();
        ValidationRules.validateSavingsBalance(balance);

        System.out.println("Enter Interest Rate: ");
        double interestRate = sc.nextDouble();

        accounts[index++] = new SavingsAccount(accountNum, balance, name, phone, interestRate);
        System.out.println("✅ Savings Account created successfully!");
    }

    @Override
    public void openCurrentAccount() throws BankException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Holder's Name: ");
        String name = sc.next();

        System.out.println("Enter Mobile Number: ");
        String phone = sc.next();
        ValidationRules.validateMobile(phone);

        System.out.println("Enter Account Number: ");
        String accountNum = sc.next();
        ValidationRules.validateDuplicate(accounts, accountNum);

        System.out.println("Enter Balance: ");
        double balance = sc.nextDouble();

        System.out.println("Enter Overdraft Limit: ");
        double odLimit = sc.nextDouble();
        ValidationRules.validateOverdraftLimit(odLimit);

        accounts[index++] = new CurrentAccount(accountNum, balance, name, phone, odLimit);
        System.out.println("✅ Current Account created successfully!");
    }

    @Override
    public String withdraw(String type, String accountNum, double amount) throws BankException {
        ValidationRules.validateAccountType(type); // validate account type

        for (BankAccount acc : accounts) {
            if (acc != null && acc.getAccountNo().equals(accountNum)) {
                return acc.withdraw(amount);
            }
        }
        throw new BankException("Account not found!");
    }

    @Override
    public double deposit(String accountNum, double amount) throws BankException {
        for (BankAccount acc : accounts) {
            if (acc != null && acc.getAccountNo().equals(accountNum)) {
                return acc.deposit(amount);
            }
        }
        throw new BankException("Account not found!");
    }

    @Override
    public String getAccountSummary(String accountNum) throws BankException {
        for (BankAccount acc : accounts) {
            if (acc != null && acc.getAccountNo().equals(accountNum)) {
                return acc.getAccountSummary();
            }
        }
        throw new BankException("Account not found!");
    }
}
