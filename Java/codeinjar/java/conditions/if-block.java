public class Main{
  public static void main (String[] args){
    //create an int variable age 
    int age = 20;
    if(age>=18 ){
      System.out.println("You are eligible to vote");
    }
  }
}
/**
 * Output: 
 * You are eligible to vote
 */
 
 if(condition to check){ //if block
   //code block to execute
   //if the condition is true
 }
 else{ //else block
   //code to execute if the if block 
   //is false
 }
 
 public class Main{
   public static void main (String[] args){
     //create an int variable age 
     int age = 20;
     if(age>=18 ){
       System.out.println("You are eligible to vote");
     }
     else{
       System.out.println("You are not eligible to vote");
     }
   }
 }
 /**
  * Output: 
  * You are eligible to vote
  */
  
  if(condition to check){
    //code block to execute if 
    //the if condition is true
  }
  else if(condition to check){
    //code block to execute if 
    //the if block if false
    //you can write many else-if block
    //as well
  } 
  else{//else block
    //execute it if the above two
    //conditions are false
  }