## Spring Boot Thymeleaf View

If we want to enable thymeleaf view in spring boot application we have to add spring-boot-starter-thymeleaf dependency in our pom.xml file if we have spring boot maven project. 

If we have already spring boot project and use maven as a build tool, just add the following dependency in our pom.xml file

```java
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

Note: If you use Intellij Ide, just open your pom.xml file and in the dependency section, right clik on your mouse -> Generate -> Dependency Template (Alt+Insert) and then provide thymeleaf groupId and ArtifactId, no need to provide version numbere here. Also, you can click on Add Dependency and find search the thymeleaf dependency and add it. 

Make sure, you have internet connection while adding thymeleaf dependency. 

Hence, If you don't have spring boot project yet, please follow the below stpes to create spring boot project.

<b>Step 1:</b> Open Spring Initializer. Visit here: [https://start.spring.io/](https://start.spring.io/) for creating spring boot application.

<b>Step 2:</b> In the Project Metadata section provide your project Group and Artifact name. the group name would be the project package name and Artifact name would be the project name overall.

<b>Step 3:</b> Add spring web and thymeleaf template engine dependency by cliking on add dependency button.

<b>Step 4:</b> Then, clik on Generate button. It will then generate a spring boot application and it will be a .zip file. Please unzip it or extract it to a new location and then import it to your favourite ide. 

Note: Is it possible to create spring boot application from your ide? 
Yes, it is. But then, we have to download additional plugin to enable this feature. You can download STS ide and it has included plugin to create spring based application out of the box.
If you use eclipe you can then add STS plugin from the eclipse marketplace. 
//link
If you use intellij ide it is not possible to create spring based application from the ide if it is community addition. But, in ultimate addition you can create spring related applition easily. Here, I found few plugins in community addition and I could able to create spring boot application from the intellij ide. But the plugins don't work always. So better to create spring boot application from the spring initializer and it is smooth enough. 

//Links

<b>Step 5:</b> Now, import the spring boot application in your favourite ide and wait few to resolve the depenencies.

<b> Step 6:</b> Now, create a controller class DemoController.java in src/main/java/com/javaondemand package. Create a helloWorld method in this class that return a string of the html file. 

Also, annotate the DemoController.java class by @Controller annotation. It is spring MVC related annotaion and it configures the view of the application. 

We use @RequestMapping(value="hello") annotation in the helloWorld method and this annotaion returns the view in hello url.

```java
package com.javaondemand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping(value = "hello")
    public String HelloWorld(){
        return "hello";
    }
}

```

<b>Step 7:</b> Now we create thymeleaf templates. Make sure spring-boot thymeleaf dependency in your classpath. Create hello.html file in the reosureces/templates folder.
Right click on the templates folder -> New -> HTML File -> Name the Html file. 

Then, in the hello.html file wirte the following

```java
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Thymeleaf View</title>
</head>
<body>
<div>
  <h1>Hello Thymeleaf!</h1>
</div>
</body>
</html>
```

Note: You have to add xmlns:th="http://www.thymeleaf.org" template engine in your html file.

<b>Step 8:</b> Open application.properties file and the following properties.

```java
spring.thymeleaf.cache=false
spring.thymeleaf.suffix:.html 
```
Note: The above properties aren't necessary for the time being.

<b>Step 9:</b> The project directory should be the following after creating all the folders and files.

//image

<b>Step 10:</b> Now, open spring-boot-example.java main class file and run it. If it successfully runs, you see the below console message.

```java
2023-08-27T10:51:14.738+06:00  WARN 6708 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2023-08-27T10:51:15.097+06:00  INFO 6708 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-08-27T10:51:15.104+06:00  INFO 6708 --- [           main] c.j.SpringBootExampleApplication         : Started SpringBootExampleApplication in 4.568 seconds (process running for 5.309)

```

It means, our application runs on port 8080. Open url http://localhost:8080/hello in your favourite web browser and you see the following message

//image 

You now successfully, add thymelaf view in your spring boot application. Let's create a string message and see how thymeleaf can process it.

<b>Step 11:</b> Open your DemoController.java class again and and few more lines.

```java
package com.javaondemand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping(value = "hello")
    public String HelloWorld(Model model){

        String message = "I am going to love thymeleaf!";
        model.addAttribute("msg", message);

        return "hello";
    }
}
```
Here, we use the model attribute in our hello.html file. 

In hello.html file we will add 

```java
  <p th:text="${msg}">text...</p>
```
And then rerun the application and you should see the follwing result in http://localhost:8080/hello url.

//image

Thanks for reading this tutorial. 
We will discuss more about thymeleaf in subsequent chapter. 

Talk Soon,
Shakil Ahmed