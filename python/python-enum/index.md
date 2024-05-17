# Enumeration in Python

Enumeration of python is called sometimes enum in python. Enum means creating constant fields that are not going to be changed throughout the application lifecycle. But in python, enum refers the set of symbolic names bound to unique values.

In order to work with enum in python, we have to import the python module called enum.

```
from enum import Enum # now enum's can be created
```

Let's print the weekdays based on the weekday number

```
from enum import Enum

class Weekday(Enum):
    Sunday = 1
    Monday = 2
    Tuesday = 3
    Wednesday = 4
    Thursday = 5
    Friday = 6
    Saturday = 7 

x = Weekday(3)
y = Weekday(7)

print(Weekday(5))
print(x)
print(y)

# output:
Weekday.Thursday
Weekday.Tuesday
Weekday.Saturday
```

As you can see, creating an enum is very simple like creating a python class but it inherits Enum itself.

## Find attribute and it's value

Enum has built in methods called name to find out the attribute name of enum and value to retrieve the value of the enum.

```
print(Weekday.Sunday.name)
print(Weekday.Sunday.value)

# output:
Sunday
1
```

