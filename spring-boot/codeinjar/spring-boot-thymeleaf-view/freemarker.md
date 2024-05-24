# Spring Boot and Freemarker Template Engine

In this simple post, we are going to see how to create a simple Hello World Application using Spring Boot and Freemarker template engine. But, it is required that in your spring boot project classpath, the freemarker starter dependency should be present.


**Freemarker**: Apache Freemarker is a java template engine that helps to generate dynamic html web pages, emails, configuration files or source code etc. The Spring Framework has built-in integration for using Spring MVC with FreeMarker templates. If you use Spring boot to bootstrap your spring powered application, then you can easily add freemarker starters in your classpath.


## Bootstrap Your Spring Boot Application

First of all, we have to create a simple spring boot application and add the spring boot starter freemarker dependency in the application classpath. If you already have a spring boot application in your system, open it in your favourite ide. Now in your application classpath add the spring boot freemarker starter dependency.

**pom.xml**

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
```

Additionally, you have to configure the template file path in your **application.properties** file. So, add the following two configurations line.

**application.properties**

```
# template file extension (html, ftl or ftlh) and where it is located.
spring.freemarker.suffix= .ftlh
spring.freemarker.template-loader-path= classpath:/templates/
```

Note: Spring Boot supports thymeleaf by default, thus adding the above configurations are optional when you use thymeleaf as a template engine.


But if you don't have spring boot application, here is a simple tutorial that will help you to create a simple spring boot application: <a href="https://codeinjar.com/spring-boot-start/" target="_blank">Create Your First Spring Boot Application</a>


## Create Freemarker Template File

Now in the templates folder create a simple freemarker template file. Let's name it **greeting.ftlh** file. But, you can also create .html file too. But, for achieving this, you have to write this ***spring.freemarker.suffix= .html*** in the **application.properties** file.



**greeting.ftlh**

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Freemarker Template View</title>
</head>
<body>
    <h1>Freemarker View</h1>
    <h2>Hello, ${name}</h2>
</body>
</html>
```

Now handling the template file **greeting.ftlh**, create a controller class and we must annotate this class by **@Controller** annotation. So, now create a controller class **GreetingController.java** in **com.company/controller** package.


**GreetingController.java**

```
package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(Model page){
        
        String name = "World";
        page.addAttribute("name", name);
        return "greeting"; //greeting.html
    }
}
```


Now, run the application, if it runs successfully, then your application by default listens port 8080 in localhost. So, invoke the uri [spring boot](http://localhost:8080/greeting) and you will see a simple greeting text message in this page.

![alt text](https://docs.javaondemand.com/blog/spring-boot/spring-boot-freemarker-view/image1.png)



## Update the GreetingController.java Class

Let's update the code of **GreetingController.java** class so that it can do more.


**HelloController.java**

```
package com.company;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name,Model page){
        
        page.addAttribute("name", name);
        return "greeting"; //greeting.html
    }
}
```

Now our application can listen string parameter from the request URI, as we have used the **@RequestParameter** annotation.

Please, start your development server again and invoke the uri [text](http://localhost:8080/greeting) and you will see the Hello, World message because we set 
**defaultValue = "World"** in the @RequestParam() but if invoke uri like this [text](http://localhost:8080/greeting?name=Freemarker) then the response would be Hello, Freemarker.

![alt text](https://docs.javaondemand.com/blog/spring-boot/spring-boot-freemarker-view/image2.png)


------

Read More: