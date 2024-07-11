# Python Tuple

Tuple is a collection data type in python that items are ordered, immutable, and index based by default.

When we need to store many items that are not going to be changed, we can use tuple data type in python instead of list.

## Syntax

```
# tuple items that are comma separated
tuple_name = a, b, c
# using parentheses ()
tuple_name = (a, b, c)
# if your tuple contains only one element then, extra comma is required
tuple_name = (a,)
# using tuple() constructor
tuple_name = tuple((a, b, c))
```

Note: It is actually the comma that makes the tuple, not parentheses. Using parentheses () is optional, except of the empty tuple or when it is required to avoid syntactic ambiguity. For example, f(a, b, c) is a function call with three arguments, while f((a, b, c)) is a function call with three tuples as the solo arguments.

# Tuple is Immutable

