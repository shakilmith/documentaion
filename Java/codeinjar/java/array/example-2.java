public class Main(){
  public static void main (String[] args){
  //creating array of fruits
  String [] fruits = {"Apple", "Banana", "Orange", "Mango", "Grape", "Kiwi", "Cherry", "Pineapple", "Papaya", "Blueberry"}; 
  
  //loop through the array
  //using for loop
  System.out.println("Fruits List: (using for loop)");
  for(int i = 0; i< fruits.length; i++){
    System.out.println(fruits[i]);
  }
  
  //iterate the fruits array using
  //enhanced for/foreach loop
  System.out.println("Fruits List: (using foreach loop)");
  for(String fruit: fruits){
    System.out.println(fruit);
  }
  }
}
/**
 * Output:
 * Fruits List: (using for loop)
 * Apple
 * Banana
 * Orange
 * Mango
 * Grape
 * Kiwi
 * Cherry
 * Pineapple
 * Papaya
 * Blueberry
 * 
 * Fruits List: (using foreach loop)
 * Apple
 * Banana
 * OrangeMango
 * Grape
 * Kiwi
 * Cherry
 * Pineapple
 * Papaya
 * Blueberry
 * 
 */
 
 
 //cars array
 
 String [] cars = {"Volvo", "Mustang", "Maruti", "BMW", "Honda"};
 
Now, changing the first element if this array we can use the syntax:
cars[0] = "Audi";

Changing the second element we can use the syntax:
cars [1] = "Ford";

Likewise the above syntax, we can change the members of the array referring the index number. 

public class Main{
  public static void main (String[] args){
    
    //cars array 
    String [] cars = {"Volvo", "Mustang", "Maruti", "BMW", "Honda"};
    
    //print the first element
    System.out.println("First Car before changing is: "+cars[0]);
    
    //change the first element of the
    //cars array
    cars[0] = "Audi";
    //now print the first element
    System.out.println("First Car after changing is: "+cars[0]);
  }
}
/**
 * Output:
 * First car before changing is: Volvo
 * First car after changing is: Audi
 */