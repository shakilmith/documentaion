## Developing a simple Greeting Rest service using Quarkus

Initial Requirements:

    - JavaSE version: 8+
    - Maven or Gradle as a build tool or using CLI (see the officila doc)
    - Maven version: 3.6.3+
    - Gradle version: 7.5+
    - And IDE that support Java and maven/gradle: Like Intellij Ide, Eclipse or VS code.

Please follow the below steps to develop a simple Greeting rest service:

Note: We use here https://code.quarkus.io  official site to bootstrap our quarkus application and use intellij ide to develop it. You can alos use VS Code or eclipse as well.

1. Open https://code.quarkus.io and to bootstarap your quarkus application. Provide the folloiwng metadata:
Group: com.company (or the default one)
Artifact: quarkus-example (or the default one)
Quarkus Platform Version: latest one or the recommended one
Build tool: Maven or Gradle

2. After adding the metadata, now it is time to add extensions/dependencies. As it is simple rest api that produces json Greeting response, then add RestEasy Reactive Jacksion extension. 

3. Click on Genrate button. It will produce a zip file and the file name should be your Artifact name.

4. Unzip it and import it or open it in your favourite Ide like intellij ide. 

Note: If you use intellij ide and want to run quarkus application from your ide, then you have to install Quarkus Tools for IntelliJ plugin from the marketplace.

Quarkus Tools for Intelli: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your Ide

Quarkus Tools for Eclipse: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your Ide

Quarkus Tools for VS Code: File -> Settings -> Plugins -> Marketplace -> Quarkus Tools (search it) -> Install -> Restart Your Ide

5. After importing or opening the quarkus example applicaton into your ide, the file structure should be like below: 

<img src="img-1.jpg" alt="Quarkus file structure" width="50%" height="auto"/>

