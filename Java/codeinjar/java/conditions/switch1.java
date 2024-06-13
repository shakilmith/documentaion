public class Main(
  public static void main (String[] args){
    
    //int variable
    int number = 4;
    String month; //declaring a string
    //switch statement
    switch(number){
      case 1:
        month = "January";
        break;
      case 2: 
        month = "February";
        break;
      case 3:
        month = "March";
        break;
      case 4: 
        month = "April";
        break;
      case 5:
        month = "May";
        break;
      case 6: 
        month = "June";
        break;
      case 7:
        month = "July";
        break;
      case 8: 
        month = "August";
        break;
      case 9:
        month = "September";
        break;
      case 10: 
        month = "October";
        break;
      case 11:
        month = "November";
        break;
      case 12: 
        month = "December";
        break;
      default: 
        month = "No match!";
    }
    System.out.println("It's "+ month);
  }
  )
  /**
   * Output: 
   * It's April
   */
   
  
  //find out season
  
  public class Main(
  public static void main (String[] args){
    
    //int variable
    int number = 4;
    String season; //declaring a string
    
    //switch statement
    switch(number){
      case 12:
      case 1: 
      case 2:
        season = "Winter";
        break;
      case 3: 
      case 4:
      case 5:
        season = "Spring";
        break;
      case 6:
      case 7: 
      case 8:
        season = "Summer";
        break;
      case 10: 
      case 11:
      case 12:
        season = "Rainy Season";
        break;
      default: 
        month = "Out of Season!";
    }
    System.out.println("It's "+ season);
  }
  )
  /**
   * Output: 
   * It's Spring
   */
   