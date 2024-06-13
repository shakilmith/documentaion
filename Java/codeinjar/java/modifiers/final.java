class A{
  
  public static void main (String[] args){
    //final members
    final int number = 10; //instantiate+initialize
    
    //access the private number variable
    System.out.println("Number is: "+number);
    
  }
}

/**
 * Output: 
 * Number is: 10
 */
 
 
 class A{
  
  public static void main (String[] args){
    //final members
    final int number = 10; //instantiate+initialize
    
    // try to update the final variable
    number = 100;
    //access the private number variable
    System.out.println("Number is: "+number);
    
  }
}

/**
 * Output: 
 * <error message> such as
 * can not reassign a value to final
 * variable number 
 */
 

class Main{
  //final member 
  static final int number = 10;
  
  public static void main (String[] args) {
    //access the final static variable
    //try to reinitialize the variable
    
    number = 100;
    System.out.println("Number is " +number);
  }
}

/**
 * Output:.
 * <error_message> such as
 * can not re assign a value to a finsl variable number
 */