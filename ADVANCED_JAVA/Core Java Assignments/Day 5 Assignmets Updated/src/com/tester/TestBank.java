// 2. Try n solve Banking assignment
// - refer to assignment help


// Optional Work - 
// Run time Polymorphism with Upcasting

// Write a Tester - TestBank
// Given - This bank can support max accounts = 100.

// Options
// 1. Open Saving account
// User i/p - accountNumber , balance  , customer name  , phone number , interest rate

// 2. Open Current account
// User i/p - accountNumber , balance  , customer name  , phone number ,overdraftLimit 

// 3. Display account summary
// User i/p - account number

// 4. Deposit
// User i/p - account number , amount

// 5. Withdraw
// User i/p - account number , amount




package com.tester;
import com.bank.hdfc.*;
import java.util.Scanner;

public class TestBank {
    public static void main(String[] args) {
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
                            String result = b.Withdraw(amountW); // assumes Withdraw returns String
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

        sc.close();
    }
}
