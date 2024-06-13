while(condition){
      //statement to execute
      iteration (increment/decrement);
}


# Simple example to demonstrate while loop in Java 

public class Main{
  public static void main (String[] args) {
    
    //initial variable
    int x = 1; 
    int y = 10
    while( x < 10){
      //statement to be executed
      System.out.print(x +" ");
      
      //iteration
      x++; //increment by one
    }
    System.out.println(" ");
    while(y > 0){
      //statement to be executed
      System.out.print(y +" ");
      
      //iteration
      y--; //decrement by ine 
    }
  }
}
/**
 * Output
 * 1 2 3 4 5 6 7 8 9 10
 * 10 9 8 7 6 5 4 3 2 1
 */


# even the condition becomes false while loop prints the initial statement

public class Main{
  public static void main (String[] args) {
    int x = 10;
    
    while (x > 10 ){
      System.out.println(x);
      x++;
    }
  }
}

# Another example

public class Main{
  public static void main (String[] args) {
    int x = 10; 
    int y = 20; 
    
    while(x < y){
      System.out.print(x +", ");
      x++;
    }
    
    //but there is no output
    while(x > y){
      System.out.println(x); //why no output? explains below
      x++;
    }
  }
}
/**
 * Output: 
 * 10
 * displays nothing for the second while
 */
 
 