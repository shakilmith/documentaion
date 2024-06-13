public class Main{
  public static void main (String[] args) {
    //creating empty HashSet
    HashSet<String> set = new HashSet<String>();
  }
}

//Integer

import java.util.HashSet;

public class Main{
  public static void main (String[] args){
    HashSet<Integer> numbers = new HashSet<Integer>();
    //add elements using add method
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);
    
    //print the elements
    System.out.println(numbers);
  }
}

/**
 * Output:
 * [1, 2, 3, 4, 5]
 */
 
 
 # 
 
 import java.util.HashSet;

public class Main{
  public static void main (String[] args){
    HashSet<String> fruits = new HashSet<String>();
    //add elements using add method
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Cherry");
    fruits.add("Guava");
    fruits.add("Plum");
    
    //print the elements
    System.out.println(fruits);
  }
}

#

import java.util.HashSet;

public class Main{
  public static void main (String[] args){
    HashSet<String> fruits = new HashSet<String>();
    //add elements using add method
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Apple");
    fruits.add("Guava");
    fruits.add("Plum");
    fruits.add("Banana")
    
    //print the elements
    System.out.println(fruits);
  }
}

/**
 * Output: 
 * [Guava, Apple, Plum, Banana]
 */