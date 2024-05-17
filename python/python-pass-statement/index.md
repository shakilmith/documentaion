# Python Pass Statement

The pass statement does nothing. It can be used when a statement is required syntactically but the program or code block requires no action or you don't want to execute the program. Such as, 

```
def print_something():
    pass # means nothing to print
```
But if you don't use pass keyword, then the compiler shows error message like the below:

```
IndentationError: expected an indented block after function definition on line 1
```

## Few more examples where we can use pass

```
if(x > y):
    pass

x = 10
while(x < 100):
    pass

class MyClass:
    pass
```

So, in any case if we want the syntax but don't want to execute the code block or there is nothing to print, then always safe to use the pass statement. If we use the pass keyword, then the code block will be ignored though they are required. Thus, it prevents showing compile time error.

