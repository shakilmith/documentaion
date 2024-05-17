
# JPA Single table strategy:
<Code code={`
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
`}/>


In single_table strategy, 1 table is generated with all the attributes of parent and child entities.

Here, We have 3 entities named Developer, FrontendDeveler, BackendDeveloper. And, Develper is the parent entity in this inheritance relationship and FrontendDeveler, BackendDeveloper are the sub entities. 

Note: Only paranet entity should have id (primary key) proerty. The child entity should not have their own id's. That's why below of this example project, you never see id propery in FrontendDeveloper and BackendDeveloper entity.

Let's follow the below steps to make Single Table relationship among entities.

1. Create Develper parent entity in com.company package. It has id, name, and experience properties. Also, we annotate the Developer entity class by @Entity annotaion. And as it is the parent or root enitty class of this relationship, that's why we annotate it by @Inheritance annotaion. 

<Code code={`
package com.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "developer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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


Here you see, we use @Inheritance(strategy = InheritanceType.SINGLE_TABLE) in the class level as we want to generate single_table reletaionship among entities. Alos note, There will be created only table wtih all the properties. 

2. Create FrontendDeveloper entity class that will extends Developer properties. It has it's own property salary and it will be inherited the properties of parent class Developer as well.

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


Note: In single table strategy, it is not possible to write table name by using @Table anootaion in child/sub classess. Even sub classess don't have thier own id's. 

4. Now create persistence.xml file under src/main/resources/META-INF folder. And map the entity classess and database information details there.

<Code code={`
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">

    <persistence-unit name ="default">

       <class>com.company.Employee</class>
        <class>com.company.ActiveEmployee</class>
        <class>com.company.RetiredEmployee</class>

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


Here you can see, we create 4 entity objects based on FrontendDeveloper and BackendDeveloper entity class. (No developer entity class.) And save them by calling entity-manager persist method. 

6. After running this application (Persistent class), in your mysql database 1 table will be generated called "employee". Open your mysql workbench and you see the following records. 

<Code code={`
mysql> select * from developer;
+-------------------+-----+------------+---------------+-------+--------+
| DTYPE             | id  | experience | name          | bonus | salary |
+-------------------+-----+------------+---------------+-------+--------+
| FrontendDeveloper | 101 |          2 | Zakir Hossain |  NULL |    800 |
| FrontendDeveloper | 102 |          4 | Vlad Smith    |  NULL |   1200 |
| BackendDeveloper  | 104 |          5 | Abdul Wahed   |   500 |   2000 |
| BackendDeveloper  | 105 |          3 | Shakil Ahmed  |   200 |   1500 |
+-------------------+-----+------------+---------------+-------+--------+
4 rows in set (0.00 sec)

mysql>
`}/>


You see, this executaion creates only one table called "developer" and it has all the properties of child entities. 



# JPA joined_table strategy: 

<Code code={`
@Inheritance(strategy = InheritanceType.JOINED)
`}/>

Joined table strategy: In this inheritance strategy, tables are generated for all entities belonging to the relationship. 

Now you can use @Table annotation externally for child entities but you are not allowed to use @Id annotation in the child entity, as child entity doesn't have their own primary key in any way.

So, let's make some changes in the parent entity class level. Instead of writing @Inheritance(strategy = InheritanceType.SINGLE_TABLE) we now write @Inheritance(strategy = InheritanceType.JOINED) inheritance strategy.

Let's run the Persistent class and see the differences in your mysql database. 

3 Tables will be generated for each entity. 
The tables are: developer, frontend_developer, backend_developer

If we run: select * from developer; We get the following output.

<Code code={`
mysql> select * from developer;
+-----+------------+---------------+
| id  | experience | name          |
+-----+------------+---------------+
| 101 |          2 | Zakir Hossain |
| 102 |          4 | Vlad Smith    |
| 104 |          5 | Abdul Wahed   |
| 105 |          3 | Shakil Ahmed  |
+-----+------------+---------------+
4 rows in set (0.00 sec)

mysql>
`}/>


If we run: select * from frontend_developer; 
We get the following output.

<Code code={`
mysql> select * from frontend_developer;
+--------+-----+
| salary | id  |
+--------+-----+
|    800 | 101 |
|   1200 | 102 |
+--------+-----+
2 rows in set (0.00 sec)

mysql>
`}/>

If we run: select * from backend_developer; 
We get the following output.

<Code code={`
mysql> select * from backenddeveloper;
+-------+--------+-----+
| bonus | salary | id  |
+-------+--------+-----+
|   500 |   2000 | 104 |
|   200 |   1500 | 105 |
+-------+--------+-----+
2 rows in set (0.00 sec)

mysql>
`}/>



Attention: You porbably have to delete the previous developer table from you database.
And please, use @Tanle annotaion to externally name of your entities. Otherwise by default the table name will be the entity name. 



# JPA table_per_class strategy:

```
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
```

In this inheritance strategy, tables are generated for sub classess not for parent class. 

Just open you parent class entity (in our case Developer.java) and use @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) annotaion in the class level. Though it will aslo create empty developer table. 


Run the Persistence class called Persistent.java, and in your mysql workbench there will 2 tables be created with data. For frontend_developer and backend_developer.

Open your mysql workbench and if you run: select * from frontend_developer; you see the follwoing schema: 

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


So, in this simple post we get little overview about JPA inheritance strategy and see, what execution output we get for each strategy. It is totally devepnd upon you which strategy you will use for your application. But, there are alos pros and cons using these strategies. Someone prefer single_table strategy and someone prefer joind table strategy. 

In coming post we will talk about the pros and cons of these 3 strategies. 

Talk soo,
Shakil Ahmed.

-----

<h2>Read More</h2>
{jpa1}