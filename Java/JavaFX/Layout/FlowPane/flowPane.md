## Javafx FlowPane

In javafx FlowPane is a layout controller. In order to use flowPane in javafx we have to import javafx.scene.layout.FlowPane class. 

At the javafx scene, the flowPane lays out it's children or child nodes horizontally (in rows) or vertically (in columns). And the child nodes are wrapped at the folowPane's boundary.

A horizontal flowPane (default behaviour) display it's nodes in horizontally (in rows) and if the child nodes requre more widths then the nodes will stack from below of the other nodes.
And, a vertical flowPane display it's nodes in vertically (in columns) and wrapping the child nodes at the flowPane height. 

## Creating Horizontal FlowPane (by default)

Just imagine we have few child nodes and we want to add them to flowPane to display. 

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Button constructor with default text
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(button1, button2, button3, button4, button5);


        Scene scene = new Scene(flowPane,300,250);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

//flowpane output: image

You can see here, the 'Button 5' has been placed next line because the space is less than the buttons required. Means, flowPane wraps it's child nodes within it's width.

## Creating Vertical flowPane

We can use setOrientation(Orientation.VERTICAL) method to lays the flowPane child nodes vertically (in columns). See the below example that display the child nodes vertically.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Button constructor with default text
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(button1, button2, button3, button4, button5);
        //make the flowPane vertically
        flowPane.setOrientation(Orientation.VERTICAL);

        Scene scene = new Scene(flowPane,300,250);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

//image 

The above image shows that all the nodes are displayed vertically. But waht if we lessen the height of scene? Then, the last node will be stack or vertically from the above. 

See the image below where we lessen our scene height. (Or just less the scene height of your application.)

//image: shows the vrticall node one after another.

Hope it make sense. 

## Set HGap an VGap in flowPane.

Hgap represents the gap on rows and Vgap represents the gap on columns of the flowPane nodes.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Button constructor with default text
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");


        //flowPane - nodes will be stacked horizontally
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(button1, button2, button3, button4);
        //add horizontal (rows) and vertical (columns) gaps.
        flowPane.setHgap(10);
        flowPane.setVgap(10);


        Scene scene = new Scene(flowPane, 300,250);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

//image: 

In the above inmage, you can see the gaps of among nodes (horizonatally, but column wise) if you lesssen the width of the scene than, you can alos notice the vGap over child nodes. 

Let's add two more button nodes, and see the effect. 

```js
  //Button constructor with default text
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");


        //flowPane - nodes will be stacked horizontally
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(button1, button2, button3, button4, button5, button6);
        //add horizontal (rows) and vertical (columns) gaps.
        flowPane.setHgap(10);
        flowPane.setVgap(10);

```

//image: flowPane that uses vGap and hGap as well.

Now, it is clear that how setHgap() and setVgap() methods work in a nutshell. 

Let's add setHgap() and setVgap in a vertical flowPane. 

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Button constructor with default text
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");


        //create flowPane
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(button1, button2, button3, button4, button5, button6);
        //set orientation
        flowPane.setOrientation(Orientation.VERTICAL);

        //add horizontal (rows) and vertical (columns) gaps.
        flowPane.setHgap(10);
        flowPane.setVgap(10);


        Scene scene = new Scene(flowPane, 300,150);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

//image: vertical flowPane where we uses hGap and vGap method

Now, it is clear how flowPane setHgap() and setVgap() methods work respectabely in horizontal and vertical flowPane.

