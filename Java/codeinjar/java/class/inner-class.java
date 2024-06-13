class OuterClass{
  int x = 10;
  
  //inner class
  class InnerClass{
    int y = 20;
  }
}

public class Main{ // file name
  public static void main (String[] args) {
    //create an object of OuterClass
    OuterClass outer = new OuterClass();
    //create an object of InnerClass
    OuterClass.InnerClass inner = outer.new InnerClass();
    //access the OutrrClass property
    System.out.println("OuterClass property is "+outer.x);
    //access the InnerClass property
    System.out.println("InnerClass property is "+inner.y);
  }
}

/**
 * Output: 
 * OuterClass property is 10
 * InnerClass property is 20
 */
 
 
 //Private inner class 
 
 //Error you will get now 
 """
 Main.java:15: error: OuterClass.InnerClass has private access in OuterClass
    OuterClass.InnerClass inner = outer.new InnerClass();
              ^
Main.java:15: error: OuterClass.InnerClass has private access in OuterClass
    OuterClass.InnerClass inner = outer.new InnerClass();
                                            ^
2 errors
"""


 
//static inner class 

class OuterClass{
  int x = 10;
  
  //inner class
  static class InnerClass{
    int y = 20;
  }
}

public class Main{ // file name
  public static void main (String[] args) {
    //create an object of InnerClass
    OutrClass.InnerClass inner = new OuterClass.InnerClass();
    
    //access the member of InnerClass
    System.out.println("InnerClass property is "+inner.y);
  }
}

/**
 * Output: 
 * OuterClass property is 10
 * InnerClass property is 20
 */
 
 
 //access the members of outerclass from inner class
 
 class OuterClass{
  int x = 10;
  
  //inner class
  class InnerClass{
    public int accessOuter(){
      return x;
    }
  }
}

public class Main{ // file name
  public static void main (String[] args) {
    //create an object of OuterClass
    OuterClass outer = new OuterClass();
    //create an object of InnerClass
    OuterClass.InnerClass inner = outer.new InnerClass();
    //invoke the method 
    System.out.println("OuterClass property is "+inner.accessOuter());
  }
}
/**
 * Output: 
 * OuterClass property is 10
 */
 
 //real life example
 
 class Laptop{
   int price = 1000;
   
   //inner class
   class MiniLaptop{
     int price = 700;
   }
 }
 
 public class Main{ // file name
   public static void main (String[] args) {
     //create an object of OuterClass
     Laptop laptop = new Laptop();
     //create an object of InnerClass
     Laptop.MiniLaptop miniLaptop = laptop.new MiniLaptop();
     
     //access the OutrrClass property
     System.out.println("Fair price if laptop is "+laptop.x);
     
     //access the InnerClass property
     System.out.println("Fair price of mini laptop is "+miniLaptop.y);
   }
 }
 
 /**
  * Output: 
  * Fair price of laptop is 1000
  * Fair price of mini laptop is 700
  */
  
 