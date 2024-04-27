# Creating User Defined Directive

Unlike many built in directives like list, if, elseif or assign directive we can also generate our own directive in Freemarker.


Syntax to create user defined directive

```
<@name_of_the_directive one or more parameters> <#--parameters are optional, but if have any, immediately should be passed when you call the directive-->
//code block
</@>

//guess our directive name is product and it has two parameters

```

Note: 