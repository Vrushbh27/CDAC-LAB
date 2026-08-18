
// 4.1 Display the accounts sorted as per account nos(natural ordering)
// 4.2 Display the accounts sorted as per account type & balance (custom ordering with ano inner class)
// 4.3 Display the accounts sorted as per customer dob & balance (custom ordering with ano inner class)
// 4.4  Delete all  accounts with balance < specified balance.
// i/p - min balance.





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
            System.out.println("11)Sort as per Account Type and Balance");
            System.out.println("12) Sort as per Date of Birth and Minimum Balance: ");
            System.out.println("13)Delete All Low Balance Accounts Account ");
            System.out.println("14) Exit");
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

                    //Sort As per Account Type and Balance
                    case 11-> service.sortByTypeAndBalance();
                    
                    //sorting as per dob and Balance
                    case 12->service.sortByDobAndBalance();
                     
                    //Delete Accounts with Minimumb balance
                    case 13->
                             {
                                    System.out.println("Enter the Minimum Balance Limit: ");
                                    double balance =sc.nextDouble();
                                    service.deleteLowBalanceAccounts(balance);
                             }
                     
                    //Program Exit
                    case 14 -> System.out.println("Exiting Program...!");
                  
                  //  Default Case
                    default -> System.out.println("Invalid choice!");
                }
            } catch (BankException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 14);
    }
    }
}
