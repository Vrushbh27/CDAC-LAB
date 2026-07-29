package com.tester;
import com.bank.hdfc.*;
import java.util.Scanner;

public class TestBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array to store multiple accounts
        BankAccount[] ba = new BankAccount[1000];
		
        int index = 0;
        int choice;

        System.out.println("-----------Bank Account Operations--------------------");
        System.out.println("1) Create Account");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Account Summary");
        System.out.println("5) Exit");
        System.out.println();

        do {
            System.out.print("Enter the Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("---Creating Account-----");

                    System.out.print("Enter the Account Owner's Name: ");
                    sc.next();
                    String name = sc.nextLine();

                    System.out.print("Enter the Account Owner's Mobile No: ");
                    long mobileNo = sc.nextLong();

                    System.out.print("Enter the Base Amount: ");
                    double balance = sc.nextDouble();

                    System.out.println("Enter Account Type: \n1) Savings \n2) Current");
                    int type = sc.nextInt();

                    switch (type) {
                        case 1:
                            System.out.print("Enter Interest Rate: ");
                            double rate = sc.nextDouble();
                            ba[index] = new SavingsAccount(balance,name,mobileNo,rate);
							index++;
                            break;

                        case 2:
                            System.out.print("Enter the Account Over Draft Limit: ");
                            double odLimit = sc.nextDouble();
                            ba[index] = new CurrentAccount(balance,name,mobileNo,odLimit);
							index++;
                            break;

                        default:
                            System.out.println("Invalid Choice! Please Enter a valid option.");
                            break;
                    }
                    index++;
                    break;

                case 2: // Deposit
                    System.out.print("Enter the Account Number: ");
                    long accNoDep = sc.nextLong();

                    System.out.print("Enter the Amount to Deposit: ");
                    double amountDep = sc.nextDouble();

                    boolean foundDep = false;
                    for (BankAccount b : ba) {
                        if (b != null && accNoDep == b.getAccountNo()) {
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
                    break;

                case 3: // Withdraw
                    System.out.print("Enter the Account Number: ");
                    long accNoW = sc.nextLong();

                    System.out.print("Enter the Amount to Withdraw: ");
                    double amountW = sc.nextDouble();

                    boolean foundW = false;
                    for (BankAccount b : ba) {
                        if (b != null && accNoW == b.getAccountNo()) {
                            String result = b.Withdraw(amountW);
                            System.out.println(result);
                            foundW = true;
                            break;
                        }
                    }
                    if (!foundW) {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 4: // Account Summary
                    System.out.println("---------------------Account List-----------------");
                    for (BankAccount b : ba) {
                        if (b != null) {
                            System.out.println(b.toString());
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Program Exited...");
                    break;

                default:
                    System.out.println("Error!!! \n Invalid Operation..!");
            }

        } while (choice != 5);

        sc.close();
    }
}
