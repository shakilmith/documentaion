## Javafx TilePane: 

TilePane in javafx is a layout controller component that lays out it's child nodes in a grid of equally sized (can be changed) cells or tiles.


## Creating TilePane

We have to import the javafx.scene.layout.TilePane; class to work with TilePane in javafx.

```js
import javafx.scene.layout.TilePane;
```

## Adding nodes to the TilePane

Let's say, we have a few button controller component and we want to add them to the tilePane. 

```js
   //Button constructor with default text
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");
        
        //creating tilePane - horizontal tilePane
        TilePane tilePane = new TilePane();
        //add button nodes to the tilePane
        tilePane.getChildren().addAll(button1, button2, button3, button4, button5, button6);
```

## Add the tilePane to the Scene graph 

In order to display the button nodes, we have to add the tilePane to Scene. 

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Button constructor with default text
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button number 2");
        Button button3 = new Button("Button number 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");

        //creating tilePane - horizontal tilePane
        TilePane tilePane = new TilePane();
        //add button nodes to the tilePane
        tilePane.getChildren().addAll(button1, button2, button3, button4, button5, button6);

        Scene scene = new Scene(tilePane, 300,150);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

If you now run the application, you will see the below result

//image: tilePane

## Add Horizontal and Vertical gap

```js
//horizontal and vertical gap among nodes
tilePane.setHgap(10);
tilePane.setVgap(10);
```
Result should be now-
//image: uses of hgap and vgap in tilePane

The notable thing when you don't use horizontal and vertical gaps in tilePane, the nodes will be lays out next other(by deafault), or top of each other (vertical tilePane)


