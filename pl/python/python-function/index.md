# Python Functions

A function or subroutine is a sequence of program instructions that perform a specific task, packaged as a unit when it is called. Before using or calling a function we first create or define it. A function may have list of arguments (parameters), local variables, or return types, default Argument values and keyword arguments. Python has list of built in functions that we can use right now, just by calling them. But today we are going to learn how to define our own functions.

**Note**: Function helps to create reusable code blocks, make our program more maintainable.


## Creating Function in Python

We can simply create a function using the **def** keyword.

Syntax:

```
def function_name():
    pass
```

**Note**: pass is used avoiding the compile time error. When it is nothing to do with your function or code block, just use the pass keyword.

**Indentation**: The python code block starts after few spaces (at least one space, but one tab is better) and this is called indentation. In python, indentation is required term to define code block. In other programming languages, indentation is used readable purposes but in python it is used to defining scope of statements, like {} - curly brackets. Remember, we basically use indentation in functions, conditionals, loops or class statements.


Like the following function definition is wrong.

```
def function_name():
return 10 + 10 # because we didn't define indentation. 
```
So, the above syntax should be written,

```
def function_name():
    return 10 + 10; # using semicolon is not required, but it is helpful to use sometimes
```


Now, when you call the function it returns 20


**Note**: Python isn't typed programming language, thus, we don't have to define any type definition or use data types like string, int, float etc. while declaring any variable, method etc but in java or c++ it is mandatory.


## Simple Python Function that Returns Hello World


Let's create a python function that returns "Hello, World" string message when we call it.

```
#creating a function using the def keyword
def greeting():
    print("Hello, World")
    
# call the function
greeting()
```
When you run the above program you will get a simple "Hello, World" string message.

Output:

```
Hello, World
```

## Calling Function multiple times

It is possible to call the function as many times as you want.

**demo.py**
```
#creating a function using the def keyword
def greeting():
    print("Hello, World")
    
# call the function
greeting()
greeting()
greeting()

# output:
Hello, World
Hello, Word
Hello, World
```


## Function Parameters

functions can take any number of parameters and when we call or invoke the function we have to pass the parameters value, then they are called arguments.

Let's create a function that takes a parameter and when we call the function we have to pass the parameters value.

**demo.py**

```
# creating a function that takes a parameter
def greeting(name):
    print("Hello, "+ name) # instead of + we can use , for concatenating numbers or strings (text)
    
# call the function
greeting("Shakil") # pass the parameter value
```

If you now run the python file, it returns Hello, Shakil.


# Multiple parameters

Function can take unlimited number of parameters. Such as,

**demo.py**

```
# creating a function that takes a parameter
def greeting(first_name, last_name):
    print("Hello, "+ first_name, last_name) # instead of + we can use , for concatenating numbers or strings (text)
    
# call the function
greeting("Shakil", "Ahmed") # pass the parameter value

# Output:
Hello, Shakil
```

# Default parameters value

We can also provide the parameters value when we define a parameter in a function. It helps to avoid the compile time error, if you define parameters you must pass their value when you call the function.

**demo.py**
```
# creating a function that takes a parameter
def greeting(first_name, last_name):
    print("Hello, "+ first_name, last_name) # instead of + we can use , for concatenating numbers or strings (text)
    
# call the function
greeting("Shakil") # pass the parameter value but forget to pass the last_name value

# output: (you will get error message like the below)
TypeError: greeting() missing 1 required positional argument: 'last_name'
```

So, how to avoid to get error like this? Provide the default parameter value (but not recommended, just casually saying)

**demo.py**
```
# creating a function that takes a parameter
def greeting(first_name, last_name = "Ahmed"):
    print("Hello, "+ first_name, last_name) # instead of + we can use , for concatenating numbers or strings (text)
    
# call the function
greeting("Shakil") # pass the parameter value but forget to pass the last_name value so default parameter value will be used

# Output:
Hello, Shakil
```


## Let's Create a Function that Print the Summation of two Integers

**demo.py**
```
# creating a function that takes parameters (int)
def print_sum(x , y):
    print(x + y);
    
# call the function
print_sum(10, 10) # pass the parameters value
```

After running the above python file, you will get

```
# output
20
```


## List As an Argument of a Function

Not only string or int but also list, set, another function can be passed to a function as arguments. I mean they can also be used as function parameters. Such as,

**demo.py**

```
# creating a function that takes list as argument
def print_numbers(numbers):
    for x in numbers: # using for loop to iterate the values
        print(x)
    
# call the function
print_numbers(numbers= [1, 2, 3, 4, 5])

# output:
1 2 3 4 5
```

But we can also use a variable to store the list elements. So, the above code can be written

**demo.py**
```
# creating a function
def print_numbers(numbers):
    for x in numbers:
        print(x)

# define a list
list = [1, 2, 3, 4, 5]

# call the function
print_numbers(list)

# output:
1 2 3 4 5
```

Thanks for reading this article.


