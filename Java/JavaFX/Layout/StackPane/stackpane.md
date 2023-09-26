##  Javafx StackPane

Javafx StackPane is a layout controller that lays out it's children in a top of each other.

## Creating StackPane in javafx

The package javafx.scene.layout.StackPane represents the class StackPane. So we have to imprort it first in order to work with javafx StackPane.

## Creating stackPane and add child nodes to it.

Creating a button node and add the button node to the stackPane constructor or call the getChildren().add(node) method.

```js
package com.javaondemand.layout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public class LayoutExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //creating a button node
        Button button = new Button("Click Me");

        //creating StackPane
        StackPane stackPane = new StackPane(button);


        Scene scene = new Scene(stackPane,250,300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```
If you run the application, you see a button that is center aligned by default. 

//image: stackPane a button that is center aligned

## Add two button nodes to the stackPane layout controller

If you add two button nodes or more than one node to the stackPane layout controller, every node will be place on top of each other.

```js
package com.javaondemand.layout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public class LayoutExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //creating a button node
        Button button1 = new Button("Button number 1");
        Button button2 = new Button("Hello");
        //creating StackPane
        StackPane stackPane = new StackPane(button1, button2);


        Scene scene = new Scene(stackPane,250,300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

After runnig the above application, if you look over the window, you can see the second button node is placed on top of the first button node. Hope it make sense.

//image: 2 stackPane buttons

## Set alignmetn property to the sstackPane nodes

By default, stackPane nodes are center aligned. But, you can use setAlignment(Pos.pos_value) method to add specific left, right, bottom, center etc. alignment to the stackPane nodes.

See the example below, wher we override the stackPane default behaviour and make our node left aligned instead of center ligned

```js
package com.javaondemand.layout;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public class LayoutExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //creating a button node
        Button button = new Button("Hello Button");
        //creating StackPane
        StackPane stackPane = new StackPane(button);

        //align the button to left
        stackPane.setAlignment(Pos.TOP_LEFT);


        Scene scene = new Scene(stackPane,250,300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

//image: where stackPane node center aligned

## All the Pos.value and their definition