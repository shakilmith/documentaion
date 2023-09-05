# Java variables

Java variables are containers for storing data values. Or you can say variables are like storage or location to hold data values somewhere in your computer. 

Variables may hava data types. Like what type of values they can usually hold or store. Like String, int, float, double, long, char (character), boolean etc. 

Sample:

```java
int my_age = 30; 
String my_name = "Shakil Ahmed; etc. 
```
Note: Two things are involved when you declare a java varible. One is declaring the varibal and another one is provide certain values in it. It is called initialization.

```java
int x; //We declare the variable with certain data type.
x = 30; //we initialize the variable based on the data type
int y = 50; //we declare as well as initialize the variable. 
```

How many types of variables in java:

Primitive types: int, float, double, long, char, byte, boolean (Is is considered built in data types in java)
Non primitve types: String, Object, Java Date apis, arrays, Java collection frameworks etc. It is required extra task to work with non-primitve types. 

Declaring a Java variable: 

In order to declare java variable, we must follow the below 3 steps: 

 1. type of the variable 
 2. Name of the varibale
 3. Use modifiers if necessary (when modifier is't present, it is default type)

Like: 

type variable_name = value; 

type: Type can be primitive or non-primitive
variable_name: any valid varibale name
value: value of the variable (it should be based on varibale type)

Note: Variables value must be based on the type of that variable.

Like, in java String type of variables need " " double quotation but int typer of varibale doesn't need quotaion. 

```java
String name = "Java is fun"; //list of characters
int age = 30; //numeric values
```

Note: In java, you must use semi-clone(;) after every valid statement. 

Sample Example: Let's we want to create a variable that store a neumeric data value and it 
will print when we execute the sample program.

```java
public class TestClass {
    public static void main(String[] args) {

        int num = 100; //variable declaration
        System.out.println(num); //print the value
    }
}
```
When you run the progaram the output should be 100

What if we want to store text value instead of neumeric value?

That's why use String data type (it is non-primitive data type)

```java
public class TestClass {
    public static void main(String[] args) {

     String text = "Java is fun enough!";
     System.out.println(text);
    }
}
```

When you run the program you should see: Java is fun enough!


It is possible to initialize a varible after declaring it?
Yes. Variable declaration has 2 steps. Data type of the variable and name of the variable. Then letter you can assign a value in it.

Like: 
```java
public class TestClass {
    public static void main(String[] args) {

        int num1 = 100; //we declare and assign a value in it

        int num2; //we only declare a variable called num2
        num2 = 200; //we assign a value in num2

        System.out.println(num1);
        System.out.println(num2);
    }
}
```
You defenitely get: 
1oo
200

But, before declaring a variable, can we access a variable?
No. You must declare a variable before accessing it in java.

Like: 

```java
public class TestClass {
    public static void main(String[] args) {

       int num1 = 100;
       System.out.println(num1); //it prints the output

        System.out.println(num2); //you will get error when you try access a variable before declaring it
        int num2 = 200; 

    }
}
```
Output: 
java: cannot find symbol
symbol:   variable num2


Let's explore little more: 

Declaring a int type of varianl and accessing it:

```java
public class TestClass {
    public static void main(String[] args) {

      int num1 = 100;
      int num2 = 200;
      int num3 = 300;

      System.out.println(num1);
      System.out.println(num2);
      System.out.println(num3);
    }
}
```
Adding 2 numeric variable value and assign it another variable:

Example: 
```java
public class TestClass {
    public static void main(String[] args) {

     int x = 100;
     int y = 200;
     int z = x + y;

     System.out.println("The summation of x and y : "+z);
    }
}
```

Note: In java we use, + sign for addition (only neumeric value) and concatination (string value)

How to declare decimal number? 
We use float or double data type to work with fraction based number.


