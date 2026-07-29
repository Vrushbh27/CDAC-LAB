// package com.bankingservice;

// import com.bank.hdfc.*;
// import com.bankexceptions.BankException;
// import com.bankexceptions.ValidationRules;
// import java.util.Scanner;

// public class ServiceImplementation implements BankingServices {

//     private BankAccount[] accounts = new BankAccount[100];
//     private int index = 0;

//     @Override
//     public void openSavingsAccount() throws BankException {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter Account Holder's Name: ");
//         String name = sc.next();

//         System.out.println("Enter Mobile Number: ");
//         String phone = sc.next();
//         ValidationRules.validateMobile(phone);

//         System.out.println("Enter Account Number: ");
//         String accountNum = sc.next();
//         ValidationRules.validateDuplicate(accounts, accountNum);

//         System.out.println("Enter Balance (min $100): ");
//         double balance = sc.nextDouble();
//         ValidationRules.validateSavingsBalance(balance);

//         System.out.println("Enter Interest Rate: ");
//         double interestRate = sc.nextDouble();

//         accounts[index++] = new SavingsAccount(accountNum, balance, name, phone, interestRate);
//         System.out.println("✅ Savings Account created successfully!");
//     }

//     @Override
//     public void openCurrentAccount() throws BankException {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter Account Holder's Name: ");
//         String name = sc.next();

//         System.out.println("Enter Mobile Number: ");
//         String phone = sc.next();
//         ValidationRules.validateMobile(phone);

//         System.out.println("Enter Account Number: ");
//         String accountNum = sc.next();
//         ValidationRules.validateDuplicate(accounts, accountNum);

//         System.out.println("Enter Balance: ");
//         double balance = sc.nextDouble();

//         System.out.println("Enter Overdraft Limit: ");
//         double odLimit = sc.nextDouble();
//         ValidationRules.validateOverdraftLimit(odLimit);

//         accounts[index++] = new CurrentAccount(accountNum, balance, name, phone, odLimit);
//         System.out.println("✅ Current Account created successfully!");
//     }

//     @Override
//     public String withdraw(String type, String accountNum, double amount) throws BankException {
//         ValidationRules.validateAccountType(type); // validate account type

//         for (BankAccount acc : accounts) {
//             if (acc != null && acc.getAccountNo().equals(accountNum)) {
//                 return acc.withdraw(amount);
//             }
//         }
//         throw new BankException("Account not found!");
//     }

//     @Override
//     public double deposit(String accountNum, double amount) throws BankException {
//         for (BankAccount acc : accounts) {
//             if (acc != null && acc.getAccountNo().equals(accountNum)) {
//                 return acc.deposit(amount);
//             }
//         }
//         throw new BankException("Account not found!");
//     }

//     @Override
//     public String getAccountSummary(String accountNum) throws BankException {
//         for (BankAccount acc : accounts) {
//             if (acc != null && acc.getAccountNo().equals(accountNum)) {
//                 return acc.getAccountSummary();
//             }
//         }
//         throw new BankException("Account not found!");
//     }
// }


package com.bankingservice;

import com.bank.hdfc.*;
import com.bankexceptions.BankException;
import com.validation.ValidationRules;
import java.util.*;

public class ServiceImplementation implements  BankingServices {

    private List<BankAccount> accounts = new ArrayList<>(); // ArrayList instead of array

    String name, dob, phone, accountNum;
    double balance, interestRate, OverDraftLimit;

    //Savings Account Opening
    @Override
    public void openSavingsAccount() throws BankException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Account Holder's Name: ");
            name = sc.next();
            
            System.out.println("Enter your Birth Date(dd-mm-yyyy): ");
            dob = sc.next();

            System.out.println("Enter Mobile Number: ");
            phone = sc.next();
            ValidationRules.validateMobile(phone);

            System.out.println("Enter the Account Number that you want: ");
            accountNum = sc.next();
            ValidationRules.validateDuplicate(accounts,accountNum);

            System.out.println("Enter the Balance(min Balance $100): ");
            balance = sc.nextDouble();
            ValidationRules.validateSavingsBalance(balance);

            System.out.println("Enter the Rate of Interest on your Deposited Amount: ");
            interestRate = sc.nextDouble();
            ValidationRules.ValidateInterestRate(interestRate);

