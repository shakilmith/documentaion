# JPA many-to-many mapping
JPA Many-To-Many mapping is a collection valued association. It comes into the catagory when colection of entities are associated with collection of other entities.

Let's generate many-to-mapping between student and library table where more than one student will be issued or use more than one book or list of books.

We follow the below stepes to achieve many-to-many feature.

1. Create Student entity or model class in com.company.model package. Provide necessary properties (id, name and reference entity info) and annotate it by @Entity annotaion.

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

    @ManyToMany(mappedBy ="student")
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

Here you see, above the Library type reference variable we use @ManyToMany(mappedBy="student") annotation with mappedBy attribute. This attribute refers nothing but Library entity is the relationship owner or owning side. 

2. Create Library entity class in the same directory (com.company.model) where Student class is located. The Library entiity contains b_id, b_name and reference entity Student of list type. 

```java
package com.company.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Library {
    @Id
    private int b_id;
    private String b_name;

    @ManyToMany()
    @JoinTable(name ="student_library", joinColumns=@JoinColumn(name ="books_id"), inverseJoinColumns=@JoinColumn(name ="student_id"))
    private List<Student> student;

    public Library(int b_id, String b_name, List<Student> student) {
        this.b_id = b_id;
        this.b_name = b_name;
        this.student = student;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Library() {
        super();
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
Here you see, we use  @ManyToMany() and  @JoinTable(name ="student_library", joinColumns=@JoinColumn(name ="books_id"), inverseJoinColumns=@JoinColumn(name ="student_id")) in List of Student type. 
The @ManyToMany() annotaion refers it is a mapping of collection type. And the purpose of
@JoinTable() annotaion, to create a seperatae table for storing student and library (book) enities id's or primary keys to show the relationship among them. In the below, you see the sql command output how, they really store id's as reference.

Again, the name="student_library" parameter refers the extra table name in the database. And, the first @JoinColumn(name="books_id) refers the current class or relationship owner class column name, and second @JoinColumn(name="student_id) refers the non-owner class column name.

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
<code style="color: white; background-color: black">Note: The persistence.xml file must be located in the src/main/resources/META-INF/persistence.xml file.</code>

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

        Student s1 = new Student(1, "Shakil Ahmed", null);
        Student s2 = new Student(2, "Zakir Hossain", null);
        Student s3 = new Student(3, "Abdul Wahed", null);


        em.persist(s1);
        em.persist(s2);
        em.persist(s3);

        List<Student> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);


        List<Student> list2 = new ArrayList<>();
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);

        Library b1 = new Library(101, "Java Development", list1);
        Library b2 = new Library(102, "Python Python Development", list2);


        em.persist(b1);
        em.persist(b2);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```
Here you see, we created lists of 3 students and add them to the library object. 

5. Now, run the Demopersistent.java class and if everything is going well, you probably don't get any error message.
And, in your mysql workbench there three tables will be generated.
student table: it contains student id and name
Library table: it contains book id and name and 
student_library table: it contains the id's of students and books and shows the relationships among them.

6. Go to your mysql workbench or command line tool and run the folloing comands to get relevant data as output.

```sql 
mysql> select * from student;
+------+---------------+
| s_id | s_name        |
+------+---------------+
|    1 | Shakil Ahmed  |
|    2 | Zakir Hossain |
|    3 | Abdul Wahed   |
+------+---------------+
3 rows in set (0.00 sec)

mysql> select * from library;
+------+---------------------------+
| b_id | b_name                    |
+------+---------------------------+
|  101 | Java Development          |
|  102 | Python Python Development |
+------+---------------------------+
2 rows in set (0.00 sec)

mysql> select * from student_library;
+----------+------------+
| books_id | student_id |
+----------+------------+
|      101 |          1 |
|      101 |          2 |
|      101 |          3 |
|      102 |          1 |
|      102 |          2 |
|      102 |          3 |
+----------+------------+
6 rows in set (0.00 sec)

mysql>
```