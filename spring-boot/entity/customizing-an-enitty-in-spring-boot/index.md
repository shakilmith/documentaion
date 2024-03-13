# Customizing an Entity Model in Spring Boot

In spring or spring boot projects, an entity is an object or data model that is a table of a database. And each properties of that entity are the column of the database table.

Here is a simple entity class that shows how we can create database dynamically.

```
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private LocalDate birthDate;

    //constructors
    //getter and setter methods
}
```

You can see, we have annotated our Person java class by @Entity annotation. This is a jakarta.persistence annotation. It ensures us that, this class is now a persistent object. 

One more thing must note, the entity has to have one primary key and it must be annotated by @Id annotation. Yes, it can be auto generated using @GeneratedValue(strategy = GenerationType.AUTO) annotation on the primary key property level.

Note: Make sure, in your classpath (for maven pom.xml file), spring data jpa dependency has been added already. 

Spring boot automatically do many hardcoded things for us. Here, the class name Person is the name of the table of our database. And each properties will be the column name. 

# How to Change the Default Behavior of an Entity Object.

Sometimes, the default feature will not meet up our requirements. Thus, we can override the default features of entity annotation. Like,


```
@Entity
@Table(name="person-details")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id", unique = true)
    private int id;

    @Column(name = "person_name", length = 255)
    private String name;

    @Column(name = "person_birthday", length = 50)
    private LocalDate birthDate;

    //constructors
    //getter and setter methods
}

```

In the class level, we use the @Table annotation, that defines our database table name. And the table name is set "person-details". Even, we have used @Column annotation for naming our column name and override default column names.

@Entity: Make a pojo java class to a persistent object. The java class name will be the database table name and each properties will be the column name of that table.

@Table: Set the table name and override the default behavior.

@Column: Set the column name (properties level) and other optional arguments can also be applied. Like, using length argument (default is 255).

@Id: Make the property as a primary key of the database table.

@GeneratedValue: Mechanism of primary key generation process of a database table.


There are lot of things can be applied in a simple entity class. But remember if you use spring data jpa, then, you can simply make a java class as a database table just using the @Entity annotation on the class level.


Hope, this simple post would be very helpful.


