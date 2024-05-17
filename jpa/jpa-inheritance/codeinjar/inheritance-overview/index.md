# JPA Inheritance Overview

In jpa, when there are relationships between entities and parent or root entity share it's attributes amongst it's child entities then we use JPA inheritance strategies.

JPA provides three strategies to share parent entity attributes to it's child entities. Such as,

**Single Table Strategy**: Only one table is generated in this strategy. And, all the attributes will reside in this table. It is required to annotate the parent or root entity by **@Inheritance(strategy = InheritanceType.SINGLE_TABLE) annotation**.

**Joined Table Strategy**: Separate tables will be generated for each entity. And the attributes will reside in respective table. Such as, parent table attributes will reside in the parent table vice versa. Also note that, it is required to annotate the parent or root entity by **@Inheritance(strategy = InheritanceType.JOINED) annotation**.

**Table Per Class Strategy**: In this strategy, tables are generated only for the child entities not the root or parent entity. Also note that, it is required to annotate the parent or root entity by **@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) annotation**.

Note: One thing always remember that, you can only have one primary key that is reside in the parent entity. That means, you can't annotate your child entities by @Id annotation. Also note that, there is no need to annotate your child entities by @Table annotation to externally provide the table name when you use **Single_table** inheritance strategy, as one table will be generated in this strategy. Another thing I should mention here, the inheritance strategy annotation (like: @Inheritance(strategy = InheritanceType.SINGLE_TABLE) ) should be reside in the parent entity only.


Additional note: @DiscriminatorColumn (used in parent entity) and @DiscriminatorValue (used in children side) can be used to define the column name and it's value that will be persisted in the linked column in the database. If you don't use these annotations then, an extra column will be generated and that name is DTYPE. At the end of this tutorial, I explain this. 



Let's look over a simple example application, that describes more about each jpa inheritance strategy.



## JPA Inheritance Strategies

Let's say we have three entities those make parent, child relationships. Guess that, we have three entities - Developer (root or parent entity), FrontendDeveloper, BackendDeveloper. Here Developer is the parent entity (contains id property or primary key) and FrontendDeveloper and BackendDeveloper are the child entities.

Note: Child entities can't have id property or can't be defined by @Id annotation. 



**Developer.java** (parent entity; thus @Id annotation is used)

```
package com.company.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Developer")
@Table(name = "developer")
public class Developer {
    @Id
    private int id;
    private String name;
    private String role;

    public Developer() {
    }

    public Developer(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
```

**FrontendDeveloper.java** (child entity; thus no @Id annotation is used)

```
package com.company.model;

import jakarta.persistence.Entity;

@Entity
public class FrontendDeveloper extends Developer{
    private int salary;

    public FrontendDeveloper() {
    }

    //constructors, getter and setter methods
}
```


**BackendDeveloper** (child entity; thus no @Id annotation is used)

```
package com.company.model;

import jakarta.persistence.Entity;

@Entity
public class BackendDeveloper extends Developer {

    private int experience;
    private int salary;
    private int bonus;

    public BackendDeveloper() {
    }

    //constructors, getter and setter methods
}
```

Here, in the **Developer.java** entity class we have defined few properties those are shared (used) across FrontendDeveloper and BackendDeveloper entities. **Note that**, here **Developer** is the parent entity thus, we have used the **@Id** annotation in this entity class. And there is need to use **@Id** annotation in the child entities (though it is not possible).


## Now Map the Entity classes and Database Configuration

So, open **persistence.xml** file and map the entity classes and database configurations. As we have used mySQL as a database, so we have used mysql specific database configurations. Also note that, there is mysql driver in your class-path (**pom.xml** file).


**persistence.xml** (located in resources/META-INF folder)

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">

    <persistence-unit name ="default">

        <!--Register the Developer, FrontendDeveloper, BackendDeveloper entities-->
        <class>com.company.model.Developer</class>
        <class>com.company.model.FrontendDeveloper</class>
        <class>com.company.model.BackendDeveloper</class>



        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/testdb"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="root"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```


