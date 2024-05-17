# JPQL overview

JPQL is an object oriented java persistence query language that can perform database operations from java code or application than in database tables. The JPQL commands are almost like SQL commands but the only difference between sql and JPQL is that, sql statements are held in database tables but JPQL statement operates in the application.


The key features of JPQL: 
  - JPQL is portable and platform independent and can be used in different datastores.
  - It can operates bulk update, delete operations without touching datastore.
  - JPQL can also perform join and aggregate operations like sql.
  - JPQL queries can be declared statically in metadata (inside the entity itself) or can be declared dynamically in code or business logic. (Below we will describe about it)
  - JPQL is used to define searches against persistent entities and store those entities in database independently.


JPQL provides 2 methods that can be used to access database records.
   1. createQuery()
     It is called dynamic query, used on the business logic.

     How to define createQuery method in the business logic?
     Query query = entityManager.createQuery("Select p.first_name from Person p);

  2. @NamedQuery()
     It is called static query and it is defined inside the entity itself. 

     How to define @NamedQuery() method inside the entity?
     @NamedQuery(name="find name", query="Select p.first_name from Person p")
     Then inside the business logic we have to mention the name to retrieve the records of exact table from database.
     Query query = em.createQuery("find name")


Note: Here, entityManager is the instance of entity-manager interface.


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


## Simple Example Application

Let's see an example of JPQL query creation. 

Suppose, we have a table called Person in mysql database. It contains properties like,

id (primary key), firstName, lastName, age, gender, role, city and country.


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


And we want to get the person first_name column value which id is equivalent to 105

If you don't already have Person entity class let's refer this tutorial: 

<a href="" alt="Save new Entity into MySQL Database">Save or Update Entities in JPA</a>


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


After executing or running the **FindPerson.java** class, in the console we will see list of names of person entity. It means, we successfully retrieve person tables data using JPQL.

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

Now, we will see how to retrieve the person records using the @NamedQuery method that is used inside the domain model than the business logic.

**Using @NamedQuery**

Just open your entity class (in our case the Person.java class) and write the following **@NamedQuery** annotation right above the entity name or just write it after the **@Entity** annotation.

**Person.java**

```
@NamedQuery(name = "find firstName", query = "Select p.firstName from Person p")

//Such as
@Entity(name = "Person")
@Table(name = "person")
@NamedQuery(name = "find firstName", query = "Select p.first_name from Person p")
public class Person {
    //to-do-list
}
```


**Note:** Here, the name property value will used inside our **FindPerson.java** class to extract or retrieve data from the person table.


In this step, now open FindPerson.java class and remove the **createQuery** method instead write @NamedQuery

```
remove: Query query = entityManager.createQuery("SELECT p.firstName FROM Person p");
write instead: Query query = entityManager.createNamedQuery("find firstName"); //parameter value of @NamedQuery annotation
```


You can see, we use the "find firstName" @NamedQuery attribute value here as a reference. 


Now if you run the **FindPerson.java** class again you will get the same output like the previous one.

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


**Note:** If you do any mistake or the createNamedQuery("") value if not match with value of name parameter of @CreateNamedQuery annotation you will get error in the console.
Such as, 


```
No query is registered under the name
```


Anyway, it seems we get the same output, but instead of using **createQuery** method we have use **createNamedQuery** method.


**Note:** There may be pros and cons of using ***createQuery*** or ***namedQuery*** query methods, but I don't know them. In upcoming chapter I will discuss about them. 


Though we get all the person records (first_name) but it is possible that we can filter our data that how to retrieve from database table. Such as, based on id, name, age, country or using specific logic (set condition) to retrieve data.



For achieving this, we have to provide **where** conditional command in our JPQL query methods. It's almost like SQL command. So, if you have basic knowledge of SQL commands, it will be easy enough for you. 


So, please open the **FindPerson.java** class and update your query method by using where command in order retrieve records based on certain condition.


**Getting specific person records based on primary key**

```
//retrieve person record based on id
Query query = entityManager.createQuery("SELECT p from Person p WHERE p.id = 105");

Person p5 = (Person) query.getSingleResult();

//retrieve person firsName, lastName and role
System.out.println("First Name: "+ p5.getFirstName());
System.out.println("Last Name: "+ p5.getLastName());
System.out.println("Role: "+ p5.getRole());
```

But the SELECT command in the createQuery method, selects all the properties from the database table. Such as, when we run the above class, the following message shows this scenario.

```
    select
        p1_0.id,
        p1_0.age,
        p1_0.city,
        p1_0.country,
        p1_0.first_name,
        p1_0.gender,
        p1_0.last_name,
        p1_0.role 
    from
        person p1_0 
    where
        p1_0.id=105
First Name: Finn
Last Name: Dan
Role: Cleaner
```


**Retrieving firsName column value based on person primary key**

```
//retrieve person record based on id
Query query = entityManager.createQuery("SELECT p.firstName from Person p WHERE p.id = 105");

String p5 = (String) query.getSingleResult();
System.out.println("First Name: "+ p5);

/*
* Output:
* First Name: Finn
*/
```

**Retrieve person details who live in specific country (filtering by country)**

```
Query query = entityManager.createQuery("SELECT p.firstName from Person p WHERE p.country = 'Australia' ");

@SuppressWarnings("unchecked")
List<String> personList = query.getResultList();

for(String p: personList){
    System.out.println(p);
}

/*
* Output:
* Alex
* Finn
* Sophia
*/
```

The above can also be written like this:

```
Query query = entityManager.createQuery("SELECT p from Person p WHERE p.country = 'Australia' ");

@SuppressWarnings("unchecked")
List<Person> personList = query.getResultList();

for(Person p: personList){
    System.out.println(p.getFirstName());
}
```

**Let's Filtering by Gender (retrieve only female person records)**

```
Query query = entityManager.createQuery("SELECT p from Person p WHERE p.gender = 'Female' ");

@SuppressWarnings("unchecked")
List<Person> personList = query.getResultList();

System.out.println("First Name "+" "+ "Last Name"+ "\t"+ "Role");
for(Person p: personList){
    System.out.println(p.getFirstName() + "\t\t"+ p.getLastName()+ "\t\t"+p.getRole());
}

/**
* Output:
* First Name  Last Name	  Role
* Sophia		  Tiffany		  Graphic Designer
* Alena		    Lopez		    Backend Developer
*/
```


**Note:** Anyway, you see, we also provide (String) wrapper type externally while creating query reference variable, otherwise it means, we are going to extract String than Object. 



Thanks for reading this article. I will be happy if you check out yourself the features  JPQL provides.



