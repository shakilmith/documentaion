interface A {
  //data members
  
  /**
   * By default
   * attributes are public, static, final
   * methods are public and abstract
   */
}
//implemented class (subclass in other form)
class X implemens A {
  //own data members
  //acquires the data members of interface A
}



//Examples

//return the are la of shape (rectangle, circle, square)

interface Shape{
  //method that return the area of any shape
  float printArea(float width, height); //this method doesn't have body
}

//implemented class 
class Rectangular implements Shape{
  //Override the method of the interface
  public float printArea(float width, float height){
    return width*height;
  }
}

//second implemented class 
class Square implements Shape{
  //Override the method of the interface
  public float printArea(float width, float height){
    return width*height;
  }
}

//third implemented class 
class Circle implements Shape{
  //Override the method of the interface
  static float PI = 3.1416f;
  public float printArea(float width, float height){
    return width*height*PI;
  }
}


//main class file (should be your file name)

public class InterfaceExample{
  public static void main (String[] args) {
    //create the objects of implemented class 
    Rectangular rect = new Rectangular();
    Square sq = new Square();
    Circle c = new Circle();
    
    //print the are of the shapes now
    System.out.println("Area of Rectangular is: "+ rect.printArea(12.00f, 8.00f));
    System.out.println("Area of Square is: "+sq.printArea(15.00f, 15.00f));
    System.out.println("Area of Circle is: "+c.printArea(8.00f, 8.00f));
  }
}

/**
 * Output: 
 * Area of Rectangular is: 96.0
 * Area of Square is: 225.0
 * Area of Circle is: 201.0624
 */