// 2.1 BankingTester
// 2.2 BankingService
// - openSavingAccount 
// - openCurrentAccount
// 2.3 BankingServiceImpl
//  - create bank account[].
//  - In opening account method - 
//   - invoke validation rules(call method of BankingValidations)
//    In case of success , create bank account & add its reference to the array.
//    Otherwise delegate the exception to the caller(Tester)
 
// 3. BankingValidations
//  Add single method (preferably !) to call different validation rules.
//   Validation rules - 
//   - dup account no (has to based on equals)
//   - if its a saving account , initial balance > MIN BALANCE

// 4. Custom exception

// 5. Core classes 
//  - BankAccount
// (If you want , you can add a field accountType : enum - AccountType
// SAVING , CURRENT)


package com.bankingservice;

import com.bankexceptions.BankException;

public interface BankingServices {
    void openSavingsAccount() throws BankException;

    void openCurrentAccount() throws BankException;

    String withdraw(String type, String accountNum, double amount) throws BankException;

    double deposit(String accountNum, double amount) throws BankException;

    String getAccountSummary(String accountNum) throws BankException;
}
