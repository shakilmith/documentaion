class A{ //Parent class
  //data members
}

class B extends A{ //child class
  //acquired the data members of A
  //own data members
}
 
 //demo inheritance example
 
 class A {
   static void showGreeting(){
     System.out.println("Greetings from A");
   }
 }
   
//child class 
class B extends A {
  //data members of B
  static String message = "ding dung";
  
  public static void main (String[] args) {
    //call the greeting message
    showGreeting();
    //access message variable
    System.out.println(message);
  }
}

/**
 * Output:
 * Greetings from A
 * ding dung
 */
 
 class Animal{ //parent class
   
   public String showGenre(genre){
     return genre;
   }
 }
 
 class Dog extends Animal{ //cild class
   String name = "Tommy";
 }
 
 class Cat extends Animal{ //child class
   String name = "Tommy";
 }
 
 //test class that contains main method
 public class TestClass{
   public static void main (String[] args) {
     //create object of Dog and Cat
     Dog d = new Dog();
     Cat c = new Cat();
     
     //access the data members of Dog 
     //and Cat including Animal
     
     //Dog members 
     System.out.println("Name: "+d.name);
     System.out.println("Genre: "+d.showGenre("Dog"));
     
     //Cat members 
     System.out.println("Name: "+c.name);
     System.out.println("Genre: "+c.showGenre("Dog"));
   }
 }
 
 
 
 //bank: return rate of interest
 
 class Bank{
   public float rateOfInterest(float x){
     return x;
   }
 }
 
 //child class 
 class PNC extends Bank{
   String bankName = "PNC Bank";
 }
 
 //child class
 class TD extends Bank{
    String bankName = "TD International";
  }
  
  class SBM extends Bank{
     String bankName = "SBM Bank";
   }
   
   class BMO extends Bank{
      String bankName = "BMO Bank";
    }
    
    //main class file
    
    public class TestClass{
      public static void main (String[] args) {
        
        //create of objects of
        //all the banks
        PNC pnc = new PNC();
        TD td = new TD();
        SBM sbm = new SBM();
        BMO bmo = new BMO();
        
        //print the data members
        System.out.println("Bank Name: "+pnc.bankName + "Interest Rate: "+ pnc.rateOfInterest(15.00f)+"%");
        
       System.out.println("Bank Name: "+td.bankName + "Interest Rate: "+ td.rateOfInterest(10.45f)+"%");
       
       System.out.println("Bank Name: "+sbm.bankName + "Interest Rate: "+ pnc.rateOfInterest(12.00f)+"%");
       
       System.out.println("Bank Name: "+bmo.bankName + "Interest Rate: "+ pnc.rateOfInterest(8.75f)+"%");
       
      }
    }
    
//Output: 
Bank Name: PNC BankInterest Rate: 15.0%

Bank Name: TD InternationalInterest Rate: 10.45%

Bank Name: SBM BankInterest Rate: 12.0%
Bank Name: BMO BankInterest Rate: 8.75
%

    