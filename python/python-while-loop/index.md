# Python While Loop

When we don't know how many times the loop should run, we can use python while loop than python for loop.

```
while (condition):
    # code block
    # iteration part (increment/decrement)
```
Iteration part is very important, otherwise there is a possibility that the loop will never end.

## While Loop Example

Let's print 1 to 10 using while loop

```
# define a variable
x = 1

while (x <= 10):
    print(x)
    x = x + 1 # we increment x by 1

# output: 
1 2 3 4 5 6 7 8 9 10
```

Note: In python while loop (similar to java), the first statement will always be executed either the condition is true or false.

Such as,

```
x = 5

while(x <= 5):
    print(x)
    x = x + 1 # increment by 1 but the 5 will be printed first

# output:
5
```

But what if, we print the code block after iteration (increment/decrement)?

```
x = 5

while(x <= 5):
    x = x + 1 # same as x += 1
    print(x)
    
# output:
6 
```

Why we got the output of 6 though x should be less than 5 or equal to 5. Because, here compiler first printed the incremented value then checked the condition. But in the previous example, the compiler printed the value then increment it by one and at last checked the condition. If the condition is fulfilled print something, otherwise the program or loop is terminated.

## Using break and continue Statement in while loop

break: The iteration will be stopped 

continue: The iteration will be skipped and proceed from next

Example:

Using break statement:

```
x = 1

while (x <= 10):
    print(x)
    if(x == 5):
        break
    x = x + 1 

# output
1 2 3 4 5
```

Using continue statement:

```
x = 0

while (x < 10):
    x = x + 1
    if (x == 5):
        continue
    print(x)
        
# output
1 2 3 4 6 7 8 9 10 
```

