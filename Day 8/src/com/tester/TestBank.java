// 2. Hands on
// Refer to Day 5 Banking assignment.
// (It was array based , with different options - to open saving or current account account , show a/c summary , withdraw , deposit ...)

// In open account case (either saving or current)
//  - You are accepting account no from User.
//  - Add new validation rule.
//   - accounts with duplicate account no , should not get added.

// Hint -Override  equals method in BankAccount class.


// OR

//  When should be 2 bank accounts considered same ? if the account nos are same right ?
//  Test with Object's equals method
//  Any problem ?
// Solution ?




package com.tester;
import com.bank.hdfc.*;
import java.util.Scanner;

public class TestBank {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Array to store multiple accounts
            BankAccount[] ba = new BankAccount[1000];
            int index = 0;
            String choice;

            System.out.println("-----------Bank Account Operations--------------------");
            System.out.println();
            System.out.println("1) Create Account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4)Account Summary");
            System.out.println("5) Exit");
            System.out.println();

            do {
                System.out.print("Enter the Choice: ");
                choice = sc.nextLine(); // read full line

                switch (choice) {
                    case "Create Account"-> {
                        System.out.println("---Creating Account-----");
                        System.out.println();

                        System.out.print("Enter the Account Owner's Name: ");
                         String name = sc.nextLine();
                                         //sc.next();

                        System.out.print("Enter the Account Owner's Mobile No: ");
                        String mobileNo = sc.next();

                        // Account number validation
                        String accountNum;
                        while (true) {
                            System.out.print("Generate Account Number: ");
                            accountNum = sc.next();
                            boolean duplicate = false;

                            for (BankAccount b : ba) {
                                if (b != null && b.getAccountNo().equals(accountNum)) {
                                    System.out.println();
                                    System.out.println("Duplicate Account!!! Please enter a new account number.");
                                    duplicate = true;
                                    break;
                                }
                            }
                            if (!duplicate) break; // exit loop if unique
                        }

                        System.out.print("Enter the Base Amount: ");
                        double balance = sc.nextDouble();

                        // clear buffer before nextLine
                        sc.nextLine();

                        System.out.println("Enter Account Type: \nSavings Account \nCurrent Account");
                        String type = sc.nextLine();

                        switch (type) {
                            case "Savings Account" -> {
                                System.out.print("Enter Interest Rate: ");
                                double rate = sc.nextDouble();
                                ba[index] = new SavingsAccount(accountNum, balance, name, mobileNo, rate);
                                index++;
                                sc.nextLine(); // clear buffer
                            }

                            case "Current Account" -> {
                                System.out.print("Enter the Account Over Draft Limit: ");
                                double odLimit = sc.nextDouble();
                                ba[index] = new CurrentAccount(accountNum, balance, name, mobileNo, odLimit);
                                index++;
                                sc.nextLine(); // clear buffer
                            }

                            default -> {
                                System.out.println("Invalid Choice! Please Enter a valid option.");
                            }
                        }
                        System.out.println();
                    }

                    case "Deposit" -> {
                        System.out.print("Enter the Account Number: ");
                        String accNoDep = sc.next();

                        System.out.print("Enter the Amount to Deposit: ");
                        double amountDep = sc.nextDouble();
                        sc.nextLine(); // clear buffer

                        boolean foundDep = false;
                        for (BankAccount b : ba) {
                            if (b != null && accNoDep.equals(b.getAccountNo())) {
                                b.Deposit(amountDep);
                                System.out.println("Amount Deposited Successfully!");
                                System.out.println("Now your Account Balance is: " + b.getBalance());
                                foundDep = true;
                                break;
                            }
                        }
                        if (!foundDep) {
                            System.out.println("Account Not Found!");
                        }
                        System.out.println();
                    }

                    case "Withdraw" -> {
                        System.out.print("Enter the Account Number: ");
                        String accNoW = sc.next();

                        System.out.print("Enter the Amount to Withdraw: ");
                        double amountW = sc.nextDouble();
                        sc.nextLine(); // clear buffer

                        boolean foundW = false;
                        for (BankAccount b : ba) {
                            if (b != null && accNoW.equals(b.getAccountNo())) {
                                String result = b.Withdraw(amountW);
                                System.out.println(result);
                                foundW = true;
                                break;
                            }
                        }
                        if (!foundW) {
                            System.out.println("Account Not Found!");
                        }
                        System.out.println();
                    }

                    case "Account Summary" -> {
                        System.out.println("---------------------Account List-----------------");
                        for (BankAccount b : ba) {
                            if (b != null) {
                                System.out.println(b.toString());
                                System.out.println();
                            }
                        }
                        System.out.println();
                    }

                    case "Exit" -> {
                        System.out.println("Program Exited...");
                        break;
                    }

                    default -> System.out.println("Error!!! \n Invalid Operation..!");
                }

            } while (!choice.equals("Exit"));

        } catch (Exception e) {
            System.out.println("Exception Caught " + e);
        } finally {
            System.out.println("Code Working Successfully...");
        }
    }
}
