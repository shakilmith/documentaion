public class Main{
  public static void main (String[] args) {
    //create a multidimensional array
    int [] [] numbers = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10} };
    
    //access the first array elements
    System.out.println("First array element is "+numbers[0] [2]);
    
    //access the second array elements
    System.out.println("Second array element is "+numbers[1] [4]);
    
    
  }
}
/**
 * Output: 
 * First array element is 3
 * Second array element is 10
 */
 
 
 

public class Main{
  public static void main (String[] args) {
    //create a multidimensional array
    int [] [] numbers = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10} };
    
    //access the first array elements
    System.out.println("Second element of the first array is: "+numbers[0] [2]);
    
    //Change the first array elements
    numbers[0][2] = 20;
    
    System.out.println("Now the second element of first array is "+numbers[0][2]);
  }
}
/**
 * Output: 
 * Second element of the first array is 3
 * Now the Second element of first array is 20
 */
 
 //loop through multidimensional array
 
 public class Main{
   public static void main (String[] args) {
     //create a multidimensional array
     int [] [] numbers = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10} };
     
     //loop through the numbers array
     // using nested for loop
     //one for index, another one for elements of that index
     
     for(int i = 0; i < numbers.length; i++){
       for(int j = 0; j < numbers[i].length; j++){
         System.out.println(numbers [i] [j]);
       }
     }
      
   }
 }

/**
 * Output: 
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 10
 */
 
 
 //for each loop
 
 public class Main{
   public static void main (String[] args) {
     //create a multidimensional array
     int [] [] numbers = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10} };
     
     //loop through array elements
     for(int[] arrays : numbers){ //array
       for(int data: arrays){ //elements of that array
         System.out.println(data);
       }
     }
      
   }
 }

/**
 * Output: 
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 10
 */
 
 
 //3 dimensional array
 
 int [] [] [] numbers = {{ {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10} }};
 
 public class Main{
   public static void main (String[] args) {
     int [] [] [] numbers = {{ {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10} }};
     
     //loop through the numbers array
     for(int [] [] arrays: numbers ){
       for(int [] values: arrays){
         for(int data: values){
           System.out.println(data);
         }
       }
     }
   }
 }
 
/**
 * Output:
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 10
 */