## Create a Crud Application using Hibernate ORM with Panache

**Note:** Skip step 1 to 5 if you know how to create Quarkus application.

<a href="#step6">Dive to Step 6</a>

**Initial Requirements:**
    - JavaSE version: 8+
    - Maven or Gradle as a build tool or using CLI
    - Maven version: 3.6.3+
    - Gradle version: 7.5+
    - An IDE that support Java and maven/gradle: Like Intellij Ide, Eclipse or VS code.

Please follow the below steps to bootstrap your quarkus application.

**Note:** We use here [https://code.quarkus.io](https://code.quarkus.io) official site to bootstrap our quarkus application and use intellij ide to develop it. You can also use VS Code or eclipse as well.

1. Open [https://code.quarkus.io](https://code.quarkus.io) to bootstrap your quarkus application. Provide the following metadata:

    - Group: com.company (or the default one)
    - Artifact: quarkus-example (or the default one)
    - Quarkus Platform Version: latest one or the recommended one
    Build tool: Maven or Gradle

2. After adding the metadata, now it is time to add extensions/dependencies. Add the following extensions:
    
    - RestEasy Reactive Jackson
    - Hibernate Orm with Panache
    - Mysql JDBC Driver extension

3. Click on Generate button. It will produce a zip file and the file name should be your Artifact name.

4. Unzip it and import it or open it in your favourite Ide like intellij ide. 

Note: If you use intellij ide and want to run quarkus application from your ide, then you have to install Quarkus Tools for Intellij plugin from the marketplace.

Quarkus Tools for IntelliJ: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your ide

Quarkus Tools for Eclipse: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your Ide

Quarkus Tools for VS Code: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your ide 

5. After importing or opening the quarkus example applicaton into your ide, the file structure should be like below: 

<img src="/images/quarkus/img1.jpg" alt="Quarkus file structure" width="50%" height="auto"/>


### How to import External Maven/Gradle project into your ide: 

    - Eclipse: Open your Eclipse (STS) Ide. File > Import -> Maven -> Existing Maven projects -> Next -> Browse your Maven/Gradle project(Reside our quarkus-example application) -> Click Finish. Please wait few seconds to complete the whole process and resolving the maven dependencies.

    - Intellij Ide: Open your IntelliJ Ide, then File -> Open -> Browse the existing Maven/Gradle project -> Click Ok. Likewise eclipse, wait few seconds to resolve Maven/Gradle dependencies. 



<span id="step6" />

6. Create an entity class called **Student.java** in **com.company.entity** package. The Student class contains name, age and nationality as properties. We also annotated the Student class by **@Entity** annotation as it is a persistent class. 


**Student.java**

```
package com.company.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
public class Student extends PanacheEntity {
    //id is automatically added when you use PanacheEntity
    public String name;
    public int age;
    public String nationality;

    public Student() {
        super();
    }

    public Student(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    /**
     * getter and setter methods are omitted as they will be
     * handled by PanacheEntity, even id will be generated programmatically
     * if you want to create id externally please extends PanacheEntityBase instead of
     * PanacheEntity
     */
}
```


**Note:** There is no getter and setter methods even id (primary key of your database table) as all of them will be handled by default programmatically by PanacheEntity.

7. Now create the service class. Create **StudentResource.java** class in **com.company.resources** package. (create new package called resources in **com.company** folder. Remember you can put all your classes in com.company). In this class, we will explore all the jax-rs rest annotations like **@GET** (Getting records), **@POST** (creating new records), **@PUT** (updating existing records), **@DELETE** (deleting existing resource) and few more. The code will be explained below.



```
package com.company.resources;

import com.company.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class StudentResource {

    //using @GET for getting all Student records
    @GET
    public List<Student> getAll(){
        return Student.listAll();
    }

    //using @POST for creating new Student record
    @POST
    @Transactional
    public Response saveStudent(Student student){
        if(student.id !=null){
            throw new WebApplicationException("Id was set invalidly on request", 404);
        }
        student.persist();
        return Response.ok().entity(student).build();
    }

    //using @GET mapping while fetching individual student by id
    @GET
    @Path("/{id}")
    public Student getOne(@PathParam("id") int id){
        return Student.findById(id);
    }

    //using @PUT mapping while updating student details

    @PUT
    @Path("/{id}")
    @Transactional
    public Student updateStudent(int id, Student student){
        if(student.name == null){
            throw new NotFoundException();
        }
        Student entity = Student.findById(id);
        if ( entity.id == null) {
            throw new WebApplicationException("Student with id of " + id + "doesn't not exist", 404);
        }
        entity.name = student.name;
        entity.age = student.age;
        return entity;
    }



    //using @Delete mapping for deleting Student record
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteStudent(int id){
        Student student = Student.findById(id);
        if(student == null){
            throw new WebApplicationException("The student of id "+ id +"doesn't exist", 404);
        }
        student.delete();
        return Response.status(204).build();
    }
}
```


**Explanation:** In this class root, we have used path annotations and they will be defined the rest endpoints. For making transactions more smooth we have used **@Produces(MediaType.APPLICATION_JSON)** and **@Consumes(MediaType.APPLICATION_JSON)** at the class level. You may or may not use **@ApplicationScoped**.


The first method will return all the student details, 2nd method will persist the Student details to the database. Here in the **@POST** we have to use **@Transactional** as it will update the database. Also, we have used **@PUT** mapping for updating existing student records and delete the Student records using **@DELETE** annotation. Overall, as we have used Reactive pattern thus, we have used the entity itself (Student) to save, update or delete database records. But you can use the **Repository** pattern as well but for now I am happy with it in Quarkus.

8. Add your database (Mysql) configuration in **application.properties** file located in resources folder.

**application.properties**

```
# datasource configuration
quarkus.datasource.db-kind = mysql
quarkus.datasource.username = root #usernmae
quarkus.datasource.password = root #password
quarkus.datasource.jdbc.url = jdbc:mysql://localhost:3306/qtestdb #5432 if postgresql

# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation= drop-and-create
```

But if you use postgreSQL use the below configuration instead.

```
# datasource configuration
quarkus.datasource.db-kind = postgresql
quarkus.datasource.username = hibernate
quarkus.datasource.password = hibernate
quarkus.datasource.jdbc.url = jdbc:postgresql://localhost:5432/hibernate_testdb

# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation=drop-and-create
```

***Attention: Your database name must be qtestdb or hibenate_testdb but no need to create table externally.***


9. Run your example application. Hope you are in IntelliJ Ide and has been installed Quarkus tools. (Though you can run your application by CLI, maven or gradle commands as well)


```
//quarkus cli
quarkus dev
//maven
mvnw quarkus:dev
//gradle
gradlew --console=plain quarkusDev
```

10. If you run your application successfully, it runs on port 8080 in localhost. Invoke the url [http://localhost:8080/students]([http://localhost:8080/students]) in your favourite web browser and you see an empty array as response.


11. Let's add few students using Postman (a popular rest client). Open Postman (If not installed, install it first or use curl). Click on plus icon and paste the url [http://localhost:8080/students](http://localhost:8080/students). Then, from the drop-down list select POST -> Body -> raw -> JSON and then add few students like below and click on Send button. ()


```
{
    "name": "Mark Smith",
    "age": 20,
    "nationality": "Enlish"
}
```

![Alt text](img3.png)


Like the above, add few more student details. (One Student at a time)

```js
{
    "name": "Lino Bozonich",
    "age": 28,
    "nationality": "Enlish"
},
{
    "name": "Tamina Nuncher",
    "age": 25,
    "nationality": "Brazilian"
},
{
    "name": "John Doe",
    "age": 25,
    "nationality": "English"
},
{
    "name": "Mark Smith",
    "age": 22,
    "nationality": "English"
},
{
    "name": "David Morison",
    "age": 22,
    "nationality": "Danish"
},
{
    "name": "Kevin Ryan",
    "age": 22,
    "nationality": "Dutch"
},
{
    "name": "Powel Smith",
    "age": 26,
    "nationality": "American"
},
{
    "name": "Shakil Ahmed",
    "age": 24,
    "nationality": "Bangladeshi"
},
{
    "name": "Jerry Reed",
    "age": 23,
    "nationality": "French"
}
```

12. Now again invoke the url: [http://localhost:8080/students](http://localhost:8080/students) and you see an array of objects like this: 

![quarkus](img2.png)

13. But if you want to get Student records by id please invoke [http://localhost:8080/students/1](http://localhost:8080/students/1) and you will get the first student records as response.


![quarkus](img1)


14. Let's delete a student records which id is 10.

For removing the student records which id is 10, open postman again and paste the url [http://localhost:8080/students/10](http://localhost:8080/students/10) and select DELETE http verbs. If you now again invoke the GET request you see there is no student records of id 10. (There should be an error message it will return on your **@DELETE** request)

That's all today.

Talk Soon,<br/>
Shakil Ahmed 



