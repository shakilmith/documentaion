## JPA removing an entity
Let's say we have the below table in our mysql workbench and we want to delete a row based on it's primary key.

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

For deleting or removing an entity record (person tables raw), we have to create an entity class called Person.java that must contains id, first_name, last_name and age as properties. Note, column name must be the same of the database table but property name can be different. Also note, when we call data we basically use property name than column name.
(if you have already Person.java entity class, you can skip the creation of Person.java class)


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

2. Provide your database information and map the Person entity class in the persistence.xml file which is located in src/main/resources/META-INF folder. If you don't already have those folder structure in your project, kindly create those and then create persistence.xml file.

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


4. Create a persitence class called DeletePerson.java under com.company package.
First of all, we have to find the person data by it's id or primary key and then we have to execute the entity-manager remove method to delete the partitcular record. At last we will run our application to affect the changes.

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
        em.getTransaction().begin(); //start the transaction
       
        Person p5 = em.find(Person.class, 105); //find the person by it's id (primary key)

        em.remove(p5); //the 5th number row will be deleted

      
        em.getTransaction().commit(); //close the transaction
        em.close();
        emf.close();
    }
}

```

5. Run the DeletePerson.java class and if everything is going well, the last row of the person table will be removed(deleted) -

Go to your mysql workbench you see the following table. It seems, the last row (id = 105) has been deleted or removed.

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

Talk soo,
Shakil Ahmed.
