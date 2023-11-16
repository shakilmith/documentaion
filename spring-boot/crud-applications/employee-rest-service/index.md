## Developing a Simple Employee Rest Service using Sping Boot.

In this simple tutorial, we are going to create a simple Employee Rest API or Employee Crun Application. But instead of using Spring data jpa CrudRepository interface, we will use ListCrudRepository interface. The coccept is almost same. 


ListCrudRepository VS CrudRepository: 

ListCrudRepository is built upon of CrudRepository. But, CrudRepostiory returns Iterable and ListCrudRepostiory returns List. 

Know more here: https://spring.io/blog/2022/02/22/announcing-listcrudrepository-friends-for-spring-data-3.0

Or, Look at the official spring data jpa doc site: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

----

Let's dive into the project.

Note: We skip the project creation steps.

1. Open your Sping Boot Application to your favourite ide. In my case, I use Intellij ide.

2. Create model package in com.company pacakage. Now in the model pacakge create Employee.java file. It contains id, firstName, lastName and role properties. All the properties are valid column name in your database. 

3. Annotate the Employee.java class by @Entity annotaion. And the id by @Id annotaion. The are also no-argument constructor, get/set methods methods.

```js
package com.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;

    private String role;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

```

4. Now, create a repository interface in com.company.repository package. We here extends ListCrudRepository instead of CrudRepository. It provides built in feature to develop a simple crud application.

```js
package com.company;

import com.company.model.Employee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee, Integer> {
    //custom query methods

    //find employee by firstName
    List<Employee> findByFirstName(String firstName);

    //find List of Employees by their role
    List<Employee> findByRole(String role);
}

```

Note: We have here declared addition 2 query methods. 

Declaring Custom Query methods in spring data jpa: 

5. Create a controller class in com.company.controller pacakge. Anntotate this class by @ResstController annotaion. We have use here all the Spring MVC Curd Operation mehods.

```js
package com.company.controller;

import com.company.model.Employee;
import com.company.repository.EmployeeRepository;
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
    public Employee findById(@PathVariable int id){
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
}

```

Code Explanation: 


6. Open your application.properties file. And add the following database (h2, mysql etc.) configuration. The application.properties file is located in resources folder.

```js
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#enabling the H2 console
spring.h2.console.enabled=true
```

7. Run the application. Our example application runs on port 8080 in localhost. If you want to change your application port, just add this line in your application.properties file: ***server.port= 9090***

8. If the application, runs successfully, please open your favourite web browser and invoke the url: http://localhost:8080/employees
and you see and empty array. 

9. Open Postman and add few Employee data. 

In this step we will use Postman, a popular rest client to work with rest APIs. If, in your system postman is already installed do the follwoing 
    - Open it (if Postman is already installed)
    - Invoke the url: http://localhost:8080/employee
    - Select Body and row then JSON as content-type
    - Insert the below demo data (one by one)
    - At last, click on send button 

Now, add some demo Employee data. Please Post each Employee details at a time.

```json

//First Employee
{
    "firstName": "Lino",
    "lastName": "Bozonich",
    "role": "Java Developer"
}

//add few more employees
{
    "firstName": "Tamina",
    "lastName": "Nuncher",
    "role": "Python Developer"
}

{
    "firstName": "John",
    "lastName": "Doe",
    "role": "React Developer"
}

{
    "firstName": "Mark",
    "lastName": "Smith",
    "role": "Rust Developer"
}

{
    "firstName": "David",
    "lastName": "Morison",
    "role": "Java Developer"
}

{
    "firstName": "Kevin",
    "lastName": "Ryan",
    "role": "React Developer"
}

{
    "firstName": "Shakil",
    "lastName": "Ahmed",
    "role": "Java Developer"
}

{
    "firstName": "Abdul",
    "lastName": "Hamid",
    "role": "Python Developer"
}
```

10. Now again invoke the url: http://localhost:8080/employees and we will see list of employee data in json format.


11. Let's access the first employee details using id. Invoke the url: http://localhost:8080/employees/1 You will get hte first employee details.

12. Let's retrieve an employee details by first name. Now invoke the URL http://localhost:8080/employees/name/Shakil 

It will retrive employee details whose id is 7.

13. Now, retrieve employee details using perticular role. Like I want to retrive employee details who are a java developer. (It will retrieve List of employee details who are java developer.)

Now, again invoket the url: "http://localhost:8080/employees/role/Java Develper" you see all the employees who are java developer. 

14. Like the above, you can simply delete an particular employee using it's id.

Just open Postman. Use HTTP verbs DELETE with this url: http://localhost:8080/employees/1 and click on Send button. The first employee will be deleted. 


***Attention:*** It is very important, all of your @RequestMapping path or URI PATH should be unique. Like @GetMapping("/employees/{id}) @GetMapping("/employees/{name}) will produce runtime exception like ambiguous path variable detected or else. So, better to use like this: @GetMapping("/employees/name/{name}) 


Thanks for reading this aritcle.<br/>
Talk Soon.


Note: This is an ongoing project.
