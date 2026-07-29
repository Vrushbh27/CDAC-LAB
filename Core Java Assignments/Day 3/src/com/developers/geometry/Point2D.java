package com.developers.geometry;

public class Point2D {
    private int x;
    private int y;
   
    //Default Constructor
   public  Point2D(){};
   
    //Parameterized
    public Point2D(int x,int y){
        this.x=x;
        this.y=y;
    }

    public String show(){
        return "The given coordinates are: x="+x+" y="+y;
    }
    
    public int getValueX()
    {
          return x;
    }
    
   public int getValueY()
    {
          return y;
    }

    //isEqual Fuction
    public boolean isEqual(Point2D p, Point2D q)
    {
        if((p.getValueX()==q.getValueX()) && (p.getValueY()==q.getValueY()))
            return true;
        else
              return false;
    }

    public double calculateDistance(Point2D p, Point2D q)
    {
       return Math.sqrt(
        Math.pow(p.getValueX() - q.getValueX(), 2) +
        Math.pow(p.getValueY() - q.getValueY(), 2)
    );
    }
    
}
