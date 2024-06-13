import java.util.LinkedList;

public class Main{
  public static void main (String[] args){
    //creating LinkedList
    LinkedList<String> fruits = new LinkedList<String>(); 
    //add new elements
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Cherry");
    fruits.add("Guava");
    fruits.add("Blackberry");
    
    //print the elements
    System.out.println(fruits);
  }
}

/**
 * Output: 
 * [Apple, Banana, Cherry, Guava, Blackberr]
 */
 
 # Removing elements from a an Existing LinkedList
 
 import java.util.LinkedList;
 
 public class Main{
  public static void main (String[] args){
    //creating LinkedList
    LinkedList<String> fruits = new LinkedList<String>(); 
    //add new elements
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Cherry");
    fruits.add("Guava");
    fruits.add("Blackberry");
    
    //print the elements
    System.out.println(fruits);
    
    //remove the first element
    fruits.remove("Apple");
    //Now print the above fruits list
    System.out.println(fruits);
  }
}

/**
 * Output: 
 * [Apple, Banana, Cherry, Guava, Blackberr]
 * After removing
 * [Banana, Cherry, Guava, Blackberry]
 */
 
 
 // addFirst() addLast() removeFirst() removeLast()
 
 import java.util.LinkedList;
 
 public class Main{
  public static void main (String[] args){
    //creating LinkedList
    LinkedList<String> fruits = new LinkedList<String>(); 
    //add new elements
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Cherry");
    fruits.add("Guava");
    fruits.add("Blackberry");
    
    //print the elements
    System.out.println(fruits);
    
    //addFirst() 
    fruits.addFirst("Orange");
    
    //Now print the above fruits list
    System.out.println(fruits);
    
   //addLast() 
   fruits.addLast("Plum")
   //now print fruits
   System.out.println(fruits);
   
   //removeFast()
   fruits.removeFirst();
   //print the list
   System.out.println(fruits);
   
   //removeLast()
   fruits.removeLast();
   //print the list now
   System.out.println(fruits);
  }
}


//Output

[Apple, Banana, Cherry, Guava, Blackberry]
[Orange, Apple, Banana, Cherry, Guava, Blackberry]
[Orange, Apple, Banana, Cherry, Guava, Blackberry, Plum]
[Apple, Banana, Cherry, Guava, Blackberry, Plum]
[Apple, Banana, Cherry, Guava, Blackberry]
