
In this tutorial, we are going to explore how to use embedded objects (a class that is not entity itself) in jpa.

Suppose, we hasve an employee entity and it has properties like emp_id, emp_name, and address information (country, city, street_address, house_numbere, house_colour, zip_code). And we have another person enitty class that have the same Address information.

So, instead of writing the same address property on the class the entity class we can create an Address object (embedded object) and use the Address object in the entity. But here, the embedded object is'st entity itself. 

Let's create a simple maven project and add the followoing dependencies in your pom.xml file

<Code code={`
   <dependency>
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
`}/>


Here we use, jakarte.persistence-api 3.1.0 and hibernate-core as implementaion. 
Also we use mysql as database. 

After successfully creating maven project let's see how we can use emebedded objects in our entity model.

Step 1: First of all, create an entity class Employee.java in src/main/java/com/javaondemand/model pacakge. The Employee.java class contains employee id, name, role and Address as embedded object type. In step 2 we can see the address table. 


<Code code={`
package com.javaondemand.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id

    private int id;
    private String name;
    private String role;

    @Embedded
    private Address address;

    public Employee() {
        super();
    }

    public Employee(int id, String name, String role, Address address) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
`}/>


As, the Employee.java class is the entity class that's why we use @Entity annotaion on the class level. Notice that, we refer the Address embedded object and use the @Embedded annotaion. Now all the Addrees properties will be the property I mean column name of the Employee table.



Step 2: Create an Address.java (Embeddable class) in src/main/java/com/javaondemand/model package and it contains city, street_address, house_number and zip_code as attrubutes.


<Code code={`
package com.javaondemand.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "city")
    private String city;
    @Column(name = "street_address")
    private String street_address;
    @Column(name = "house_number")
    private String house_number;
    @Column(name = "zip_code")
    private int zip_code;

    public Address() {
    }

    public Address(String city, String street_address, String house_number, int zip_code) {
        this.city = city;
        this.street_address = street_address;
        this.house_number = house_number;
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }
}
`}/>


Here, we annotate the Address.java class by @Embeddable annotaion and it will treat as embedded object and can be used multiple entities. (For our case in Employee entity)


Step 3: Now map the database and entity class information in the persistence.xml file. If you just create a fresh maven project than probably you don't have that file. Create a resources folder in src/main package or directory and then inside the resources folder create META-INF Folder. Then inside the META-INF folder create persistence.xml file. 
So, your persistence.xml file should be located in src/main/resources/META-INF folder. 

Note: Here, directory, folder or package is the same thing. 

The persistence.xml file should contains the following configurations.

<Code code={`
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">

    <persistence-unit name ="default">

       <class>com.javaondemand.model.Employee</class>
        <class>com.javaondemand.model.Address</class>

        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/testdb"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="root"/>
            <property name="hibernate.hbm2ddl.auto" value="create"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>

`}/>


Here, we provide database information inside the properties and map the entity clsss inside te persistence-unite. The peristence-unite name will be required in EnityManagerFactory in the dbpersistent.java class

Step 4: Now create a dao package in com/javaondemand folder and then inside this folder create a persistence class called EmployeePersistent.java 

In this class we make our database operation.

<Code code={`
package com.javaondemand.dbpersistent;

import com.javaondemand.model.Address;
import com.javaondemand.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeePersistent {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();

        //create Address data
        Address address1 = new Address("El Alto", "Street X", "70-A", 3030);
        Address address2 = new Address("Effonn Alaiya", "Street Y", "80-A", 7070);

        Employee employee1 = new Employee(101, "Shakil Ahmed", "Java Developer", address1);
        Employee employee2 = new Employee(102, "Mark Smith", "Frontend Developer", address2);

        //persist of save the employee details to database
        em.persist(employee1);
        em.persist(employee2);

        //Should we persist Address too?:- No. As this is not an entity itself


        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
`}/>


After creating few employess we call the entity-manager persist method and to save our employee details to the databse. 

Step 5: Run the EmployeePersistent.java class and you definately see the following console message if everything is going well. Remember we use hibernate as a jpa implementaion.

<Code code={`
Hibernate: 
    
    drop table if exists employee
Aug 29, 2023 3:54:31 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@60c1663c] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    create table employee (
       id integer not null,
        city varchar(255),
        house_number varchar(255),
        street_address varchar(255),
        zip_code integer,
        name varchar(255),
        role varchar(255),
        primary key (id)
    ) engine=InnoDB
Aug 29, 2023 3:54:31 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@3178219a] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Aug 29, 2023 3:54:31 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate: 
    insert 
    into
        employee
        (city, house_number, street_address, zip_code, name, role, id) 
    values
        (?, ?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        employee
        (city, house_number, street_address, zip_code, name, role, id) 
    values
        (?, ?, ?, ?, ?, ?, ?)
Aug 29, 2023 3:54:31 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/testdb]

`}/>


It shows that, employee table has been created in the testdb database with relevent properties including the Address embedded object properties.

Step 6: Open your mysql workbench or CommandLine Tool and type the following commands

<Code code={`
mysql> use testdb;
Database changed
mysql> select * from employee;

//following output you will get 

+-----+---------------+--------------+----------------+----------+--------------+--------------------+
| id  | city          | house_number | street_address | zip_code | name         | role               |
+-----+---------------+--------------+----------------+----------+--------------+--------------------+
| 101 | El Alto       | 70-A         | Street X       |     3030 | Shakil Ahmed | Java Developer     |
| 102 | Effonn Alaiya | 80-A         | Street Y       |     7070 | Mark Smith   | Frontend Developer |
+-----+---------------+--------------+----------------+----------+--------------+--------------------+
2 rows in set (0.00 sec)

mysql>
`}/>


Note: You may have to use password for authenticate your mysql CommandLine Tool.

Anyway, you see we have now employee address details in the employee table. 

Here, the benefits of using embedded object is that we can also use the same embedded object to other entities if it is required. Also remember the embedded class is not entity itself, it is just a class that helps to organize database table more softly. All the attributes of embedded class (like Address class) will be the attributes of Employee entity class here.


Note: If you don't know how to create maven based JPA application please check out this tutorial

//How to create your first jpa application

-----

<h2>Read More</h2>
{jpa1}