// 2. Refer to the Banking assignment
// In the saving account class , you must be already checking for minimum balance condition (or balance < 0) right ?
//  - You are currently returning a boolean , indicating success or failure.
//  - Meaning you have to check status & change the flow of execution.
// - No more !!!!!
// Modify
// Problem Statement
// Your withdraw method should throw a custom exception
//  - InsufficientBalanceException
//  - Create it as a checked exception n throw this exception in case of the error.
// - This will help you to apply exception handling to banking scenario.
// - Take the reference of Vehicle Speed scenario.
package com.tester;

import com.BankingExceptions.InSufficientBalanceException;
import com.bank.hdfc.*;
import java.util.Scanner;

public class TestBank {

    public static void main(String[] args) throws InSufficientBalanceException {
        try (Scanner sc = new Scanner(System.in)) {

            // Array to store multiple accounts
            BankAccount[] ba = new BankAccount[100];

            int index = 0;
            int choice;

            System.out.println("-----------Bank Account Operations--------------------");
            System.out.println();
            System.out.println("1) Open Savings Account");
            System.out.println("2) Open Current Account");
            System.out.println("3) Deposit");
            System.out.println("4) Withdraw");
            System.out.println("5) Account Summary");
            System.out.println("6) Exit");
            System.out.println();

            do {
                System.out.print("Enter the Choice: ");
                choice = sc.nextInt();
                System.out.println();

                switch (choice) {
                    case 1: // Creating Savings Account
                        System.out.println("---Creating Savings Account-----");
                        System.out.println();

                        System.out.print("Enter the Account Owner's Name: ");
                        String name = sc.next();

                        System.out.print("Enter the Account Owner's Mobile No: ");
                        String mobileNo = sc.next();

                        System.out.print("Enter the Base Amount: ");
                        double balance = sc.nextDouble();

                        System.out.print("Enter Interest Rate: ");
                        double rate = sc.nextDouble();

                        // Upcasting
                        ba[index] = new SavingsAccount(balance, name, mobileNo, rate);

                        System.out.println("Your Account Number is : " + ba[index].getAccountNo());
                        index++;
                        System.out.println();
                        System.out.println("Your Savings Bank Account Successfully Opened!");
                        break;

                    case 2: // Creating Current Account
                        System.out.println("---Creating Current Account-----");

                        System.out.print("Enter the Account Owner's Name: ");
                        name = sc.next();

                        System.out.print("Enter the Account Owner's Mobile No: ");
                        mobileNo = sc.next();

                        System.out.print("Enter the Base Amount: ");
                        balance = sc.nextDouble();

                        System.out.print("Enter the Account Over Draft Limit: ");
                        double odLimit = sc.nextDouble();

                        ba[index] = new CurrentAccount(balance, name, mobileNo, odLimit);
                        System.out.println("Your Bank Account Number is: " + ba[index].getAccountNo());
                        index++;
                        System.out.println();
                        System.out.println("Your Current Bank Account Successfully Opened!");
                        break;

                    case 3: // Deposit
                        System.out.print("Enter the Account Number: ");
                        long accNoDep = sc.nextLong();

                        System.out.print("Enter the Amount to Deposit: ");
                        double amountDep = sc.nextDouble();

                        boolean foundDep = false;
                        for (BankAccount b : ba) {
                            if (b != null && accNoDep == b.getAccountNo()) {
                                b.Deposit(amountDep); // assumes Deposit exists
                                System.out.println("Amount Deposited Successfully!");
                                System.out.println("Now your Account Balance is: " + b.getBalance());
                                foundDep = true;
                                break;
                            }
                        }
                        if (!foundDep) {
                            System.out.println("Account Not Found!");
                        }
                        break;

                    case 4: // Withdraw
                        System.out.print("Enter the Account Number: ");
                        long accNoW = sc.nextLong();

                        System.out.print("Enter the Amount to Withdraw: ");
                        double amountW = sc.nextDouble();

                        boolean foundW = false;
                        for (BankAccount b : ba) {
                            if (b != null && accNoW == b.getAccountNo()) {
                                try {
                                    String result = b.Withdraw(amountW);   // may throw exception
                                    System.out.println(result);
                                } catch (InSufficientBalanceException e) {
                                    System.out.println("Withdrawal Failed: " + e.getMessage());
                                }
                                foundW = true;
                                break;
                            }
                        }
                        if (!foundW) {
                            System.out.println("Account Not Found!");
                        }
                        break;

                    case 5: // Account Summary
                        System.out.println("---------------------Account Summary-----------------");
                        System.out.println();

                        System.out.println("Enter the Account Number: ");
                        long AccountNum = sc.nextLong();

                        boolean foundAcc = false;
                        for (BankAccount b : ba) {
                            if (b != null && b.getAccountNo() == AccountNum) {
                                System.out.println(b.getAccountSummary());
                                foundAcc = true;
                                System.out.println();
                                break;
                            }
                        }
                        if (!foundAcc) {
                            System.out.println("Account Not Found!");
                        }
                        break;

                    case 6:
                        System.out.println("Program Exited...");
                        break;

                    default:
                        System.out.println("Error!!! \n Invalid Operation..!");
                }

            } while (choice != 6);
        }
    }
}
