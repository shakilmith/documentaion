# JPA finding an entity

JPA entity-manager contains find method that helps to find data or entity records easily. 
Let's follow the below stpes to find database data and print them to console.


Let's say we have the folloing Person table in mysql workbench.

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

For finding this data, we have to create an entity class called Person.java that must contains id, first_name, last_name and age as properties. Note, column name must be the same of the database table but property name can be different. Also note, when we call data we basically use property name than column naem.

1. Create an entity class called Person.java in com.company package and we annotate it by @Entity annotaion as usual.
It contains id, first_name, last_name and age properties. The property name eventually will be tha column name of your person table.

```java

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
3. Provide your database information and map the Person entity class in persistence.xml file which is located in src/main/resources/META-INF folder. If you don't already have those folder structure in your project, kindly create those and then, create persistence.xml file.

```xml

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

```

4. Create a persitence class called FindPerson under com.company package.

```java 

package com.company;

import com.company.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindPerson {

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
Here you see, we print the Person first_name, and last_name in the console by calling it's gettr method. Also note that, we specify the person id to find the specific person records from the database.

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