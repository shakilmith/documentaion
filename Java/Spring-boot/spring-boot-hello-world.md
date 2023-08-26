## Spring Boot Hello World example

In this tutorial, we will explain how to create a simple spring boot hello world application.

Basic requirements in order to create spring boot hello world application:

    - JavaSE Version: 8+
    - Maven: 3.3.9+
    - An IDE (Eclipse or Intellij ide)
    - Spring Boot: 3.1.2

Note: In this project, I will use intellij idea

Let's follow the following steps: 

Step 1: Open Spring Initializer. Visit here: https://start.spring.io/ for creating spring boot application.

Step 2: It wiill be a Maven based project and we use Java as a language. Spring Boot version should be 3.1.2 or vice versa.

<strong>Step 3:</strong> In the Project Metadata section provide GroupId and ArtifactId name. 
GroupId: com.javaondemand 
ArtifactId: spring-boot-example (at the end Application will be added)

Here, Group name will be the package name and Artifact name will be the name of your project. We use jar as a packaging and java version 17. You can use java 8, 11 too.


Step 4: Now we add dependency. As it is a simple Hello World application we add Spring Web dependency. 

Step 5: Clik on Generate button. It will package your applicaton into a zip file. Then, Extract the spring-boot-example.zip file to any directory. Later we will import it in our IDE.

Step 6: Open your favourite Ide. In my case Intellij Ide. Improt the spring-boot-example application into your ide. 

Intellij: File -> Open -> Select the project foleder -> Ok (finish) It will now open your project in the current window or new window. Remeber your project location you have just downloaded or extracted.

Eclipse: File -> Import -> Existing Maven Project -> Next -> Browse (you have just downloaed and extracted) -> Select the project folder (spring-boot-example) -> Finish 

Note: When you Generate the spring-boot-example project, it is a .zip file. The file name should be spring-boot-example.zip file. You must unzip or extract it to somewhere in order to import it into your ide okay. 


Step 7: After successfully importing the spring boot project, please wait few seconds to resolve the maven dependencies. Then, you see the follwing project directory in your ide. 

//image 

You see, SpringBootExampleApplication.java file in src/main/java . It is our main application file. 


Step 8: create a controller pacakge in the src/main/java/com/javaondemand folder. 

Then, inside controller package create a java class called HelloController.java 

Step 9: Now, open the HelloController.java class and create an method name printHello(){} and it will return a String message. 

See here: 

```js

package com.javaondemand.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    private String printHello(){
        return "Hello World!";
    }
}

```

You see, we annotate the class by @RestController annotaion and in the method level we use @GetMapping annotion. These are spring web related annotaion. We will describe them in upcoming tutorial.

But note, the @GetMapping or @RequestMapping annotaion will tell us where we find our endpoint (URL OR URI)


Step 9: Run the SpringBootExampleApplication.java file. If the application runs successfully, in the console you see the following message.

```console

2023-08-24T15:18:44.049+06:00  WARN 2556 --- [           main] ion$DefaultTemplateResolverConfiguration : Cannot find template location: classpath:/templates/ (please add some templates, check your Thymeleaf configuration, or set spring.thymeleaf.check-template-location=false)
2023-08-24T15:18:44.151+06:00  INFO 2556 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-08-24T15:18:44.160+06:00  INFO 2556 --- [           main] c.j.SpringBootExampleApplication         : Started SpringBootExampleApplication in 4.062 seconds (process running for 4.813)

```

You see, our application runs on port 8080. Yes, it is a default port runs spring boot application and you can always change it from the application.properties file.

Step 10: Open your favourite browser and type: http://localhost:8080/ and see Hello World! String message.

//image

It means, our Hello World! endpoit runs on http://localhost:8080/ port. Can we change the url instead of root url? yes, In the @GetMapping annottion we use our custom url endpoint name. See below

```js
package com.javaondemand.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello-world")
    private String printHello(){
        return "Hello World!";
    }
}

```

Now open, http://localhost:8080/hello-world and you see the previous message. 

Note: Make sure you terminate or hault application and restart again. Otherwise the application will produce error message that, port 8080 is used already or vise versa.


Few More: 

You see we successfully run our simple hello world application.
Let's explore the file structure little bit. 

As it is a maven projct, we have pom.xml file for required dependency management.

Open your pom.xml file and see what dependency you have added.

```js
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<groupId>com.javaondemand</groupId>
	<artifactId>spring-boot-example</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-boot-example</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
	
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```

You see, we have added spring-boot-starter-web dependency for our application. Spring-boot-starter-test has been added automatically. You can add as many as dependencies for your application requirements. When you addd new dependency you see them your classpath. Maven will automatically resolve this dependency.


Also, in the praent section you see, 

```js
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
```

This are spring boot related configuration these are not not your project groupId and artifactId.


Today is enough!

Talk soon,
Shakil Ahmed
