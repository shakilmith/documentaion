package com.company; 

public class Student{
  //public members
  private String name = "Mark Smith";
  private int age = 30;
}

/**
 * If you now run the example, you will
 * get the following output: 
 * 
 * Mark Smith
 * 30
 */
 
 
// Main.java class
 
public class Main{
  public static void main (String[] args) {
    //try to access the private fields
    //of Students class
    Student student = new Student();
    System.out.println(student.name);
    System.out.println(student.age);
  }
}



//Student.java containing get/set
package com.company;

public class Student{
  private String name; //no need to initialize the variable
  private int age;
  
  // public getter and setter
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public int getAge(){
    return age;
  }
  public void setAge(String age){
    this.age = age;
  }
}

//Main.java class
package com.company;

public class Main{
  public static void main (String[] args) {
    //create an object of Student class
    
    Student student = new Student();
    //set the value using setter method
    student.setName("Mark Smith");
    student.setAge(30);
    
    //access the value now using getter
    System.out.println(student.getName());
    System.out.println(student.getAge());
  }
}

