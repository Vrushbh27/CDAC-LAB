/*
Write Java program - 
Display food menu to user. 
User will select items from menu along with the quantity. 
(eg 1. Dosa 2. Samosa 3. Idli ... 0 . Generate Bill ) 
Assign fixed prices to food items(hard code the prices)
When user enters 'Generate Bill' option(0) , display total bill & exit.

*/
import java.util.Scanner;

public class GenerateBill
{
	
	public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
	 //int choice;
	  double bill = 0;
	  boolean exit= false;
	  do{
	    System.out.println("--------------Menu-------------");
		System.out.println("0) Generate the Bill ");
		System.out.println("1) Tea ");
		System.out.println("2) Samosa ");
		System.out.println("3) Idali ");
		System.out.println("4)  Dosa ");
		
		System.out.println("Enter the Choice:");
		 
		switch(sc.nextInt())
		{
			case 1:
			         bill = bill + 10;
					 break;
					 
			case 2:
			         bill += 15;
					 break;
					 
			case 3: 
			         bill += 30;
					 break;
					 
			case 4:
			         bill += 40;
					 break;
					 
			case 0:
			         System.out.println("Your Total Bill is "+bill);
					 exit = true;
					 break;
			
			default:
			        System.out.println("Menu is not Present.");
		  }
	   }while(!exit);  
       sc.close()	   
	}
}