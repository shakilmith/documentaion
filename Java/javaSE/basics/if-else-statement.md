# Java If Statement

If we want to render something based on certain condition, we use if statement in java.

The systax is very simple:

```js
if(condition){
    //code to be executed.
}
```

Note that, the code or statement inside of if statement will only be executed when the condition fulfilled.

Such as, entering a pun has age limits. Like you can't enter in the pub if you are not 18 or over. So, the application will check your age that it is at least 18 or not. If the age is 18 or more than 18 then you can enter the pub.

```js
public class JavaExample {
    public static void main(String[] args) {
        int age =  20;
        if(age >=18 ){
            System.out.println("You are eligible to enter this pub!");
        }
    }
}
//output
You are eligible to enter this pub!
```

Here, we declare a variable age and add value 20 in it. Now, we use if statement to render some data based on the age variable. So, if the age is over 18 the statement will be rendered otherwise not.

Now, make your age 17 or lower 18 and see the code block renders or not.

```js
public class JavaExample {
    public static void main(String[] args) {
        int age =  17;
        if(age >=18 ){
            System.out.println("You are eligible to enter this pub!");
        }
    }
}
//output
```
Nothing to be rendered.

## Java If-Else statement

If you want to render some data if the if condition is not trur, then you can use an else blok. The else block will always render if the if condtion is false.

Like:

```js
public class JavaExample {
    public static void main(String[] args) {

        //initial age variable
        int age = 17;

        if(age>=18){
            System.out.println("You are eligible to enter this pub");
        }
        else {
            System.out.println("You are not eligible to enter this pub!");
        }
    }
}
//output
You are not eligible to enter this pub!
```

## Java Else-if statment

If we want to specify a new condition to check we can use else-if stement regardless if statement only. 


```js
public class JavaExample {
    public static void main(String[] args) {

        //initial age variable
        int age = 20;

        if(age < 18){
            System.out.println("You are not eligible to enter this pub!");
        } else if (age >= 18) {
            System.out.println("You are eligible to enter this pub.");
        }
        else {
            System.out.println("You enter wrong number.");
        }
    }
}
//output:
You are eligible to enter this pub.
```
Now compiler checks the first condition and found that the age is over 18 and go to next condition. Here, the compiler found that the else-if condition is true thus it render the else block. Because the the age is set to 20.

## Another example:

Let's say we want to render some usefull data based on user input of the day of the week.


```js

public class JavaExample {
    public static void main(String[] args) {

        String dayOfTheWeek = "Monday";

        if (dayOfTheWeek == "Saturday") {
            System.out.println("It's " + dayOfTheWeek + " ...");
        } else if (dayOfTheWeek == "Sunday") {
            System.out.println("It's " + dayOfTheWeek + " ...");
        } else if (dayOfTheWeek == "Monday") {
            System.out.println("It's " + dayOfTheWeek + " ...");

        } else if (dayOfTheWeek == "Tuesday") {
            System.out.println("It's " + dayOfTheWeek + " ...");

        }else if (dayOfTheWeek == "Wednesday") {
            System.out.println("It's " + dayOfTheWeek + " ...");

        }else if (dayOfTheWeek == "Thursday") {
            System.out.println("It's " + dayOfTheWeek + " ...");

        }else if (dayOfTheWeek == "Friday") {
            System.out.println("It's " + dayOfTheWeek + " ...");
        }
        else {
            System.out.println("You input was wrong!");
        }
    }
}
/*
 * Output:
 * It's Monday ...
 */
```

The above example can be simply replaced with swithc statement. To less our else-if statement we can use switch statement.

Like: 

```js
public class JavaExample {
    public static void main(String[] args) {

        String dayOfTheWeek = "Monday";

        switch (dayOfTheWeek) {
            case "Saturday":
                System.out.println("It's "+ dayOfTheWeek +" ...");
            break;
            case "Sunday":
                System.out.println("It's "+ dayOfTheWeek +" ...");
            break;
            case "Monday":
                System.out.println("It's "+ dayOfTheWeek +" ...");
            break;
            case "Tuesday":
                System.out.println("It's "+ dayOfTheWeek +" ...");
            break;
            case "Wednesday":
                System.out.println("It's "+ dayOfTheWeek +" ...");
            break;
            case "Thirsday":
                System.out.println("It's "+ dayOfTheWeek +" ...");
             break;
            case "Friday":
                System.out.println("It's "+ dayOfTheWeek +" ...");
            break;
            default:
                System.out.println("You input was wrong!");
        }
    }
}
/*
 * output:
 * It's Monday ...
 *
 */
```

The above Switch stament should be simpified by lamda expression:

See the code below:

```js
public class JavaExample {
    public static void main(String[] args) {

        String dayOfTheWeek = "Monday";

        switch (dayOfTheWeek) {
            case "Saturday" -> System.out.println("It's " + dayOfTheWeek + " ...");
            case "Sunday" -> System.out.println("It's " + dayOfTheWeek + " ...");
            case "Monday" -> System.out.println("It's " + dayOfTheWeek + " ...");
            case "Tuesday" -> System.out.println("It's " + dayOfTheWeek + " ...");
            case "Wednesday" -> System.out.println("It's " + dayOfTheWeek + " ...");
            case "Thirsday" -> System.out.println("It's " + dayOfTheWeek + " ...");
            case "Friday" -> System.out.println("It's " + dayOfTheWeek + " ...");
            default -> System.out.println("You input was wrong!");
        }
    }
}
/*
 * output:
 * It's Monday ...
 *
 */
```

More consige like the below too:

```js
public class JavaExample {
    public static void main(String[] args) {

        String dayOfTheWeek = "Monday";

        switch (dayOfTheWeek) { 
            //by case merging
            case "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thirsday", "Friday" -> System.out.println("It's " + dayOfTheWeek + " ...");
            default -> System.out.println("You input was wrong!");
        }
    }
}
/*
 * output:
 * It's Monday ...
 *
 */
```

But remember the the compiler only can reach to Monday and the rest of the statement will be ignored. But if your variable value if "Friday" or else then the compiler will chekc all the conditions to be fullfilled if none of the condition is fulfilled, the default statment will be executed. 

Hence, I will describe more about Switch statement in the Java Swtich tutorial section.

Take care,
Shakil Ahmed.