            //  Add to ArrayList
            accounts.add(new SavingsAccount(accountNum, balance, name, phone, interestRate,dob));
            System.out.println("Savings Account Created Successfully!");
           // sc.close();
    }

    //Current Account Opening
    @Override
    public void openCurrentAccount() throws BankException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Account Holder's Name: ");
            name = sc.next();
            
             System.out.println("Enter your Birth Date(dd-mm-yyyy): ");
            dob = sc.next();

            System.out.println("Enter Mobile Number: ");
            phone = sc.next();
            ValidationRules.validateMobile(phone);

            System.out.println("Enter the Account Number that you want: ");
            accountNum = sc.next();
            ValidationRules.validateDuplicate(accounts, accountNum);

            System.out.println("Enter the Balance(min Balance $100): ");
            balance = sc.nextDouble();
           ValidationRules.validateSavingsBalance(balance);

            System.out.println("Enter the OverDraftLimit for your Account: ");
            OverDraftLimit = sc.nextDouble();
            ValidationRules.validateOverdraftLimit(OverDraftLimit);

            // Add to ArrayList
            accounts.add(new CurrentAccount(accountNum, balance, name, phone, OverDraftLimit,dob));
            System.out.println("Current Account Created Successfully!");
           // sc.close();
    }

    //Withdrawing Amount
    @Override
   public String withdraw(String type, String accountNum, double amount) throws BankException {
    for (BankAccount acc : accounts) {
        if (acc.getAccountNo().equals(accountNum) &&
           acc.getAccountType().equals(type.toUpperCase())) {
            
            return acc.withdraw(amount); // polymorphism in action
        }
    }
    throw new BankException("Account Not Found!");
}


    //Deposit
    @Override
    public double deposit(String accountNum, double amount) throws BankException {
        for (BankAccount acc : accounts) {  // loop through ArrayList
            if (acc.getAccountNo().equals(accountNum)) {
                return acc.deposit(amount);
            }
        }
        throw new BankException("Account Not Found!");
    }

    //Get Account Summary
    @Override
    public String getAccountSummary(String accountNum) throws BankException {
        for (BankAccount acc : accounts) {  // loop through ArrayList
            if (acc.getAccountNo().equals(accountNum) && acc.getName().equals(name)) {
                return acc.getAccountSummary();
            }
        }
        throw new BankException("Account Not Found!");
    }

    public void transferFunds(String sourceAccountNum, String destinationAccountNum, double amount) throws BankException {
    BankAccount source = null, destination = null;

    // Find source and destination accounts
    for (BankAccount acc : accounts) {
        if (sourceAccountNum.equals(acc.getAccountNo())) {
            source = acc;
        } else if (destinationAccountNum.equals(acc.getAccountNo())) {
            destination = acc;
        }
    }

    if (source == null || destination == null) {
        throw  new BankException("One of the accounts was not found!");
        // return;
    }

    // Check balance
    if (source.getBalance() < amount) {
        throw new BankException("Insufficient funds in source account!");
        //return;
    }

    // Transfer money
    source.setBalance(source.getBalance() - amount);
    destination.setBalance(destination.getBalance() + amount);

    System.out.println("Transfer successful!");
    System.out.println("New Balance (Source): " + source.getBalance());
    System.out.println("New Balance (Destination): " + destination.getBalance());
}


    //Close Account
    public void closeAccount(String accountNum,String name, String phone) throws BankException
    {
          ValidationRules.validateMobile(phone);
          for(BankAccount acc:accounts)
          {
             if(accountNum.equals(acc.getAccountNo()) && name.equals(acc.getName()) && phone.equals(acc.getMobile()))
             {
                accounts.remove(acc);
             }
          }
          System.out.println();
          System.out.println("Your Account is Closed Permenantly....");
    }

    //Set Interest Rate
    public void setInterest(double Rate)throws BankException
    {
        ValidationRules.ValidateInterestRate(Rate);
        for(BankAccount acc: accounts)
        {
             if(AccountType.SAVINGS == acc.getAccountType())
             {
                System.out.println("The Common Interest Rate on Your Amount is "+Rate+" % per year."+" So you will get $"+acc.getBalance()*Rate+" per year.");
             }
        }
          System.out.println();
         System.out.println("Interest Rate Applied Successfully to all Savings Accounts.");
    }


    //Sort Accounts as per AccountNumbers
    public void sortedAccounts()
    {
    Collections.sort(accounts); // sorts by accountNo
    }
     
    //Delete All Currents
    public void deleteAllCurrentAccounts()
    {
        for(BankAccount acc: accounts)
        {
            if(AccountType.CURRENT == acc.getAccountType())
              accounts.remove(acc);
        }
    }

   //Sort Accounts By Type And Balance
    public void sortByTypeAndBalance() {
    Collections.sort(accounts, new Comparator<BankAccount>() {
        @Override
        public int compare(BankAccount a1, BankAccount a2) {
            int typeCmp = a1.getAccountType().compareTo(a2.getAccountType());
            if (typeCmp == 0) {
                return Double.compare(a1.getBalance(), a2.getBalance());
            }
            return typeCmp;
        }
    });

    accounts.forEach(System.out::println);
}

//Sort By DOB and Balance
public void sortByDobAndBalance() {
    Collections.sort(accounts, new Comparator<BankAccount>() {
        @Override
        public int compare(BankAccount a1, BankAccount a2) {
            int dobCmp = a1.getDob().compareTo(a2.getDob());
            if (dobCmp == 0) {
                return Double.compare(a1.getBalance(), a2.getBalance());
            }
            return dobCmp;
        }
    });

    accounts.forEach(System.out::println);
}

//Remove Accounts with Minimum Balance;
public void deleteLowBalanceAccounts(double minBalance) {
    accounts.removeIf(acc -> acc.getBalance() < minBalance);
    System.out.println("Accounts after deletion:");
    accounts.forEach(System.out::println);
}


}
