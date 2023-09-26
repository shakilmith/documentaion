## Javafx ChoiceBox

ChoiceBox in javafx is a small set of buttons and it allow a user to select one of the choices(choice buttons). But only one choice button can only be selected. By default, ChoiceBox has no item selected unless you have specified. The class javafx.scene.control.ChoiceBox is represented the ChoiceBox class and we have to import this pacakage to work with ChoiceBox in javafx.

## Creating ChoiceBox

We can create a ChoiceBox by creating a ChoiceBox contructor.

```js
 //creating ChoiceBox instance
 ChoiceBox<String> choiceBox = new ChoiceBox<>();
 //OR
ChoiceBox choiceBox = new ChoiceBox();

```

## Add Choices or Items to ChoiceBox

After creating choiceBox constructor or in instancce variable, we can simply add new choices by calling getItems().add() method. See the example below.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating ChoiceBox instance
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //add choices to the choiceBox object
        choiceBox.getItems().add("Item 1");
        choiceBox.getItems().add("Item 2");
        choiceBox.getItems().add("Item 3");
        choiceBox.getItems().add("Item 4");

        //then, create HBox layout component and add choiceBox to it
        HBox root = new HBox(choiceBox);


        Scene scene = new Scene(root, 300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

If you run the example above, it generates a no text button 