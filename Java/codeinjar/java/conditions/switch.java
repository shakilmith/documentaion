//switch statement that render quote for each day

public class Main(
  public static void main (String[] args){
    
    //String used as expression
    String day = "Sunday";
    
    //switch block 
    switch (day){
      case "Saturday": 
        System.out.println("zzz...");
        break;
      case "Sunday": 
        System.out.println("zzz...");
        break;
      case "Monday": 
        System.out.println("zzz...");
        break;
      case "Tuesday": 
        System.out.println("zzz...");
        break;
      case "Wednesday": 
        System.out.println("zzz...");
        break;
      case "Thursday": 
        System.out.println("zzz...");
        break;
      case "Friday": 
        System.out.println("zzz...");
        break; 
      default: 
        System.out.println("Alas! Nothing is for you.");
    }
  }
  )
  /**
   * Output: 
   * 
   */
  
  
  //Quote render
  
  public class Main(
    
    public static void main (String[] args){
    
    //String used as expression
    String day = "Tuesday";
    
    //switch block 
    switch (day){
      case "Saturday": 
        System.out.println("Quality isn't act, it is a habit.");
        break;
      case "Sunday": 
        System.out.println("Ever tried. Ever failed. No matter. Try again. Fail again. Fail better.");
        break;
      case "Monday": 
        System.out.println("We do not remember days, we remember moments.");
        break;
      case "Tuesday": 
        System.out.println("He who has a why to live can bear almost any how.");
        break;
      case "Wednesday": 
        System.out.println("It takes half of your life before you discover life is a do-it-yourself project.");
        break;
      case "Thursday": 
        System.out.println("Computers are fast, programmers keep it slow.");
        break;
      case "Friday": 
        System.out.println("Programming isn't about what you know; it's about what you can figure out.");
        break; 
      default: 
        System.out.println("Alas! Nothing is for you.");
    }
  }
  )
  /**
   * Output: 
   * He who has a why to live can bear
   * almost any how.
   * 
   */
  
  
 // syntax
 
 switch(expression){
   case value1:
     //statement to be executed
     break;
   case value2: 
     //statement to be executed
     break;
   case value3: 
     //statement to be executed
     break;
   ....
   ....
   case valueN:
     //statement to executed
     break;
   default: //optional 
     //default statement 
 }
  
  
 Note: 
 
 The break statement is used inside the switch to terminate a statement sequence. When a break statement is encountered, execution branches to the first line of code that follows the entire switch statement. This has the effect of “jumping out” of the switch.

Here, you can see a default statement too. When no case statement is match then the default statement will be executed. 
