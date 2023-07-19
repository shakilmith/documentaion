# JPA one-to-many annotaion
JPA one-to-many mapping is a collection valued association. Where one entity is associated collection of other entites (one column of a table will be connected collection of columns of another table.)

Let's say, we have a Student and a Library (Where many books can be found) entity class. So, create one-to-many mapping between tham so that one student can be issued collection of books (Unidirectional way). 
Note: same books can not be issued by many students. (I don't know why while writing this article.)

Follow the below steps to create one-to-many mapping between Student and Library entity class. 
1. Create Student entity or model class in com.company.model package. Provide necessary properties (like id, name, age etc.) and annotatev this class by @Entity annotaion as it is a persistence class.
Remember, the id property should be annotaded by @Id annotaion as it is the primary key of the database table.

```java
package com.company.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    private int s_id;
    private String s_name;

    public Student() {
    }

    @OneToMany(targetEntity = Library.class)
    //@JoinColumn(name="FK_book_id") it will be then column name
    private List<Library> books;

    public Student(int s_id, String s_name, List<Library> books) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.books = books;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return s_name;
    }

    public void setName(String name) {
        this.s_name = s_name;
    }


    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public List<Library> getBooks() {
        return books;
    }

    public void setBooks(List<Library> books) {
        this.books = books;
    }
}

```
Here you can see, we add additional reference Library property List<Library> books; We annotate it by @OneToMany annotaion. It means, one student can be issued list of books. 
Also, you can use the @JoinColumn(name="FK_name_id) annotaion externally provide the foreign key column name in the Student table.

2. Create Library entity class in the same directory (com.company.model) where Student class is located. Annotate this class by @Entity annotaion and it contains id, name property as well as getter & setter methods.

```java
package com.company.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Library {
    @Id
    private int b_id;
    private String b_name;


    public Library() {
        super();
    }

    public Library(int b_id, String b_name) {
        this.b_id = b_id;
        this.b_name = b_name;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }
}

```
Note: As, Student entity class is the relationship owner that's why we use the oneToMany annotation in the Student entity class with the Library type. But, if you want to make this relatiionship Bidirectional way (both can change or see each properties) then, you must provide the Student type of reference in the Library class too. (we talk about it soon.)

3. Map the database information in the persistence.xml file and also add the Student and Library entity class.

```xml 
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">
    
    <persistence-unit name ="default">
        <class>com.company.model.Student</class>
        <class>com.company.model.Library</class>
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

4. Now create a persistence class called DemoPersistent in com.company.dbpersistent package.

```java
package com.company.dbpersistent;

import com.company.model.Library;
import com.company.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class DemoPersistent {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();

        //create 3 Library object
        Library b1 = new Library(1, "Java Development");
        Library b2 = new Library(2, "Python Development");
        Library b3 = new Library(3, "PHP Development");

        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        //add b1, b2, b3 to a list
        List<Library> book_list = new ArrayList<>();
        book_list.add(b1);
        book_list.add(b2);
        book_list.add(b3);


        //create 2 Student object
        Student s1 = new Student(101, "Shakil Ahmed", book_list);
        //persist s1 to database
        em.persist(s1);


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```
You see, there are three Library objects b1, b2, b3 and add them to book_list. The, we create a student object with necessary data. Then, we persist (save) the Student object to database by EntityManager persist method.

5. Run the DemoPersistent class. If everything is going well you see in the mysql workbench or mysql command line tool the folloing schema:
Note: 3 tables will be created by running DemoPersisten class.

student table - it cointains s_id, s_name column
library tablle - it contains b_id, b_name column and 
student_library table - it contains the s_id and b_id column.

```sql
mysql> use testdb;
Database changed
mysql> select * from student;
+------+--------------+
| s_id | s_name       |
+------+--------------+
|  101 | Shakil Ahmed |
+------+--------------+
1 row in set (0.00 sec)

mysql> select * from library;
+------+--------------------+
| b_id | b_name             |
+------+--------------------+
|    1 | Java Development   |
|    2 | Python Development |
|    3 | PHP Development    |
+------+--------------------+
3 rows in set (0.00 sec)

mysql> select * from student_library;
+--------------+------------+
| Student_s_id | books_b_id |
+--------------+------------+
|          101 |          1 |
|          101 |          2 |
|          101 |          3 |
+--------------+------------+
3 rows in set (0.00 sec)

mysql>
```

Talk soon.




-----
Note:
When you use one-to-one/many-to-one Bidirectional way then, many-to-one side will always be the relationship owner side and it has @JoinColumn annotation specified. And the one-to-many annotation must have mappedBy="" parameter specified.
Also note, when you make the relationship (one-to-many/many-to-one) bidirectioal way then, in the database schema there will 2 tables be created instead of 3 tables.

```sql
mysql> select * from student;
+------+----------------+
| s_id | s_name         |
+------+----------------+
|  101 | Shakil Ahmed   |
|  102 | Zakir  Hossain |      |
+------+----------------+
2 rows in set (0.00 sec)

mysql> select * from library;
+------+--------------------+--------------+
| b_id | b_name             | student_s_id |
+------+--------------------+--------------+
|    1 | Java Development   |          101 |
|    2 | Python Development |          102 |
+------+--------------------+--------------+
2 rows in set (0.00 sec)

mysql>
```