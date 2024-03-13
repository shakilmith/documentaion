## Java Variable

Variables are basically storage location for data memebers. We can stroe values or data members in java variables. 

## Variable Declaration

In java we can many ways declare variables. But one common path is to use certain type followed by variable name. Like:

```js
type name_of_the_variable;
int age; //variable declaration
int age = 30; //varaible declaration + initialization
```

Note that, we can declare a variable first then initialze it. But constant variable means, the varaibles which are final, can't be reinilized ageter instantiation.

```js
final int age = 30; //can't change this variable later.
age = 25; //get compile time error
```

Anyway, we can use any valid java data types to declare vriables. Even, you can use variable concept to store objects too later use.

## Print a variable in the console

```js
public class JavaExample {
    public static void main(String[] args) {
        String name = "Mark Smith";
        int age = 30;
        //print name and age in java console
        System.out.println("My name is "+ name);
        System.out.println("I am "+ age + " years old");
    }
}

/**
 * Output:
 * My name is Mark Smith
 * I am 30 years old
 */
```

## Java Final Variables

Below example we show you how to creat final variable.

```js
final int Pin_NUM = 1234;
// Pin_NUM = 14567;  You get compile time error
System.out.println(Pin_NUM);

/**
 * Output:
 * PIN_NUM
 */
```
So, if you create a variable to final and initialize it then you never can change the variable value.

## Java fields. 

Fields are also variables but it resides outside the main method of the application. We can call them class memebers. Class members are methods and fields. They can be static or no-nonstatic. Non-static members can be used creating objects of the class.

Let's see an example:

```js
public class Student {

    //declaring class members
    static int id = 123;
   static String name = "Mark Smith";
   static int age = 22;
    //creating static method
    static void printInfo(){
        System.out.println(id +" "+ name + " "+age);
    }

    public static void main(String[] args) {
        //accessing class members
        System.out.println(id);
        System.out.println(name);
        System.out.println(age);
        
        //call the static method printInfo()
        printInfo();
    }
}
/**
 * Output:
 * 123
 * Mark Smith
 * 22
 * 123 Mark Smith 22
 */
```

Non static data members:

In order access no-static data members we have to create objec of the class to access them.

See another example below:

```js
public class Student {

    static String name = "Mark Smith";
    static int age = 30;
    String country = "England";
    public static void main(String[] args) {
        //accessing static members without creating object of the clas
        System.out.println("Student name is "+ name +". He is now "+ age);

        //accessing non-static member country but for this we have to create object of the class
        Student obj = new Student();
        System.out.println("He is from "+ obj.country);
    }
}
/**
 * Output:
 * Student name is Mark Smith. He is now 30
 * He is from England
 */
```

So, hope it make sense how to access static and non-static data memmbers. Again, new tuttorail will be avaiable soon about this topic.

