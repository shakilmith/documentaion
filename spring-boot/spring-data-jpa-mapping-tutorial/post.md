In this simple example application, we will describe how to use One-To-One (@OneToOne) mapping in Spring Boot.

If you don't have any Spring Boot application bootstrapped yet, let's create one.

Let's follow the below steps to bootstrap a simple Spring Boot application using spring initializer.

1. Open [https://start.spring.io/](https://start.spring.io/) and provide necessary information to create spring boot project. The project will be a .zip file and we have to unzip it in a directory to work with it.

***Now in this page, Select***
    - Maven as a build tool (you can select gradle as well)
    - Java as a language
    - Spring Boot version 3.0.12 (or the latest version)
    - In the Project Metadata section, provide your application group, artifact, package name etc. Note: The group and package name will be same. Also the artifact and name of your project will be same as well (Not mandatory). 
    - Then, select jar for packaging (for simplicity) and select the java language version. The java language version I use is 17 (LTS). You can choose 8, 11 or the latest LTS version.
    - The last step is to adding dependencies. Add the following starter dependencies:
        - Spring Web (MVC)
        - Spring Data JPA
        - H2/MySQL driver dependency (H2 for embedded database); Select H2 for simplicity 



<PostImage src="https://docs.javaondemand.com/spring-boot/spring-data-jpa-mapping-tutorial/img10.png" alt="spring-boot-img" />




2. After generating the .zip file now unzip it to any directory. 

3. Import the unzip spring-boot-example project into your favourite Ide.

**Eclipse:** File > Import > Maven > Existing Maven projects > Next > Browse your spring boot project (you have just downloaded)> Click Finish. Please wait few seconds to complete the whole process and resolving the maven dependencies.

**Intellij Ide:** File > Open > Browse the existing spring boot project > Click Ok. Likewise eclipse, wait few seconds to resolve maven/Gradle dependencies.

**VS Code:** File > Open Folder > Browse the existing spring boot project > Select Folder.

**NetBeans:** File > Open Project > Browse the existing spring boot project (maven project) > Open project. 


4. The project file structure will be like this.

<PostImage src="https://docs.javaondemand.com/spring-boot/spring-data-jpa-mapping-tutorial/img7.png" alt="spring-boot-img" />


5. Now, Create a model package in **com.company** folder. Inside the model package, create an entity class called **Person** and Relationship entity class called **Car**. Both are annotated by **@Entity** annotation.


**Person.java**

```
package com.company.model;

import jakarta.persistence.*;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person() {
        super();
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
```

About the code above: We have annotated the class above by **@Entity** annotation to make it persistent class. By default it is the table name in your database. The Person class contains id, name as attributes. It also contains, associated class with @OneToOne annotation. There is also @JoinColumn annotation is used to make the person class is the relationship owner. It means, foreign key will be found in the Person table not the Car table. Note that if you don't use the **@JoinColumn(name = "car_id")** then the foreign key table column name would be **(person_car)**. 
 

The associated Car class is:

**Car.java**

```
package com.company.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int car_id;
    private String name;
    private String brand;

    public Car() {
        super();
    }

    public Car(int car_id, String name, String brand) {
        this.car_id = car_id;
        this.name = name;
        this.brand = brand;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" + "car_id=" + car_id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
```

6. Now create PersonRepository.java interface class in com.company.repository package. (You may have to create the repository package first of all). Here, we extends JpaRepository. You may also extends CrudRepository as well. Then, provide the domain an it's type.


**PersonRepository.java**:

```
package com.company.repository;

import com.company.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);
}
```


**Note:** Skip **findByName(String name)** query method for the time being. It is a custom query method to find the entity records by name.



6. Create a **PersonController.java** class in com.company.controller package. 



**PersonController.java**

```
package com.company.controller;


import com.company.repository.EmployeeRepository;
import com.company.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    //get all the employees

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public int saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee).getId();
    }

    //find by id
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeRepository.findById(id).get();
    }

    @GetMapping("/employees/name/{firstName}")
    public List<Employee> getByFirstName(@PathVariable String firstName){
        return employeeRepository.findByFirstName(firstName);
    }

    @GetMapping("/employees/role/{role}")
    public List<Employee> getEmployeeByRole(@PathVariable String role){
        return employeeRepository.findByRole(role);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        employeeRepository.deleteById(id);
    }
}
```


The most common rest annotations (http verbs) have been used here like **@GetMapping**, **@PostMapping**, **@DeleteMapping** etc. We focus on **@GetMapping** and **@PostMapping** only.


**@GetMapping("/persons"):** Get all the person records

**@GetMapping("/persons/{id}):** Get a person record by id

**@PostMapping("persons"):** Save or persist a new person record in this endpoint

**@DeleteMapping("/persons/{id}):** Delete a single person by id

Additionally, we have annotated the PersonController class by **@RestController** annotation to make it behave like web application and get accessible of all the rest endpoints.


7. Now, open the main class file and run the example application or type ***Shift+F10***.

If you run the application, by default your application listens port 8080 in localhost. 


8. Add database configurations in **application.properties** file. It is located in resources folder. 

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#enabling the H2 console
spring.h2.console.enabled=true
```

***spring.h2.console.enabled=true*** #enable h2 embedded database to access from your web browser.


9. After running the application successfully, Open Postman or use Curl to post some demo data.


**If Postman:** 

In this step we will use Postman, a popular rest client or rest api management software. If postMan is already installed in your system -
    - Open it (if Postman is already installed)
    - Invoke the url: http://localhost:8080/persons
    - Select Body and row then JSON as content-type
    - Insert the below demo data (one by one)
    - At last, click on send button 


```
{
    "name": "Bob Smith",
    "car": {
        "name": "A",
        "brand": "X"
    }
}
```

Add two more person records. (Click on Send button for each person record)

```js
{
    "name": "Jekov Jenkov",
    "car": {
        "name": "B",
        "brand": "Y"
    }
}

{
    "name": "Shakil Ahmed",
    "car": {
        "name": "C",
        "brand": "Z"
    }
}
```

10. Invoke the url: [http://localhost:8080/persons](http://localhost:8080/persons) in your favourite web browser. You get a list of three person records in json format.

```js
[{"id":1,"name":"Bob Smith","car":{"car_id":1,"name":"A","brand":"X"}},{"id":2,"name":"Jekov Jenkov","car":{"car_id":2,"name":"B","brand":"Y"}},{"id":3,"name":"Shakil Ahmed","car":{"car_id":3,"name":"C","brand":"Z"}}]
```

11. Now invoke the url: [http://localhost:8080/h2-console](http://localhost:8080/h2-console) from your web browser. Then, You will come to a new window. Click connect. 

<PostImage src="https://docs.javaondemand.com/spring-boot/spring-data-jpa-mapping-tutorial/img9.png" alt="spring-boot-img" />



In H2 workbench you see, there will be 2 tables - Person and Car. Click on person or type this sql command: **SELECT * FROM PERSON** -> Click Run. The response will be tabular data. 

<PostImage src="https://docs.javaondemand.com/spring-boot/spring-data-jpa-mapping-tutorial/img1.png" alt="spring-boot-img" />


Again click on Car table or type this sql command in the command section: **SELECT * FROM CAR;** 

It will now show the following table with car info only.

<PostImage src="https://docs.javaondemand.com/spring-boot/spring-data-jpa-mapping-tutorial/img2.png" alt="spring-boot-img" />


Here, the Person table has id, name columns including a foreign key - car_id - that is the primary key or id of the Car table. (Remember we have used **@JoinColumn(name="car_id")**) in the Person entity class. What if we didn't use the external **@JoinColumn annotation?** Yet, there will be a foreign key column in the person table but then, the column name will be: **person_car** (entity names separated by underscore)


Hope, this post will be very helpful overall. 
