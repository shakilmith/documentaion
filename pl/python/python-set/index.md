# Python Set Data Type

Python contains built in data types for storing collection of values either same type of different types (Remember, python isn't strictly typed language)

The built in collection data types are: List, Set, Tuple and Dictionary.

Today, we are going to discuss about Set data type in details.

## Set Type Features in Python

1. Set is unordered
2. No duplicate entries/elements allowed
3. Immutable (not changeable but adding or removing new elements are allowed)
4. Not indexed based (elements aren't ordered) 

## Syntax to Create Set type in Python

```
# using {} - curly brackets
set_name = {...} # add your set items in the curly brackets
# using set() constructor
set_name = set ((...))

# such as
numbers = {"First", "Second", "Third"}
```

## Creating a Set type and Print the Result

Here, we will use {} - curly brackets to define our set type, than using the constructor.

```
# creating a Set
persons= {"Elena", "Alfred", "Bhumi", "Fredrick", "Cobult"}

# print persons
print(persons) 
# Output: {'Fredrick', 'Alfred', 'Bhumi', 'Elena', 'Cobult'}
```

## Set Items can be Different types as well

Here, we define a set of string, int, boolean.

```
demo_set = {"Java", 25, True}
print(demo_set) # output: {25, 'Java', True}
```

**Note**: In python, we can use either double quotation ("") or single quotation ('') for string or text based values, both are same as there is no charter type in python. But it is always a good practice is to using single quotation '' for characters ('a', 'b', 'C') and double quotation for sequence of characters like ("Java", "Python"), yes "Java" and 'Java' treats same.


## No Duplicate Elements Allowed

```
# creating a Set
persons = {"Elena", "Alfred", "Bhumi", "Fredrick", "Cobult", "Alfred"}

# duplicate elements will be ignored
print(persons)
# output: {'Alfred', 'Fredrick', 'Bhumi', 'Elena', 'Cobult'}
```

## Set Type is Unordered

```
# creating a Set
persons = {"Elena", "Alfred", "Bhumi", "Fredrick", "Cobult"}

# duplicate elements will be ignored
print(persons)
# output: {'Bhumi', 'Cobult', 'Alfred', 'Elena', 'Fredrick'}


# now you can't access the first element by it's index number, such as
print(persons[0])
# Error in console: TypeError: 'set' object is not subscriptable
```

## Using Boolean Values as Set Elements

```
set_as_bool = {True, False, 1, 0,}
print(set_as_bool)
# output: {False, True}
```

You get the above output after running the python file because, python treats True == 1 and False == 0, thus duplicate elements are ignored.

## Iterate Set Elements Using For Loop

We can simply iterate Set elements using python for loop.

```
# creating a Set
persons = {"Elena", "Alfred", "Bhumi", "Fredrick", "Cobult"}

for p in persons:
    print(p)

# output
Bhumi
Cobult
Fredrick
Alfred
Elena
```

**Note**: You may get different result because, Set isn't ordered or indexed.


