
# JPA - Insert or Save an Entity


Attention: Before walk further, make sure you have maven project and in your pom.xml file you have already installed the jpa maven dependency and hibernate core for jpa implementation.

Let's follow the below few steps to insert an entity in our relational database.

## Create an Entity

Create an entity class called <b>Person.java<b> in your **com.company.model** package. 
The person entity class contains the following properties: id, firstName, lastName, age, role. 

First of all, you must annotate your Person.java class by @Entity annotation and we have to make the id as primary key of our database. So, annotate the id attribute by @Id annotation.

Note: Any java class will be the persistent class (database table in other words) when we annotate it @Entity annotation. Optionally, we can use the @Table annotation to name the table.

**Person.java**

```
package com.company.model;

import jakarta.persistence.*;

@Entity(name = "Person")
@Table(name = "person")
public class Person {
    @Id
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "role")
    private String role;

    //constructors, getter and setter methods
}
```

Note: In jpa convention no-argument constructor is required.

## Map the Database Configuration

To provide the database configuration and map the Person.java class, please open persistence.xml file which is located in src/main/resources/META-INF folder. If you don't already have this xml file in this location, please create META-INF folder in the src/main/resources/ folder and create the persistence.xml file. Now, the persistence.xml file will look like

**persistence.xml**

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">

    <persistence-unit name ="default">

        <!--Register the Person class-->
        <class>com.company.model.Person</class>

        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/testdb"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="root"/>
            <property name="hibernate.hbm2ddl.auto" value="create"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

Here, in the persistence.xml file we provide our database information (in my case mysql database system info) and hibernate specific mapping information.


Note: In jakarta.persistence.jdbc.url property, we use jdbc:mysql://localhost:3306/testdb as value. Here, testdb is our database name in mysql workbench. At least, you have to create a database in your RDBMS system like mysql database and provide the database name here.

But, you don't have to create table name externally. JPA will handle this and your entity class name actually will be the table name.

## Create a Persistence Class 

Let's create a persistence class called **PersonPersistent.java** to save the person objects data into the database.


**PersonPersistent.java**

```
package com.company.dao;

import com.company.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class PersonPersistent {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); //it will start the transaction

        //create few person objects
        Person p1 = new Person(101, "Shakil", "Ahmed", 25, "Java Developer");
        Person p2 = new Person(102, "Jekov", "Jenkov", 40, "Python Developer");
        Person p3 = new Person(103, "Mark", "Smith", 30, "Rust Developer");

        //call the entity-manager persist method to save the objects

        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

Here you can see, we use  **EntityManagerFactory** and **EntityManager** interfaces and call entity-manager **getTransaction()** method to start the transaction.

Basically, in JPA entity-manager is used to **create**, **read**, **write**, **update** and **delete** an entity. And EntityManagerFactory method provides EntityManager to work with java object.

Here, we have created 3 Person objects and call the entity-manager **persist** method to save them into database.

**Note:** If you use Spring Data JPA, you actually use the save method that almost work like the persist method.

## Run the PersonPersistent.java Class

In order order save the Person objects into the database we have to run the PersonPersistent.java class. So, open PersonPersistent.java class and click on the run button or ( type SHIFT + F10 if you use intellij ). If everything is okay, in your mysql workbench a person table will be generated with 3 person records.

```
create table person (
    id integer not null,
    age integer,
    first_name varchar(255),
    last_name varchar(255),
    role varchar(255),
    primary key (id)
) engine=InnoDB
```


In order to see the person records, open the mySQL CommandLine tool and run the following sql commands:

```
$ SELECT * FROM PERSON;
# Person data will be shown here
```

Such as,

```
mysql> use testdb;
Database changed
mysql> SELECT * FROM person;
+-----+------+------------+-----------+------------------+
| id  | age  | first_name | last_name | role             |
+-----+------+------------+-----------+------------------+
| 101 |   25 | Shakil     | Ahmed     | Java Developer   |
| 102 |   40 | Jekov      | Jenkov    | Python Developer |
| 103 |   30 | Mark       | Smith     | Rust Developer   |
+-----+------+------------+-----------+------------------+
3 rows in set (0.00 sec)
```

![alt text](image1.png)


Here, person is the table name. And id, first_name, last_name, role and age are the column names of person table. Also, id is the primary key of person table that can be used to retrieve, update or delete records from person table.

## Update an Entity Record

Let's say we want to update the last record of the person table that id is 103. So first of all, we have to find the entity using the jpa find method based on the person object id (primary key). Then can set new value to that person object, then when we run the persistent class automatically, the database table will be updated. Such as,


**PersonPersistent.java** class


```
package com.company.dao;

import com.company.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class PersonPersistent {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); //it will start the transaction

        //find the person which id is 103

        Person p3 = entityManager.find(Person.class, 103); //using the entity-manager find method 

        //before updating:
        System.out.println("Before Updating the Person 103");

        System.out.println("Role: "+ p3.getRole());

        //set a new role for the person 103
        p3.setRole("Cleaner"); //it will set new role for the person 103

        System.out.println("After Updating the Person 103");
        System.out.println("New Role: "+p3.getRole());


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

If you now run your PersonPersistent.java class, you can see the person table has been updated as well.

console:

```
Before Updating the Person 103
Role: Rust Developer
After Updating the Person 103
Role: Cleaner
```

You can also see the differences in your mysql workbench.

```
mysql> SELECT * FROM person;
+-----+------+------------+-----------+------------------+
| id  | age  | first_name | last_name | role             |
+-----+------+------------+-----------+------------------+
| 101 |   25 | Shakil     | Ahmed     | Java Developer   |
| 102 |   40 | Jekov      | Jenkov    | Python Developer |
| 103 |   30 | Mark       | Smith     | Clearer          |
+-----+------+------------+-----------+------------------+
```

Thanks.