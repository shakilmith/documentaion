
# JPA tablse_per_class strategy: 
    
    <Code code={`
     @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    `}/>
    

In this inheritance strategy, tables are generated for sub classess not for parent class.

Here, We have 3 entities named Developer, FrontendDeveler, BackendDeveloper. And, Develper is the parent entity in this inheritance relationship and FrontendDeveler, BackendDeveloper are the sub entities. 

Let's follow the below steps to achieve table_per_class strategy:


1. Create the the root enttiy class called Developer with subsequent properties. In the class level we privide inheritance type. 


<Code code={`
package com.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "developer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Developer {

    @Id
    private int id;
    private String name;
    private int experience;

    public Developer() {
    }

    public Developer(int id, String name, int experience) {
        this.id = id;
        this.name = name;
        this.experience = experience;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
`}/>



2. Then, create FrontendDeveloper entity class with the following properties. As the FrontendDeveloper is the subclass of Developer entity class, so it will inherit all the properties of Develpoer class behind the scene.


<Code code={`
package com.company;

import jakarta.persistence.Entity;

@Entity
public class FrontendDeveloper extends Developer { 

    private int salary;

    public FrontendDeveloper(){
        super();
    }

    public FrontendDeveloper(int salary) {
        this.salary = salary;
    }

    public FrontendDeveloper(int id, String name, int experience, String genre, int salary) {
        super(id, name, experience);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
`}/>



Here you can see, this enity doesn't have it's own primary key, that means it's a child entity. 

3. Create another entity class called BackendDeveloper in com.company package. It also contains salary, bonus as propeties and it will extend the Developer enity as well. And it doesn't have primary key or id like FrontendDeveloper.


<Code code={`
package com.company;

import jakarta.persistence.Entity;

@Entity
public class BackendDeveloper extends Developer {

    private int salary;
    private int bonus;

    public BackendDeveloper() {
        super();
    }

    public BackendDeveloper(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public BackendDeveloper(int id, String name, int experience, int salary, int bonus) {
        super(id, name, experience);

        this.salary = salary;
        this.bonus = bonus;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
`}/>



Here, we have extra property int bonus in the BackendDeveloper class.

4. Now create persistence.xml file under src/main/resources/META-INF folder. And map the entity classess and database information details there.

<Code code={`
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">

    <persistence-unit name ="default">

        <class>com.company.Developer</class>
        <class>com.company.FrontendDeveloper</class>
        <class>com.company.BackendDeveloper</class>

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

Here, persistence-unit name is "default" that we will refer in the persistent class.


5. Now create Persistent.java class in com.company package. In this class we will create entity objects and persist or save them to our mysql relational database. 


<Code code={`
package com.company;

import com.company.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Persistent {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();

        FrontendDeveloper fd1 = new FrontendDeveloper(101, "Zakir Hossain", 2, 800);
        FrontendDeveloper fd2 = new FrontendDeveloper(102, "Vlad Smith", 4, 1200);

        BackendDeveloper bd1 = new BackendDeveloper(104, "Abdul Wahed", 5, 2000, 500);
        BackendDeveloper bd2 = new BackendDeveloper(104, "Shakil Ahmed", 3, 1500, 200);
        
        em.persist(fd1);
        em.persist(fd2);
        
        em.persist(bd1);
        em.persist(bd2);
        
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
`}/>




6. Run the Persistence class called Persistent.java, and in your mysql workbench you will see tables are generated only for subclasses, not for root class with data In our case tables will be frontend_developer and backend_developer.

Open your mysql workbench you get the follwoing schema:

If you run: select * from frontend_developer;  


<Code code={`
mysql> select * from frontend_developer;
+-----+------------+---------------+--------+
| id  | experience | name          | salary |
+-----+------------+---------------+--------+
| 101 |          2 | Zakir Hossain |    800 |
| 102 |          4 | Vlad Smith    |   1200 |
+-----+------------+---------------+--------+
2 rows in set (0.00 sec)

mysql>
`}/>


And if you run: select * from backend_developer; you see the follwoing schema:


<Code code={`
mysql> select * from backend_developer;
+-----+------------+--------------+-------+--------+
| id  | experience | name         | bonus | salary |
+-----+------------+--------------+-------+--------+
| 104 |          5 | Abdul Wahed  |   500 |   2000 |
| 105 |          3 | Shakil Ahmed |   200 |   1500 |
+-----+------------+--------------+-------+--------+
2 rows in set (0.00 sec)

mysql>
`}/>



In coming post we will talk about the pros and cons of these 3 strategies. 

Talk soon,
Shakil Ahmed.


------

<h2>Read More</h2>
{jpa1}
