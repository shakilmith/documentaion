Note: Skip step 1 to 5 if you know how to create Quarkus application.

Initial Requirements:

    - JavaSE version: 8+
    - Maven or Gradle as a build tool or using CLI (see the officila doc)
    - Maven version: 3.6.3+
    - Gradle version: 7.5+
    - An IDE that support Java and maven/gradle: Like Intellij Ide, Eclipse or VS code.

Please follow the below steps to bootstrap your quarkus application.

Note: We use here https://code.quarkus.io  official site to bootstrap our quarkus application and use intellij ide to develop it. You can also use VS Code or eclipse as well.

1. Open https://code.quarkus.io to bootstarap your quarkus application. Provide the following metadata:

    - Group: com.company (or the default one)
    - Artifact: quarkus-example (or the default one)
    - Quarkus Platform Version: latest one or the recommended one
    Build tool: Maven or Gradle

2. After adding the metadata, now it is time to add extensions/dependencies. Add the folloiwng extensions:
    
    - RestEasy Reactive Jacksion
    - Hibernate Orm with Panache
    - Mysql JDBC driver

3. Click on Generate button. It will produce a zip file and the file name should be your Artifact name.

4. Unzip it and import it or open it in your favourite Ide like intellij ide. 

Note: If you use intellij ide and want to run quarkus application from your ide, then you have to install Quarkus Tools for Intellij plugin from the marketplace.

Quarkus Tools for Intelli: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your ide

Quarkus Tools for Eclipse: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your Ide

Quarkus Tools for VS Code: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your ide 

5. After importing or opening the quarkus example applicaton into your ide, the file structure should be like below: 

<img src="/images/quarkus1.jpg" alt="Quarkus file structure" width="50%" height="auto"/>


### How to import External Maven/Gradle project into your ide: 

    - Eclipse: Open your Eclipse (STS) Ide. File > Import -> Maven -> Existing Maven projects -> Next -> Browse your Maven/Gradle project(Reside our quarkus-example application) -> Click Finish. Please wait few seconds to complete the whole process and resolving the maven dependencies.

Intellij Ide: Open your Inellij Ide, then File -> Open -> Browse the existing Maven/Gradle project -> Click Ok. Likewise eclipse, wait few seconds to resolve Maven/Gradle dependencies. 