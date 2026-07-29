package com.tester;

import com.bankexceptions.BankException;
import com.bankingservice.ServiceImplementation;
import java.util.Scanner;

public class TestBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceImplementation service = new ServiceImplementation();

        int choice;
        do {
            System.out.println("\n-----------Bank Account Operations--------------------");
            System.out.println("1) Open Savings Account");
            System.out.println("2) Open Current Account");
            System.out.println("3) Deposit");
            System.out.println("4) Withdraw");
            System.out.println("5) Account Summary");
            System.out.println("6) Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> service.openSavingsAccount();
                    case 2 -> service.openCurrentAccount();
                    case 3 -> {
                        System.out.print("Enter Account Number: ");
                        String accNoDep = sc.next();
                        System.out.print("Enter Amount: ");
                        double amtDep = sc.nextDouble();
                        System.out.println("Updated Balance: $" + service.deposit(accNoDep, amtDep));
                    }
                    case 4 -> {
                        System.out.print("Enter Account Number: ");
                        String accNoW = sc.next();
                        System.out.print("Enter Amount: ");
                        double amtW = sc.nextDouble();
                        System.out.println(service.withdraw("SAVINGS", accNoW, amtW)); // type could be user input too
                    }
                    case 5 -> {
                        System.out.print("Enter Account Number: ");
                        String accNo = sc.next();
                        System.out.println(service.getAccountSummary(accNo));
                    }
                    case 6 -> System.out.println("Exiting program...");
                    default -> System.out.println("Invalid choice!");
                }
            } catch (BankException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 6);
    }
}
