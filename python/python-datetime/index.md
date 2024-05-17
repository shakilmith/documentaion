# Python Datetime Module

In order to work with data and time in python, we have to import a python module (package in other words) called datetime module. Then, there are built in methods in datetime module to work with date and time in python.

Syntax:

```
# first of all you have to import the datetime module (top of the file)
import datetime
# or
import datetime as date

# now we can access the built-in methods that datetime module provides

# Note: we have to use the datetime constructor to construct date and time to use in our application
```

## A simple example that demonstrate the use of datetime module

Using datetime.now() method

```
import datetime 

# display the current date and time (using datetime.now() method)

ct = datetime.datetime.now()
print(ct)
```

After running the application, it prints the current date an time including milliseconds.

```
2024-05-10 12:25:30.471523
```

What if you only want to print the date or time only?

```
import datetime 

# display the current date and time (using datetime.now() method)

ct = datetime.datetime.now()

print("Current Date is: ", ct.date())
print("Current Time is: ", ct.time())

# display only year, month, day separately

current_year = ct.date().year
current_month = ct.date().month
current_date = ct.date().day

print("Current year: ", current_year)
print("Current month: ", current_month)
print("Current date: ", current_date)

# display only hour and minute 

current_hour = ct.time().hour
current_minute = ct.time().minute

print("Hour: ", current_hour)
print("Minutes: ", current_minute)
```

After running the python file, following output will be displayed

```
Current Date is:  2024-05-10
Current Time is:  12:44:58.833225
Current year:  2024
Current month:  5
Current date:  10
Hour:  12
Minutes:  44
```

## Specify our own datetime definition instead of using datetime.now()

```
import datetime

# Creating objects of datetime

current_date = datetime.datetime(2024, 3, 24) # 3 arguments required (year, month, day)
print(current_date)

# output:
2024-03-24 00:00:00
```

Note: The date object can also take additional three parameters including year, month, day. Such as, hour, minutes, seconds, tzone. But those are optional, if you don't specify them, 00:00:00 will be added.

## Format Datetime



