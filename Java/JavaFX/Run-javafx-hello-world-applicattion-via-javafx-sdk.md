## Run your javafx application via command line.

In order to run simple javafx application via command line tool like cmd or shell we need to download Javafx SDK and set it to our system. 


Let's say we want to run the following javafx application. 

//Link of HelloFX.java

```js
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane(new Label("Hello JavaFX!"));

        Scene scene = new Scene(root, 300,300);
        stage.setScene(scene);
        stage.setTitle("Demo Javafx app");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

```

When we run it produces Hello JavaFX! in a new window. 

//window image.


1. How to run javafx application via Command Line.

    Step 1. Download javafx SDK LTS version from here: https://gluonhq.com/javafx 

    Step 2. After downloading, unzip it to a new directory. The directory should be located C:\Program Files\JavaFX here. And your javafx SDK will be extracted here. You can unzip or extract your javafx sdk anywhere in your system. Just remembere the location. In our case, our javafx sdk will be found here: C:\Program Files\JavaFX\C:\Program Files\JavaFX\javafx-sdk-17.0.2

    Step 3: Now Download the hellofx.java file or clone the repository from github.

    Step 4: Or, create a simple hellofx application in your ide.

    Step 3: We for the time being, create a simple java application in intellij ide.
    
    Step 4: Open your intellij ide and create a hellofx java application. then in the src folder, create a file HelloFX.java and paste the following java code.

```js
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane(new Label("Hello JavaFX!"));

        Scene scene = new Scene(root, 300,300);
        stage.setScene(scene);
        stage.setTitle("Demo Javafx app");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

```

Note: In upcoming tutorial, we will describe about th code above.


2. Compile and run the HelloFX.java application via command promt.

    - Open cmd or shell. Then, find the hellofx/src directory. in my case D:\Java\JavaFX\hellofx\src and type the following command to compile your HelloFX.java file.

    ```js
    javac --module-path "C:\Program Files\JavaFX\javafx-sdk-19\lib" --add-modules javafx.controls HelloFX.java

    //If you set javafx SDK in your system environment variables and name the path JAVAFX_HOME, instead of write the above command you can write

     javac --module-path %JAVAFX_HOME% --add-modules javafx.controls HelloFX.java
    ```
    
    - Then, run your HelloFX.java file typing the following command.
    ```js
    java --module-path "C:\Program Files\JavaFX\javafx-sdk-19\lib" --add-modules javafx.controls HelloFX
    ```


