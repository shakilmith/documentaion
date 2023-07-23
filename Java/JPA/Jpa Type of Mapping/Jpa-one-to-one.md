# JPA OneToOne mapping:
JPA one to one mapping represents single valued associalton where one entity shares it's single property with another entity.
One to one mapping can be Unidirectional or Bidirectional. 
Unidirectional: Only the source entity can see or update the target entity. You can say relationship owner can see or update/change the target entity.
Bidirectional: Both entity used in this mapping can see or update both data but one entity must be the relationship owener. 

Let's propagate one to one mapping between Student and Library entity. 
Note one of the enity must be the relationship owner. Here Library will be the relationship owner. Relationship owner is nothing but to have the foreign key in the databse table. Which entity will be the relationship owner have @OneToOne annotaion with the reference entity details.

#Steps to achieve onetoone mapping between Student and Library entity.
1. Create Student.java entity or model class in com.company.model package. Provide necessary properties and annotate it by @Entity annotaion.

```java

package com.company.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int s_id;
    private String name;

    public Student() {
    }

    public Student(int s_id, String name) {
        this.s_id = s_id;
        this.name = name;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```
Note: We provide s_id, s_name property in the Student class. And annotate it by @Entity annotaion as it is a persistent class. Also there should be a primary key. so, we add @Id annotaion on the s_id property to make this id as primary key of the database table.

2. Create Library.java class in the same directory (com.company.model) where Student class is located. In this class we we use @OneToOne mapping annotaion along with the reference entity.

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
    @OneToOne
    private Student student;

    public Library() {
        super();
    }

    public Library(int b_id, String b_name, Student student) {
        this.b_id = b_id;
        this.b_name = b_name;
        this.student = student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

```
You see, we use @OneToOne annotaion along with the refecence entity Student in the Library entity class.
Note: You also use, @JoinColumn(name="fk_student_id") annotaion to externally provide the foreign key name in the Library table. If you don't use the @JoinColumn annotaion then the foreign key name will be student_id; 

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
            <property name="hibernate.hbm2ddl.auto" value="create"/>
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

public class DemoPersistent {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();

        Student s1 = new Student(101, "Mark");
        Student s2 = new Student(102, "Vlad");



        Library b1 = new Library();
        b1.setB_id(1);
        b1.setB_name("Java Development");
        b1.setStudent(s1);

        Library b2 = new Library();
        b2.setB_id(2);
        b2.setB_name("Data Science");
        b2.setStudent(s2);


        em.persist(s1);
        em.persist(s2);

        em.persist(b1);
        em.persist(b2);




        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

```

You see, we create two student objects s1 and s2 and create 2 Library objects b1 and b2 and also set their values.

5. Run the DemoPersistent class. If everything is going well you see in the mysql workbench or mysql command line tool the folloing schema:

```sql 

mysql> select * from Student;
+------+------+
| s_id | name |
+------+------+
|  101 | Mark |
|  102 | Vlad |
+------+------+
2 rows in set (0.00 sec)

mysql> select * from library;
+------+------------------+--------------+
| b_id | b_name           | student_s_id |
+------+------------------+--------------+
|    1 | Java Development |          101 |
|    2 | Data Science     |          102 |
+------+------------------+--------------+
2 rows in set (0.00 sec)

mysql>

```


After executaion of the program, it creates Studet and Library table in the mysql workbench.
when you run: <code>mysql> select * from Student; </code> it produces the following output. student id(s_id) and Student name(s_name) column name.

```sql 

mysql> select * from Student;
+------+------+
| s_id | name |
+------+------+
|  101 | Mark |
|  102 | Vlad |
+------+------+
2 rows in set (0.00 sec)

```


Again if you run: <code>mysql> select * from Library; </code> it produces the following output. A book id(b_id), book name(b_name) and reference student id (student_s_id)
Here, the first part <code style="background-color: black; color: white">student</code> is the reference property name used in the Library entity class and the seocnd part  <code style="background-color: black; color: white">s_id</code> is the primary key of Student entity class. 

Also, you can externally provide the foreign key name in the Libraary class. But for achieving this you have to use <code style="background-color: black; color: white">@JoinColumn(name="fk_student_id")</code> annotaion.

Thanks for reading this article,
Talk soon, 
Shakil Ahmed.