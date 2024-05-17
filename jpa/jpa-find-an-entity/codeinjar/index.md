# JPA - Find an Entity Records

Let's say we want to find or retrieve records of the person table from our mysql workbench.

Our person table has the following records

```
+-----+------+------------+-----------+------------------+
| id  | age  | first_name | last_name | role             |
+-----+------+------------+-----------+------------------+
| 101 |   25 | Shakil     | Ahmed     | Java Developer   |
| 102 |   40 | Jekov      | Jenkov    | Python Developer |
| 103 |   30 | Mark       | Smith     | Rust Developer   |
+-----+------+------------+-----------+------------------+
```

Here we want to retrieve or find the person tables data or records based on primary key. Let's say we want to person records which id is 101.


Note: For updating or changing data or retrieving (The records of the Person table), we have to create an entity class called **Person.java** that must contains id (primary key), firstName, lastName and age, role as properties including constructors, getter and setter methods. 

**Note**: Column name must be the same of the database table but property name can be different. Also note, when we call data we basically use property name than column name.

(if you have already created **Person.java** entity class, you can skip the creation of **Person.java** class)


## Create an Entity Class

Now create an entity class called **Person.java** in **com.company.model** package and annotate it by **@Entity** annotation as usual.

It contains id, firstName, lastName and age, role as properties. The property name eventually will be tha column name of your person table (if you don't specify the column name explicitly).


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


In this step, we will provide database information and map the Person entity class in the **persistence.xml** file which is located in **src/main/resources/META-INF** folder. If you don't already have those folder structure in your project, kindly create those and then create **persistence.xml** file.

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

## Create an FindPerson.java Persistence Class

Create a persistence class called **FindPerson.java** under **com.company.dao** (package structure can be different) package.
 
Here we use the **entity-manager find** to retrieve the person records and show them in the console. When we run the java class all the transaction will be committed and our specific person records will be retrieved from the database, that you can see in the console.


**UpdatePerson.java** class

```
package com.company.dao;

import com.company.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class FindPerson {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); //it will start the transaction

        //find the person which id is 101
        Person p1 = entityManager.find(Person.class, 101);

        //display the person info in the console
        System.out.println("Person Info: which id is "+ p1.getId());
        System.out.println("Id: "+p1.getId());
        System.out.println("First Name: "+p1.getFirstName());
        System.out.println("Last Name: "+p1.getLastName());
        System.out.println("Age: "+p1.getAge());
        System.out.println("Role: "+p1.getRole());


        entityManager.getTransaction().commit(); //it will commit the transaction
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

After running the FindPerson.java persistence class, if you look at the console, you can see the person records which id is 101


```
Person Info: which id is 101
Id: 101
First Name: Shakil
Last Name: Ahmed
Age: 25
Role: Java Developer
```

You can see the difference before deleting and after deleting the last row from the person table.

Even if you try to get the info of person which id is 103, you will get error in the console..


Thanks for reading this article.



