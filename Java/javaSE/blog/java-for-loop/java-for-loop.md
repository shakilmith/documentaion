## Java For Loop

To iterate or execute some or same statements multiple times we use For loop in java.

## Syntax

```js
for(initial statement; condition; increment/decremetn){
//code to be executed
}
```

Here inside the for loop, the first parameter is the initial statement, second parameter is condition and the third one is increment or decrement.

## First Example

Look at the example below: We want to print 1 to 10 in the console;

```js

public class ForLoopExample {
    public static void main(String[] args) {

        for (int i = 0;; i <= 10; i++) {
            System.out.println(i);
        }
    }
}

//output:
0
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
Code explaination: Firstly, the compiler finds the initial statement is 0 and then it prints it. Then it checks the condition and if it is fulfilled it increments the intitial int variable by 1 and prints it again. The process will be continued untill the condion will not mathced. 

## What if your conditios is i<10 than i<=10? 

Then 10 will not be printed.

## Example Two

The initial statement variable can be declated outside the for loop. Like 

```js
public class ForLoopExample {
    public static void main(String[] args) {

        int i = 0;
        for (; i <= 10; i++) {
            System.out.println(i);
        }
    }
}

//Now just add a cemicolon (;)
```

## Example Three

Print an int variable like 5 multiple times (10 times)

```js
public class ForLoopExample {
    public static void main(String[] args) {
        int x = 5;
        for(int i = 1; i<=10; i++){
            System.out.println(x);
        }
    }
}
```

## Example Four

We can pass any types of data like primitive types(int, Float, double or string) even objects to our for loop. Here in this example we pass an int array to our for loop to print it. Let's see two examples using for and without using for loop.

Printing array of data: Without using for loop:

```js
package com.company;

public class ForLoopExample {
    public static void main(String[] args) {
        int [] array = new int[5]; //array declaration
        //array initialization
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3]= 4;
        array[4] = 5;
        System.out.println(array);
    }
}
//output:
I@404b9385 
//meand it produces the array addresses in the memory
```

Printing array of int variables: using For loop;

```js
for (int i = 0; i<5; i++){
            System.out.println(array[i]);
        }
```

Note: Array index starts with 0 

## Using Arrays.toString method (alernative for loop)

```js
import java.util.Arrays;

public class ForLoopExample {
    public static void main(String[] args) {

        int [] array = new int[]{1, 2, 3, 4, 5}; //array declaration and initialization
        System.out.println(Arrays.toString(array));
    }
}

//output:
[1, 2, 3, 4, 5]
```

## Example Five

Let's print array of String variables

```js
public class ForLoopExample {
    public static void main(String[] args) {
        //arrays of fruits
        String [] fruits = new String[]{"Apple", "Banana", "Orange", "Grape", "Mango"};
        for(int i = 0; i < 5; i++){
            System.out.println(fruits[i]);
        }
    }
}

//output:
Apple
Banana
Orange
Grape
Mango
```

## Collecttion in For Loop

Here, we have created list of Books and then use for loop to print the book list

```js

import java.util.ArrayList;
import java.util.List;

public class ForLoopExample {
    public static void main(String[] args) {
        
        //List of books
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Python");
        books.add("C++");
        books.add("Rust");
        books.add("Go");
        System.out.println("Printing List of books using For loop each loop");
        for (int i = 0; i <books.size(); i++){
            System.out.println(books.get(i));
        }
    }
}

```

## Make our for loop more handy using enhanced for loop. 

```js

import java.util.ArrayList;
import java.util.List;

public class ForLoopExample {
    public static void main(String[] args) {
        
        //List of books
        List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Python");
        books.add("C++");
        books.add("Rust");
        books.add("Go");
        System.out.println("Printing List of books using For loop each loop");
        for (String book : books) { //it is called for each loop
            System.out.println(book);
        }
    }
}
```

Thanks for reading this article. This is an ongoing article.
