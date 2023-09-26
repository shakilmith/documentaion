## Javafx ToggleButton

ToggleButton is a speacial button in javafx that can be selected by clicking on it and deselected when you click that button again. So, it is a button with a boolean indicating whether it has been selected or not. 
Also note that, javafx toogleButton should be placed in ToogleGroup if there is more one button to be placed. 

ToogleButton in javafx is represented by this class javafx.scene.control.ToggleButton; And obviously we have to import this class to work with toggleButton in javafx.


## Creating ToggleButton 

For creating toggleButton, we have to create ToggleButton constructor with default text.
Then have to add it to any container controller.

```js
//toggleButton constructor with default text
ToggleButton btn1 = new ToggleButton("Toggle Button");
//a toggleButton that can take a graphic node 
ToggleButton btn1 = new ToggleButton("Toggle Button", Node graphic);

```

## Adding toggleButton in the VBox layout controller

The below example shows you two toggleButton we have added in the VBox controller component and the first button is not selected(we didn't click on it) and the second is selected (we have clicked on it, mouse pressed). And this example also shows you the differences between a selected and not selected button (Active and Inactive button, if we say)

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //creating toggle-button with default text
        ToggleButton btn1 = new ToggleButton("Toggle Button");
        ToggleButton btn2 = new ToggleButton("Selected Toggle Button");

        //adding toggleButton to the VBox
        VBox root = new VBox(btn1, btn2);


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

If you run this example, you see the following window 

//image: toggleButton- selected and not selected

Then, if you now click on both, both button will be selected. And if you want to deselect them, just clik on them again.

## Add ToggleButton in the ToggleGroup

As the ToggleButton default behaviour is, if you select any of the button they will be selected (activated) and click them again they will be deselected (deactivated). 

Let's say we have two buttons. If we click on the first button, it will be selected or activated and if we click on the second button, the first button should be deselected or deactivated. 

In this case, if we add our toggleButton other than ToggleGroup, we can't get this feature or behaviour. But, overall we have to add the toggleButton to any container controller like Group, HBox or VBox in order to display on the scene.

So, let me show you how to add ToggleButton in a ToggleGroup

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //creating toggleButton with default text
        ToggleButton btn1 = new ToggleButton("Play");
        ToggleButton btn2 = new ToggleButton("Pause");

        //ToggleGroup
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

Now, run the application and you can see, ther are two buttons. If you click on the Play button it is selected or activated and if you click then on the Pause button, the first button I mean, Play button is deactivated. 

So, it make sense that why we should add ToggleButtons in ToggleGroup.

## Add text in ToggleButton

Though we can add text to a toggleButton while wrting constructor. But sometimes, we need to change the text of toggleButtons. That's why we can use setText method to add text to the toggleButton.

```js
//creating toggleButton
ToggleButton button = new ToggleButton();
//call setText() method to add text to the button
button.setText("Demo Toggle Button");

```

## Adding Color to the ToggleButton text

We can also call setTextFill() paint method in the toggleButton to set the color of the button text.

```js
 //creating toggleButton with default text
ToggleButton btn1 = new ToggleButton("Play");
ToggleButton btn2 = new ToggleButton("Pause");

//color the text of the first button
btn1.setTextFill(Color.BLUE);

```
//image: first button is blue color