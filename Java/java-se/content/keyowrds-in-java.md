## Java improtant keywords and their basic uses:
 
1. Class: Class is one kind of blueprint or template of creating objetcts in java. Class is required componet in java programming language. In java, class may contain properties(fields or states) and methods (functions). It is required to create object in order to access or execute class members (properties or methods but while they are not static)

2. Object: Object is an instance of class. Objects is created for executing class non-static members or initializing constructors. A class may have more than one object and in java, object is being created by class and can have their own properties or methods.

3. Methods: Methods are called functions that can perform different operations based certain commands. When you declare a method it is necessary to call or invoke it in order to execute. In java method must be declared inside a class/inteface. A method may contain parameters inside parenthesis. 
   - parameters: When you write varibale inside parenthesis when you declare a method.
    - arguments: When you provide values at the time of calling the method based on parameters.

4. Variable: In java variable is a storage location in somewhere in your computer memory where are values are stored. In a word, we create variables to store specific values in them. In java, we must declare a  variable before accessing it. Also note, variable in java type based means, we use type while declaring a variable. 
like: int x = 101;
Note: The data type of a variable determines which type of data it can hold. 
The possible data types are: int, String(object actually), char, float, double, long, boolean, Object etc.
Also note, you can use diffrent modifies while declaring variables.

5. Interface: A collection of Absatract methods that define a contract for implementing classes. In a word, interface is 100% abstract class as well as implies more restrictions.
The implementations is provided by the subclass or subsequent classes.

6. Inheritance: A mechanism or strategy that allows classes to inherit properties or beahaviors. Overall, inheritance means creating a relationship between parant and child class in such a way so that, child class can acquire the members of parent class. but, child classes may have their own properties or methods.
    - Parent Class: Super class or the class whcich is used to create child classes.
    - Child Class: Derived class or the class which is being created by parent class.


7. Polymorphism: It means many forms. In java, polymorphism can achieve when same type of tasks can be done many ways or differently. Like, when you have methods those actually do the same type of job, you can overload or override them. And, it is called polymorphism.
    - Method overloading: 
    - Method overriding:

8. Package: A single unit that organizes common or related classes, interfaces together. Like, a capsule with different types of medicines or a toy box of many toys. Basically, packages help to organize or manage large codebase and prevent naming conflicts.
Note: In real life application you always work with packages. Do you notice, when you wrtie your java code in a simple form, like int, String etc. they comes from, java.lang package. The built in packages are: 
Note: In order to use a class or interface that is belong to any package, you must import it before accesing.

9. Static: Static is a keyword that is used to define class level members that are shared among all instances of a class. When class members are static, no longer to create objects or instances of that class to access static members.
Note: Object and Instance: Same thing. Also note that, if a class members aren't static, you have to create object or instance of that class to access those non-static members. 

10. Final: It is a keyowrd that implies restrictions over class and it's members. When a class is final, it can't be inherited, means can not be used to create sub classes. When a class members are final, can't be changed or modified or renamed or overrriden. Final properties must be initialized (value should be added) when declaring.

11. Modifiers: Public, Private, Protected
Public: It is used to declare a class and class memebers. When a class or class members are public, it means they accessed or used in the same package or outside of the package. 
Private: It implies restrictions over class and it's members. If a class is private it can't be accessed outside of the package. And, when a class members are private, they can't be used without getter and setter methods.

12. Protected: 
