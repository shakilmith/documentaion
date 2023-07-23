
# How to save, update, delete, find an entity object in jpa.

## JPA save, find, update and delete entity.
1. Save or inserting an entity.

Imagine we have Person entity and we want to save it to relational database with data. 
Follow the below steps to save Person entity data to database. 

1. Create a Person entity class in com.company package. Annotate this class with @Entity and @Table(name="person_details). This Person class contains 4 properties like person id (it will be the primary key of Person table), first_name, last_name and age. Annotate the id by @Id annotation. You can also use @Generated annotation on id to make the primary key auto generated. I omit this for the time being.

```java
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
    private int last_name;
    @Column(name = "age")
    private int age;

    public Person() {
    }

    public Person(int id, String first_name, int last_name, int age) {
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

    public int getLast_name() {
        return last_name;
    }

    public void setLast_name(int last_name) {
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

2. Create persistence.xml file in src/main/resources/META-INF folder to provide the necessary database inforamation and entity class. 

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
            <property name="hibernate.hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>
</persistence>
```
3. Create PersonPersistent class in com.company package and create five Person objects with data. Save them to database by entity-manager persist method.
Note: entity-manager constains several methods like persist(save), find, remove(delete), createQuery, createNamedQuery, flush, lock, refresh etc. methods to work with relational databases.

```java
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

```
Here you can see, we have created five Person objects and save them to tha database by calling entity-manager persist method. 
Note: It is necessary to start the transaction by calling  em.getTransaction().begin(); and close the transaction by calling  em.getTransaction().commit(); You alos have to close the entity-manager interface and it's factory methods. So, we call em.close and emf.close as well.

4. After run the PersonPersistent class, you will see the person table has been generated in your mysql workbench. (If everything is going well.)

```sql 
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

mysql>
```
Here, person is the table name. And p_id, first_name, last_name, age is the column name of person table. Also, p_id is the primary of this database table.


-----
# JPA finding an entity
JPA entity-manager contains find method that helps to find database database data easily. 
Let's follow the below stpes to find database data and print them to console.

1. Let's say we have the folloing Person table in mysql workbench.

```sql
+------+------+------------+-----------+
| p_id | first_name | last_name | age
+------+------+------------+-----------+
|  101 |  Shakil     | Ahmed     | 24  |
|  102 |  Zakir      | Hossain   | 50  |
|  103 |  Abdul      | Wahed     | 35  |
|  104 |  Ismail     | Haq       | 45  |
|  105 |  Vlad       | Smith     | 40  |
+------+------+------------+-----------+
```

For finding this data, we have to create an entity class called Person that must contains id, first_name, last_name and age as properties. Note, column name must be the same of the database table but property name can be different. Also note, when we call data we basically use property name than column naem. 
As we have already Person entity class so let's check out the next step. 

3. Create a persitence class called FindPerson under com.company package.

```java 
package com.company.dbpersistent;

import com.company.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DemoPersistent {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();
        //call the entity-manager find method to get the person data by it's id
        
        Person p = em.find(Person.class, 101);
        //print the peron data to console by calling getter method

        System.out.println(p.getFirst_name()+ " "+p.getLast_name());


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```
Here you see, we print the Person first_name, and last_name in the console by calling it's gettr method. Also note that, we specify the person id to find it from the database.

Here in the console you must see the person (101) first_name and last_name

```console
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Shakil Ahmed
Jul 19, 2023 12:00:42 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/testdb]
```

So, the question is, it is possible to find all the person data at a time and print them to the console? Yes, definately. We can use JPQL creatQuery method to get all the person data at a time. Otherwise, we can also get all the person data manually. 
kindly see the below code.

```java
package com.company.dbpersistent;

import com.company.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DemoPersistent {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();
        //call the entity-manager find method to get the person data by it's id

        Person p1 =em.find(Person.class, 101); //first person
        Person p2 =em.find(Person.class, 102); //second person
        Person p3 =em.find(Person.class, 103); //second person
        Person p4 =em.find(Person.class, 104); //second person
        Person p5 =em.find(Person.class, 105); //second person


        //Use getter method to print the all the person data

        System.out.print("p_id");
        System.out.print("\t first_name");
        System.out.print("\t \t last_name");
        System.out.print("\t \t \t age");
        System.out.println(" ");
        System.out.println(p1.getId()+"\t\t "+p1.getFirst_name()+"\t\t\t "+p1.getLast_name()+"\t\t\t\t "+p1.getAge());
        System.out.println(p2.getId()+"\t\t "+p2.getFirst_name()+"\t\t\t "+p2.getLast_name()+"\t\t\t\t "+p2.getAge());
        System.out.println(p3.getId()+"\t\t "+p3.getFirst_name()+"\t\t\t "+p3.getLast_name()+"\t\t\t\t "+p3.getAge());
        System.out.println(p4.getId()+"\t\t "+p4.getFirst_name()+"\t\t\t "+p4.getLast_name()+"\t\t\t\t "+p4.getAge());
        System.out.println(p5.getId()+"\t\t "+p5.getFirst_name()+"\t\t\t "+p5.getLast_name()+"\t\t\t\t "+p5.getAge());

        //It is a bit awkward, right? for loop or java stream() would be very helpful in this case.
        //Though barely you have to do this in production grade application
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```
You see in the console output like like the below then-
```consol

p_id	 first_name	 	 last_name	 	 	 age 
101		 Shakil			 Ahmed				 24
102		 Zakir			 Hossain			 50
103		 Abdul			 Wahed				 35
104		 Ismail			 Haq				 45
105		 Vlad			 Smith				 40
Jul 19, 2023 12:24:54 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/testdb]

Process finished with exit code 0
```

# JPA updating an entity.
Let's say we want to updata the person table data. 
First of all, we have to find the person data by it's id and then we have to set new values in it. Then we execute this operation (Run the class) and the person data will be changed or updated.

```java
  Person p5 = em.find(Person.class, 105);
  System.out.println("Before updating");
  System.out.println("Age was: "+p5.getAge());

  p5.setAge(47);
  System.out.println("After Updating");
  System.out.println("Now age is: "+p5.getAge());
```
In the console you see: 
```console
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Before updating
Age was: 40
After Updating
Now age is: 47
Jul 19, 2023 10:56:02 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/testdb]
```

## JPA removing an entity
Let's say we have the same table in our mysql workbench and we want to delete the last person id is 105

```sql
+------+------+------------+-----------+
| p_id | first_name | last_name | age
+------+------+------------+-----------+
|  101 |  Shakil     | Ahmed     | 24  |
|  102 |  Zakir      | Hossain   | 50  |
|  103 |  Abdul      | Wahed     | 35  |
|  104 |  Ismail     | Haq       | 45  |
|  105 |  Vlad       | Smith     | 40  |
+------+------+------------+-----------+
```
And we want to delete or remove the last row of person table. 
First of all we find the entity object through it's id. Then, we call the entity-manager remove method to delete this entity object or table row from the person table.

```java

Person p5 = em.find(Person.class, 105);
em.remove(p5);
        
```
Now if you open your mysql command line tool or workbench you see there is no row of id=105. Means the data has been deleted already.

```sql
+------+------+------------+-----------+
| p_id | age  | first_name | last_name |
+------+------+------------+-----------+
|  101 |   24 | Shakil     | Ahmed     |
|  102 |   50 | Zakir      | Hossain   |
|  103 |   35 | Abdul      | Wahed     |
|  104 |   45 | Ismail     | Haq       |
+------+------+------------+-----------+
```


