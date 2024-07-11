# Python List 

Python contains built in data types for storing collection of values either same type of different types (Remember, python isn't strictly typed language)

The built in collection data types are: List, Set, Tuple and Dictionary.

Today, we are going to discuss about List data type in details.

Syntax:

```
list_name = [...]
# Or through list constructor
list_name = list ((...)) # two parentheses are required
```
Here, we use the first approach to define a list.

# An Example of Python Python List

Let's see how to define python list.

```
# creating a list of int values 
list1 = [1, 2, 3, 4, 5]

# creating a list of string values
list2 = ["Java", "Python", "C++", "Rust"]

# creating a list of boolean values
list3 = [true, false, false, true]

# creating a list of different types
list4 = ['A', 40, "years", "old", false] # in python '' and "" are same
```

## Accessing Data Members From List

First of all, list data type is index based in python. Thus, we can access the list data members using the index number. By default index number starts from 0 to n-1. Means, first member of the list is list[0], second member of the list is list[1] and last member of the list is (len(list) - 1). Here, len(list) returns the list length.

Let's look over the following list example where we define a list and access the data members using their appropriate index number.

```
# Creating a list of same type
languages = ["Java", "JavaScript", "Python", "Rust", "C++"]

# print the list members
print("First element is ", languages[0])
print("Second element is ", languages[1])
print("Last element is ", languages[-1]) # same as languages[len(languages) - 1]

# output:
First element is:  Java
Second element is:  JavaScript
Last element is:  C++
```

So, for accessing the first element of this list, we used the index [0], for second element we use index [1] and so on. Note that, negative indexes starts from the end of the list.

# Use Built in len() function to access the last data member of a list

We can use the built in len() function to access the last element of a list instead of using the negative index number.

```
list = [1, 2, 3, 4, 5]

# access the last data member
print(languages[len(languages) - 1]) # same as languages[ - 1]

# output:
5
```

Here, built in len() function returns the length of the list (total elements number). And we know list index is always one less then the length of the list (as index starts from 0).Thus, the last element of the above list is 4th index (as length is 5). Therefore, list[len(list) - 1] == list[4]


## Iterate List Elements

We can simply use python for loop or range function to iterate over list elements. 

Using for loop: 

```
languages = ["Java", "Python", "C++", "Rust", "Ruby"]

# Iterate list elements using for loop
for x in languages: # here x is the reference or alias of the languages list
    print(x)
```

If you now run the above python file, you will get the following output:

```
Java
Python
C++
Rust
Ruby
```

Using range() function

Python built in range function can also be used to iterate over list elements.

```
languages = ["Java", "Python", "C++", "Rust", "Ruby"]

# Iterate list elements using range() loop
for x in range(len(languages)):
    print(languages[x]) # but print(x) returns only 0 to 4, index number
```

If you now again, run the python file, you will get the same output as before.

```
Java
Python
C++
Rust
Ruby
```

# Built in Methods for List

There are built in methods available in python to work with list or list data members. Let's explore them one by one with example.

    <div>
        <table>
            <tr>
                <th>Methods</th>
                <th>Description</th>
                <th>Example</th>
            </tr>

            <tr>
                <td>append(x)</td>
                <td>insert a new item at the end of the list</td>
                <td>
                    lang = ["Java", "Python", "C++"]

## using append() method to insert a new item at the end of the list
lang.append("Rust") 
print(lang)
# output: ['Java', 'Python', 'C++', 'Rust']
                </td>
            </tr>

            <tr>
                <td>insert(index, el)</td>
                <td>insert a new element to a given position, but required two arguments</td>
                <td>
                    lang = ["Java", "Python", "C++"]

## using insert(index, el) method to insert a new item at the end of the list
lang.insert(3, "Rust")
print(lang)
# output: ['Java', 'Python', 'C++', 'Rust']
                </td>
            </tr>
            <tr>
                <td>remove(el)</td>
                <td>remove the specified element (one argument is required)</td>
                <td>
                    lang = ["Java", "Python", "C++", "Rust"]

# using remove(el) method to remove element from the list
lang.remove("Rust") # Rust is deleted now
print(lang)
# output: ['Java', 'Python', 'C++']
                </td>
            </tr>
            <tr>
                <td>pop(index)</td>
                <td>remove the element from the list based on the index number. If no index is specified then the last element will be removed</td>
                <td>
                    list1 = ["Java", "Python", "C++", "Rust"]
list2 = [1, 2, 3, 4, 5]
# using pop() method to remove the element from the list
list1.pop() # last item is removed from list1
# remove the first element from the list
list2.pop(0) # first item is removed from list2 as we specified the index number

print(list1)
print(list2)
# output for list1: ['Java', 'Python', 'C++']
# Output for list2: [2, 3, 4, 5]

                </td>
            </tr>
            <tr>
                <td>clear()</td>
                <td>remove all the elements from the list. It is equivalent to del list[ :]. But the list itself will not be deleted entirely, it will remain same with empty elements.</td>
                <td>
                    lang = ["Java", "Python", "C++", "Rust"]

# using clear() method
lang.clear() # empty the the list
print(lang) # returns empty list: []

# now the len() function returns 0
print(len(lang)) # output: 0
                </td>
            </tr>

            <tr>
                <td>count(el)</td>
                <td>the count method returns, how many times a element is present in the list. One element is required.</td>
                <td>
                    person = ["Shakil", "Rebeka", "Rebeka", "Shakil", "Jenkov"]

# using count() method
x = person.count("Rebeka")
print(x) # it returns 2
                </td>
            </tr>
            <tr>
                <td>sort() or sorted</td>
                <td>sort the item of the list either ascending(default) or descending order</td>
                <td>
                    person = ["Elena", "Alfred", "Bhumi", "Fredrick", "Cobult"]

# sort the person list (ascending by default)
person.sort() # same as sorted(person)
# if descending order

print(person)
# output: ['Alfred', 'Bhumi', 'Cobult', 'Elena', 'Fredrick']

# sort the person list descending order
person.sort(reverse= True)
print(person)
# output: ['Fredrick', 'Elena', 'Cobult', 'Bhumi', 'Alfred']

                </td>
            </tr>
            <tr>
                <td>reverse()</td>
                <td>reverse list elements in place</td>
                <td>
                    person = ["Elena", "Alfred", "Bhumi", "Fredrick", "Cobult"]

# before reversing
print(person)
# output: ['Elena', 'Alfred', 'Bhumi', 'Fredrick', 'Cobult']

# after reversing
person.reverse()
print(person)
# output: ['Cobult', 'Fredrick', 'Bhumi', 'Alfred', 'Elena']

                </td>
            </tr>
            <tr>
                <td>copy()</td>
                <td>returns shallow copy of the list, equivalent to list[:]</td>
                <td>
                    person = ["Elena", "Alfred", "Bhumi", "Fredrick", "Cobult"]

# using copy() method
new_person_list = person.copy()
print(new_person_list)
# Output: ['Elena', 'Alfred', 'Bhumi', 'Fredrick', 'Cobult']

# person == new_person_list always returns true
print(person == new_person_list) # output: True

                </td>
            </tr> 
        </table>
    </div>


## List type Features that You Should Remember while working on Python List

1. List members are index based and ordered.
2. List is mutable - new elements can be added or removed.
3. Allow duplicate elements.
4. Allow different data types.

