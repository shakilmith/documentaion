public class Employee{
  
  public int emp_id;
  public String emp_name;
  public int emp_salary;
  public String emp_type;
  
  //no argument constructor
  public Employee(){
    super();
  }
  //constructor with arguments
  public Employee(int emp_id, String emp_name, int emp_salary, String emp_type){
    this.emp_id = emp_id;
    this.emp_name = emp_name;
    this.emp_salary = emp_salary;
    this.emp_type = emp_type;
  }
  
  //getter and setter methods 
}

//ArrayListExample.java class

import java.util.ArrayList;

public class ArrayListExample {
  public static void main (String[] args) {
    
    //Creating ArrayList 
    ArrayList<Employee> employees = new ArrayList<Employee>();
    
    //creating Employee objects
    Employee e1 = new Employee(1, "Mark Smith", 1200, "Regular");
    Employee e2 = new Employee(2, "Eugene Homu", 1500, "Regular");
    Employee e3 = new Employee(3, "Bob Proctor", 950, "Irregular");
    Employee e4 = new Employee(4, "Jackov Jenkov", 1750, "Regular");
    
    //add Employee objects to the ArrayList
    employees.add(e1);
    employees.add(e2);
    employees.add(e3);
    employees.add(e4);
    
    //Iterate the elements of list
    System.out.println("Employee Details:");
    
    for(Employee employee: employees){
      System.out.println(employee.emp_id +" "+employee.emp_name +" "+ employee.emp_salary +" "+ employee.emp_type);
    }
    
  }
}

//Run the program and get the following output

Employee Details:
1 Mark Smith 1200 Regular
2 Eugene Homu 1500 Regular
3 Bob Proctor 950 Irregular
4 Jackov Jenkov 1750 Regular