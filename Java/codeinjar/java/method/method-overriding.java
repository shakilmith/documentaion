class Fruits { //parent class
  public void taste(){
    System.out.println("Fruits are usually tasty!");
  }
}

class Apple extends Fruits{
  //override the taste method
  public void taste(){
    System.out.println("Apple is little bit salty.");
  }
}

class Kiwi extends Fruits{
  //override the taste method
  public void taste(){
    System.out.println("Kiwi is sweet.");
  }
}

class Orange extends Fruits{
  //override the taste method
  public void taste(){
    System.out.println("Oranges are sour overall.");
  }
}

class Carrots extends Fruits{
  //override the taste method
  public void taste(){
    System.out.println("The taste of carrots are little bit bitter.");
  }
}

public class Main{ //must be file name
  
  public static void main (String[] args) {
    //create objects of fruits and subclasses
    
    Fruits fruits = new Fruits();
    Apple apple = new Apple();
    Kiwi kiwi = new Kiwi();
    Orange orange = new Orange();
    Carrots carrots = new Carrots();
    
    //invoking the method
    fruits.taste(); //parent class
    
    apple.taste(); //subclass
    orange.taste(); //subclass 
    kiwi.taste();
    carrots.taste(); // subclass 
  }
}

/**
 * Fruits are usually tasty!
Apple is little bit salty.
Oranges are sour overall.
Kiwi is sweet.
The taste of carrots are little bit bitter.

 */
//Output:
Fruits are usually tasty!
Apple is little bit salty.
Oranges are sour overall.
Kiwi is sweet.
The taste of carrots are little bit bitter.


//bank 

class Bank {
  public float getInterestRate(){
    return 0.0f;
  }
}

class SBI extends Bank{
  public float getInterestRate(){
    return 7.50f;
  }
}

class TDI extends Bank{
  public float getInterestRate(){
    return 5.75f;
  }
}

class BMO extends Bank{
  public float getInterestRate(){
    return 12.50f;
  }
}

public class Main{
  public static void main (String[] args) {
    //create objects of sub-classes
    SBI sbi = new SBI();
    TDI tdi = new TDI();
    BMO bmo = new BMO();
    
    System.out.println("Rate of Interest of SBI is "+sbi.getInterestRate()+"%");
    System.out.println("Rate of Interest of TDI is "+tdi.getInterestRate()+"%");
    System.out.println("Rate of Interest of BMO "+bmo.getInterestRate()+"%");
  }
}




