# Using Embedded Object in your JPA Entity

Embedded objects are used to organize jpa entities when it is required to represent different reusable data in the same table. Like a student table has that has columns like student name, age, email_address, department etc. and address details (city, postal_code, street_number, house_number etc.). In this case, it will be a good approach to use embedded object in this entity table. 

**Note:** Embedded object isn't entity itself. It just helps to organize the entity table.


## Using Embedded Object

For demonstrating this approach, we will create two class. An entity class and we name it Person.java and an embeddable class (it is not entity itself).

**Person.java**

```
package com.company.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity(name = "Person")
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    @Embedded
    private Address address;

    public Person() {
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
```

And then the **Address** embeddable class will like

**Address.java**

```
package com.company.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity(name = "Person")
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    @Embedded
    private Address address;

    public Person() {
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
```

**Note:** The Address class should be annotated by @Embeddable annotation. It means this class will be used as an embedded object inside the Person entity class. Another thing to note that, all the properties of address class will be the property of Person class, but they resides in the embeddable class.

Then, create a **PersonPersistent.java** class to handle the database operation.

```
package com.company.dao;

import com.company.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class DemoPersistent {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();

        /*
         * Start from here
         */

        //create few address object
        Address a1 = new Address("West Benside", "34bAB", "45AF", "kA11 7LW");
        Address a2 = new Address("Dunnington", "39BC", "30LK", "YO252DA");
        Address a3 = new Address("Barton", "40CA", "45BK", "SG2 IE8");

        Person p1 = new Person("Mark Smith", 30, a1);
        Person p2 = new Person("Jakov Jenkov", 45, a2);
        Person p3 = new Person("Selena Gomez", 25, a3);

        //invoking persist method to save the person objects in the database
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
```

We first of all, create three addresses and then three person object and then persist or save them into the database by calling the <i>entity-manager</i> **persist()** method.

Just run the **PersonPersistent.java** class and if you look over your log messages you can see that in the person table there are 6 entries added.


```
create table person (
    id integer not null,
    city varchar(255),
    house_number varchar(255),
    street_number varchar(255),
    zip_code varchar(255),
    age integer not null,
    name varchar(255),
    primary key (id)
) engine=InnoDB
```

Now, open your mysql commandLine terminal and run the following commands.

```
mysql> use testdb;
Database changed
mysql> SELECT * FROM person;
```
You will get the following output.

![alt text](image1.png)

Hope, now you can guess the benefits of using embedded objects in your jpa entity. It is also possible to reuse the Address embeddable class in other entities when it is required.