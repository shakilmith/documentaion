# Python OOP (Object Oriented Concept)

OOP means object oriented programming. Python is an object oriented programming (OOP) language. The main concept of oop is that, everything will be recognized as object. Like your laptop, book, keyboard or bike or pen etc. An object may contain properties (attributes), methods (behaviors), constructors. Such as, if your pen is an object then it has properties like name, color, size or price and behaviors like can_write, can_erase etc. In programming object helps us to organize codes concisely, write maintainable application.

## Creating Python Class

However, class is the blueprint or mechanism of creating objects. 

Syntax of defining a class

Note: indentation is required for the code block

```
class MyClass: # class MyClass(): would be valid
    pass 
```

Here MyClass is the name of the class and it may have constructors, properties (attributes), methods or even sub classes.

Note: In python, class name can start lowercase letter, but it is always a good practice to write your class by uppercase letter.

## Class Members 

Class members are constructors, properties, methods and sub_classes. Here properties, fields, attributes are recognized as same in python language. Such as,

```
class MyClass:
    x = 10 # x is the property of MyClass
    pass
```

Here x is the property of MyClass and we initialized it by 10. Also, we have used the pass statement to avoid the compile time error.

## Creating Object

In order to access the properties, methods of a class it is required to create an instance or object of that class. Such ass,

```
class MyClass:
    x = 10 # x is the property of MyClass

obj = MyClass() # here obj is the name of MyClass object

# access the property of MyClass using the obj

print(obj.x)
```

Let's see another example accessing the class members

```
class MyClass:
    x = 10 # class property
    def get_x(self): # class method that print the value of x when it will be called
        print(self.x)
    
# creating obj of MyClass
obj = MyClass()

# print the value of x
print(obj.x) 

# invoke the get_x() method 
obj.get_x()
```

If you run the above python file, the following result will be printed in the console.

```
10 # property value
10 # after the method invocation.
```

Note: self keyword used in the method body, refers this keyword of java or c++. It means to access the current instance members from the block and it can be anything else than exact self. 

## Using __init__() function

Every python class has a special method called __init__() function. Like the default constructor of java that helps to initialize the class members. Similarly, the role of the __init__() function is to define the class members like properties or methods and initialize their values at the time of object creation. Though you can explicitly define the __init__() function, but if you don't declare any __init__() function explicitly, then an implicit __init__() function will be constructed for you when you create any instance (object) of that class.

Such as,

```
class Area:
    def __init__(self, x, y): # the first parameter must be self (you can use your name too)
        self.x = x 
        self.y = y 
        
    def get_rect_area(self): 
        print("The area of rectangle is", self.x*self.y)

# now create an object of Area

obj = Area(12, 10) # the the default constructor requires 2 arguments x and y

# print the area of rectangle
print("Length: ",obj.x)
print("Width: ", obj.y)

## area is:
obj.get_rect_area()
```
If you run the above python file, you will get the following output:

```
Length:  12
Width:  10
The area of rectangle is 120
```

Note: self is the required first keyword of __init__() function in python and it must be the first argument. It doesn't need to be the name of self, it can be anything (your name or python) but should be the first argument. It works like this keyword of java or javaScript that refers the current object that is used to access or initialize the current instance members.

Also note that, when you define __init__(self) function with any arguments they must be given at the time of object creation of that class. Then they will be called instance variable (object).

Such as,

```
class Person:
    def __init__(self, name, role):
        self.name = name
        self.role = role
        
obj = Person("Mark Smith", "Python Developer")
print("Name: ", obj.name)
print("Role: ", obj.role)
```

After running the above python file, the result will be

```
Name:  Mark Smith
Role:  Python Developer
```

You can see, we have passed the parameters value when we created the object, same number, same type (though python isn't typed language.)
