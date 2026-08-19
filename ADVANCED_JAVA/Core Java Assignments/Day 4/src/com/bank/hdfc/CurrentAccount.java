//CurrentAccount ->  add overdraftLimit field and method useOverdraftFacility().


package com.bank.hdfc;

public class CurrentAccount extends BankAccount {
      //data members
	  private double overDraftLimit;
	  
	  //Default Constructor
	  public CurrentAccount()
	  {
		  super();
	  }
	  
	  //parameterized Constructor
	  public CurrentAccount(double b,String name,String mb,double overDraftLimit)
	  {
		  super(b,name,mb);
		  this.overDraftLimit = overDraftLimit;
	  }
      
	  //setter
	  public void setOverDraftLimit(double amount)
	  {
		 this.overDraftLimit = amount;
	  }

	  //Getter
	  public double getOverDraftLimit()
	  {
		return this.overDraftLimit;
	  }
	  
	  //Withdraw
	  @Override
	  public String Withdraw(double amount)
	  {
		  if(super.getBalance()+getOverDraftLimit()>= amount){
    return "Amount Withdrawed "+amount+" & reamaining Balance is "+
           ((super.getBalance()+getOverDraftLimit())-amount)+"\n";
		  }
		  else{
		      return "OverDraft Limit Exceeded";
		  }
	  } 
	  
	//  //Over Draft Facility
	//   public String useOverDraftFacility(double amount)
	//   {
	// 	if(super.getBalance()==0 && amount<= 25000)
	// 		return "Withdrawed amount is "+amount;
	// 	else
	// 		return "Over Draft Limit Exceeded..............";
	//   } 
	  
	  @Override
	  public String getAccountSummary()
	  	{
              	return "----------Account Summary-----------\n"+
	                   super.getAccountSummary()+"\n Account Type: Current \n Over Draft Limit:"+overDraftLimit;
	    	}
}
