# Java method: 

Method in java is like function of other programming languages. Method can do certain task when it is called. In java programming language you must create a method outside the main() method and in order to access the method, you have to call or invoke it inside the main() method. Method is also called behavior of the defined class and it is a class member like properties.

Method Declaration:

modifiers return-type methood-name(param1, param2){
    //method body.
}

Such as: 

```
//method that return values
public int addNumbers(int x, int y){
        return x+y;
}

//method that doesn't return any value.
public void printMessage(){
    System.out.println("This method doesn't return any value.");
}

//static method

public static void printMessage(){
    System.out.println("This method doesn't return any value.");
}

//final method
public final void changeDirection(){
    System.out.println("Final method");
}

//method with parameters
public void printSummation(int x, int y){
    System.out.println(x+y);
}

```


So method declaration has almost 6 components: 
- modifires: public, private, protected etc.
- return-type: it means, which data the method will return after it is invoked. If the mehod doesn't return any value,  void will be used.
- method name: any valid name excetp reserved words. Basically, method name starts with verbs and related to the class or class properties.
- list of parameters: if you want to pass data as a parmeter you can pass them inside parantheses. the parametr must have type and name. 
- method body: it is enclosed between { } braces. The methods code and local variables will go here.
- An exception list: 

Also note that, a method can be static or non static. 
Static method: when a method is static, it means, the method belongs to the class and you can accesss it without creating object. 
Non-static method: when a method is not static, it means, you have to create an object to access or invoke the method. 

Let's see an example of method declaration and how to invoke it: 

Static method: 

```java
public class TestClass {
    
    //declare the method
    public static void printName(){
        System.out.println("My name is Zakir Hossain");
    }
    public static void main(String[] args) {

        //invoke the method
        printName();
    }
}

output: 
My name is Zakir Hossain
```

Not static method: 
If the method is not static, you have to create object of the class to invoke or call the method.

```java
public class TestClass {

    //declare the method
    public void printName(){
        System.out.println("My name is Zakir Hossain");
    }
    public static void main(String[] args) {

        //creating a TestClass object
        TestClass obj = new TestClass();
        //here the new TestClass(); statement create a reference variable of TestClass java class.
        
        obj.printName();
    }
}

```

A method with parameters: 
Java method can contain parameters. You can pass parameters at the time of method declaration and when you invoke the method you must pass the same number of argumetns with the same type.

```java

public class TestClass {

    //declare the method
    public static void printFullName(String first_name, String last_name){
        System.out.println("Full name is: "+first_name + last_name);
    }
    public static void main(String[] args) {
        
        //invoke the method with the defined parameters.
        printFullName("Zakir", " Hossain");
    }
}

output: 
Full name is: Zakir Hossain

```

Another example that sum 2 int numbers and print result:

```java

public class TestClass {
    
    //declare the method
    public int printSummation(int x, int y){
        return x+y;
    }
    public static void main(String[] args) {

        TestClass obj = new TestClass();
        System.out.println(obj.printSummation(10,10));
    }
}

output: 
20
```

Note: When you pass value insdie the method parenthesis at the the time of method declaration it is called, parameter. But, when you provide values at the time of method calling, it is called arguments. Arguments must match the parameters type and you have to provide the same number of argumetns as well.