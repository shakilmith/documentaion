//creating Enum

enum Colors{
  RED,
  BLUE,
  YELLOW
}

public class Main{ //file name
  public static void main (String[] args) {
    System.out.println(Colors.RED);
    //or 
    Colors redColor = Colors.RED;
    System.out.println(redColor);
  }
}
/**
 * RED
 * RED
 */
 
 
enum Colors{
  RED,
  BLUE,
  YELLOW
}

public class Main{ //file name
  public static void main (String[] args) {
    
    for(int i = 0; i < Colors.values(). length; i++){
      System.out.println(Colors.values()[i]);
    }
  }
}
/**
 * RED
 * BLUE
 * YELLOW 
 */
 
 //using for each loop
 
enum Colors{
  RED,
  BLUE,
  YELLOW
}

public class Main{ //file name
  public static void main (String[] args) {
    
    //using for each loop
    for(Colors colors: Colors.values()){
      System.out.println(colors);
    }
  }
}
/**
 * RED
 * BLUE
 * YELLOW 
 */
 
 //enum values method
enum Colors{
   RED,
   BLUE,
   YELLOW
 }
 
 public class Main{ //file name
   public static void main (String[] args) {
     
     Colors colors = Colors.values();
     //using values() method
     System.out.println(colors);
   }
 }
 /**
  * RED
  * BLUE
  * YELLOW 
  */