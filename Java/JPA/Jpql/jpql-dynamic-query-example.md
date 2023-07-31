## JPQL dynamic query example:

In this example we will use jpql dynamic query method to fetch data from relational database.

You have to know that, jpql provides dynamic queries including static queries.
Here we are going to use createQuery() method to fecth data from our relational database by different circumstances.

# Fetch a column from database table:

Suppose, we have a person table like below in our mysql database.

```sql
+-----+---------------------------------+
| id  | first_name | last_name |  age   |
+-----+---------------------------------+
| 101 |  Shakil     | Ahmed     |  25   |
| 102 |  Vlad       | Smith     |  30   |
| 103 |  Jekov      | Jenkov    |  38   |
| 104 |  Abdul      | Wahed     |  52   |
| 105 |  Zakir      | Hossain   |  55   |
+-----+---------------------------------+
```

We want to extract first_name column data using createQuery() method.

Let's follow the below stpes:

1. Ceate an entity class called Person.java as per as the database column name and it must contains the same amount and type of properties like person table.

```java
package com.company.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
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

```

As it is a domaon type, so we have to annotate this Person.java class by entity annotaion and make the id as primary key using @Id annotation. I here, skip the @GeneratedValue annotaion as per I don't want to auto generate my id.

2. Now map your database and domain or entity informaion in the persistence.xml file. This file is located under src/main/resources/META-INF/ folder. (It is mendatory to follow the directory structure if you use maven)

```xml
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
```

3. Now create FetchData.java class in com.cmpany package. In this class we provide our JPQL select statement in createQuery method and call the getResultList() method to retrive list of data.

```java

package com.company;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class FetchData {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select p.first_name from Person p");

        @SuppressWarnings("unchecked")
        List<String> person_list = query.getResultList();
        System.out.println("Person First Name");
        for(String p: person_list){
            System.out.println(p);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

```

4. Now run the FecthData.java class and after completing the execution you should get the following log messeage:

```console
Person First Name
Shakil
Vlad
Jekov
Abdul
Zakir
```

Here you can see, we used p.first_name, it means we want to retrive data of String type. But what if we use p instead of p.first_name? Then, it will be meant, we want to retrive data of Object type not String type.

Now just write
```
Query query = entityManager.createQuery("Select p from Person p");

```
You get the following error: 

```console
class com.company.Person cannot be cast to class java.lang.String 

```
So, make little bit changes in your business logic so that it returns, Object than String.

And, we use the getter method to retrive data from database here.

```java
Query query = entityManager.createQuery("Select p from Person p");

    @SuppressWarnings("unchecked")
    List<Person> person_list = query.getResultList();
    System.out.println("Person First Name");
    for(Person p: person_list){
        System.out.println(p.getFirst_name());
    }
```

# How to retrive specific column or columns data:

Let's say, from the person table, we want to get the first_name, last_name and age column data for person 105. For getting this, we have to provide condition in our jpql command.

```java
Query query = entityManager.createQuery("Select p from Person p where p.id = 105");

Person p_data= (Person) query.getSingleResult();      
System.out.println("fist_name   last_Name   age");
System.out.println(p_data.getFirst_name()+"\t "+ p_data.getLast_name()+"\t "+p_data.getAge());

```

When you run the application again you see the folloiwng data in the console fetched from person database table.

```console
fist_name   last_Name   age
Zakir	 Hossain	 55
```

Note: We use here where clause to get data based on certain condition. We wanted to get person data whose id is 105. So, we wrote where p.id = 105; Please, don't use double equalt sign.

## Get list of perosn data age is less than 50

```
Query query = entityManager.createQuery("Select p from Person p where p.age < 50");

@SuppressWarnings("unchecked")
List<Person> personList = query.getResultList();

System.out.println("fist_name   last_Name   age");

for(Person p: personList){
    System.out.println(p.getFirst_name()+"\t    "+ p.getLast_name()+"\t    "+p.getAge());
}

//data we will get
fist_name   last_Name   age
Shakil	    Ahmed	    25
Vlad	    Smith	    30
Jekov	    Jenkov	    38

```

Note: It is also possible to write any type of SQL commnands in jpql. What are valid in SQL, also valid in JPQL. The only difference between sql and jpql is that, sql is being used in database and jpql is being used inside application to retrive database data statically or dynamically.

## JPQL Aggregate operations: 

- Count, Max, Min, Sum, Avg etc. 

Let's see the use of count, max, min, sum, avg aggretaage funcions and how to use them in JPQL. Also note that, they all return numeric value. 

```java

Query query1 = entityManager.createQuery("Select COUNT(p) from Person p");
System.out.println("Number of person: "+query1.getSingleResult());

Query query2 = entityManager.createQuery("Select MIN(p.age) from Person p");
System.out.println("Minimum age: "+query2.getSingleResult());

Query query3 = entityManager.createQuery("Select MAX(p.age) from Person p");
System.out.println("Maximum age: "+query3.getSingleResult());

Query query4 = entityManager.createQuery("Select SUM(p.age) from Person p");
System.out.println("Sum of Ages: "+query4.getSingleResult());

Query query5 = entityManager.createQuery("Select AVG(p.age) from Person p");
System.out.println("Average age: "+query5.getSingleResult());

//possible output

Number of person: 5
Minimum age: 25
Maximum age: 55
Sum of Ages: 200
Average age: 40.0

```
## Use of Limit statement in JPQL

As, JPQL doesn't supptort Limit clause, but we can achieve the same result by using setMaxResults() method and then use the getResultList() method to retrive list of limiting data.

```java
Query query1 = entityManager.createQuery("Select p from Person p");

@SuppressWarnings("unchecked")
List<Person> personList = query1.setMaxResults(3).getResultList();
for(Person p: personList){
    System.out.println(p.getFirst_name());
}

```

## Use LIKE operator and % pattern in JPQL

- In JPQL Like operator is used with where clause and retrive data based on certain pattern.



