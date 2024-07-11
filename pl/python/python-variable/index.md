# Declaring Variable in Python

In python, variable declaration is very straightforward. When you assign a value to a variable, it's called variable declaration. As python isn't strictly typed programming language like java or c++, so there is no need to specify the data type of your variable.

Syntax:

```
variable_name = value

# such as
name = "Python" # string variable
age = 30 # int variable
is_mature = false # boolean variable
```

Here, name is the variable name and it holds string value, "Python". Similarly, age is the name of a variable that holds int value.

## Print the Variable Value

We can store a value in python usually in a variable (sometimes it is called the memory address of your computer where the value will be stored), and use the python built in print() method to print it in the terminal. Such as,

```
name = "Julian Smithy"
age = 30
# print name age using print() method
print(name) # output: Julian Smithy
print(age) # output: 30
print("I am ", age, "Year's old") # output: I am 30 years old
```

You can see, we use "," for concatenating variables of literals, instead of using "+" symbol. 

Note: Usually, String (str in python - sequence of characters) are concatenated but numbers are added. So, recall this behavior when it is required use string (texts) and numbers together.

## Python Data Types

Though usually, you don't have to concern about python data types as it's not completely typed language. Hence, you don't have to provide the type definition when you declare any python variable (unlike java or c++). But python has built in method (called type()) to check the type of your declared variable. Such as,

```
name = "Juliana Smithy"
age = 30
PI = 3.1416
is_mature = False
planets = ["Earth", "Jupiter", "Saturn", "Mars", "Mercury"]

print(type(name))
print(type(age))
print(type(PI))
print(type(is_mature))
print(type(planets))
```

If you run the above python file, you will get type definitions for all.

```
<class 'str'> # string type - sequence of characters, in python str and character don't have different type like java
<class 'int'> # numeric type - all: int, float, complex
<class 'float'> # numeric type
<class 'bool'> # boolean type: support True/False value
<class 'list'> # Sequence type - all: list, tuple, range
```

# Python Built in Data Types:

Python contains the following built in data types (though usually, you don't have to provide the type definition while declaring a variable - they are used internally) 


Text or character: str # note: In python " " and ' ' are same. Thus, there is no character data type in python. For storing text based information, you can either use "" or '' - single quotation or double quotation.

Numeric : int, float (decimal include), complex (with j)

Boolean : True/False (support these two possible values)
Sequence (array or list): list, tuple, range

Set: set and frozenset

Binary : bytes, bytearray, memoryview,

None : NoneType

