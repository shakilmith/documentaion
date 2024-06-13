public class Main{
  public static void main (String[] args) {
    HashSet<K, V> map = new HashMap<K, V>();
  }
}

# 

import java.util.HashMap;

public class Main{
  public static void main (String[] args) {
    //creating HashMap
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    
    //add new elements using put() method
    map.put(1, "Mark Smith");
    map.put(2, "Bob Smith");
    map.put(3, "Jekov Jenkov");
    map.put(4, "Shakil Ahmed");
    map.put(5, "Jhon Peterson");
    
    //print the HashMap
    System.out.println(map);
  }
}

//Output:

{1=Mark Smith, 2=Bob Smith, 3=Jekov Jenkov, 4=Shakil Ahmed, 5=Jhon Peterson}


// getValue() method

import java.util.HashMap;

public class Main{
  public static void main (String[] args) {
    //creating HashMap
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    
    //add new elements using put() method
    map.put(1, "Mark Smith");
    map.put(2, "Bob Smith");
    map.put(3, "Jekov Jenkov");
    map.put(4, "Shakil Ahmed");
    map.put(5, "Jhon Peterson");
    
    //print the HashMap
    System.out.println(map);
    
    //get the first value usin get(key)
    System.out.println(map.get(1));
    
    //get the second value
    System.out.println(map.get(2));
    
    //get the last value
    System.out.println(map.get(5));
  }
}

//output:

{1=Mark Smith, 2=Bob Smith, 3=Jekov Jenkov, 4=Shakil Ahmed, 5=Jhon Peterson}
Mark Smith
Bob Smith
Jhon Peterson


# Iterating HashMap (both keys and values )

import java.util.HashMap;

public class Main{
  public static void main (String[] args) {
    //creating HashMap
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    
    //add new elements using put() method
    map.put(1, "Mark Smith");
    map.put(2, "Bob Smith");
    map.put(3, "Jekov Jenkov");
    map.put(4, "Shakil Ahmed");
    map.put(5, "Jhon Peterson");
    
    //print the HashMap
    System.out.println(map);
  }
}


# Iterate HashMap

import java.util.HashMap;

public class Main{
  public static void main (String[] args) {
    //creating HashMap
    HashMap<Integer, String> map = new
    HashMap<Integer, String>();
    
    //add new elements using put() method
    map.put(1, "Mark Smith");
    map.put(2, "Bob Smith");
    map.put(3, "Jekov Jenkov");
    map.put(4, "Shakil Ahmed");
    map.put(5, "John Peterson");
   
    //iterate HashMap (keys and values)
    for(Map.Entry value: map.entrySet()){
      System.out.println(value.getKey +" "+value.getaValue);
    }
  }
}
/**
 * Output: (together keys and values)
 * 1 Mark Smith
 * 2 Bob Smith 
 * 3 Jekov Jenkov
 * 4 Shakil Ahmed 
 * 5 John Peterson 
 */


# Inserting new elements using put, putAll and putIfAbsent method and then iterate 

import java.util.HashMap;

public class Main{
  public static void main (String[] args) {
    //creating HashMap
    HashMap<Integer, String> map = new
    HashMap<Integer, String>();
    
    //add new elements using put() method
    map.put(1, "Mark Smith");
    map.put(2, "Bob Smith");
    map.put(3, "Jekov Jenkov");
    map.put(4, "Shakil Ahmed");
    map.put(5, "John Peterson");
    
    //initial map
    System.out.println("Initial List");
    System.out.println(map);
    
    //using putIfAbsent() method
    map.putIfAbsent(6, "Abdul Hamid");
    map.putIfAbsent(3, "Eugune Uzbek"); // will not be updated
    
    //updated list 
    System.out.println("Updated List using putIfAbsent");
    System.out.println(map);
    
    //Creating new entry 
    HashMap<Integer, String> newMap = new HashMap<Integer, String>();
    
    //add new elements
    newMap.put(7, "Rebeka Ghom");
    newMap.putAll(map); //using putAll()
    
    //print newMap
    System.out.println("Updated List using putAll()");
    System.out.println(newMap);
    
    //iterate map and newMap now
    System.out.println("map iteration");
    for(Map.Entry value: map.entrySet()){
      System.out.println(value.getKey +" "+value.getaValue);
    }
    
    System.out.println("newMap iteration");
    for(Map.Entry value: newMap.entrySet()){
      System.out.println(value.getKey +" "+value.getaValue);
    }
  }
}

//output (together with keys and values)

Initial List
 {1=Mark Smith, 2=Bob Smith, 3=Jekov
 Jenkov, 4=Shakil Ahmed, 5=Jhon
 Peterson}
 
Updated List using putIfAbsent()
{1=Mark Smith, 2=Bob Smith, 3=Jekov Jenkov, 4=Shakil Ahmed, 5=Jhon Peterson, 6=Abdul Hamid}

Updated List using putAll
{1=Mark Smith, 2=Bob Smith, 3=Jekov Jenkov, 4=Shakil Ahmed, 5=Jhon Peterson, 6=Abdul Hamid, 7=Rebeka Ghom}

map iteration 
 1 Mark Smith
 2 Bob Smith 
 3 Jekov Jenkov
 4 Shakil Ahmed 
 5 John Peterson 
 6 Abdul Hamid
  
 newMap iteration 
 1 Mark Smith
 2 Bob Smith 
 3 Jekov Jenkov
 4 Shakil Ahmed 
 5 John Peterson 
 6 Abdul Hamid
 7 Rebeka Ghom


# remove any entry based on key, value, and both (keys abd values)

import java.util.HashMap;

public class Main{
  public static void main (String[] args) {
    //creating HashMap
    HashMap<Integer, String> map = new
    HashMap<Integer, String>();
    
    //add new elements using put() method
    map.put(1, "Mark Smith");
    map.put(2, "Bob Smith");
    map.put(3, "Jekov Jenkov");
    map.put(4, "Shakil Ahmed");
    map.put(5, "John Peterson");
    
    //print initial HashMap 
    System.out.println("Initial HashMap:  "+map);
    
    //remove based on key
    map.remove(5)
    
    //print updated list 
    System.out.println("Updated Entry "+map);
    
    //remove based on value 
    map.remove("Shakil Ahmed")
    
    //print updated list
    System.out.println("Updated Entry "+map);
    
    //remove based on keys and values
    map.remove(3, "Jekov Jenkov");
    
    //print update list
    System.out.println("Update d Entry " +map);
    
    //now iterate  HashMap (after removal)
    for(Map.Entry value: map.entrySet()){
      System.out.println(value.getKey +" "+value.getaValue);
    }
  }
}


//Output

Initial HashMap:  {1=Mark Smith, 2=Bob Smith, 3=Jekov
 Jenkov, 4=Shakil Ahmed, 5=Jhon
 Peterson}
 
 Updated Entry:  {1=Mark Smith, 2=Bob Smith, 3=Jekov
  Jenkov, 4=Shakil Ahmed}
  
 Updated Entry:  {1=Mark Smith, 2=Bob Smith, 3=Jekov
  Jenkov,}
 
 Updated Entry:  {1=Mark Smith, 2=Bob Smith}
 
 //iteration entry after removal
1 Mark Smith
2 Bob Smith
 
 