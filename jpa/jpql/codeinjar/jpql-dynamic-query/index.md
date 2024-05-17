# JPQL dynamic Query Tutorial:

In this example application, we are going to explore JPQL dynamic query and how we can retrieve, update or delete data from our relational database using JPQL dynamic query method.

Before going to dive into the real example, we have to know little bit about jpql. **JPQL** means **java persistence query language**. JPQL provides two methods to retrieve, update, delete or filter data from our application instead of the database tables.


The key features of JPQL: 
  - JPQL is portable and platform independent and can be used in different datastores.
  - It can operates bulk update, delete operations without touching datastore.
  - JPQL can also perform join and aggregate operations like sql.
  - JPQL queries can be declared statically in metadata (inside the entity itself) or can be declared dynamically in code or business logic. (Below we will describe about it)
  - JPQL is used to define searches against persistent entities and store those entities in database independently.


JPQL provides 2 methods that can be used to access database records.
   1. **createQuery()**
     It is called dynamic query, used on the business logic.

     How to define createQuery method in the business logic?
     Query query = entityManager.createQuery("Select p.first_name from Person p);

  2. **@NamedQuery()**
     It is called static query and it is defined inside the entity itself. 

     How to define **@NamedQuery()** method inside the entity?
     @NamedQuery(name="find name", query="Select p.first_name from Person p")
     Then inside the business logic we have to mention the name to retrieve the records of exact table from database.
     Query query = em.createQuery("find name")


Note: Here, entityManager is the instance of entity-manager interface.


The following are the possible JPQL statements that can used on the queries: 
  - SELECT: (Select p from Person p)
  - SELECT: (Select p from Peron p where p.id < 109) //using optional where clause
  - Update: (Update Person p SET p.salary = 2500 where p.id > 135) 
  - DELETE: (Delete p from Person p where p.id = 109) or (Delete from Person where p.id = 109)

  Note: Here, Person is the entity name, p is the instance of the Peron class.


In JPQL Select, Update, Delete statements may contains the following clauses (parameters): 
  - Select clause (It determines the type of the objects or values to be selected)
  - From clause (It mentions the entity name or designate the domain type which expressions specified)
  - Entity reference ()
  - An optional Where clause (like SQL where statement, and it applies conditions which can be used to restrict the results that are returned by the query)
  - An optional Order By clause (Order by not OrderBy)
  - An optional Group By clause
  - An optional Having clause
  - Identifiers like Distinct, Like, Join, As, True or False.




But in this post, we will see how to retrieve data from our relational database table using JPQL dynamic query means using **createQuery() method.


## Simple Example Application

Suppose, we have a table named Person in the mysql database. It contains properties like: id (primary key), firstName, lastName, age, gender, role, city and country.


**Note:** In your application, you must have entity class of **Person.java** and all the properties mentioned above. If you don't have the person entity class, create one with the respective properties, otherwise you can't retrieve data from the database.

For your favour, the Person entity class will look like:

**Person.java** entity class

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

    @Column(name = "gender")
    private String gender;

    @Column(name = "role")
    private String role;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    //constructors, getter and setter methods
}
```




Now guess, the person table has the following records with respective data.

```
+-----+------+-----------+-----------+------------+--------+-----------+-------------------+
| id  | age  | city      | country   | first_name | gender | last_name | role              |
+-----+------+-----------+-----------+------------+--------+-----------+-------------------+
| 101 |   30 | Helsinki  | Finland   | Barney     | Male   | Harold    | Java Developer    |
| 102 |   45 | Kazan     | Russia    | Henry      | Male   | Vincent   | Java Developer    |
| 103 |   40 | Brussels  | Belgium   | Trevor     | Male   | Chris     | SQL Developer     |
| 104 |   29 | Sydney    | Australia | Alex       | Male   | David     | Python Developer  |
| 105 |   49 | Sydney    | Australia | Finn       | Male   | Dan       | Cleaner           |
| 106 |   45 | Melbourne | Australia | Sophia     | Female | Tiffany   | Graphic Designer  |
| 107 |   41 | Berlin    | Germany   | Chad       | Male   | Ralph     | Web developer     |
| 108 |   37 | Frakfurt  | Germany   | Aaron      | Male   | Chris     | JavaFX Developer  |
| 109 |   30 | Seville   | Spain     | Adam       | Male   | Chris     | Rust Developer    |
| 110 |   31 | Oslo      | Norway    | Alena      | Female | Lopez     | Backend Developer |
+-----+------+-----------+-----------+------------+--------+-----------+-------------------+
```


And we want to retrieve all the first_name column value.

If you don't already have Person entity class let's refer this tutorial: 

<a href="https://codeinjar.com/how-to-create-jpa-entity/" alt="Create JPA Entity">Create Your First JPA Entity</a>


## Create Persistence Class for Retrieving Person Records from Person Table Using JPQL

So, now create a **FindPerson.java** class in **com.company.dao** package. We will use jpa (jakarta specific) Query interface to retrieve person tables data, for the time being only the person firstName (fistName will be converter first_name in mysql).


**Using createQuery method** 

```
package com.company.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class FindPerson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); //it will start the transaction

        //create jpa dynamic query using entity-manager createQuery() method
        //the JPQL commands must be specific to the entity (like property name)
        Query query = entityManager.createQuery("SELECT p.firstName FROM Person p"); //Person is the entity name not the table name, and firsName also the property name not the column name, kindly recall this behavior

        @SuppressWarnings("unchecked")
        List<String> personList = query.getResultList(); //invoke the getResultList() method to retrieve list of values

        //iterate and then print the firstName values
        System.out.println("First Name of all Persons");
        for(String p: personList){
            System.out.println(p);
        }

        entityManager.getTransaction().commit(); //it will commit the transaction
        entityManager.close();
        entityManagerFactory.close();
    }
}
```


After executing or running the **FindPerson.java** class, in the console we will see list of names of person entity. It means, we successfully retrieve person tables data using **JPQL**.

```
First Name of all Persons
Barney
Henry
Trevor
Alex
Finn
Sophia
Chad
Aaron
Adam
Alena
```

Here you can see, how we can retrieve data using **JPQL Dynamic Query method** and we used the SQL like commands inside our application other than the database table.