## Spring Data JPA Many-To-Many mapping tutorial

In this simple example tutorial, we will demonstrate how to use Many-To-Many mapping in spring boot. Either, we will create a simple Rest api with Spring Data JPA mapping associations.


**Note: For database persistence, we will use Spring data jpa and H2 database.**

When to use **@ManyToMany** mapping? - When more than one entity is associated with multiple other entities. In database terminology, we say more than one table is linked with more than one table or multiples tables are linked with multiple tables.

Like, Several owners have several cars and several cars have several owners.

Also we can say, 2 books has been written by 5 authors or 5 authors have been written 2 books. 


To understand the scenario clearly, we will go under a live project.

If you don't have any Spring Boot application bootstrapped yet, let's create one.

Let's follow the below steps to bootstrap our simple Spring Boot application.

1. Open [https://start.spring.io](https://start.spring.io/) and provide necessary information to create spring boot project. The project will be a .zip file and we have to unzip it in a directory to work with it.

Now in this page, Select 
    - Maven as a build tool (you can select gradle too)
    - Java as a language
    - Spring Boot version 3.0.12 (or the latest version)
    - In the Project Metadata section, provide your application group, artifact, package name etc. Note: The group and package name will be same. Also the artifact and name of your project will be same as well (Not mandatory). 
    - Then, select jar for packaging (for simplicity) and select the java language version. The java language version I use is 17. You can choose 8, 11 or the latest LTS version.
    - The last step is adding dependencies. Add the following starter dependencies:
        - ***Spring Web (MVC)***
        - ***Spring Data JPA***
        - ***H2/MySQL database driver** (H2 for emebedded database); Select H2 for simplicity 


2. After generating the .zip file now unzip it to any director. 

3. Import the unzip **spring-boot-example** project into your favourite Ide.

**Eclipse:** Open your Eclipse (STS) Ide. File > Import > Maven > Existing Maven projects > Next > Browse your spring boot project (Reside our example spring boot project) > Click Finish. Please wait few seconds to complete the whole process and resolving the maven dependencies.

**Intellij Ide:** Open your Intellij Ide, then File > Open > Browse the existing spring boot project > Click Ok. Likewise eclipse, wait few seconds to resolve maven/Gradle dependencies. 

4. The project Project Structure will be like this.

<img 
src="https://trash.codeinjar.com/static/backend/spring-boot/images/img-1.png" 
alt="Spring Boot Project Structure"
width="50%"
height="auto"
/>

5. Now, Create a model package in **com.company** folder. Inside the model package, create an entity class called Person and Relationship entity class called Car. Both are annotated by **@Entity** annotation. Here, the Person class is the relationship owner. Thus, we have used **@JoinTable** annotation in it. 

    ***Also note that, you can use @ManyToMany association unidirectional (one side) or bidirectional (both side). There will be required an extra table that will store the ids of the linked or associated entities. Thus we have used @JoinTable to generate an extra table named person_car. Also note that, there is no need to use CascadeType.REMOVE operation, thus we have removed it. (Because it might remove/delete more associative entities than expected.)***


```js
package com.company.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "person_car",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> cars;
    

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
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
                ", cars=" + cars +
                '}';
    }
    
}

```

About the code above: We have annotated the class above by **@Entity** annotation to make it persistent class. By default it is the table name in your database. The Person class contains id, name as attributes. It also contains, associated class with **@ManyToMany** annotation. There is also **@JoinTable** annotation to generate an extra table just store ids of the linked entities. Also **@JoinTable** annotation indicates that Person is the relationship owner. It means, foreign key will be found in the Person table not the Car table. 

Attention: Extra table is required to store the ids of the association. Here the name is the table name. The first **@JoinColumn(name = "person_id")** is the owner entity id and the second **@JoinColumn(name = "person_id")** is the child class id.


The Associative Car.java class: 

```js
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

Note: Inside the Car class, we don't refer the Person class as it is unidirectional association. If you want to make it bidirectional association, just add the following code in including get/set methods in the Car.java class.

```js
@ManyToMany(mappedBy = "cars")s
private List<Person> persons;

public List<Person> getPersons() {
        return persons;
}

public void setPersons(List<Person> persons) {
        this.persons = persons;
}
```

Note: Here the mappedBy attribute also indicate that Person.java class is the relationship owner. Relationship owner refers that it contains the primary key of the associative/child class as foreign key.


6. Now create **PersonRepository.java** interface class in **com.company.repository** package. (You may have to create the repository package first of all). Here, we extends **JpaRepository**. You may also extends **CrudRepository** as well. Then, provided the domain an it's type.

**PersonRepository.java** class:

```js
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

Note: Skip **findByName(String name)** query method for the time being. It is a custom query method to find the entity records by name.

6. Create a **PersonController.java** class in **com.company.controller** pacakage. 

**PersonController.java** class:

```js
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

The most common rest annotation (http verbs) have been used here like @GetMapping, **@PostMapping**, **@DeleteMapping** etc. We focus on **@GetMapping** and **@PostMappig** only.

***@GetMapping("/persons"):*** Get all the person records

***@GetMapping("/persons/{id}):*** Get person record by id

***@PostMapping("persons"):*** save or persist new person record in this endpoint

***@DeleteMapping("/persons/{id}):*** Delete persons record by id

Additonally, we have annotated the PersonController class by **@RestController** annotation to make it behave like web application and get accessible of all the rest endpoints.

7. Now, open the main class file and run the example application or type Shift+F10.

Note: The application listens port 8080 in localhost.


8. Add database configuration in ***application.properties*** file. It is located in resources folder. 

```js
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#enabling the H2 console
spring.h2.console.enabled=true
```
***spring.h2.console.enabled=true*** enable h2 embedded database to access from your web browser.

9. After run the application successfully, Open Postman or use Curl to post some fake data.

If Postman: 

In this step we will use Postman, a popular rest client to work with rest APIs. If, in your system postman is already installed do the following 
    - Open it (if Postman is already installed)
    - Invoke the url: ***[http://localhost:8080/persons](http://localhost:8080/persons)***
    - Select Body and row then JSON as content-type
    - Insert the below demo data (one by one)
    - At last, click on send button 

Imagine, we have three person records in the persons table and all are owned **Car A, B and C**. Means list of cars.

```js
//First perosn
{
       "id": 1,
        "name": "Shakil Ahmed",
        "cars":[
            {
            "car_id": 1,
            "name": "A",
            "brand": "X"
        },
        {
            "car_id": 2,
            "name": "B",
            "brand": "Y"
        },
        {
            "car_id": 3,
            "name": "C",
            "brand": "Z"
        }
    ]
}

//second person
{
       "id": 2,
        "name": "Bob Smith",
        "cars":[
            {
            "car_id": 1,
            "name": "A",
            "brand": "X"
        },
        {
            "car_id": 2,
            "name": "B",
            "brand": "Y"
        },
        {
            "car_id": 3,
            "name": "C",
            "brand": "Z"
        }
    ]
}

//third person
{
       "id": 3,
        "name": "Jekov Jenkov",
        "cars":[
            {
            "car_id": 1,
            "name": "A",
            "brand": "X"
        },
        {
            "car_id": 2,
            "name": "B",
            "brand": "Y"
        },
        {
            "car_id": 3,
            "name": "C",
            "brand": "Z"
        }
    ]
}

//If you don't use id, then id will be generated automatically.
//but if you use id, then, you must use the id (primary key) in the parent entity+child entity too.
//otherwise the the transaction will not be held.
```

10. Invoke the url: [http//localhost:8080/persons](http//localhost:8080/persons) in your favourite web browser. You will see all the persons records in json format.

```js
[{"id":1,"name":"Shakil Ahmed","cars":[{"car_id":1,"name":"A","brand":"X"},{"car_id":2,"name":"B","brand":"Y"},{"car_id":3,"name":"C","brand":"Z"}]},{"id":2,"name":"Bob Smith","cars":[{"car_id":1,"name":"A","brand":"X"},{"car_id":2,"name":"B","brand":"Y"},{"car_id":3,"name":"C","brand":"Z"}]},{"id":3,"name":"Jekov Jenkov","cars":[{"car_id":1,"name":"A","brand":"X"},{"car_id":2,"name":"B","brand":"Y"},{"car_id":3,"name":"C","brand":"Z"}]}]
```

<img 
src="https://trash.codeinjar.com/static/backend/spring-boot/images/img-36.png" 
alt="Spring Boot"
width="75%"
height="auto"
/>


Also, if you call the @GET request in Postman, the response will be pretty straightforward json format.

```js
[
    {
        "id": 1,
        "name": "Shakil Ahmed",
        "cars": [
            {
                "car_id": 1,
                "name": "A",
                "brand": "X"
            },
            {
                "car_id": 2,
                "name": "B",
                "brand": "Y"
            },
            {
                "car_id": 3,
                "name": "C",
                "brand": "Z"
            }
        ]
    },
    {
        "id": 2,
        "name": "Bob Smith",
        "cars": [
            {
                "car_id": 1,
                "name": "A",
                "brand": "X"
            },
            {
                "car_id": 2,
                "name": "B",
                "brand": "Y"
            },
            {
                "car_id": 3,
                "name": "C",
                "brand": "Z"
            }
        ]
    },
    {
        "id": 3,
        "name": "Jekov Jenkov",
        "cars": [
            {
                "car_id": 1,
                "name": "A",
                "brand": "X"
            },
            {
                "car_id": 2,
                "name": "B",
                "brand": "Y"
            },
            {
                "car_id": 3,
                "name": "C",
                "brand": "Z"
            }
        ]
    }
]
```

12. Let's again check the same response in H2 console. Invoke the url: [http://localhost:8080/h2-console](http://localhost:8080/h2-console) clikc enter -> Connect. Now run this command: **SELECT * FROM PERSON;** in the command section.

Now the person table would be like this:

<img 
src="https://trash.codeinjar.com/static/backend/spring-boot/images/img-39.png" 
alt="Spring Boot"
width="75%"
height="auto"
/>

If you noticed already that, there is no extra column in the person table like foreign key column. If you look at the left side of the H2 console window you can an extra table called person_car that stores the id's of both tables. (Whic cars belongs to which person)

**But if you run this command: SELECT * FROM CAR;**

<img 
src="https://trash.codeinjar.com/static/backend/spring-boot/images/img-37.png" 
alt="Spring Boot"
width="75%"
height="auto"
/>

You can see in the car table there are total three columns like car_id, name and brand. 

As we know in **@ManyToMany** mappings, an extra table is required to store the reference ids like primary key and foreign of the objects or the linked entities. Thus, the extra table name is here **person_car.** (Look at the **@JoinTables** annotation in the Person class.)

Run this command:  **SELECT * FROM PERSON_CAR;**

You get primary keys or ids of person and car table.

There will be two columns: car_id and person_id.

<img 
src="https://trash.codeinjar.com/static/backend/spring-boot/images/img-38.png" 
alt="Spring Boot"
width="75%"
height="auto"
/>




Thanks for reading tutorial. Hope this article will be very helpful.

Talk Soon,<br/>
Shakil Ahmed.