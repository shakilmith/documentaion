
# JPA - Insert or Save an Entity

Attention: Before walk further, make sure you have maven project and in your pom.xml file you have already installed the jpa and it's implementaion dependencies. 

Let's follow the below few steps to insert an entity in our relational database.

1. Create an entity class called Person.java in your com.company package. 
The person entity class contains the following properties: id, first_name, last_name and age. 
First of all, you must annotate your Person.java class by @Entity annotaion and make the id as primary key of your database. So, anotate the id by @Id annotation.

<Code code={`
package com.company.model;

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
`}/>


2. Provide your database information and map the Person entity class in persistence.xml file which is located in src/main/resources/META-INF folder. If you don't already have those folder structure in your project, kindly create those and then, create persistence.xml file.

<Code code={`
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">

    <persistence-unit name ="default">

        <class>com.company.model.Person</class>

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


Here we provide our database information (in my case mysql database system info) and hibernate specific mapping information.
Note: In jakarta.persistence.jdbc.url property, we use jdbc:mysql://localhost:3306/testdb as value. Here, testdb is our database name in mysql workbench. At least, you have to create a database in your RDBMS system like mysql and provide the database name here.
But, you don't have to create table name externally. JPA will handle this and your entity class name actually will be the table name.

3. Create a persistence class called PersonPersistent  to save your person objects data into database.

<Code code={`
import com.company.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DemoPersistent {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();

        Person p1 = new Person(101, "Shakil", "Ahmed", 24);
        Person p2 = new Person(102, "Zakir", "Hossain", 50);
        Person p3 = new Person(103, "Abdul", "Wahed", 35);
        Person p4 = new Person(104, "Ismail", "Haq", 45);
        Person p5 = new Person(105, "Vlad", "Smith", 40);
        
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

Here you can see, we use  EntityManagerFactory and EntityManager interfaces and call entity-manager getTransaction() method to start the transaction. 
Basically, in JPA entity-manager is used to create, read, write, update and delete an entity. And EntityManagerFactory method provides EntityManager to work with java object.

Here, we create 5 Person objects and call entity-manager persist method to save them to database.

4. Run the PersonPersistent class and if everything is okay, in your mysql workbench you see person table with the stored data. 

<Code code={`
mysql> use testdb;
Database changed
mysql> select * from person;
+------+------+------------+-----------+
| p_id | age  | first_name | last_name |
+------+------+------------+-----------+
|  101 |   24 | Shakil     | Ahmed     |
|  102 |   50 | Zakir      | Hossain   |
|  103 |   35 | Abdul      | Wahed     |
|  104 |   45 | Ismail     | Haq       |
|  105 |   40 | Vlad       | Smith     |
+------+------+------------+-----------+
5 rows in set (0.00 sec)

`}/>

Here, person is the table name. And p_id, first_name, last_name, age is the column name of person table. Also, p_id is the primary key of person table.

-----

<h2> Read More</h2>
{jpa1}