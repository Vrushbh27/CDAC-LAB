// 3.1 Modify yesterday's Point2D's assignment 
// Re factor (modify) & add Point2D class under the package - com.developers.geometry
// Add TestPoint class under the package - com.tester

// 3.2 Make necessary changes , to remove compilation errors.
// (How to compile ?
// Compile from src
// javac -d ..\bin com\tester\TestPoint.java
// )

// 3.3 To run the class ,
// cd ..\bin
// How will you run it ?
// java com.tester.TestPoint


package com.testers;
import com.developers.geometry.Point2D;
import java.util.Scanner;

//Class PointTest
public class PointTest {
    public static void main(String[] args){

        Point2D call = new Point2D();
        
        Scanner sc = new Scanner(System.in);

        int x1,y1;

        System.out.println("Enter the details for first point:");
        System.out.println("Enter the coordinate x:");
        x1=sc.nextInt();
        System.out.println("Enter the coordinate y:");
        y1=sc.nextInt();
        Point2D p1 = new Point2D(x1, y1);
       
        System.out.println();

        System.out.println("Enter the details for second point:");
        System.out.println("Enter the coordinate x:");
        x1=sc.nextInt();
        System.out.println("Enter the coordinate y:");
        y1=sc.nextInt();
        Point2D p2= new Point2D(x1, y1);
        
        System.out.println(p1.show());
        System.out.println();
        System.out.println(p2.show());
        
        System.out.println();

        if(call.isEqual(p1,p2))
        {
            System.out.println("Both Points have same coordinates.");
        }
        else
        {
            System.out.println("Points have different coordinates.");
        }
      
        System.out.println();
        System.out.println("Distance Between points is "+call.calculateDistance(p1, p2));
        sc.close();
    }
}
