//SavingAccount -> add interestRate field and method applyInterest().


package com.bank.hdfc;

public class SavingsAccount extends BankAccount {
        private double interestRate;
        
        //Default Constructor
        public SavingsAccount() {
			super();
		}
        
        //Parameterized Constructor
        public SavingsAccount(double b,String name,long mb,double ir)
        {
        	super(b,name,mb);
        	this.interestRate = ir;
        }

        //Set Interest Rate
        public void setInterest(double interest)
        {
            this.interestRate = interest;
        }

        //get InterestRate
        public double getInterestRate()
        {
            return this.interestRate;
        }
        
        //apply InterestRate
        public String applyInterestRate()
        {
        	return "Interest on your amount is:"+((super.getBalance()*getInterestRate())/100)+
        			" with rate of Interest "+getInterestRate()+"% per year.";
        }

        //Overriding Withdraw Method
        @Override
        public String Withdraw(double amount) {
            if(getBalance() >= amount) {
                 setBalance(getBalance() - amount);
                return "Amount Withdrawn: " + amount + " | Remaining Balance: " + getBalance();
            } else {
                    return "Withdrawal failed! Savings Account cannot go negative.";
                }
            }

        
        @Override
        public String toString()
  	{
//    		return "Account Holder Name: "+name+
//    				"\n Account Number: "+accountNum+
//    				"\n Mobile Number: "+mobileNo+
//    				"\n Account Balance:"+balance;

        	return "----------Account Summary-----------\n"+
                   super.toString()+"\n Account Type: Savings \n"+applyInterestRate();
    	}
}
