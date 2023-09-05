## Button in javafx

A button can execute something when we click on it. Like, play a song, pause the video or open a new window etc. So the main purpose to use a button in javafx to handle an action. 

## Creating Javafx button.

First of all, we have to import javafx.scene.control.Button to implement Button in javafx. Then, we can create Button constructor like the below.

```js
//creating button constructor
Button button = new Button();

//button constructor with default text
Button button = new Button("Button");

```

## Setting Button text

We can call setText to set a text message or change the button default text in javafx.

```js
Button btn1 = new Button();
btn1.setText("Button");

//or change the default text
Button btn2 = new Button("Default Button");
//change the button text
btn2.setText("Button 2");

```

## How to adding a button to the scene:

It is not enough just to creating the button node. In order to display it in the scene graph we have to place it in any container node. See the example below-

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating button
        Button button = new Button();

        //Add text to button
        button.setText("Click Me!");

        StackPane root = new StackPane(button);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```
If you run the application, you see the following window, a button in the middle of the screen.

//image of a button


If you notice that, this button doesn't do anything. But, we want the button should do something when we click on it.

## Button that handle events.

Likewise, when we clikc on a button, we want that it should execute something. Like open a new window, play the music, pause the video or save information to the database. 

Button provides setOnAction method and we need to add an event listener to the button object. See the example below.

```js
//creating button
Button button = new Button();

//Add text to button
button.setText("Click Me!");

//event handler
button.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent actionEvent) {
//to do something
 }
});

```

We can get almost result like the above by java lambda expression.

```js
 button.setOnAction(actionEvent -> {
            //to-do-something
});

```

In the event handler section or block, we can set anything to execute or perform. 

If you want to just print a console message, see the example below that returns a simple console message when we click on a button.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating button
        Button button = new Button();

        //Add text to button
        button.setText("Click Me!");

        //event handler
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("You clicked the button!");
            }
        });

        StackPane root = new StackPane(button);
        Scene scene = new Scene(root,300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```
If you now, run the application and it shows you a button on the screen. If you click on it, in the console you see: You clicked the button! 
If you click on the mulitple times, it shows mulitple times the same result.

//image: button produces console messsage


## Button can change the text:

Let's we want to change a text of any label or text node. See the example below:

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Label label = new Label("I love Javafx!");

        Button button = new Button("Change the text");
        //action event
        button.setOnAction(actionEvent -> {
            //change the label default text
            label.setText("Javafx is fun enough!");
        });


        //creating VBox container that display nodes vertically.
        VBox root = new VBox(label, button);
       root.setAlignment(Pos.BASELINE_CENTER);
        Scene scene = new Scene(root,300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

If you now click on the button after running the application, you see the text has been changed. 

//image: button that change a label text

//image after click on the button

Not just like changing text, a button can do a lot of possible things as well. 
1. Change text 2. Change default style. 3. Change the default alignment 4. Change Backgroud 5. Change effects or set graphics etc. 

## Setting Button Size

In javafx, button class contains several methods to work with buttons. Even, it contains methods to change the button size. See the example below

```js
//setMinWidth, MaxWidth and PrefWidth
btn.setMinWidth(duble_value);
btn.setMaxWidth(doble_value);
btn.setPrefWidth(double_value);

//setMinHeight, setMaxHeight and PreHeight
btn.setMinHeight(duble_value);
btn.setMaxHeight(doble_value);
btn.setPrefHeight(double_value);

//setMaxSize, setMinSize and PrefSize
btn.setMinSize(duble_value, double_value);
btn.setMaxSize(doble_value, double value);
btn.setPrefSize(double_value, double value);
```

## Add CSS to a Button

We can add external or internal css style to a button and make our button more stylish and look great. 

Let's add button size, color, backgorund color or font style (size, color, font-family etc.)

In the below example I demonstrate only how to apply how to apply inline css to a button node.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Button button = new Button("My Button");
        //change default button size, color, font-family or background color by inline css
        button.setStyle("-fx-font-family: Verdana; -fx-font-size: 35; -fx-font-weight: normal; -fx-color: blue; -fx-background-color: black;");

        StackPane root = new StackPane(button);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

Here, after running the application you see a white button with bakcground color:

//image: a button that uses css inline style

Note: In javafx, when we wrtie css command we have to use extra -fx command. If you already work with css, you know, we use just only font-family: < value >, but, in javafx we have to write -fx-font-family: < value >; Hope it make sense.
Another thing to note, sometimes, -fx-color: (value); works and sometimes -fx-text-fill: works; If -fx-color doesn't work just use -fx-text-fill:(value);

//More information will be provided here: work with javafx css

## Buttons with diffrent css styles (More examples)

```js

```

## Style a button by CSS StyleSheets

## Set Image to a Button

## Set Effect to a Button

## How to Create a Disable Button

## Buton in FXML

## How to Implement Transition or Transformation in a Javafx Button

## Set Mnemonic on Javafx Button

## How to display buttons horizontally or Vertically 

