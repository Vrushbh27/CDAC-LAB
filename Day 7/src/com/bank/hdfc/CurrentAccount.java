//CurrentAccount ->  add overdraftLimit field and method useOverdraftFacility().
package com.bank.hdfc;

import com.BankingExceptions.InSufficientBalanceException;

public class CurrentAccount extends BankAccount {
    //data members

    private double overDraftLimit;

    //Default Constructor
    public CurrentAccount() {
        super();
    }

    //parameterized Constructor
    public CurrentAccount(double b, String name, String mb, double overDraftLimit) {
        super(b, name, mb);
        this.overDraftLimit = overDraftLimit;
    }

    //setter
    public void setOverDraftLimit(double amount) {
        this.overDraftLimit = amount;
    }

    //Getter
    public double getOverDraftLimit() {
        return this.overDraftLimit;
    }

    //Withdraw
    @Override

     public String Withdraw(double amount) throws InSufficientBalanceException {
    if (getBalance()+getOverDraftLimit() < amount) {
        throw new InSufficientBalanceException("OverDraft Limit Exceeded. Available: " + getBalance());
    }
       setBalance(getBalance()+getOverDraftLimit() - amount);
    return "Withdrawal Successful. Remaining Balance: " + getBalance();
    }

    //   public String Withdraw(double amount)
    //   {
    // 	  if(super.getBalance()+getOverDraftLimit()>= amount){
    // return "Amount Withdrawed "+amount+" & reamaining Balance is "+
    //        ((super.getBalance()+getOverDraftLimit())-amount)+"\n";
    // 	  }
    // 	  else{
    // 	      return "OverDraft Limit Exceeded";
    // 	  }
    //   } 

    // public void Withdraw(double amount) throws InSufficientBalanceException {
    //     try {
    //         if (super.getBalance() + getOverDraftLimit() >= amount) {
    //             System.out.println("Amount Withdrawed " + amount + " & reamaining Balance is " + ((super.getBalance() + getOverDraftLimit()) - amount)); 
	// 			 double newBalance = (super.getBalance() + getOverDraftLimit()) - amount;
	// 			 //Setting new Balance.
	// 			  super.setBalance(newBalance);
    //         }else {
    //             throw new InSufficientBalanceException("Over Draft Limit Exceeded...!");
    //         }
    //     } catch (InSufficientBalanceException e) {
    //         System.out.println(e);
    //     }
    // }

    //  //Over Draft Facility
    //   public String useOverDraftFacility(double amount)
    //   {
    // 	if(super.getBalance()==0 && amount<= 25000)
    // 		return "Withdrawed amount is "+amount;
    // 	else
    // 		return "Over Draft Limit Exceeded..............";
    //   } 
    @Override
    public String getAccountSummary() {
        return "----------Account Summary-----------\n"
                + super.getAccountSummary() + "\n Account Type: Current \n Over Draft Limit:" + overDraftLimit;
    }
}
