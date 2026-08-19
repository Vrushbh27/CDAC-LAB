/*
Write Java program for the following - 
It should  run till user enters any other option than add or sub or multiply or divide
Prompt user to enter the input operation : (add|subtract|multiply|divide) & 2 numbers(double)
Display the result of the operation.
Use Scanner for accepting all inputs from user. 
*/

import java.util.Scanner;

public class Calculator
{
  public static void main(String[] args)
  {
     Scanner sc = new Scanner(System.in);
	 double num1,num2;
	 int choice;
	  //boolean exit = false;
	 do
	 {
	   System.out.println("-----------------Arithmetic Operations-----------------");
	   System.out.println("1) Add ");
	   System.out.println("2) Substract ");
	   System.out.println("3) Multiply ");
	   System.out.println("4) Divide ");
	   System.out.println("5) Power ");
	   System.out.println("6) Modulo ");
	   System.out.println("7) Exit ");
	  
	    System.out.println();
		
		 System.out.println("Enter two numbers(Double Datatype): ");
		 num1 = sc.nextDouble();
		 num2 = sc.nextDouble();
		 
	    System.out.println(" Enter the choice: ");
		choice = sc.nextInt();
		switch(choice)
		{
		   case 1:
		            System.out.println("The sum is "+(num1+num2));
					break;
					
			case 2:
			       System.out.println("The Substraction is "+(num1-num2));
					break;  
					
			case 3:
			        System.out.println("The Multiplication is "+(num1*num2));
					break;
			
			case 4:
			        System.out.println("The Division is "+(num1/num2));
					break;
					
			case 5: 
			        System.out.println(num1+" to the power "+num2+" is "+(num1 % num2));
					break;
					
			case 6:
			         System.out.println("The modulo is "+(num1+num2));
					break;
					
			case 7:
			         System.out.println("Exiting the Program...");
					  break;
					
			default:
			         System.out.println("Invalid Operation!");
		}
	 }while(choice!= 7);
	 sc.close();
  }
}