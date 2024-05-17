# JPQL Static Query Tutorial:

In this example application, we are going to explore JPQL static query and how we can retrieve, update or delete data from our relational database using JPQL static query method.

Before going to dive into the real example, we have to know little bit about jpql. JPQL means java persistence query language. JPQL provides two methods to retrieve, update, delete or filter data from our application instead of database tables.


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

The key features of JPQL: 
  - JPQL is portable and platform independent and can be used in different datastores.
  - It can operates bulk update, delete operations without touching datastore.
  - JPQL can also perform join and aggregate operations like sql.
  - JPQL queries can be declared statically in metadata (inside the entity itself) or can be declared dynamically in code or business logic. (Below we will describe about it)
  - JPQL is used to define searches against persistent entities and store those entities in database independently.



The following are the possible JPQL statements that can used on the queries: 
  - SELECT: (Select p from Person p)
  - SELECT: (Select p from Peron p where p.id < 109) //using optional where clause
  - Update: (Update Person p SET p.salary = 2500 where p.id > 135) 
  - DELETE: (Delete p from Person p where p.id = 109) or (Delete from Person where p.id = 109)

  Note: Here, Person is the entity name, and p is the reference or alias of Person.


In JPQL Select, Update, Delete statements may contains the following clauses (parameters): 
  - Select clause (It determines the type of the objects or values to be selected)
  - From clause (It mentions the entity name or designate the domain type which expressions specified)
  - Entity reference ()
  - An optional Where clause (like SQL where statement, and it applies conditions which can be used to restrict the results that are returned by the query)
  - An optional Order By clause (Order by not OrderBy)
  - An optional Group By clause
  - An optional Having clause
  - Identifiers like Distinct, Like, Join, As, True or False.




But in this post, we will see how to retrieve data from our relational database table using JPQL static query means using **createNamedQuery() method.


## Simple Example Application

Now we are going to retrieve data using JPQL static query, means **createNamedQuery()** method from our relational database instead of using dynamic query.


**Using @NamedQuery**

Just open your entity class (in our case the **Person.java** class) and write the following **@NamedQuery** annotation right above the entity name or just write it after the **@Entity** annotation (I mean at the package definition)


**Person.java**

```
/**
* @NamedQuery(name = "find name", query = "Select p from Person p")
* then, the name attribute value will be used in the createNamedQuery() method
*/


package com.company.model;

import jakarta.persistence.*;

@Entity(name = "Person")
@Table(name = "person")
@NamedQuery(name = "find firstName", query = "Select p.first_name from Person p")
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


**Note:** Here, the name property value will be used inside our **FindPerson.java** class to extract or retrieve data from the person table.


In this step, now open **FindPerson.java** class and write the namedQuery() definition to work with tables data.

**FindPerson.java**

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
        Query query = entityManager.createNamedQuery("find firstName); // find firstName is the @NamedQuery() attribute value, and it must be matched.


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

You can see, we use the "find firstName" @NamedQuery attribute value here as a reference. 


Now if you run the **FindPerson.java** class you will get the same output like the previous one.

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


**Note:** If you do any mistake or the createNamedQuery("") value if not match with value of the name parameter of @CreateNamedQuery annotation then you will get error in the console.
Such as, 


```
No query is registered under the name
```


Here you can see, how we have retrieve data using JPQL Static Query method and we used how we can use SQL like commands inside our application other than the database table.