package com.tester;

import com.bank.hdfc.*;
import com.bankexceptions.BankException;
import com.bankexceptions.ValidationRules;
import java.util.Scanner;

public class TestBank {
    public static void main(String[] args) throws BankException {
        Scanner sc = new Scanner(System.in);

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

                    System.out.print("Enter the Account Owner's Name: ");
                    String name = sc.next();

                    System.out.print("Enter the Account Owner's Mobile No: ");
                    String mobileNo = sc.next();

                    // Account number validation
                    String accountNum;
                    while (true) {
                        System.out.print("Enter Account Number: ");
                        accountNum = sc.next();
                        boolean duplicate = false;

                        for (BankAccount b : ba) {
                            if (b != null) {
                                try {
                                    ValidationRules.validate(b.getAccountNo(), accountNum);
                                } catch (BankException e) {
                                    System.out.println(e.getMessage());
                                    duplicate = true;
                                    break; // found duplicate, ask again
                                }
                            }
                        }
                        if (!duplicate) break; // valid number
                    }

                    System.out.print("Enter the Base Amount: ");
                    double balance = sc.nextDouble();

                    System.out.print("Enter Interest Rate: ");
                    double rate = sc.nextDouble();

                    // Upcasting
                    ba[index] = new SavingsAccount(accountNum, balance, name, mobileNo, rate);
                    index++;

                    System.out.println("Your Savings Bank Account Successfully Opened!");
                    break;

                case 2: // Creating Current Account
                    System.out.println("---Creating Current Account-----");

                    System.out.print("Enter the Account Owner's Name: ");
                    name = sc.next();

                    System.out.print("Enter the Account Owner's Mobile No: ");
                    mobileNo = sc.next();

                    // Account number validation
                    while (true) {
                        System.out.print("Enter Account Number: ");
                        accountNum = sc.next();
                        boolean duplicate = false;

                        for (BankAccount b : ba) {
                            if (b != null) {
                                try {
                                    ValidationRules.validate(b.getAccountNo(), accountNum);
                                } catch (BankException e) {
                                    System.out.println(e);
                                    duplicate = true;
                                    break; // found duplicate, ask again
                                }
                            }
                        }
                        if (!duplicate) break; // valid number
                    }

                    System.out.print("Enter the Base Amount: ");
                    balance = sc.nextDouble();

                    System.out.print("Enter the Account Over Draft Limit: ");
                    double odLimit = sc.nextDouble();

                    ba[index] = new CurrentAccount(accountNum, balance, name, mobileNo, odLimit);
                    index++;

                    System.out.println("Your Current Bank Account Successfully Opened!");
                    break;

                case 3: // Deposit
                    System.out.print("Enter the Account Number: ");
                    String accNoDep = sc.next();

                    System.out.print("Enter the Amount to Deposit: ");
                    double amountDep = sc.nextDouble();

                    boolean foundDep = false;
                    for (BankAccount b : ba) {
                        if (b != null && b.getAccountNo().equals(accNoDep)) {
                            b.deposit(amountDep);
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
                    String accNoW = sc.next();

                    System.out.print("Enter the Amount to Withdraw: ");
                    double amountW = sc.nextDouble();

                    boolean foundW = false;
                    for (BankAccount b : ba) {
                        if (b != null && b.getAccountNo().equals(accNoW)) {
                            String result = b.withdraw(amountW);
                            System.out.println(result);
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

                    System.out.print("Enter the Account Number: ");
                    String AccountNum = sc.next();

                    boolean foundAcc = false;
                    for (BankAccount b : ba) {
                        if (b != null && b.getAccountNo().equals(AccountNum)) {
                            System.out.println(b.getAccountSummary());
                            foundAcc = true;
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

        sc.close();
    }
}
