// Create a  class Point2D   for representing a point in x & y(int) co-ordinate system.
// (Tight encapsulation please !)

// 4.1 Create a parameterized constructor to accept x & y co-ords.

// 4.2 Add  show() method  --to return point's x & y co-ords
//Add a non static  , isEqual method to Point2D class : boolean returning method : must return true if both points are having same x,y co-ords or false otherwise.
// Add a non static method , calculateDistance , to calc distance between 2 points
// Hint : use distance formula.

import java.lang.Math;

public class Point2D {
    private int x;
    private int y;
   
    //Default Constructor
    Point2D(){};
   
    //Parameterized
    Point2D(int x,int y){
        this.x=x;
        this.y=y;
    }

    String show(){
        return "The given coordinates are: x="+x+" y="+y;
    }
    
    int getValueX()
    {
          return x;
    }
    
    int getValueY()
    {
          return y;
    }

    //isEqual Fuction
     boolean isEqual(Point2D p, Point2D q)
    {
        if((p.getValueX()==q.getValueX()) && (p.getValueY()==q.getValueY()))
            return true;
        else
              return false;
    }

    double calculateDistance(Point2D p, Point2D q)
    {
       return Math.sqrt(
        Math.pow(p.getValueX() - q.getValueX(), 2) +
        Math.pow(p.getValueY() - q.getValueY(), 2)
    );
    }
    
}
