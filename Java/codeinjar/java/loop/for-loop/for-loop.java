Syntax: 

for(initialization; condition; iteration){
  //statement to iterate 
}

Such as: 

for(int i = 0; i < 10; i++ ){
  System.out.println(i); //not only the inner variable, applicable for anything
}


//for loop example: 

public class Main{
  public static void main (String[] args) {
    //for lopp to print 1 to 10 
    for(int i = 1; i < 10; i++){
      //statement
      System.out.println(i);
    }
  }
}

//output: 
1
2
3
4
5
6
7
8
9

//declare the variable outside the loop

public class Main{
  public static void main (String[] args) {
    //declaring the loop control variable
    int i;
    //for lopp to print 1 to 10 
    for( i = 1; i < 10; i++){
      //statement
      System.out.println(i);
    }
  }
}

# increase by 2

public class Main{
  public static void main (String[] args) {
    //for lopp to print 1 to 10 
    for(int i = 1; i < 10; i = i + 2){
      //statement
      System.out.println(i);
    }
  }
}
/**
 * Output: 
 * 1 
 * 3
 * 5
 * 7
 * 9
 */

// increase by 2
public class Main{
  public static void main (String[] args) {
    //for lopp to print 1 to 10 
    for(int i = 0; i < 10; i = i + 2){
      //statement
      System.out.println(i);
    }
  }
}
/**
 * Output:
 * 0
 * 2
 * 4
 * 6
 * 8
 */


// loop syring variable

public class Main{
  public static void main (String[] args) {
    //for lopp to print 1 to 10 
    for(int i = 1; i < 10; i = i + 2){
      //statement
      System.out.println(i);
    }
  }
}
/**
 * Output: 
 * 1 
 * 3
 * 5
 * 7
 * 9
 */

# iterate String 

public class Main{
  public static void main (String[] args) {
    
    String name = "Codeinjar";
    //for lopp to print 1 to 10 
    for(int i = 0; i < name.length(); i++){
      //statement
      System.out.print(name.charAt(i) + " ");
    }
  }
}
/**
 * C
 * o
 * d
 * e
 * i
 * n
 * j
 * a
 * r
 */

Or if you want to loop through the String side by side use print() than prinln().

like:

public class Main{
  public static void main (String[] args) {
    
    String name = "Codeinjar";
    //for lopp to print 1 to 10 
    for(int i = 0; i < name.length(); i++){
      //statement
      System.out.print(name.charAt(i) + " ");
    }
  }
}
/**
 * Output:
 * C o d i n j a r
 */


# For loop to find out odd and even number from 0 to 20 

public class Main{
  public static void main (String[] args) {
    //print odd number from 0 to 20
    System.out.println("Odd Numbers");
    for(int i = 1; i <= 20; i = i + 2){
      System.out.print(i +" ");
    }
    //print evem number
    System.out.println("Even numbers");
    for(int i = 2; i <= 20; i = i + 2){
      System.out.print(i +" ");
    }
  }
}
/**
 * Output:
 * Odd Numbers
 * 1 3 5 7 9 11 13 15 17 19 
 * Even numbers
 * 2 4 6 8 10 12 14 16 18 20 
 */


# For loop with if statement (print odd numbers)

public class Main{
  public static void main (String[] args) {
    
    //print odd numbers
    System.out.println("Odd Numbers");
    
    for(int i = 1; i <= 20; i++){
      
      //condition to print odd numbers
      if(i % 2 != 0){
        System.out.print(i +" "); //output will be side by side
      }
    }
  }
}
/**
 * Output:
 * 1 3 5 7 9 11 13 15 17 19
 * 
 */
 
 # For loop with if statement (print even numbers)

public class Main{
  public static void main (String[] args) {
    
    //print even numbers
    System.out.println("Even Numbers");
    
    for(int i = 1; i <= 20; i++){
      
      //condition to print odd numbers
      if(i % 2 == 0){
        System.out.print(i +" "); //output will be side by side
      }
    }
  }
}
/**
 * Output:
 * Even Numbers
 * 2 4 6 8 10 12 14 16 18 20 
 */
 

# Iterate an array elements using for loop

public class Main{
  public static void main (String[] args) {
    
    int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    
    //loop through the array using for loop
    for(int i = 0; i < numbers.length; i++){
      //print the numbers
      System.out.print(numbers[i] +" ");
    }
  }
}
/**
 * 1 2 3 4 5 6 7 8 9 10 
 */