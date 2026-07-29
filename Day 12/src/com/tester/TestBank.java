
// 2. Solve banking assignment completely.(Mandatory)
// - Using the layers
// Tester - Service Layer - Validation Rules - Core classes , enums .
// Options
// 1. Open account
// (You can add 2 separate options for saving & current)
// 2. Withdraw
// 3. Deposit
// 4. Transfer funds 
// i/p - src account no , dest account no , transfer amount
// 5.Close account
// i/p - account no

// 6. Apply Interest to all saving accounts.

// 7. Display phone numbers for customers with specified account type , having balance > specific value.
// i/p - account type , min balance .

// 8. Try this
// Display the accounts sorted as per account nos.

// 9. Delete all current accounts.

// 0. Exit.



package com.tester;

import com.bankexceptions.BankException;
import com.bankingservice.ServiceImplementation;
import java.util.Scanner;

public class TestBank {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
        ServiceImplementation service = new ServiceImplementation();

        int choice;
        do {
            System.out.println("\n-----------Bank Account Operations--------------------");
            System.out.println();
            System.out.println("1) Open Savings Account");
            System.out.println("2) Open Current Account");
            System.out.println("3) Deposit");
            System.out.println("4) Withdraw");
            System.out.println("5) Transfer Funds.");
            System.out.println("6) Close Account ");
            System.out.println("7) Apply Interest Rate(Savings Account)");
            System.out.println("8) Account Summary");
            System.out.println("9) Account Sorting ");
            System.out.println("10) Delete All Current Accounts ");
            System.out.println("11) Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    //Open Savings Account
                    case 1 -> service.openSavingsAccount();
                    
                    //Open Current Account
                    case 2 -> service.openCurrentAccount();

                    //Deposit
                    case 3 -> {
                        System.out.print("Enter Account Number: ");
                        String accNoDep = sc.next();
                        System.out.print("Enter Amount: ");
                        double amtDep = sc.nextDouble();
                        System.out.println("Updated Balance: $" + service.deposit(accNoDep, amtDep));
                    }

                     //Withdraw Amount
                    case 4 -> {
                        System.out.print("Enter Account Number: ");
                        String accNoW = sc.next();
                        System.out.println("Enter Account Type (Savings / Current): ");
                         String type = sc.nextLine();

                        System.out.print("Enter Amount: ");
                        double amtW = sc.nextDouble();

                        System.out.println(service.withdraw(type, accNoW, amtW)); // type could be user input too
                    }

                   //Funds Transfer
                    case 5 -> {
                                  try
                                  {
                                      System.out.println("Enter the Source Account Number: ");
                                      String sourceAccountNum = sc.next();

                                      System.out.println("Enter the Destination Account Number: ");
                                      String destinationAccountNum = sc.next();
                                      System.out.println("Enter the Amount to Transfer: ");
                                      double amount = sc.nextDouble();

                                     service.transferFunds(sourceAccountNum, destinationAccountNum, amount);
                                  }catch(BankException e)
                                  {
                                     System.out.println(e.getMessage());
                                  }
                            
                        // System.out.print("Enter Account Number: ");
                        // String accNo = sc.next();
                        // System.out.println(service.getAccountSummary(accNo));
                    }

                    //Close Accounts
                    case 6 -> {
                                    System.out.println("Enter the Account Number: ");
                                    String accountNum = sc.next();
                                    
                                    System.out.println("Enter the Account Owner's name: ");
                                    String name = sc.next();

                                    System.out.println("Enter the Phone number: ");
                                    String phone = sc.next();
                                    service.closeAccount(accountNum, name, phone);
                             }


                   //Apply Common Interest Rate to all Accounts
                    case 7 ->{
                                System.out.println("Enter the Common Interest Rate for All Savings Accounts: ");
                                double Rate = sc.nextDouble();
                                service.setInterest(Rate);
                             }
                    
                     // Account Summary
                    case 8 -> {
                        System.out.print("Enter Account Number: ");
                        String accNo = sc.next();
                        System.out.println(service.getAccountSummary(accNo));
                    }
                   
                    //Sorting of Accounts As Per Account Numbers;
                    case 9 -> service.sortedAccounts();
                     
                    //Delete All Current Accounts
                    case 10 -> service.deleteAllCurrentAccounts();

                    //Program Exit
                    case 11 -> System.out.println("Exiting Program...!");
                  
                  
                  //  Default Case
                    default -> System.out.println("Invalid choice!");
                }
            } catch (BankException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 11);
    }
    }
}
