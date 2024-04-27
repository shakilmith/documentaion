
Sometitmes it is required  to map a list of values to an entity but those values aren't entity.

Note:  Remember we use one-to-many/many-to-many mapping hierarchy while making collection valued association between entities.

Like a person has many dogs, email addresses, social media accounts, an Employee has list of roles, an Author published list of books and an Owner has list of cars etc. Here, We are going to demonstrate this scenario for the person entity. 

Imagine we have person entity class and the has list of cars. 

So, let's create a simple jpa application. We use maven as a build tool. 

//Check out how to create a simple jpa project.

After successfully creating the jpa project let's follow the below steps.

Step 1: Create a Person.java enttiy class in the src/main/java/com/javaondemand/model folder. The Person entity class contains the following properties. 
person_id, person_name, list of cars(String variables).

We have to use here @ElementCollection annotaion and an optional @CollectionTable(name="name_of_the_column") annotaion. If you don't use the @CollectionTable annotaion and provide the column name externally, then entity_attirbute-name will be the column name by default. 

<Code code={`
package com.javaondemand.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    private int id;
    private String name;

    @ElementCollection
    @CollectionTable(name = "person_has_cars")
    //this annotation determines in which table the cars information will be persisted
    //if you don't use the @CollectionTable annotation then the table name will be 
    // person_cars (entityName_variableName)
    private List<String> cars;

    //no-arg constructor and getter-setter methods

    public Person() {
        super();
    }

    public Person(int id, String name, List<String> cars) {
        this.id = id;
        this.name = name;
        this.cars = cars;
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

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }
}
`}/>


Step 2: Create PersonPersistent.java class under src/main/java/com/javaondemand/dao package. If you don't have dao package just create a dao package in com.javaondemand package.

The PersonPersistent.java class will be like this.

<Code code={`
package com.javaondemand.dao;

import com.javaondemand.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;


public class PersonPersistent {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Create List of cars, String type
        List<String> cars = new ArrayList<>();
        cars.add("Car A");
        cars.add("Car B");

        //Create 2 person and persist them to database
        Person p1 = new Person(101, "Shakil Ahmed", cars);
        Person p2 = new Person(102, "Mark Smith", cars);

        //persist the person objects
        entityManager.persist(p1);
        entityManager.persist(p2);

       //Should we persist the cars object too? No:- Because it is not entity.



        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
`}/>


Note: Please don't forget to close the transaction.

Step 3: Run the PersonPersistent.java class and it will create two tables in your mysql database with the relevant data. One is person table and another is person_has_cars table. The person_has_cars table contains person_id and cars column.

<Code code={`
mysql> use testdb;
Database changed
mysql> select * from person;
+-----+--------------+
| id  | name         |
+-----+--------------+
| 101 | Shakil Ahmed |
| 102 | Mark Smith   |
+-----+--------------+
2 rows in set (0.00 sec)

mysql> select * from person_has_cars;
+-----------+-------+
| Person_id | cars  |
+-----------+-------+
|       101 | Car A |
|       101 | Car B |
|       102 | Car A |
|       102 | Car B |
+-----------+-------+
4 rows in set (0.00 sec)

mysql>
`}/>


You can see, the person_has_cars table has a forein key (constraint) person_id. You can easily recognize which person has which cars by it's id.

# What if we want to map list of values for objects type not simple Attribute like String, int etc. 

Let's say, the person has many list of branded cars. And we want to create a class that shows the brand names. 

Then, we  create CarBrands.java class in the model package and it contains the following properties. But the CarBrands.java class isn't the entity itself.

<Code code={`
package com.javaondemand.model;

import jakarta.persistence.Embeddable;

@Embeddable //as it is a embedded class; not an entity
public class CarBrands {
    @Column(name = "brand_name")
    private String name;

    public CarBrands() {
        super();
    }

    public CarBrands(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBrand_name(String name) {
        this.name = name;
    }
}
`}/>


Now just, add the following lines in your Person.java entity class. 

<Code code={`
@ElementCollection(targetClass = CarBrands.class)
//we use targetClass parameter for referring the CarBrands class
@Embedded
private List<CarBrands> brands;

//getter and setter methods
`}/>



Also update the PersonPersistent.java class.

<Code code={`
//Create list of CarBrands objects
List<CarBrands> brandsList = List.of(new CarBrands("Ford"), new CarBrands("Fiat"), new CarBrands("Maruti"));

//then
//set the car_brands to each person
p1.setBrands(brandsList);
p2.setBrands(brandsList);

`}/>

You see now, a new table has been generated in your mysql workbench. And it is person_brands. You can aslo use @CollectionTable annotaion to provide the external name of the this table. Hence the output should be...

<Code code={`
mysql> select * from person_brands;
+-----------+--------------+
| Person_id | brand_name   |
+-----------+--------------+
|       101 | Ford         |
|       101 | Fiat         |
|       101 | Maruti       |
|       102 | Ford         |
|       102 | Fiat         |
|       102 | Maruti       |
+-----------+--------------+
6 rows in set (0.00 sec)

//But if you use @CollectionTable(name="car_brands")
//then you have to use following command but will get the same result

mysql> select * from car_brands;
+-----------+--------------+
| Person_id | brand_name   |
+-----------+--------------+
|       101 | Ford         |
|       101 | Fiat         |
|       101 | Maruti       |
|       102 | Ford         |
|       102 | Fiat         |
|       102 | Maruti       |
+-----------+--------------+
6 rows in set (0.00 sec)

mysql>
`}/>


# Is it possible to use Enum as a @ElementCollection? Yes, you can also use enum as a collection table. Any valid java type can be used as @ElementCollection
 
`{/* Links */}`


-------

<h2>Read More</h2>
{jpa1}