## Create a Persistence Class

Let's create a simple persistence class to handle database operations, such as saving entities or retrieving entities (records of any table) from database.



**DeveloperPersistent.java**

```
package com.company.dao;

import com.company.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class DeveloperPersistent {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); //it will start the transaction

        //create few objects of child entities
        FrontendDeveloper f1 = new FrontendDeveloper(101, "Shakil Ahmed", "JavaScript Developer", 700);
        FrontendDeveloper f2 = new FrontendDeveloper(102, "Mark Smith", "UI/UX designer", 900);

        BackendDeveloper b1 = new BackendDeveloper(103, "Selena Gomez", "Java Developer", 3, 1200, 100);
        BackendDeveloper b2 = new BackendDeveloper(104, "Don Roger", "Rust Developer", 5, 1500, 300);

        //using entity-manager persist method to save the entity objects
        entityManager.persist(f1);
        entityManager.persist(f2);
        entityManager.persist(b1);
        entityManager.persist(b2);


        entityManager.getTransaction().commit(); //it will commit the transaction
        entityManager.close();
        entityManagerFactory.close();
    }
}
```


Okay, before running this file, we have to customize or determine few things - as Developer entity shares it's attributes amongst the child entities, thus we have to determine which JPA specific inheritance strategy we will use here. Let's say, we will go through all the inheritance strategies that JPA provides - such as, **Single_table** strategy, **joined_table** strategy and **table_per_class** strategy.



## Single Table Inheritance Strategy

We previously talk that, in a single table inheritance, single or one table is generated for all the entities. Means, all the attributes either parent class or child class will reside in a single table in the relational database.

So, open **Developer.java** entity class (in our case, it is the parent entity) and write this inheritance strategy after the **@Entity** annotation.


**Developer.java**

```
@Entity(name = "Developer")
@Table(name = "developer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class Developer {
    //rest of the codes will remain same
}
```

And now run the **DeveloperPersistent.java** class (you probably have to open this file) and you see in the console that, a single table has been generated and it's name is developer.

```
create table developer (
    DTYPE varchar(31) not null,
    id integer not null,
    name varchar(255),
    role varchar(255),
    bonus integer,
    experience integer,
    salary integer,
    primary key (id)
) engine=InnoDB
```


Let's open you mysql CommandLine tool and check that, data really has been persisted or not.

```
mysql> use testdb;
Database changed
mysql> SELECT * FROM developer;
+-------------------+-----+--------------+----------------------+-------+------------+--------+
| DTYPE             | id  | name         | role                 | bonus | experience | salary |
+-------------------+-----+--------------+----------------------+-------+------------+--------+
| FrontendDeveloper | 101 | Shakil Ahmed | JavaScript Developer |  NULL |       NULL |    700 |
| FrontendDeveloper | 102 | Mark Smith   | UI/UX designer       |  NULL |       NULL |    900 |
| BackendDeveloper  | 103 | Selena Gomez | Java Developer       |   100 |          3 |   1200 |
| BackendDeveloper  | 104 | Don Roger    | Rust Developer       |   300 |          5 |   1500 |
+-------------------+-----+--------------+----------------------+-------+------------+--------+
4 rows in set (0.00 sec)
```

Okay, we have successfully persisted data to our relational database. And you can see, all the attributes value (child entities) reside in a single table. But what if you use different strategy than single_table strategy?


## JPA Joined Table Strategy

Earlier in this tutorial, we have described that when we use **joined_table** strategy, individual tables will be created for each entity with respective data. As we have three entities, one is parent entity and the rest two are child entities. Thus, if we use **joined_table** strategy three tables will be generated.


So, open your root entity class, in our case **Developer.java** and remove the the **single_table** strategy and write the **joined_table** strategy.

**Developer.java**

