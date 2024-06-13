
/**
 * Imagine, we have two int numbers.
 * And we want to add these two numbers.
 * It is possible to add these numbers directly or 
 * storing them in a variable.
 */

public class Main{
    public static void main(String[] args) {
        
        //create two int variable x and y
        //both are static by default as they are in static 
        //context

        int x = 19;
        int y = 19;

        System.out.println(x + y); //output will be 38

        //it it possible to add the summation result in a new variable

        //add the summation of x and y into z
        int z = x + y;

        System.out.println(z);
    }
}