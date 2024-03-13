
For creating our first JPA application we use maven as a build tool instead of downloading api packages manually. Additionally we use Intellj idea to create our maven based project.

Basic requirements:
1. Java development kit - jdk-8+
2. Maven/Gradle as a build tool. Make sure you have the latest maven version install or at least version 3+
3. An IDE like intellij ide.
4. Basic knowledge of java and maven/gradle.

Let's follow the below steps to create our first JPA project.

1. Create a simple maven project.
Go/Open to your favourite ide. In my case intellij ide. Click on File->New->Project-> Maven-> Maven Archetype.

image

2. Right side of the window provide the 
   - name of your project
   - Configure the project location (which folder you porject will reside.)
  If you quite don't know about folder structur of your system, then just creat a new folder in your C drive called jpa and provide the path here.
   - configure your jdk version. May be it will be selected by default.
   - In catalogue option you can select internal, maven central or default local. As we just create this project to explore, just select internal.
   - In Archetype option select - maven-archetype-quickstart for simplicity.
   - Version 1.1 (I quite don't know how to upgrade the maven archetype-quickstart-version!)
   - Then click on Advanced Settings and provide 
      - GroupId : com.company (your project package name and by default it is org.example)
      - ArtifactId : my-app (your project name)
      - Version : 1.0-SNAPSHOT (maens development phase)

3. Now click Create button. If you are not happy just click Cancel.
After clicking create button, please wait few seconds for packaging your maven based application.
Note: You must have suitable internet connection while creating maven project. If you are in bad network, you may have to wait few more seconds in order to create your first maven project.

4. When your project is ready, you see the the following packages and files.
image
Clik on App class which is in com.company package. Run the App and you see Hello, World! message in the console. If you see the Hello World message in the console it means, there is no error involved in your maven (my-app) project and your project is ready to create our first jpa project.
Attention: Steps 4 is totally optional.

5. As it is a maven project and you have pom.xml file to hadnle project dependecies.
Open pom.xml file and add 3 more dependencies. 

<Code code={`
<dependency
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    <version>3.1.0</version>
</dependency>

<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.1.6.Final</version>
</dependency>

<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <version>8.0.32</version>
</dependency>
`} />

Here, we use jakarta.persistence-api for JPA specification, org.hibernate-core for implemenataion of JPA and mysql as RDBMS. 

Note: As JPA is just a specification and it doesn't provide any implemantation by it's ownself. Thus, we use hibernate as an implementation of JPA. There are various alternatives available like eclipselink, openJPA, TopLink etc. You can use them as well instead of hibernate.

6. Reload your pom.xml file to load the dependecies you have just added.
Inside your pom.xml file, right click your mouse -> Maven -> Reload project.
image

After a few moment when all the above dependencies will be loaded, you can see them in External Libraries folder. 
image

7. Now, create a model or an entity class called Person (Person.java) in com.company package.

Model/Entity: A class in java is considered as a simple pojo class. But, when the class is associated or connect with database or treated as persistent class then it is called an Entity. 
Note: You must annotate your pojo class by @Entity annotaion or provide metadata in orm.xml file when your class is a persistent class and it must have primary key (id) annotated by @Id annotaion. 
A persistent class is nothing but the name of a database table.

<Code code={`
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
`}/>


Here, Person is the entity class annotated by @Entity annotaion and externally if you want to provide your table name, you can also use @Table(name ="table_name") annotaion otherwise the class name will be the table name of your database. 
Few more detailsw.

8. Noew create the main class, I mean persistent class called PersonPersistent in com.company package to store our Person entity with data in database

<Code code={`
package com.company;

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

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
   
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
`}/>


Here you can see, inside em.getTransaction().begin() method we have created 3 Person objects with data. And then, we call entity-manager persist method to store them into our database. 

Wait, before running or executing the PersonPersistent class, we have to create another file called persistence.xml file. In this file we will provide our database information and confifure the Person entity class.

9. So, create persistence.xml file to map or provide the database information and configure the entity classes. The persistence.xml file must be located in src/main/resources/META-INF folder.

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


Here you can see, we configure the entity class name Person with it's specific location.

Here, persistence-unit is the root component and the persistence-unit name must be same EntityManagerFactory name what you have used in PersonPersistent class (Look over in step 8). Then, inside **properties** component we provide our database information. JDBC dirver name, database url, user-name and password. Alos we use hibernate specific mappings like hibernate.hbm2ddl.auto . 
Note: hibernate.hbm2ddl.auto contains 4 possible values. 
   - create: create the schema (means create tables with data) and erase the previous data if it finds.
   - create-drop: create the schema and drop when the application is stopped.
   - update: update the schema or table, but if you have asoociation/linking with other tables like 2 table shares data with each other, you probally get error as your application then says, duplicate entry key '1/2/3..' for key 'related table details'...
   - validate: validate the schema, no changes will be generated in database.

Okay then. Now it is our final step.

10. Open or go to your PersonPersistent.class and run the application. 

If everything is going well, you see a successful console message and it says Person table has been created in localhost:/3036/testdb database.

So, Now open your mysql workbench or Command Line tool and execute the following commad. 

use testdb;
select * from student;
And you see the folloing person table with data.

<Code code={`
mysql> use testdb;
Database changed
mysql> select * from person;
+------+------+------------+-----------+
| p_id | first_name | last_name | age  |
+------+------+------------+-----------+
|  101 |  Shakil     | Ahmed     | 24  |
|  102 |  Zakir      | Hossain   | 50  |
|  103 |  Abdul      | Wahed     | 35  |
+------+------+------------+-----------+
5 rows in set (0.00 sec)

`}/>

Here,  person is the table name. 
p_id is the primary key of this table.
first_name, last_name and age are the column names of this table.

Oh! So it means, you have successfully created your first JPA based application. 

If you are interested you can dive into the following topics-

-----

<h2>Read More</h2>
{jpa1}