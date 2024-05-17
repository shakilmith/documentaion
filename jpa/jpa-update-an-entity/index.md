
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


1. Create an entity class called **Person.java** in **com.company.model** package and annotate it by **@Entity** annotation as usual.

It contains id, first_name, last_name and age properties. The property name eventually will be tha column name of your person table.

```
package com.company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "p_id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "age")
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

2. Provide your database information and map the Person entity class in the persistence.xml file which is located in src/main/resources/META-INF folder. If you don't already have those folder structure in your project, kindly create those and then create persistence.xml file.

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
            <property name="hibernate.hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>
</persistence>
`}/>


4. Create a persitence class called UpdatePerson.java under com.company package.

First of all, we have to find the person data by it's id and then we have to set new values in it. Then we execute this operation (Run the class) and the person data will be changed or updated.

<Code code={`
package com.company;

import com.company.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindPerson {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin(); //start the transaction
       
         Person p5 = em.find(Person.class, 105); //find the person by it's id (primary key)

         System.out.println("Before updating");
         System.out.println("Age was: "+p5.getAge());

         p5.setAge(47); //update the person age.

         System.out.println("After Updating");
         System.out.println("Now age is: "+p5.getAge()); //the updated age


        em.getTransaction().commit(); //close the transaction
        em.close();
        emf.close();
    }
}
`}/>


5. Run the UpdatePerson.java class and in the console you see the following log messages -

<Code code={`
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Before updating
Age was: 40
After Updating
Now age is: 47
Jul 19, 2023 10:56:02 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/testdb]
`}/>


It means, our Person table in testdb (mysql workbench) database has been succesfully updated. 

Look: 

Before updating - Person table was:

<Code code={`
+------+------+------------+-----------+
| p_id | age  | first_name | last_name |
+------+------+------------+-----------+
|  101 |   24 | Shakil     | Ahmed     |
|  102 |   50 | Zakir      | Hossain   |
|  103 |   35 | Abdul      | Wahed     |
|  104 |   45 | Ismail     | Haq       |
|  105 |   40 | Vlad       | Smith     |
+------+------+------------+-----------+
`}/>


After updating - Person table is:

<Code code={`
+------+------+------------+-----------+
| p_id | age  | first_name | last_name |
+------+------+------------+-----------+
|  101 |   24 | Shakil     | Ahmed     |
|  102 |   50 | Zakir      | Hossain   |
|  103 |   35 | Abdul      | Wahed     |
|  104 |   45 | Ismail     | Haq       |
|  105 |   47 | Vlad       | Smith     |
+------+------+------------+-----------+
`}/>

You can see, the age of Vlad Smith is now 47 (id = 105) instead of 40. 

-----

<h2>Read More</h2>
{jpa1}
