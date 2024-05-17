# JPQL overview
# What is JPQL?
JPQL is an object oriented java persistence query language that can perform database operations from java code or application than sql database. The JPQL syntaxes are almost like sql syntaxes but the only difference between sql and JPQL is that, sql statement operates in database but JPQL statement operates in the application.

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
     Query query = em.createQuery("Select p.first_name from Person p);

  2. @NamedQuery()
     It is called static query and it is defined inside the entity itself. 
     How to define @NamedQuery() method inside the entity?
     @NamedQuery(name="find name", query="Select p.first_name from Person p")
     Then inside the business logic we have to mention the name,
     Query query = em.createQuery("find name")
     Note: Here, em is the instance of entity-manager interface.

Note: Here, em is the reference variable of entity-manager interface.

The following are the possible JPQL statements on the queries: 
  - SELECT (Select p from Peron p where p.id < 109)
  - Update (Update Person p SET p.salary = 2500 where p.id > 135) 
  - DELETE (Delete p from Person p where p.id = 109) or (Delete from Person where p.id = 109)
  Note: Here, Person is the entity name, and p is the reference of Person.


In JPQL Select, Update, Delete statements may contains the following clauses (parameters): 
  - Select clause (It determines the type of the objects or values to be selected)
  - From clause (It mentions the entity name or designate the domain type which expressions specified)
  - Entity reference ()
  - An optional Where clause (like sql where statement, and it applies conditions which can be used to restrict the results that are returned by the query)
  - An optional Order By clause (Order by not OrderBy)
  - An optional Group By clause
  - An optional Having clause
  - Identifiers like Distinct, Like, Join, As, True or False.



Let's see an example JPQL query creation. 

Suppose, we have a table called Person in mysql database. It contains 4 properties 
int id (primary key of person table)
String first_name;
String last_name;
int age;

The person table is look like: 

<Code code={`
+-----+-----+------------+-----------+
| id  | age | first_name | last_name |
+-----+-----+------------+-----------+
| 101 |  25 | Shakil     | Ahmed     |
| 102 |  30 | Vlad       | Smith     |
| 103 |  38 | Jekov      | Jenkov    |
| 104 |  52 | Abdul      | Wahed     |
| 105 |  55 | Zakir      | Hossain   |
+-----+-----+------------+-----------+
`}/>



And we want to get the person first_name column value which id is is equivalent to 105

If you don't already have Person entity class let's see the follow the following steps: 
Or If you have person table already in your mysql database, please skip step 1 and 2. 

1. Create Person entity class in com.company package and it has four properties id, first_name, last_name and age. Remember the id is the primary key of database table and you annotate your Person.class by @Entity annotation as it is the persistent class. 

<Code code={`
package com.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    @Id
    private int id;
    private String first_name;
    private String last_name;
    private int age;

    public Person() {
    }

    public Person(int id, String first_name, String last_name, int age) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
`}/>



We externally name our database table person by using @Table annotation. The @Id annotation refers that it is the primary key of person table. You can also use @Column(name ="default_name") for the properties and @GeneratedValue annotation for make the id generations process automatically. But, I omit them for now.

2. Now create persistence.xml file and provide your database and entity class information here. If you already have this file, skip this step kindly. The persistence class must be located inside the src/main/resources/META-INF/ folder. 

<Code code={`
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
            <property name="hibernate.hbm2ddl.auto" value="create"/>
        </properties>
    </persistence-unit>
</persistence>

`}/>


3. Now create persistence class named PersonPersistent.java in com.company package.
If you have person table in your database already, please skip this step. Otherwise you may get error. (Probably you get id duplication error!). Or, if you are aware that you don't have real data in your person table, you can simply delete the person table and follow this article (Joke!). 

<Code code={`
package com.company;

import com.company.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonPersistent {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p1 = new Person(101, "Shakil", "Ahmed", 25);
        Person p2 = new Person(102, "Vlad", "Smith", 30);
        Person p3 = new Person(103, "Jekov", "Jenkov", 38);
        Person p4 = new Person(104, "Abdul", "Wahed", 52);
        Person p5 = new Person(105, "Zakir", "Hossain", 55);

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
`}/>


You see here, we have created 5 Person objects to insert in our person database table.

4. Create FindPerson.java class in com.company package. We create Query method here to extract person tables first_name column name data.

### Using createQuery method: 

<Code code={`
package com.company.dbpersistent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class FindPerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("Select p.first_name from Person p");

        @SuppressWarnings("unchecked")
        List<String> person_list = query.getResultList();

        System.out.println("First Names of all person:");
        for(String p: person_list){
            System.out.println(p);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
`}/>


After execution the the FindPerson.java class, we get the following log messages including person table first_name column: 

<Code code={`
First Names of all person:
Shakil
Vlad
Jekov
Abdul
Zakir
`}/>


Hold on!
Let's see another example using @NamedQuery() method. We extract the same output but, now we provide our Query inside the entity itself. And refer the reference in the application logic.

Open the Person.java entity class. And write the following in at the class level.

<Code code={`
@NamedQuery(name = "find first name", query = "Select p.first_name from Person p")
`}/>

Remeber the name property value! We will use it inside our FindPerson.java class to extract data from person table.

Now remove the 
<Code code={`
//remove this query method
Query query = em.createQuery("Select p.first_name from Person p");
//write the below one instead
Query query = em.createNamedQuery("find first name");

`}/>


You can see, we use the "find first name" @NamedQuery property name value here as a reference. 

- Now run the FindPerson.java classs and you should the following result like the previous log output.

<Code code={`
First Names of all person:
Shakil
Vlad
Jekov
Abdul
Zakir
`}/>


Yes, you get the same output. But, now we use createNamedQuery method instead of using createQuery method. 

**Note:** There may be pros and cons of using ***createQuery*** or ***namedQuery*** query methods, but I don't know them. In upcoming chapter I will discuss about them. 


Okay, As we got all the first_column data from person table. But what if, we want to get only the specific data based on person id (primary key)

For achieving this, we have to provide where condition in our JPQL query methods. It's almost like SQL statement. So, if you have basic knowledge of SQL command, it will be fun enough for you. 

So, please open the FindPerson.java class and please look over on the 

<Code code={`
Query query = em.createQuery("Select p.first_name from Person p");
`}/>

Remember our first example where we used createQuery() method tp extract person first names. But, this JPQL statement extracts all the fist_name columns value. 

So, getting only the specific person first_name data we write like the below: 

<Code code={`
Query query = em.createQuery("Select p.first_name from Person p where p.id = 105");

String p5 = (String) query.getSingleResult();
System.out.println("First Name: "+p5);
`}/>


Here you can see, we use where condition: where p.id = 105; Please don't use == rather use = (means, use one equal sign instead of two)

Here, I got mistook when I use == instead of = 

Anyway, you see, we also provide (String) wrapper type externally while creating query reference variable, otherwise it means, we are going to extract String than Object. 

If you write like this:

<Code code={`
String p5 = query.getSingleResult(); 
//It means you are going to extract Object type (But we want to extract String type)
`}/>


Rather write: 
<Code code={`
Sting p5 = (String) query.getSingleResult(); 
//If you use ide, I thing it will be solved automatically.
`}/>



Here in the console output after executing the FindPerson.java class:
<Code code={`
First Name: Zakir
`}/>

Okay, now let's check out our last example to extract full raw of person table whose id is 105; Means, we want to get first_name, last_name and age of 105 no: person;

The code will be like: 
<Code code={`
Query query = em.createQuery("Select p from Person p where p.id = 105");

Person p5 = (Person) query.getSingleResult();
System.out.println("First Name: "+p5.getFirst_name());
System.out.println("Last Name: "+p5.getLast_name());
System.out.println("Age :"+p5.getAge());
`}/>


The output will be: 
<Code code={`
First Name: Zakir
Last Name: Hossain
Age :55
`}/>

Here, you can see we user Person object type instead of String type. And, we use getter method to get the person data base on certain condition.

Thanks for reading this article. I will be happy if you check out yourself the features of JPQL provides, instead of reading the article merely. 

Talk soon.

----

<h2>Read More</h2>
{jpa1}

