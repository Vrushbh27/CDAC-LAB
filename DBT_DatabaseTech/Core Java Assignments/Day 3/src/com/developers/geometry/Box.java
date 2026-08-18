package com.developers.geometry;
public class Box 
{
    //Scanner sc = new Scanner(System.in);

    //Data Members or Properties

     private double length;
     private double width;
     private double  depth;
  
    //public Constructor

    public Box(double length, double width, double  depth)
    {
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    //for cube
    public Box(double side)
    {
       // this.length = this.width = this.depth = length;
       this(side,side,side);
    }

  //Default Constructor
    public Box()
    {
        this(-1);
    };

    //Setters
    // public void setLength(double length)
    // {
    //     // System.out.println("Enter the length: ");
    //     // length = sc.nextDouble();
    //     this.length = length;
    // }

    public void setWidth(double width)
    {
        // System.out.println("Enter the length: ");
        // width = sc.nextDouble();
        this.width = width;
    }

    // public void setDepth(double depth)
    // {
    //     // System.out.println("Enter the length: ");
    //     // depth = sc.nextDouble();
    //     this.depth = depth;
    // }

   // Getters
   
   public double getLength()
    {
        return length;
    }

    public double getWidth()
    {
        return width;
    }

    public double getDepth()
    {
        return depth;
    }

    public double Do_double()
    {
         return this.width*= 2;
    }
    
    //Function for Dimension
    public String getDimensions()
    {
        return "Dimensions of a Box are length = "+this.length+" width = "+this.width+" depth = "+this.depth;
    }

    //Function for Volume
     public double getVolume()
     {
        return this.length* this.width* this.depth;
     }
    // sc.close();
}
