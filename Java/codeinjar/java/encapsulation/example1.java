//person.java 

public class Person{
  //private members
  private String name;
  private int age;
  
  //constructor
  //public getter and setter methods
  
  //getter 
  public String getName(){
    return name;
  }
//setter
public void setName(String name){
  this.name = name;
 }
 
  //getter 
  public int getAge(){
    return age;
  }
//setter
public void setAge(int age){
  this.age = age;
 }
}


// TestExample.java class 

public class TestExample{
  public static void main (String[] args) {
    //create object of the Person class
    
    Person person = new Person(); 
    //set the value of the private members
    person.setName("Mark Smith");
    person.setAge(30);
    
    //use getter for getting the values 
    System.out.println("Name is: "+person.getName());
    System.out.println("Age is: "+person.getAge());
     
  }
}

/**
 * Output: 
 * Name is: Mark Smith
 * Age is: 30
 */
 
 