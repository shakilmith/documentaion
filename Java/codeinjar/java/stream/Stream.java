import java.util.List;
import java.util.stream.Collectors;

public class Main{
  public static void main (String[] args) {
    
    List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
    List <Integer> result =
    number.stream()
    .map(x -> x*x )
    .collect(Collectors.toList());
    
    System.out.println(result);
    
    result.forEach(y -> System.out.println(y);)
  }
}


# 2 (String)

import java.util.stream.*;
import java.util.*;

public class Main{
  public static void main (String[] args) {
    
    List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
    
    List<String> languages = Arrays.asList("Java", "Python", "Rust", "Ruby")
    
    List<String> result = 
    languages.stream()
    .filter(r -> r.startsWith("R"))
    .collect(Collectors.toList());
    
    
    System.out.println(result);
    
    result.forEach(y -> System.out.println(y);)
  }
}



// Example 1:

import java.util.List;
import java.util.stream.Collectors;

public class Main{
  public static void main (String[] args) {
    
    //create list of integer data 
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    
    //returns a list using stream()
    List<Integer> result = numbers.stream().collect(Collectors.toList());
    
    //print the stream result
    System.out.println(result); //returns array of list
  }
}
/**
 * Output:
 * [1, 2, 3, 4, 5]
 */
 
 Note: collect(Collectors.toList()) can be replaced with toList() method. Similarly toSet() or toMap() etc.
 
 
 //example 2
 
 import java.util.List;
 import java.util.stream.Collectors;
 
 public class Main{
   public static void main (String[] args) {
     
     //creating list of integer 
     List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    
    //returns a list of stream
     List<Integer> result = number.stream()
     .map(x -> x*2) //lambda expression as function
     .collect(Collectors.toList());
     
     //print the result
     System.out.println(result);
   }
 }
 
 /**
  * Output:
  * [2, 4, 6, 8, 10]
  */
  
  
 // Example 3
 
 import java.util.List;
 import java.util.stream.Collectors;
 
 public class Main{
   public static void main (String[] args) {
     
     //creating list of integer 
     List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    
    //returns square of the elements
     List<Integer> squareResult= numbers.stream()
     .map(x -> x*x) //lambda expression as function
     .collect(Collectors.toList()); //returns a result as list
     
     //returns cube of the elements
     List<Integer> cubeResult= numbers.stream()
     .map(x -> x*x) //lambda expression as function
     .collect(Collectors.toList()); // returns a result as list
     
     
     //print the results of the stream
     System.out.println(squareResult);
     System.out.println(cubeResult);
   }
 }
 
 /**
  * Output:
  * [1, 4, 9, 16, 25]
  * [1, 8, 27, 64, 125]
  */
  
  
  # example 4
  
import java.util.List;
import java.util.stream.Collectors;

public class Main{
  public static void main (String[] args) {
    
    List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
    List <Integer> result =
    number.stream()
    .map(x -> x*x )
    .collect(Collectors.toList());
    
    System.out.println("Print the stream result using forEach loop");
    
    result.forEach(number -> System.out.println(number);)
  }
}
/**
 * Output:
 * 1
 * 2
 * 3
 * 4
 * 5
 */
 
# Example 5

import java.util.List;
import java.util.stream.Collectors;

public class Main{
  public static void main (String[] args) {
    
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    //print the result using forEach loop
    numbers.stream.forEach(System.out::println);
  }
}
/**
 * Output:
 * 1
 * 2
 * 3
 * 4
 * 5
 */


# Example 6

import java.util.List;
import java.util.stream.Collectors;

public class Main{
  public static void main (String[] args) {
    
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    //print the result using forEach loop
    numbers.stream.map(x -> x*x).filter(y -> y > 50).forEach(System.out::println);
  }
}
/**
 * Output:
 * 64
 * 81
 * 100
 */

# Using filter method 

import java.util.List;
import java.util.stream.*;

public class Main{
  public static void main (String[] args) {
    
    List<String> languages = List.of("C++", "Java", "Ruby", "Python", "Rust");
    //print the result using forEach loop
    numbers.stream.filter(r -> r.startsWith("R")).forEach(System.out::println);
  }
}
/**
 * Output:
 * Ruby
 * Rust
 */
