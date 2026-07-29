package com.testers;
import com.developers.geometry.Box;
import java.util.Scanner;
public class TestBox {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
         int size;
         double length,width,depth;

        //Creating Object Array
        System.out.println("Enter the Size of the Array: ");
        size = sc.nextInt();
        Box[] boxes = new Box[size];
        
        //Enter the details of Boxt
         for(int i = 0; i<boxes.length;i++)
         {
            System.out.println("For Box "+(i+1));
            System.out.println("Enter the length: ");
            length = sc.nextDouble();

            System.out.println("Enter the width: ");
            width = sc.nextDouble();

            System.out.println("Enter the Depth: ");
            depth = sc.nextDouble();
          
           boxes[i] = new Box(length,width,depth);

            System.out.println();
         }
        
         //for each loop
         for(Box b : boxes){
                  System.out.println(b.getDimensions());
                  System.out.println("Volume is "+b.getVolume());
                  System.out.println();
         }

         //for each loop to Change Dimensions
         for(Box b:boxes)
         {
            if(b.getVolume()<100){
                b.Do_double();
                flag = true;
            }
         if(flag == true)
         {
            System.out.println("Updated Width = "+b.getWidth()+" Volume = "+b.getVolume());
            break;
         }
      }
         sc.close();
    }
}