```
@Entity(name = "Developer")
@Table(name = "developer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Developer {

    //rest of the codes will remain same
}
```



If you now run the **DeveloperPersistent.java** persistence class again, you will see three tables are generated in our database. Look at the console please;

```
create table developer (
    id integer not null,
    name varchar(255),
    role varchar(255),
     primary key (id)
) engine=InnoDB

create table frontend_developer (
    bonus integer not null,
    experience integer not null,
    salary integer not null,
    id integer not null,
    primary key (id)
) engine=InnoDB


create table frontend_developer (
    salary integer not null,
    id integer not null,
    primary key (id)
) engine=InnoDB

```

**Note:** Now we can use **@Table** annotation to externally name our child entities table name, but in a **single_table** strategy it is not possible as only one table is created for that strategy. So, for maintainable purposes, we have used @Table annotation in the child entities and name the tables.

**Note:** If you don't set the table name externally then, the entity name will be the table name when you use jpa.


```
//for FrontendDeveloper.java
@Table(name = "frontend_developer")

//for BackendDeveloper.java
@Table(name = "backend_developer")
```



So, here three tables are created in our relational database. Such as, developer, frontend_developer and backend_developer. Now, open your mysql commandLine tool and see really our data has been persisted or not.


```
mysql> use testdb;
Database changed
mysql> SELECT * FROM developer;
+-----+--------------+----------------------+
| id  | name         | role                 |
+-----+--------------+----------------------+
| 101 | Shakil Ahmed | JavaScript Developer |
| 102 | Mark Smith   | UI/UX designer       |
| 103 | Selena Gomez | Java Developer       |
| 104 | Don Roger    | Rust Developer       |
+-----+--------------+----------------------+
4 rows in set (0.00 sec)

mysql> SELECT * FROM frontend_developer;
+--------+-----+
| salary | id  |
+--------+-----+
|    700 | 101 |
|    900 | 102 |
+--------+-----+
2 rows in set (0.00 sec)

mysql> SELECT * FROM backend_developer;
+-------+------------+--------+-----+
| bonus | experience | salary | id  |
+-------+------------+--------+-----+
|   100 |          3 |   1200 | 103 |
|   300 |          5 |   1500 | 104 |
+-------+------------+--------+-----+
2 rows in set (0.00 sec)
```

Okay, we have successfully persisted our data in our relational database. But, you might be wondered that though we didn't use @Id annotation and don't have id property in our child entities yet, the child entity tables, contain the id (primary key) column. Then how? Basically, this is not a primary key, it is a foreign key of the child entity tables, that also refers that which data is related to which developer. But remember that, you can't use @Id annotation or you can't have primary key for your child entities. There is only one primary key or @Id annotation can be used, that will reside in the parent entity side - in our case, the Developer entity.


## JPA Table Per Class Strategy

In this approach, tables are generated for each child entity, not the parent entity. So, open your **Developer.java** parent entity class, and use the table_per_class inheritance strategy than the rest two.

```
@Entity(name = "Developer")
@Table(name = "developer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Developer{
    
    //rest of the code blocks
}
```

If  you now run the **DeveloperPersistent.java** persistence class class, in the console you will see there are two tables have been generated in your mysql database.

**Note:** If you get any error message in you console, you probably have to remove all the tables generated previously, and then restart your application.


```
create table backend_developer (
    id integer not null,
    name varchar(255),
    role varchar(255),
    bonus integer not null,
    experience integer not null,
    salary integer not null,
    primary key (id)
) engine=InnoDB

create table frontend_developer (
    id integer not null,
    name varchar(255),
    role varchar(255),
    salary integer not null,
    primary key (id)
) engine=InnoDB
```

**Note:** Though, there is a possibility to have a developer table in your database, but that will be an empty table.


So, tables data will be be persisted in the child or concrete tables.


