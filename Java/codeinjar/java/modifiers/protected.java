package com.company; 

public class Person{
  //protected method
  protected void printMessage(){
    System.out.println("Protected members can be accessible within the decalared class and same package.");
  }
  
  //nain method
  public static void main (String[] args) {
    //create an object of Person class
    Person obj = new Person (); 
    obj.printMessage();
  }
}

//TestExample.java 

package com.company;

public class TestExample{
  public static void main (String[] args) {
    //create an object of Person
    Person obj = new Person();
    obj.printMessage();
  }
}