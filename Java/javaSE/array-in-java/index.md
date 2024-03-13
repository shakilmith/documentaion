## Array in Java

What is Array in Java?

Arrays are used to store more than one value or multiple same type of values at a time in a single varibale then creating variables for each value. In array we can store, int, String or objects types values.

## Array declaration:

First of all we define the type like int and followed by the array name. Here we have to use [] brackets to indicate the variable that it stores multiple values.

```js
//array declaration
int [] array1;
//array declaration and initialization
int [] array2 = {1, 2, 3, 4};

//here int [] array and int array [] is the same thing
//or declare an array with predefined size
int [] array3 = new int[5]; // this array can store 5 data members
```
Note: Array index starts from 0. It means, for accessig first member of the array you have to invoke array[0];

## An example of array

We have created an array that stores list of fruits.

```js

public class JavaExample {
    public static void main(String[] args) {

        String [] fruits = {"Apple", "Banana", "Orange", "Guava", "Jackfruits"};
        //accessing the first data member of this array
        System.out.println(fruits[0]);
        //accessing the first data member of this array
        System.out.println(fruits[1]);
        //accessing the last data member of this array
        System.out.println(fruits[4]);
        //accessing the last data member of this array using Array's length/size method
        System.out.println("Arrays length method");
        System.out.println(fruits[fruits.length-1]);
    }
}

//output
Apple
Banana
Jackfruits
Arrays length method
Jackfruits
```

Here, fruits[0] is the first member of this array. Likewise the second member of this array should be fruits[1]. If we want to access the last array and don't know the exact size of the array using array Length method would be very handy.

## Change the data member of the array

```js
public class JavaExample {
    public static void main(String[] args) {

        String [] fruits = {"Apple", "Banana", "Orange", "Guava", "Jackfruits"};
        System.out.println("The first fruit is "+ fruits[0]);
        //change the first fruit
        fruits[0] = "Licy";
        System.out.println("The updated first fruit is: "+fruits[0]);
    }
}
```
We can update the array data member using it's index as well.

## Using For loop to iterate over an array

We can use for loop or Arrays factory method to iterate over an array and print them to the console.

```js

public class JavaExample {
    public static void main(String[] args) {

        int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
}
//output:
1
2
3
4
5
6
7
8
9
10
```
## Using for each loop or enhanced for loop

```js
public class JavaExample {
    public static void main(String[] args) {

        int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
//output
1
2
3
4
5
6
7
8
9
10
```

## Using Array's Static Factory method

There is a factory method called Arrays.toString() method. It also helps us to iterate over an array.

```js
public class JavaExample {
    public static void main(String[] args) {

        String [] languages = {"C", "C++", "Java", "Python", "Rust", "Go"};
        System.out.println(Arrays.toString(languages));
    }
}
```

