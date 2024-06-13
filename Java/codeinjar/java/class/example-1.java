public class Rectangular{
  //static width and height
 static float width = 12.0f;
 static float height = 10.0f;
  
  //non static method
  public float showArea(float x, float y){
    return x*y;
  }
  
  public static void main(String [] args){
    //access the state members
    //without creating the object
    //of the class
    System.out.println("Rect Width: "+ width);
   System.out.println("Rect Height "+ height);
   
   //call the showArea() method
   //System.out.println(showArea(width, height)); //you will get error
   //so you have to create object of the 
   //class to access the showArea()
   //method
   //create an object the Rectangular class
   Rectangular rect = new Rectangular();
   System.out.println("Area of Rectangle "+ rect.showArea(width, height));
    
  }
}
/**
 * Output:
 * Rect Width: 12.0
 * Rect Height 10.0
 * Area of Rectangle 120.0
 */
 
 