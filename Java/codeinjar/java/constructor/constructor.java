public class A {
  //data members
  int number; //declare a variable 
  //constructor
  public A (){
    //access the A class member
    number = 10; //initialize the variable number 
  }
  
  public static void main (String[] args) {
    //create an object of class A
    A obj = new A();
    System.out.println(obj.number);
  }
}
/**
 * Output: 
 * 10
 */
 
//Person class

 public class Person{
   public String firstName;
   public String lastName;
   
   public Person(String firstName, String lastName){
     this.firstName = firstName;
     this.lastName = lastName;
     //this keyword is used to refer the current object (person properties )
   }
   public static void main (String[] args) {
     
     //creating object of class Person
     Person person = new Person("Mark", "Smith"); //initialize the data members
     System.out.println("FullName: " person.firstName +" "+person.lastName);
   }
 }
 
 /**
  * Output: 
  * FullName: Mark Smith 
  */
  
  // 
  
public class A {
    int x; 
    public A (int y){
      x = y ; 
    }
    //main method 
  }
  
But if you use this keyword then, class members name and parameters name should be same. 
public class A {
    int x; 
    public A (int x){
      this.x = y ; 
    }
    //main method 
  }
  
  
  //example
  
  public class Employee{
    public int id; 
    public String firstName;
    public String lastName; 
    
    //constructor
    public Employee(int id, String firstName, String lastName){
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
    }
    
    //main method
    public static void main (String[] args) {
      
      //Create an Employee object
      Employee obj = new Employee(1, "Mark", "Smith");
      
      System.out.println("Employee Details");
      System.out.println("Employee id: "+obj.id +" First Name: "+obj.firstName +" Last Name: "+obj.lastName);
    }
  }
  
  /**
   * Output:
   * Employee Details
   * Employee id: 1 First Name: Mark Last
   * Name: Smith

   */