public class Main{
  public static void main (String[] args) {
    //Creating ArrayList
    List<Integer> numbers = new ArrayList<Integer>();
    //add elements 
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);
    numbers.add(40);
    numbers.add(50);
    
    //Creating Iterator
    Iterator<Integer> itr = numbers.iterator();
    
    //using hasNext() and next() method to print the elements of the ArrayList
    while (itr.hasNext()){
      System.out.println(itr.next());
    }
  }
}
/**
 * 10
 * 20
 * 30
 * 40
 * 50
 */
 
# Example 2

public class Main{
  public static void main (String[] args) {
    //Creating ArrayList
    List<Integer> numbers = new ArrayList<Integer>();
    //add elements 
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);
    numbers.add(40);
    numbers.add(50);
    
    //Creating Iterator
    Iterator<Integer> itr = numbers.iterator();
    
    //using hasNext() and next() method to print the elements of the ArrayList
    while (itr.hasNext()){
      
      //implie condition to remove elements
      if(itr.next() < 30){
        itr.remove();
      }
    }
    //print the list
    System.out.println(numbers);
  }
}
/**
 * [30, 40, 50]
 */
 