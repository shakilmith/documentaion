## Jpa mapped super class

When we need to generate a parent child relationship in jpa but don't want to make the parent class as database table or persitent class then we can use mapped-super-class. 

The mapped-super-class I mean parent class should be annotated by @MappedSuperClass annotaion and it should not be an entity. The role of this class only provides it's attributes and methods to the child class.

Let's demonstrate the concept of mapped-super-class.

Step 1: Create a maven project and add the following dependencies in your pom.xml file.

```js
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
```

We added here, jpa (3.1.0) and hibernate for jpa implementation. You can use alternative implementaion as well like eclipse-link. Also you can see we have added mysql as a database system.

Note: If you don't know how to create a maven project, please refer this link:
If you don't have mysql installed. Check this tutorail how to install mysql community addition in your system.

Step 2: In your com.javaondemand package, create model and dao folder. 

Step 3: Then in your com.javaondemand.model package, create Employee.java mapped-super-class and it will be our parent class and it shares it's attributes and methods with the child class. It is not an entity, so there is no need to mark it by @Entity annotation.


```js

package com.javaondemand.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Employee {
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```

Step 4: Create RegularEmployee.java and IrRegularEmployee.java entity class in src/main/java/com/javaondemand package. 

RegularEmployee.java entity class:

```js
package com.javaondemand.model;

import jakarta.persistence.*;

@Entity
@Table(name = "regular_employee")
public class RegularEmployee extends Employee {
    @Id
    private int id;
    private String role;
    private int bonus;

    public RegularEmployee() {
        super();
    }

    public RegularEmployee(int id, String role, int bonus) {
        this.id = id;
        this.role = role;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}

```

Code Description: Here RegularEmployee class extends the Employee class and it has it's own attributes. As this class is an entity so, we marked it by @Entity annotation.

IrRegularEmployee.java entity class:

```js
package com.javaondemand.model;

import jakarta.persistence.*;

@Entity
@Table(name = "irregular_employee")
public class IrRegularEmployee extends Employee {
    @Id
    private int id;
    private String role;

    public IrRegularEmployee() {
        super();
    }

    public IrRegularEmployee(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public IrRegularEmployee(String name, int id, String role) {
        super(name);
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

```

Code Description: Here IrRegularEmployee class extends the Employee class and it has it's own attributes. As this class is an entity so, we marked it by @Entity annotation.

Step 5: Create a dao package in src/main/java/com/javaondemand and then create DemoPersisten.java class in it.

DemoPersistent.java class: 

```js
package com.javaondemand.dao;

import com.javaondemand.model.Employee;
import com.javaondemand.model.IrRegularEmployee;
import com.javaondemand.model.RegularEmployee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DemoPersistent {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();

        RegularEmployee r_emp1 = new RegularEmployee();
        RegularEmployee r_emp2 = new RegularEmployee();

        //Add data
        r_emp1.setId(101);
        r_emp1.setName("Shakil Ahmed");
        r_emp1.setRole("Java Developer");
        r_emp1.setBonus(200);

        r_emp2.setId(102);
        r_emp2.setName("Mark Smith");
        r_emp2.setRole("Python Developer");
        r_emp2.setBonus(200);

        //Ir-regular-employee
        IrRegularEmployee ir_emp1 = new IrRegularEmployee();
        IrRegularEmployee ir_emp2 = new IrRegularEmployee();

        //Add data
        ir_emp1.setId(103);
        ir_emp1.setName("Rebeka Jesmin");
        ir_emp1.setRole("Help r_emp1 to code review");

        ir_emp2.setId(104);
        ir_emp2.setName("Vlad Smith");
        ir_emp2.setRole("Help r_emp2 to code review");

        //persist the data to database
        em.persist(r_emp1);
        em.persist(r_emp2);

        em.persist(ir_emp1);
        em.persist(ir_emp2);



        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```

Code Description: We create here RegularEmployee and IrRegularEmployee object and set relevant data and persist them to database. Don't forget to close the transection.

Step 6: Map your entities and database related informations in your persistence.xml file. 
The persistence.xml file should be located src/main/resources/META-INF folder.

persistence.xml file:

```js
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">

    <persistence-unit name ="default">

       <class>com.javaondemand.model.Employee</class>
        <class>com.javaondemand.model.RegularEmployee</class>
        <class>com.javaondemand.model.IrRegularEmployee</class>

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
```

Code Description: (Will be added soon)


Note: After creating all the folders and files, your files structure should be like this: 

//image 

Step 7: Now open your DemoPersistent.java class and run it. After running the DemoPersistent.java class you should get the following console message.

```js
Hibernate: 
    
    drop table if exists `irregular-employee`
Aug 31, 2023 12:21:50 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@75babb67] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    drop table if exists `regular-employee`
Hibernate: 
    
    create table `irregular-employee` (
       id integer not null,
        name varchar(255),
        role varchar(255),
        primary key (id)
    ) engine=InnoDB
Aug 31, 2023 12:21:50 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@3667faa8] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    create table `regular_employee` (
       id integer not null,
        name varchar(255),
        bonus integer not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB
Aug 31, 2023 12:21:50 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate: 
    insert 
    into
        `
        regular_employee` (
            bonus, name, role, id
        ) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        `
        regular-employee` (
            bonus, name, role, id
        ) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        `
        irregular-employee` (
            name, role, id
        ) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        `
        irregular-employee` (
            name, role, id
        ) 
    values
        (?, ?, ?)
Aug 31, 2023 12:21:51 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/testdb]

Process finished with exit code 0

```

It means in our database, two tables are generated, regular_employee and irregular_employee.

Step 8: Open your mysql CommandLine Tool and run the folliwng commans and you get the following output. 

```sql
mysql> use testdb;
Database changed
mysql> select * from regular_employee;
+-----+--------------+-------+------------------+
| id  | name         | bonus | role             |
+-----+--------------+-------+------------------+
| 101 | Shakil Ahmed |   200 | Java Developer   |
| 102 | Mark Smith   |   200 | Python Developer |
+-----+--------------+-------+------------------+
2 rows in set (0.00 sec)

mysql> select * from irregular_employee;
+-----+---------------+----------------------------+
| id  | name          | role                       |
+-----+---------------+----------------------------+
| 103 | Rebeka Jesmin | Help r_emp1 to code review |
| 104 | Vlad Smith    | Help r_emp2 to code review |
+-----+---------------+----------------------------+
2 rows in set (0.00 sec)

mysql>
```

Here notable thing is that, the Employee class just share name property with the RegularEmployee and IrRegularEmployee entity class and it is not an entity itself. We just mark it by @MappedSuperClass annotaion and there is not need to use @Entity/@Table annotaion here. 
The mapped-super-class can be concrete class or abstract class. 

