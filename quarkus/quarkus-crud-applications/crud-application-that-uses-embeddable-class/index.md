## Develop a Simple Employee Rest Service using Hibernate ORM with Panache

In this tutorial post, we are going to build a simple employee rest api using Hibernate Orm with Panache. If you already have Quarkus application bootstrapped, just add the hibernate-orm-panache, jdbc-mysql and rest-jackson dependency in your classpath.


```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-hibernate-orm-panache</artifactId>
</dependency>
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-jdbc-mysql</artifactId>
</dependency>
 <dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-rest-jackson</artifactId>
</dependency>
```

**Note:** Skip step 1 to 5 if you know how to create Quarkus application.

<a href="#step6">Dive to Step 6</a>

Initial Requirements:
    - JavaSE version: 8+
    - Maven or Gradle as a build tool or using CLI
    - Maven version: 3.6.3+
    - Gradle version: 7.5+
    - An IDE that support Java and maven/gradle: Like Intellij Ide, Eclipse or VS code.

Please follow the below steps to bootstrap your Quarkus application.

**Note:** We use here https://code.quarkus.io  official site to bootstrap our quarkus application and use intellij ide to develop it. You can also use VS Code or eclipse as well.

1. Open [https://code.quarkus.io](https://code.quarkus.io) to bootstrap your quarkus application. Provide the following metadata:

    - Group: com.company (or the default one)
    - Artifact: quarkus-example (or the default one)
    - Quarkus Platform Version: latest one or the recommended one
    Build tool: Maven or Gradle

2. After adding required metadata, now it is time to add extensions/dependencies. Add the following extensions:
    
    - RestEasy Reactive Jackson (now rest-jackson)
    - Hibernate Orm with Panache
    - Mysql JDBC driver

3. Click on Generate button. It will produce a zip file and the file name should be your Artifact name.

4. Unzip it and import it or open it in your favourite Ide like intellij ide. 

Note: If you use intellij ide and want to run quarkus application from your ide, then you have to install Quarkus Tools for Intellij plugin from the marketplace.

Quarkus Tools for IntelliJ: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your ide

Quarkus Tools for Eclipse: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your Ide

Quarkus Tools for VS Code: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your ide 

5. After importing or opening the quarkus example application into your ide, the file structure should be like below: 

<img src="/images/quarkus/img1.jpg" alt="Quarkus file structure" width="50%" height="auto"/>



### How to import External Maven/Gradle project into your ide: 

    - Eclipse: Open your Eclipse (STS) Ide. File > Import -> Maven -> Existing Maven projects -> Next -> Browse your Maven/Gradle project(Reside our quarkus-example application) -> Click Finish. Please wait few seconds to complete the whole process and resolving the maven dependencies.

    - Intellij Ide: Open your IntelliJ Ide, then File -> Open -> Browse the existing Maven/Gradle project -> Click Ok. Likewise eclipse, wait few seconds to resolve Maven/Gradle dependencies. 


<span id="step6" />

6. Create a package called entity in com.company directory. Now, in com.company.entity package create an entity class **Employee.java** and annotate it by **@Entity** annotation. Here the **Employee.java** class contains firstName, lastName, age and an Embedded class Address (resides in **Address.java**) as properties. All are valid column name in your relational database. Make sure, you have annotated the Address.java class by @Embeddable annotation. 


**Employee.java**

```
package com.company.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Employee extends PanacheEntity {

    public String firstName;
    public String lastName;
    public LocalDate joiningDate;

    public Address address;

    /**
     * getter and setter methods are omitted as they will be
     * handled by PanacheEntity, even id will be generated programmatically
     * if you want to create id externally please extends PanacheEntityBase instead of
     * PanacheEntity
     */
}
```

As usual, we use reactive pattern here (alternative of repository pattern), thus we have extends PanacheEntity. There is no need to create getter/setter as well as no-arg constructor. Also, the id creation process will be handled by PanacheEntity. But, if you want to manually create your id, not by the application please use PanacheEntityBase.

7. Create **Address.java** embeddable class in **com.company.entity** package. It will be used in Employee table but it is not entity itself.


**Address.java**

```
package com.company.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    public String country;
    public String state;

    public Address() {
        super();
    }

    public Address(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
```

8. Create **EmployeeService.java** class in **com.company.service** package. 


```
package com.company.services;

import com.company.entity.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class EmployeeService {

    //using @GET for getting all the students
    @GET
    public List<Employee> getAll(){
        return Employee.listAll();
    }

    //using @POST for creating new Student record
    @POST
    @Transactional
    public Response saveStudent(Employee employee){
        if(employee.id !=null){
            throw new WebApplicationException("Id was set invalidly on request", 404);
        }
        employee.persist();
        return Response.ok().entity(employee).build();
    }

    //using @GET while fetching individual student by id
    @GET
    @Path("/{id}")
    public Employee getOne(@PathParam("id") int id){
        return Employee.findById(id);
    }

    //using @PUT while updating individual student details
    @PUT
    @Path("/{id}")
    @Transactional
    public Employee updateStudent(int id, Employee employee){
        if(employee.firstName == null){
            throw new NotFoundException();
        }
        //also we can chain multiple if conditions (for simplicity I omit them)

        Employee entity = Employee.findById(id);
        if ( entity.id == null) {
            throw new WebApplicationException("Student with id of " + id + "doesn't not exist", 404);
        }
        //allow to change firstName and lastName
        entity.firstName = employee.firstName;
        entity.lastName = employee.lastName;
        return entity;
    }



    //using @Delete mapping for deleting existing Employee record
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteEmployee(int id){
        Employee employee = Employee.findById(id);
        if(employee == null){
            throw new WebApplicationException("The employee of id "+ id +"doesn't exist", 404);
        }
        employee.delete();
        return Response.status(204).build();
    }
}
```

We used here jax-rs **@GET** (for getting list of employee records), **@POST** (creating new employee resource), **@PUT** (for updating an existing resource) **@Delete** (for deleting and existing employee records) etc. 


**Note:** Root level **@Path("/")** is required. For simplicity we have used @Produces(MediaType.APPLICATION_JSON), @Consumes(MediaType.APPLICATION_JSON) annotation at class level than method level. For @POST @PUT AND @DELETE we have also used @Transactional annotation that will be responsible for changing the database. Use it carefully in production environment. 

Now it is time to run the application and test it.

Before executing the application we have do one more thing.

9. Add database (Mysql) configuration in **application.properties** file located in resources folder.

```
# datasource configuration
quarkus.datasource.db-kind = mysql
quarkus.datasource.username = root #usernmae
quarkus.datasource.password = root #password
quarkus.datasource.jdbc.url = jdbc:mysql://localhost:3306/qtestdb #5432 if postgresql

# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation= drop-and-create
```


But if you use postgreSQL use the below configuration instead.

```
# datasource configuration
quarkus.datasource.db-kind = postgresql
quarkus.datasource.username = hibernate
quarkus.datasource.password = hibernate
quarkus.datasource.jdbc.url = jdbc:postgresql://localhost:5432/hibernate_testdb

# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation=drop-and-create
```


***Attention: You must create database named qtestdb or hibenate_testdb but no need to create table externally.***

10. Run the quarkus example application now. The application will run on port 8080 in localhost.

After successfully run the appellation, please invoke the url: [http://localhost:8080/employees](http://localhost:8080/employees) in your favourite web browser. You will see an empty array.


11. Now open Postman (a popular rest client) and add few Employee records, one at a time. 

```
{
    "id": 1,
    "firstName": "Mark",
    "lastName": "Smith",
    "joiningDate": "2010-12-03",
    "address": { 
        "country": "UK", "state": "London" 
        }
}
```
![Alt text](/images/quarkus/img8.jpg)

Like the above I have added 7 more Employee details. We have send Employee records via json format. (One at a time) 

```js
{
    "id": 2,
    "firstName": "Lino",
    "lastName": "Bozonich",
    "joiningDate": "2011-02-17",
    "address": { "country": "UK", "state": "Westminister" }
  },
  {
    "id": 3,
    "firstName": "Tamina",
    "lastName": "Nuncher",
    "joiningDate": "2011-07-05",
    "address": { "country": "UK", "state": "Brimingham" }
  },
  {
    "id": 4,
    "firstName": "John",
    "lastName": "Doe",
    "joiningDate": "2011-05-10",
    "address": { "country": "UK", "state": "London" }
  },
  {
    "id": 5,
    "firstName": "David",
    "lastName": "Morison",
    "joiningDate": "2008-12-10",
    "address": { "country": "USA", "state": "California" }
  },
  {
    "id": 6,
    "firstName": "Kevin",
    "lastName": "Ryan",
    "joiningDate": "2018-03-05",
    "address": { "country": "USA", "state": "Texas" }
  },
  {
    "id": 7,
    "firstName": "Kate",
    "lastName": "Hale",
    "joiningDate": "2019-02-01",
    "address": { "country": "USA", "state": "Florida" }
  },
  {
    "id": 8,
    "firstName": "Powel",
    "lastName": "Smith",
    "joiningDate": "2012-09-12",
    "address": { "country": "USA", "state": "Florida" }
  }
```

**Note:** We can only Post one employee record at a time. (Whatever logic we have implemented in **@POST** mapping inside the application)


12. After adding few Employee details, please now again open the url: [http://localhost:8080/employees](http://localhost:8080/employees) and you see list of employees. All are valid json format.

![quarkus atl](/images/quarkus/img9.jpg)


13. Retrieve Single Employee Records

It is possible to get individual employee records using their id. Like, if we want to get the first Employee details, we just invoke the url in our browser: [http://localhost:8080/employees/1](http://localhost:8080/employees/1). Also we can add custom finder in our Entity class to retrieve employee details in certain form, such as - based on first_name, last_name, city, country or email_address.

![quarkus](/images/quarkus/img10.jpg)

14. How to delete a particular employee details:

Open Postman again, and use the delete Http verb like invoking any particular employee which we want to delete. Guess, we have 10 employees in our database employees table. And we want to delete or remove the 7 number employee. Then invoke the url [http://localhost:8080/employees/1](http://localhost:8080/employees/7) with the DELETE http verb. The employee records will be deleted instantly.



