## Sping Boot and Mysql Database

Mysql is an open source relational database management system (RDBMS) and spring boot supprt mysql database fully. 

If you have an existing spring boot application you can add mysql dependency in your classpath. Open your pom.xml file or gradle.build file add the mysql dependency.

## How to add mysql database in your Spring boot application

For Maven User:

```js
  <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
      <scope>runtime</scope>
    </dependency>
```

For Gradle User:

```js
dependencies {
    runtimeonly 'com.mysql:mysql-connector-j'
}
```

Note: The mysql dependency moved from mysql-connector-java to mysql-connector-j. So make sure if you didn't update your sping boot version yet, you probably have to change the mysql artifact.


After adding the mysql, please reload your appplication. In your pom.xml file right click -> Maven -> Reload Project.

```js
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql: true
```
Here, tesdtb our database name. Please open your mysql commandline interface. After login, careate a database named testdb. Note, you don't have to create table or columns externally. All the hardcoded things have been maintained by spring data jpa. 

Okay, if you don't have any spring boot appliaction ready yet, let's together create one. 

Let's follow the belew steps to bootstrap our simple Spring Boot application.

1. Open https://start.spring.io/ and provide necessary information to create spring boot project. The project will be a .zip file and we have to unzip it in a directory to work with it.

Now in this page, Select 
    - Maven as a build tool (you can select gradle too)
    - Java as a language
    - Spring Boot version 3.0.12 (or the latest version)
    - In the Project Metadata section, provide your application group, artifact, package name etc. Note: The group and package name will be same. Also the artifact and name of your project will be same as well (Not mendatory). 
    - Then, select jar for packaging (for simplicity) and select the java language version. The java language version I use is 17. You can choose 8, 11 or the latest LTS version.
    - The last step is adding dependencies. Add the following dependencies in your classpath. 
        - Spring Web
        - Spiring data jpa
        - Mysql driver (You must have mysql installed in your system or in host)
    - After adding the spring web dependency click on Generate button. It will create a simple zip file (the zip file name is your project name)

2. After generating the .zip file now unzip it to any director. 

3. Import the unzip spring-boot-example project into your favourite Ide.

Eclipse: Open your Eclipse (STS) Ide. File > Import > Maven > Existing Maven projects > Next > Browse your sping boot project (Reside our example spring boot project) > Click Finish. Please wait few seconds to complete the whole process and resolving the maven dependencies.

Intellij Ide: Open your Inellij Ide, then File > Open > Browse the existing spring boot project > Clikc Ok. Likewise eclipse, wait few seconds to resolve maven/Gradle dependencies. 

4. Now create an entity class called Person.java in com.company package. As it is a persistent class, we annotate it by @Entity annotation. It contains properties like id, firstName, lastName and age. It is required that we make our id as database primary key. So, annotate the id by @Id annotation.

```js
package com.company.model;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private int age;


    //no-arg constructor
    public Person() {
        super();
    }

    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .toString();
    }
}

```

5. Create PersonRepository interface in com.company.repositroy pacakge. 

We here extends the CrudRepository interface that propvides sophisticated methods to handle crud operations.

```js
package com.company.repository;

import com.company.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    //query methods
}
```

6. Now create PersonPersistent.java class in com.company.persistence package that impelements the CommandLineRunner interface. Override the run method and inside the run method we populate few person data to store person data in mysql database when the application starts.

```js
package com.company.persistence;


import com.company.SpringBootExampleApplication;
import com.company.model.Person;
import com.company.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonPersistent implements CommandLineRunner {

    @Autowired
    public PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        Person p1 = new Person(1, "Allice", "Smith", 55);
        Person p2 = new Person(2, "Bob", "Williams", 40);
        Person p3 = new Person(3, "Frank", "Thomas", 48);
        Person p4 = new Person(4, "Emily", "Davis", 30);
        Person p5 = new Person(5, "Charlie", "Brown", 25);

        //save the person objects
        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(p3);
        personRepository.save(p4);
        personRepository.save(p5);

        /* instead of writing save method for individual person object
        * invoke the saveAll(List.of(p1,p2,p3,p4,p5)); to save
        * all the person objects to database
        * */
    }
}

```

Here we have created five person object to be stored in mysql database. 

7. Let's open your main application file and run the example application. If it successfully runs you see the application runs on port 8080.

8. As we have added few demo person data in our mysql database, so open your mysql command line interface. (Make sure you have mysql minimum 6+ version installed in your system). 

9. Login your mysql commandline using your username and password. Run the follwing command and you see that we have person table with few person demo data.

```js
mysql> use testdb;
Database changed
mysql> select * from person;
mysql> select * from person;
+----+-----+------------+-----------+
| id | age | first_name | last_name |
+----+-----+------------+-----------+
|  1 |  55 | Allice     | Smith     |
|  2 |  40 | Bob        | Williams  |
|  3 |  48 | Frank      | Thomas    |
|  4 |  30 | Emily      | Davis     |
|  5 |  25 | Charlie    | Brown     |
+----+-----+------------+-----------+
5 rows in set (0.00 sec)

mysql>
```

We now successfully, stored few person data to our mysql database. You now can retrieve these data using various spring data jpa methods. In upcoming post I will try to show you how to retireve data from your mysql database using spring data jpa.