```
mysql> use testdb;
Database changed
mysql> SELECT * FROM frontend_developer;
+-----+--------------+----------------------+--------+
| id  | name         | role                 | salary |
+-----+--------------+----------------------+--------+
| 101 | Shakil Ahmed | JavaScript Developer |    700 |
| 102 | Mark Smith   | UI/UX designer       |    900 |
+-----+--------------+----------------------+--------+
2 rows in set (0.00 sec)

mysql> SELECT * FROM backend_developer;
+-----+--------------+----------------+-------+------------+--------+
| id  | name         | role           | bonus | experience | salary |
+-----+--------------+----------------+-------+------------+--------+
| 103 | Selena Gomez | Java Developer |   100 |          3 |   1200 |
| 104 | Don Roger    | Rust Developer |   300 |          5 |   1500 |
+-----+--------------+----------------+-------+------------+--------+
2 rows in set (0.00 sec)
```


## Using DiscriminatorColumn and DiscriminatorValue Annotation

In a **single_table** and **joined_table** strategy, we can use **@DiscriminatorColumn** and **@DiscriminatorValue** annotations, to define the column and value in a respective order.


**@DiscriminatorColumn**: It is defined the name of the column that will link a database table row to a class. Remember the DTYPE, we saw in a single table strategy. If we use it, then DTYPE will be replaced by a useful name.


**@DiscriminatorValue**: It is used to set the value to be persisted in the column defined in the annotation **@DiscriminatorColumn**.

Let's see the use of  **@DiscriminatorColumn** and **@DiscriminatorValue** annotation in our first example, means in a **single_table** strategy.


**Developer.java**

```
@Entity(name = "Developer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "developer")
public class Developer {
    //rest of the code block
}
```

**FrontendDeveloper.java**

```
@Entity(name = "FrontendDeveloper")
@DiscriminatorValue("frontend_developer")
public class FrontendDeveloper extends Developer{
    //rest of the code block
}
```

**BackendDeveloper.java**

```
@Entity(name = "BackendDeveloper")
@DiscriminatorValue("backend_developer")
public class BackendDeveloper extends Developer {
    //rest of the code block
}
```

As, in a **single_table** strategy, one table is created and that will only be root table, so if you now open mysql commandLine tool and write the following select command you can see how the @DiscriminatorColumn and @DiscriminatorValue have been persisted or used.


```
mysql> SELECT * FROM developer;
+-----+--------------+----------------------+--------------------+-------+------------+--------+
| id  | name         | role                 | developer          | bonus | experience | salary |
+-----+--------------+----------------------+--------------------+-------+------------+--------+
| 101 | Shakil Ahmed | JavaScript Developer | frontend_developer |  NULL |       NULL |    700 |
| 102 | Mark Smith   | UI/UX designer       | frontend_developer |  NULL |       NULL |    900 |
| 103 | Selena Gomez | Java Developer       | backend_developer  |   100 |          3 |   1200 |
| 104 | Don Roger    | Rust Developer       | backend_developer  |   300 |          5 |   1500 |
+-----+--------------+----------------------+--------------------+-------+------------+--------+
```

Here if you look at the developer column and it's value, you can guess, how the **@DiscriminatorColumn** and **@DiscriminatorValue** annotation has been used.



**Note:** You can only use, **@DiscriminatorColumn** and **@DiscriminatorValue** annotation in the **single_table** and **joined_table** inheritance strategy. There is no need to use these in the **table_per_class** strategy.



Another thing to recall here, in a **@DiscriminatorColumn** definition, we can also set the type of the value of **@DiscriminatorValue** (either int or string). By default values are string or text based but if you want to numeric, then you have to use an extra attribute called, **discriminatorType = DiscriminatorType.INTEGER** in the @DiscriminatorColumn annotation. Such as,


```
@DiscriminatorColumn(name = "developer", discriminatorType = DiscriminatorType.INTEGER) 

//now the @DiscriminatorValue annotation should change
@DiscriminatorValue(1) //instead of string value, we have to use now numeric value.
```


Thanks for reading this article.

