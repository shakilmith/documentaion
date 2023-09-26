## Javafx RadioButton

In javafx RadioButton is like a button that can be selected or not selected. Even you can select multiple buttons at time and unselect them. But, if you add RadioButtons to javafx ToggleGroup then you can't deselect(unchecked) a button if there is only one button and if there is more than one RadioButton in the ToggleGroup, you can only select only one button at a time. 

You first of all must import this class javafx.scene.control.RadioButton to work with javafx RedioButton. 

## Creating RedioButton.

We can create a RadioButton by instantiating a constructor of RadioButton.

```js
//creating a RadioButton constructor
RadioButton btn1 = new RadioButton();
//creating RadioButton consstructor with default text
RadioButton btn1 = new RadioButton("Play");

```

## Add RadioButton to any container controller

Let's add RadioButton to VBox() layout controller add it to the scene graph. Here we create two RadioButtons and both can be selected or unselected (checked or uncecked) at a time. 

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        RadioButton btn1 = new RadioButton("Play");
        RadioButton btn2 = new RadioButton("Pause");
        
        //adding toggleButton to the VBox layout controller
        VBox root = new VBox(btn1, btn2);
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

Now run the application, judge the following four screenshots.

//image: preview button //image: the first button is selected //image: both button is selected //both button is unselected again.

Note: It means, when you create a RadioButton or more than one RadioButton, if you don't add them to ToggleGroup, multiple buttons can selected at a time as well as unselected too.

## Add RadioButtons to ToggleGroup

If you don't allow a user not to select more that one RadioButton and a button must be checked(selected) than add RadioButtons to ToggleGroup.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        RadioButton btn1 = new RadioButton("Play");
        RadioButton btn2 = new RadioButton("Pause");

        //creating ToggleGroup and each button we invoke setToggleGroup method
        ToggleGroup group = new ToggleGroup();
        btn1.setToggleGroup(group);
        btn2.setToggleGroup(group);

        //adding toggleButton to the VBox
        VBox root = new VBox(btn1, btn2);
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

After running the application, in the window there should be two RadioButtons. If you select the first Button (Play button) you can't unselect it again by clicking on it. But, if you then, click on the second button (Pause button) the first button automatically will be unselected. Hence, a button in ToggleGroup must selected, it means, you now can't unselect both buttons at a time. Means, one of them should be selected.

//image: preview image, no button is selected //image: first button is selected //image: second button is selected


## How to read a selected state in a ToggleGroup

Call getSelectedToggle() method to read a ToggleGroup RadioButton whether it is selected or not. 

```js
RadioButton isSelctedRadioButton = (RadioButton) group.getSelectedToggle();

```
If no RadioButton is selected, instead of returning false, it will return null.

