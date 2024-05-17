
# JPA - Update an Entity Records

Let's say we want to update the person table data in mysql workbench.


```
+-----+------+------------+-----------+------------------+
| id  | age  | first_name | last_name | role             |
+-----+------+------------+-----------+------------------+
| 101 |   25 | Shakil     | Ahmed     | Java Developer   |
| 102 |   40 | Jekov      | Jenkov    | Python Developer |
| 103 |   30 | Mark       | Smith     | Rust Developer   |
+-----+------+------------+-----------+------------------+
```


For updating or changing data (The records of Person table), we have to create an entity class called **Person.java** that must contains id (primary key), firstName, lastName and age as properties including constructors, getter and setter methods. 

**Note**: Column name must be the same of the database table but property name can be different. Also note, when we call data we basically use property name than column name.

(if you have already created **Person.java** entity class, you can skip the creation of **Person.java** class)


## Create an Entity Class

Now create an entity class called **Person.java** in **com.company.model** package and annotate it by **@Entity** annotation as usual.

It contains id, first_name, last_name and age properties. The property name eventually will be tha column name of your person table.


**person.java**

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

    public Person() {
    }

    // constructors, getter and setter methods
}
```

## Map the Database Configuration


In this step, we will provide database information and map the Person entity class in the **persistence.xml** file which is located in src/main/resources/META-INF folder. If you don't already have those folder structure in your project, kindly create those and then create **persistence.xml** file.

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">

    <persistence-unit name ="default">

        <class>com.company.Person</class>

        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/testdb"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="root"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>
</persistence>
```

## Create an UpdatePerson.java Persistence Class

Create a persistence class called UpdatePerson.java under com.company.dao (package structure can be different) package.


First of all, we have to find the person data by it's id using the **entity-manager find** method and then we have to set new values in it. Then when we run the java class all the transaction will be committed and our specific person records will be updated.

**UpdatePerson.java** class

```
package com.company.dao;

import com.company.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class UpdatePerson {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); //it will start the transaction

        //find the person record which id is 103
        Person p3 = entityManager.find(Person.class, 103);

        System.out.println("Before updating the person record");
        System.out.println("Id: "+p3.getId());
        System.out.println("First Name: "+p3.getFirstName());
        System.out.println("Last Name: "+p3.getLastName());
        System.out.println("Age: "+p3.getAge());
        System.out.println("Role: "+p3.getRole());

        //update the role
        p3.setRole("Frontend Developer");

        System.out.println("After updating the person record");
        System.out.println("Id: "+p3.getId());
        System.out.println("First Name: "+p3.getFirstName());
        System.out.println("Last Name: "+p3.getLastName());
        System.out.println("Age: "+p3.getAge());
        System.out.println("Role: "+p3.getRole());


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

If you now run the UpdatePerson.java class, in the console you will see the following lof messages:


```
Before updating the person record
Id: 103
First Name: Mark
Last Name: Smith
Age: 30
Role: Rust Developer
After updating the person record
Id: 103
First Name: Mark
Last Name: Smith
Age: 30
Role: Frontend Developer
```

You can see, the role column of the person record which id is 103 has been updated and persisted successfully in our mysql workbench.

You can also see the in the mysql commandLine tool.


```
# Before updating the person table

mysql> SELECT * FROM person;
+-----+------+------------+-----------+------------------+
| id  | age  | first_name | last_name | role             |
+-----+------+------------+-----------+------------------+
| 101 |   25 | Shakil     | Ahmed     | Java Developer   |
| 102 |   40 | Jekov      | Jenkov    | Python Developer |
| 103 |   30 | Mark       | Smith     | Rust Developer   |
+-----+------+------------+-----------+------------------+

# After updating the person table:

mysql> SELECT * FROM person;
+-----+------+------------+-----------+--------------------+
| id  | age  | first_name | last_name | role               |
+-----+------+------------+-----------+--------------------+
| 101 |   25 | Shakil     | Ahmed     | Java Developer     |
| 102 |   40 | Jekov      | Jenkov    | Python Developer   |
| 103 |   30 | Mark       | Smith     | Frontend Developer |
+-----+------+------------+-----------+--------------------+
```

You can see the difference before updating and after updating the person table. 

