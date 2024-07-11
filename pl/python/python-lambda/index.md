# Python Lambda Function
In python lambda means, creating anonymous function that can have any number of arguments but have only one expression.

Syntax:

```
lambda (list of arguments): expression
```

## First Lambda Example

Let's create a simple lambda function that prints the summation of given numbers

```
sum = lambda a, b: a + b
result = sum (10, 10)
print(result)

# output:
20
```

firstly, we define a simple lambda expression with two arguments and in the expression part, we define how the arguments will be used. Then, use the **print()** method to output the result.

**Note**: When you invoke or call the lambda function (an anonymous function that works like almost regular function), it must match the arguments number as well as type while declaration. Like, if your lambda function has two parameters, you must provide two arguments when you invoke/call the lambda function as a value. 

Such as,

```
def demoFunc(x, y):
    return x + y;

result = demoFunc(10, 10) # we provided two arguments
print(result)

# output:
20
```

But if you don't pass the required number of arguments, you will get compile time error. Such as,

```
def demoFunc(x, y):
    return x + y;

result = demoFunc(10) # pass one argument accidentally, though required two arguments
print(result)

# output:
TypeError: demoFunc() missing 1 required positional argument: 'y'
```


## Another Example that Shows the Real Use of Lambda Function

Let's say we have a number called 'n' and we want to multiply it by unknown number. So, the example lambda expression would be

```
def multiply(n):
    return lambda x: x*n

# store the function in a variable
result = multiply (10) # value of parameter n

print(result(5)) # value of x
print(result(6)) # value of x
print(result(7)) # value of x

# output 

50 
60
70
```



