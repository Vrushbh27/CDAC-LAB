//  Copy  earlier Point2D class .
// 6.2    Create a driver / tester   class(for UI)  , in the "tester" package "TestPoints" , with main(..)
// 1. Prompt user , how many points to plot? 
// Create suitable array. (Hint : array of references)
// 2. Show following options
// Options : 
// 1. Plot a point
// Inputs : array index , x  ,y
// Check boundary conditions  & also check if some point is already plotted at the same index , if not then store the point details.
// In case of any errors , display suitable error message.
// 2.   Display x,y co-ordinates of all the points plotted so far ,using for-each loop.
// 0. Exit 
package com.testers;

import com.developers.geometry.Point2D;
import java.util.Scanner;

public class PointTes2 {

    public static void main(String[] args) {
        //Scanner class call
        Scanner sc = new Scanner(System.in);
         int Choice,size,index = 0;
        //Input No. of Points
        System.out.println("Enter the No. of Points that you want to plant: ");
        size = sc.nextInt();

        Point2D[] newPoint2Ds = new Point2D[size];
        System.out.println();

        System.out.println("------------Menu-----------");
        System.out.println();
        System.out.println("1) Plot the points.");
        System.out.println("2) Display Points");
        System.out.println("3)Exit");
        System.out.println();
 
        do { 
                System.out.println("Ente the Choice: ");
                Choice = sc.nextInt();

           switch(Choice){
                  case 1:
            //Inserting A points
            System.out.println("Enter the details for " + (index + 1) + " point: ");
            System.out.println();

            System.out.println("Enter the coordinate x:");
            int x = sc.nextInt();
            System.out.println();

            System.out.println("Enter the coordinate y:");
            int y = sc.nextInt();
            Point2D point = new Point2D(x, y);
           
            
            boolean duplicate = false;
            for (Point2D p : newPoint2Ds) {
                if (p != null && p.getValueX() == point.getValueX() && p.getValueY() == point.getValueY()) {
                    System.out.println("Error!!! Point already exists!");
                    duplicate = true;
                    break;  // stop checking further
                }
            }
            if (!duplicate) {
                newPoint2Ds[index] = point;  // only add if no duplicate found
                index++;
            }
        System.out.println();
        break;

        case 2:
        //Dislaying Point Array
        System.out.println("Your Points are : ");
        System.out.println();
        for (Point2D p : newPoint2Ds) {
            if (p != null) {
                System.out.println(p.show());
            }
           }
          break;
         case 3:
               System.out.println("Exiting the Program...");   
               break;
        default:
               System.out.println("Invalid Choice! Enter Once Again!");
               System.out.println();
          }
        } while (Choice != 3); 
        sc.close();
    }
}
