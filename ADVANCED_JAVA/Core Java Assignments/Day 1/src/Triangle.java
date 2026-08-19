
import java.util.Scanner;

//Patterns

public  class Triangle
{
    public static void main(String[] args) {
         int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        num = sc.nextInt();

         for (int i = 1; i <= num; i++) {
        // print spaces
        for (int j = 1; j <= num - i; j++) {
            System.out.print(" ");
        }
        // print stars
        for (int k = 1; k <= i; k++) {
             System.out.print("*");
        }
         System.out.println();
    }
        sc.close();
    }
}

//      *
//     **
//    ***
//  *****
// ******