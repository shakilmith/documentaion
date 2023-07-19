# Jpa entity manager interface provides several methods to worok with relational databse to save, find, update and delete an etity's records.

Note: A java class is nothing but a simple pojo class inlcuding properties and methods. But, when it conntected with database, then we call that pojo class as entity or persistent object. This entiyt treats as database table and it's properties are treat as databse column and the are records. 

Let's follow the below steps to save, find, update and delete an entiy records. 

In oreder to save, find, update, delete an entity object to databse we have to create an entity class, persistence.xml file for providig the databse information and write entitymanager factory method. 

1. Create an entiy class called Person in the src/main/java/model package or folder. 
{code}
YOu see, we annotate our entity class Person by @Entity annotaton and @Table annotaion. The @Entity annotaion makes this pojo class as databse table or persistence class means, the properties of this class will be persisted to database. And also write @Table annotaion externally for namming database table. If you don't write @Table externally then the class name will be the table name of your databse.

2. Create persistence.xml file in the src/main/resources/META-INF package.(here package name and folder name almost same)
{code}
Here in the persistence.xml file, if you look over <persistence-unit> </persistence-unit> you see we provide all the database information inside it.(we discussed already what all this means.)
You see, We also define our Entity class information hrer in the persistence unit. The persistence should have unique name. We name it default. You can name it anything based upon your projct.

3. Create PersionPersistent class in the src/main/java/com/company/dbpersistent package/folder. 

```java
package com.company.dbpersistent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonPersistent {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        //begin the transaction
        em.getTransaction().begin();

        //We write here our entity objects
        //thus, we can save, update, find or delete an entity inside this class


        //close the transaction
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```
Here you see, we call EntityManager factory method and also write entitmanager interface.
For starting our transection or database operation we write em.getTransaction().begin() method and for closing/releasing the transection we write em.getTransaction().commit(); 
em.close(); emf.close();

4. Write Persion entiy object and call save metthod in the PersonPersistent class.

```java
package com.company.dbpersistent;

import com.company.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonPersistent {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        //begin the transaction
        em.getTransaction().begin();


        //first person
        Person p1 = new Person();
        p1.setId(101);
        p1.setfName("Shakil");
        p1.setlName("Ahmed");
        p1.setAge(24);

        //second person
        Person p2 = new Person();
        p2.setId(102);
        p2.setfName("Vlad");
        p2.setlName("Smith");
        p2.setAge(45);

        //third person object
        Person p3 = new Person();
        p3.setId(103);
        p3.setfName("Mark");
        p3.setlName("Smith");
        p3.setAge(35);


        //save these 2 entity objects to the database
        em.persist(p1);
        em.persist(p2);
        em.persit(p3);


        //close the transaction
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```
5. Run your application (Ctrl+Shift+F10). If everythig is going well you see the following consoe message.

```console
Jul 14, 2023 2:21:07 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: default]
Jul 14, 2023 2:21:07 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 6.1.6.Final
Jul 14, 2023 2:21:08 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using built-in connection pool (not intended for production use)
Jul 14, 2023 2:21:08 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: Loaded JDBC driver class: com.mysql.cj.jdbc.Driver
Jul 14, 2023 2:21:08 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001012: Connecting with JDBC URL [jdbc:mysql://localhost:3306/testdb]
Jul 14, 2023 2:21:08 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {password=****, user=root}
Jul 14, 2023 2:21:08 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Jul 14, 2023 2:21:08 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH10001115: Connection pool size: 20 (min=1)
Jul 14, 2023 2:21:09 PM org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl logSelectedDialect
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
Jul 14, 2023 2:21:09 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@1f2f0109] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Jul 14, 2023 2:21:09 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@5d94a2dc] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Jul 14, 2023 2:21:09 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Jul 14, 2023 2:21:09 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/testdb]

Process finished with exit code 0

```
6. Please open your database (in case mysql). Type <code>select * from Person;</code> and you see the following output.

```sql
mysql> use testdb;
Database changed
mysql> select * from person;
+-----+------+------------+-----------+
| id  | age  | first_name | last_name |
+-----+------+------------+-----------+
| 101 |   24 | Shakil     | Ahmed     |
| 102 |   45 | Vlad       | Smith     |
| 103 |   35 | Mark       | Smith     |
+-----+------+------------+-----------+
3 rows in set (0.00 sec)

```
If you see the above output from our your sql command, then means, your Person records has been saved to database succesfully.

As we have 3 person entity object to the databse let's find one of them by entity manager find() method and print it to console.
# How to find and entity from database table.
We follow the below steps to find and existing entity from our database.
1. Create a class called FindPerson in src/main/java/com/company/dbpersistent and wrtie the folloing like the PersonPersistent.java class.
```java
package com.company.dbpersistent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindPerson{
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        //begin the transaction
        em.getTransaction().begin();
         

         //we write here entity manager find() method to find an existing entiy

        //close the transaction
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```
2. Inside the <code> em.getTransaction().begin();</code> and <code>em.getTransaction().commit();</code> method we write entity manager find() method to find and existing entity.
If you come from the the begining of this post, you may know we have 3 persons in our database table (in case you used the update as hibernate.hbm2ddl.auto property value in your persistence.xml; if not kindly use update as propery value.). So, we call find the third person (Id = 103) based on it's Id.
See the code below: 
```java 
package com.company.dbpersistent;

import com.company.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindPerson {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        //begin the transaction
        em.getTransaction().begin();

        //use the Jpa find method to find an existing entity
        Person p = em.find(Person.class,103);
        //print the person information
        System.out.println("Id: "+p.getId()+" "+"first_name: "+p.getfName()+" "+"last_name: "+p.getlName()+" "+"age: "+p.getAge());

        //close the transaction
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```
3. Run your application (Ctrl+Shift+F10) and you see the output below if everything is going well. <code>(Here we omit the console messages.)</code>

```console
Id: 103 first_name: Mark last_name: Smith age: 35
```
## How to update an existing entity records.
Let's follow the below steps to update and entity records.
