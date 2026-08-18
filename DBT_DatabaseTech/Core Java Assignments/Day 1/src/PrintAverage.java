/*
   Accept 5 doubles from user (scanner)
Print it's average.

After creating PrintAverage.java (under day1_lab\src)
Open cmd prompt from the same src folder
To compile
javac -d ..\bin PrintAverage.java
cd ..\bin
To run 
java PrintAverage

*/

 java.util.Scanner;

public class PrintAverage
{
	public static void main(String[] args)
	{
		double num,average,sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 5 numbers (Double Datatype): ");
		for(int i = 0; i<5;i++)
		{
			num = sc.nextDouble();
			sum += num;
	    }
		System.out.println("The Average of given numbers is : "+(sum/5));
		 sc.close();
	}
}