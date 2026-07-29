// 4.5  Create a separate Driver(main)  class(for UI )  , "TestPoint" , with main(..)
// 4.6  Accept x,y co-ordinates for 2 points & store the co-ordinates
// 4.7  Display x,y co-ordinates of both of the points plotted  (using show() method)
// 4.8  (OPTIONAL WORK)
// Find out if the points  are same or different (Hint : isEqual)
// Print the message accordingly. (print SAME or DIFFERENT)
// If points are not same , display distance between these 2 points.


import java.util.Scanner;

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
    }
}
