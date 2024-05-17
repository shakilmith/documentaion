# JPA - Delete an Entity Record

Let's say we want to delete the person table data or records from our mysql workbench.

The person is look like this:

```
+-----+------+------------+-----------+------------------+
| id  | age  | first_name | last_name | role             |
+-----+------+------------+-----------+------------------+
| 101 |   25 | Shakil     | Ahmed     | Java Developer   |
| 102 |   40 | Jekov      | Jenkov    | Python Developer |
| 103 |   30 | Mark       | Smith     | Rust Developer   |
+-----+------+------------+-----------+------------------+
```


Here we will delete or remove the person records which id is 103. Then the whole row will be deleted (though it is possible to delete specific column of this record) 


For updating or changing data (The records of the Person table), we have to create an entity class called **Person.java** that must contains id (primary key), firstName, lastName and age, role as properties including constructors, getter and setter methods. 

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

## Create an DeletePerson.java Persistence Class

Create a persistence class called **DeletePerson.java** under **com.company.dao** (package structure can be different) package.

First of all, we have to find the person data by it's id using the **entity-manager find** method and then we can call the **entity-manager remove** method to delete that person records. Then when we run the java class all the transaction will be committed and our specific person records will be removed from the database.


**DeletePerson.java** class

```
package com.company.dao;

import com.company.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class DemoPersistent {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); //it will start the transaction

        //find the person record which id is 103
        Person p3 = entityManager.find(Person.class, 103);
        
        //delete the person records by calling the remove method
        entityManager.remove(p3); //all the records from this row will be deleted


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
```

Now open your mysql workbench or CommandLine tool you can see the the person which id is 103 has not been in this table, it is removed. 


```
# Before deleting the last row

mysql> SELECT * FROM person;
+-----+------+------------+-----------+------------------+
| id  | age  | first_name | last_name | role             |
+-----+------+------------+-----------+------------------+
| 101 |   25 | Shakil     | Ahmed     | Java Developer   |
| 102 |   40 | Jekov      | Jenkov    | Python Developer |
| 103 |   30 | Mark       | Smith     | Rust Developer   |
+-----+------+------------+-----------+------------------+

# After deleting the last raw

mysql> SELECT * FROM person;
+-----+------+------------+-----------+--------------------+
| id  | age  | first_name | last_name | role               |
+-----+------+------------+-----------+--------------------+
| 101 |   25 | Shakil     | Ahmed     | Java Developer     |
| 102 |   40 | Jekov      | Jenkov    | Python Developer   |
+-----+------+------------+-----------+--------------------+
```

You can see the difference before deleting and after deleting the last row from the person table.

Even if you try to get the info of person which id is 103, you will get error in the console..

```
Cannot invoke "com.company.model.Person.getId()" because "p3" is null
```

Thanks for reading this article.



