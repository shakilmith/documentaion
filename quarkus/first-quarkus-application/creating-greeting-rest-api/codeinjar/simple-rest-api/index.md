## Creating A Simple JSON REST Service


In this tutorial post, we are going to explore how to create a simple greeting rest api using Quarkus **quarkus-rest-jackson** extension.

**quarkus-rest-jackson:** When a JSON extension is installed such as quarkus-rest-jackson or quarkus-rest-jsonb, Quarkus will use the **application/json** media type by default for most return values, unless the media type is explicitly set via **@Produces** or **@Consumes** annotations (there are some exceptions for well known types, such as String and File, which default to **text/plain** and **application/octet-stream** respectively).


**Initial Requirements:**
    - JavaSE version: 8+
    - Maven or Gradle as a build tool or using CLI (see the official doc)
    - Maven version: 3.6.3+
    - Gradle version: 7.5+
    - And IDE that support Java and maven/gradle: Like Intellij Ide, Eclipse or VS code.


Please follow the below steps to develop a simple Greeting rest service:

**Note:** We use here [https://code.quarkus.io](https://code.quarkus.io)  official initializer site to bootstrap our Quarkus application and use intelliJ IDE to develop it. You can also use VS Code or Eclipse as well.


## Bootstrap Quarkus Application

For bootstrapping our Quarkus application, we will use quarkus initializer. So, visit [https://code.quarkus.io/](https://code.quarkus.io/) using your favourite web browser and a new page will be appeared. Using this page, you can bootstrap your Quarkus application by adding required dependencies or extensions.

![alt text](/img3.png)


Here I have added **quarkus-rest-jackson** (support json) extension in order to complete this simple tutorial. Later, always you can add new extensions if required.

After adding required extensions, click on generate button, and it will now create a zip file for you. Unzip it and open it in your favourite ide.

**How to open your Quarkus Application into your favourite IDE**

**IntelliJ:** File -> Open -> Select the project folder -> Ok (finish) It will now open your project in the current window or new window. Remember your project location you have just downloaded or extracted.

**Eclipse:** File -> Import -> Existing Maven Project -> Next -> Browse (you have just download and extracted) -> Select the project folder (spring-boot-example) -> Finish

**VS Code:** File > Open Folder > Browse the existing spring boot project > Select Folder.

**NetBeans:** File > Open Project > Browse the existing spring boot project (maven project) > Open project.

**Note:** After opening your project into your favourite IDE (in my case IntelliJ IDE) wait few seconds in order to resolve the maven dependencies. As Quarkus doesn't have main class file, thus you get compile time error - **ClassNotFoundException** while running your application for the first time. So, you have to install quarkus tools plugin if you use intelliJ Ide. **How to install Quarkus Tools plugin?** - File -> Settings -> Plugins -> Search Quarkus Tools (from the marketplace) -> Click on Quarkus Tools -> Click Apply -> As usual wait few seconds till completing the download (probably you have to restart your IDE)

![alt text](img2.png)

Let's get into the project now. 

After opening your project into your favourite ide, your project structure probably like the following -

![alt text](/img1.jpg)

You can either keep them or delete them, your choice.

## Creating A Simple Pojo Class

Now create a simple **Greeting.java** class in **com.company** folder. The Greeting.java class contains id and message properties.

**Greeting.java**

```
package com.company;

public class Greeting {
    private int id;
    private String message;

    public Greeting() {
    }

    public Greeting(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
```

## Define A Resource Class

Now, create a **GreetingResource.java** class in the same package. Here we user **jax-rs** **@GET** mapping to generate json greeting service.


**GreetingResource.java**

```js
package com.company;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @Path("/greetings")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting createGreetings(){
        return new Greeting(1, "Hello Java!");
    }
}
```

## Test The Application

In this step run your application and it will listen ports 8080 in localhost. If you now invoke the uri [http://localhost:8080/greetings](http://localhost:8080/greetings) in localhost, you will see a simple greeting response in json format.


![alt text](/img2.png)


## Get List of JSON Greeting Response

In order to getting list of json response, we have to update the method return type and add list of greeting objects in the **GreetingResource.java** class.


**GreetingResource.java**

```
package com.company;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
public class GreetingResource {

    @Path("/greetings")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Greeting> createGreetings(){
        return List.of(
                new Greeting(1, "Hello Java!"),
                new Greeting(2, "Hello PHP!"),
                new Greeting(3, "Hello Python!"),
                new Greeting(4, "Hello C++!")
        );
    }
}

```

If you stop and again run the application, the json response should be in this url: [http://localhost:8080/greetings](http://localhost:8080/greetings)

```
[
  {
    "id": 1,
    "message": "Hello Java!"
  },
  {
    "id": 2,
    "message": "Hello PHP!"
  },
  {
    "id": 3,
    "message": "Hello Python!"
  },
  {
    "id": 4,
    "message": "Hello C++!"
  }
]
```

Hence, we have successfully developed a simple Greeting json service that handles jax-rs **@GET** request.


-----

I want to recall one more thing here that, the basic **jax-rs** CRUD annotations are: ***@GET***, ***@Post***, ***@PUT***, ***@DELETE***, ***@PATCH*** equivalent to ***@GetMapping***, ***@PostMapping***, ***@PutMapping***, ***@DeleteMapping***, ***@PatchMapping*** used in Spring Boot. If you ar the fan of Spring/Spring Boot you may familiar of those as well.

Talk Soon.

