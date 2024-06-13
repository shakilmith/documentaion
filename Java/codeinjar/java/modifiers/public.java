package com.company;

public class Rectangle{
  public float printArea(float width, float height){
    return width*height;
  }
  
  //main method
  public static void main (String[] args)
  {
   //create an object of Rectangle
   Rectangle rect = new Rectangle();
   System.out.println(rect.printArea(12.0f, 8.0f));
   
  }
}
/**
 * Output
 * 96.0
 */
 

//from different class (outside the decalared class)

//Rectangle class

package com.company;

public class Rectangle{
  public float printArea(float width, float height){
    return width*height;
  }
  
  
 //TestExample class 
 
package com.company;

public class TestExample{
  
  public static void main (String[] args)
  {
   //create an object of Rectangle
   Rectangle rect = new Rectangle();
   System.out.println(rect.printArea(12.0f, 8.0f));
   
  }
}
/**
 * Output
 * 96.0
 */


//outside the decalared class, from a different package

//Rectangle class

package com.company;
 
 public class Rectangle{
   public float printArea(float width, float height){
     return width*height;
   }
   
   
  //TestExample class 
  
 package com.company;
 
 public class TestExample{
   
   public static void main (String[] args)
   {
    //create an object of Rectangle
    Rectangle rect = new Rectangle();
    System.out.println(rect.printArea(12.0f, 8.0f));
    
   }
 }
 /**
  * Output
  * 96.0
  */
 
//through inheritance

package com.company;

class Shape{
  public float printArea(float width, float height){
    return width*height;
  }
}
  
public class Rectangle extends Shape{
    public static void main (String[] args) {
  //create an object of Rectangle
  Rectangle rect = new Rectangle();
  System.out.println(rect.printArea(12.0f, 8.0f));
    }
}
/**
 * Output
 * 96.0
 */
 
 


 