# Freemarker if, elseif and else directive


In Freemarker template engine, the main purpose of using if, elseif or optional else expression is to render content conditionally. Here, always if code block will render if the condition is true. In case if block will turn false, then the elseif block will render. But, always else block will render when none of the condition (if, and elseif) is true. Even there are ways to use shorthand if, else statement in freemarker.


Syntax:

```
<#if condition1>
//code block
<#elseif condition2>
//code block
...
<#else>
//code block (always tru)
```

Here, if condition1 is true then if block will be executed and rest of the block (elseif and else) will be skipped. If condition1 becomes false then elseif block will be executed. But, if condition1, condition2 is false then only block will be executed (Note: the else block will always be true when if, elseif conditions are false)


Guess, you have a **sample.ftlh** file in your templates folder. Let's check out a simple example.

sample.ftlh:

```
<#assign name="Mark Smith">
    
<#if name="Mark Smith">
<p>Our Beloved Team Leader.</p>
</#if>
<#--Output: Our Beloved Team Leader.-->

//But the "if condition" becomes false noting will render on the screen

<#if name="Bob Smith">
<p>Our Beloved Team Leader.</p>
</#if> 
<#--Render nothing in the screen-->
```

sample.ftlh (use extra else block)

```
<#assign name="Mark Smith">
    
<#if name="Bob Smith">
<p>Our Beloved Team Leader.</p>
<#else>
<p>Our Beloved New Member.</p>
</#if>
<#--Output: Our Beloved New Member-->
//As if condition is false, thus the else block will render.
```

sample.ftlh (using elseif block)

```
<#assign age=16> 

<#if (age >= 18)> <#--use gt for '>' and gte for '>=' if you don't use parenthesis-->
<p>Your can enter the pub.</p>
<#elseif age < 18> <#--You can also use lt for '<' and lte for '<=' but it is up to you-->
<p>You can only enter the pub with your parent permission.</p>
<#else>
<p>Something went wrong</p>
</#if>

//output:
You can only enter the pub with your parent permission.
```

Note: '> or >=' can be written gt and gte, but if you use parenthesis then it is okay not to use gt or gte. But if you don't use parenthesis like ```<#if x > 10 >``` makes confusion with closing ```>``` tag of if statement. Thus recommended to use either gt for ```>``` and ```gte``` for ```>=```. But, lt and lte don't create any error.

## Another Example of Using Multiple Elseif condition

sample.ftlh

```
<#assign day="Tuesday">

<#if day=="Sunday">
<p>It is Sunday</p>
<#elseif day="Monday">
<p>It is Monday</p>
<#elseif day="Tuesday">
<p>It is Tuesday</p>
<#elseif day="Thursday">
<p>It is Thursday</p>
<#elseif day="Friday">
<p>It is Friday</p>
<#else>
<p>Nothing to display.</p>
</#if>

//Output:
It's Tuesday
```

Note: The above repetitive elseif block can be replaced by freemarker ```switch``` statement, but the template author advices to avoid switch directive for the sake of elseif directive and moreover it's error-prone due to the fall-through behavior. 

Yet, for your favour, I can just show you how ```switch/case``` directive works in freemarker templates.

sample.ftlh

```
<#assign day="Tuesday">

    <#switch day>
    <#case "Sunday">
    <p>It's Sunday</p>
    <#break>
    <#case "Tuesday">
    <p>It's Tuesday</p>
    <#break>
    <#case "Friday">
    <p>It's Friday</p>
    <#break>
    <#default> <#--When none case are matched-->
    <p>Something went wrong.</p>
    </#switch>

//Output:
It's Tuesday
```

Note: Using ```<#break>``` directive after each ```<#case>``` is mandatory because it is the only way to skip the ```case``` block when it doesn't match. 




