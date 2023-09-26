## Javafx CheckBox

Javafx CheckBox is one kind of Button that has three stats - selected(checked), unselected(unchecked) and interminate(undefined - when a user is not interecting with that button)
But here, the interminate feature is not enabled by default like selected or unselected. 
To make the CheckBox button interminate or undefined, we have to call the method setAllowInterminate(true). When it is set to true, then if a user click on a button it is undefined first (a minus icon - ) will be presneted, then selected icon and at last unselected if the user click that button three times(again and again)

```js
CheckBox.setAllInterminate(true);

```
Here, jvafx CheckBox is represented by this class javafx.scene.control.CheckBox and we have to import this class to implement CheckBox buttons.

## Creating CheckBox in javafx

Just create the chcekBox construcor with default text or using setText() method to add a button text.

```js
//creating CheckBox constructo with default text
CheckBox button1 = new CheckBox("Play");
//CheckBox contructor without default text.
CheckBox button1 = new CheckBox();
//set Button text
button1.setText("Play");

```

## Creating CheckBox andd add it to the scene graph

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

       CheckBox button1 = new CheckBox("Play");
       CheckBox button2 = new CheckBox("Pause");
       
       
       //adding CheckBox buttons to the VBox
        VBox root = new VBox(button1, button2);
        root.setSpacing(10);

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

//image: //image: //image: 

## Allow inteminate or defined feature on the first button

```js
//allow indeterminate feature
button1.setAllowIndeterminate(true);

```
Now if you click on the first button you should see, minus icon first time, then checked icon and last the button will be unselected.

//image: //image: //image: 

