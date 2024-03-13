## Method in Java

Method in java is one kind of function or code block when you call or invoke it, it perfroms some actions or tasks.

Note, that before invoking the method you must declare it. 

Attention: In java, method should be decalred outside the main method. And in order to acces or invoke or call the method, it is only possible inside the main method. Means, declare a method outside the main method and call it inside the method.

Few more thins, I should specify here too. 

A method in java is a data member of a class. Methods can be be public, private or protected. It can be static or non-static too. 

Statc vs Non-static: Static method means, you don't need to create object or instance variable of the class (method is beloging) to access the method statements. No-static method means, you have to create object of the class to access the methods.

## Syntax 

```js
methodName(){
    //code block to be executed
}
```

## Declaring the Java Mehtod.

```js
public class JavaMethodExample {
    //declare a static method that prints simple hello world message
    static void myMethod(){
        System.out.println("Hello World!");
    }

    //java main method
    public static void main(String[] args) {
        //invoke or call the myMethod
        myMethod();
    }
}
/**
 * Output:
 * Hello, World!
 */

```

Here you can see, the method name inside the javaMethodExample class is myMethod and it print's simple Hello World message when it is called.

Here, void means, this method doesn't return any value.
Here, static means, this method belongs to the class not the object of the class.

Anyway, you can call the multiple times. Like

```js
public class JavaMethodExample {
    //declare a static method that prints simple hello world message
    static void myMethod(){
        System.out.println("Hello World!");
    }

    //java main method
    public static void main(String[] args) {
        //invoke or call the myMethod
        myMethod();
        myMethod();
        myMethod();
        myMethod();
    }
}
/**
 * Output:
 * Hello, World!
 * Hello, World!
 * Hello, World!
 * Hello, World!
 */
```

## Method that Returns something (like value)

As we have creted a simple void method that doesn't return any value.

Let's say we want declare a method that returns a value, like int value. But it is static method.

```js
public class JavaMethodExample {
    //declare a static method that add to int num
    static int makeAddition(){
        return 10+20;
    }

    //java main method
    public static void main(String[] args) {
        //invoke or call the myMethod
        System.out.println(makeAddition());
    }
}
/**
 * Output:
 * 30
 */
```

## Method that takes parameters

Parameters (addition inforamation) should be passed inside the parentheses "()" of the method. Parameters can be String, int or float type or even objects.

See a simple example below:

```js
public class JavaExample {

    public static int addTwoNumbers(int x, int y){
        return x + y;
    }
    public static void main(String[] args) {
        //invoke the static method
        System.out.println(addTwoNumbers(10, 10));
    }
}
/**
 * Output:
 * 20
 */
```

Here, inside addTwoNumbers(int x, int y); x and y are paremeters. But when we call the method we have to provide the paremerters value matching their types, then, they are called arguments.


It is also possible to pass the method as variable value. Like

```js
public class JavaExample {

    public static int addTwoNumbers(int x, int y){
        return x + y;
    }
    public static void main(String[] args) {
        //store the method as variable value
        int summation = addTwoNumbers(10, 10);
        System.out.println(summation);
    }
}
/**
 * Output:
 * 20
 */
```


## Different types of parameters.

It is not obvious to use same type of parameters. We can even use int, string or float as parameters of any method. Like

```js
public class JavaExample {

    public static void demoMethod(String name, int age){
        System.out.println("His name is " + name + "\nHe is "+age +" years old");
    }
    public static void main(String[] args) {
        demoMethod("Mark Smith", 25);
    }
}
/**
 * Output:
 * His name is Mark Smith
 * He is 25 years old
 */
```

But you should remember, when you declare the method, the parameters value should be type matched. You can't use numeric or int in the String parameter.

```js
public class JavaExample {

    public static void demoMethod(String name){
        System.out.println(name);
    }
    public static void main(String[] args) {
        demoMethod(20);
    }
}
/**
 * Output:
 * java: incompatible types: int cannot be converted to java.lang.String
 * 
 */
```

If you do the above you get compile time error like incompatible types passed.


## Java Non-static method.

