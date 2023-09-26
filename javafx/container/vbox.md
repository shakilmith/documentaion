## VBox in javafx:

HBox in javafx position nodes vertically, stack top of each other, start from top left upper-corner. Means the child node gets position (0,0).

## Creating VBox  layout component:

First of all we have to import javafx.scene.layout.HBox; layout class. Then, we can create HBox() layout object and pass other controller nodes to it. See the example below:

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating VBox constructor that doesn't take any child node
        VBox vbox = new VBox();

        Scene scene = new Scene(vbox,300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

When you run the application, it shows you an empty screen as we don't add any controller node to the VBox to display.

//image of empty window:

## Add child node to the VBox layout:

Let's create a Button controller component and add it as a child to the VBox layout.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Button constructor with default text
        Button button = new Button("Button");

        //creating HBox constructor that doesn't take any node
        VBox vbox = new VBox();
        vbox.getChildren().add(button);

        Scene scene = new Scene(vbox,300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```
As we have added a Button node to the HBox layout, it now displays a button top of the screen. The button co-ordinates will be (0,0)

//image: hbox button

## Adding multiple nodes to VBox Layout

If we add more than one child controller node the VBox then, they will be stacked vertically top of each other. See the example below: 

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Button constructor with default text
        Button button1 = new Button("Button");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        //creating HBox constructor that doesn't take any node
        VBox vbox = new VBox();
        vbox.getChildren().addAll(button1, button2, button3);

        Scene scene = new Scene(vbox,300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```
You now see, all three buttons have been displayed horizontally. But, we can also make space in HBox child nodes so that they look pretty.

## Adding spaces in VBox child nodes

VBox layout component provides setSpacing(double) method that generates additional spaces to the VBox child nodes. The following example shows how to set-spaces in VBox:

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Button constructor with default text
        Button button1 = new Button("Button");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        //creating HBox constructor that doesn't take any node
        VBox vbox = new VBox();
        vbox.getChildren().addAll(button1, button2, button3);

        //adding space to the hbox children nodes
        vbox.setSpacing(20);

        Scene scene = new Scene(vbox,300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```
You will now get the following window when you run the application: 

//image: where in hbox button gets space

## Child Node alingment in VBox container component

we can use setAlignmnet(Pos.value) make the child in VBox aligned in different position in the screen.

Like, for centering all the child nodes in VBox container, we can use Pos.BASELINE_CENTER. Likewise, for the alignment of the child nodes to the left or right we can use respectively Pos.BASELINE_LEFT and Pos.BASELINE_RIGHT. 

Look over the chart below, How Pos alignment works. Note: the Pos alignment comes from javafx.geometry.Pos package;

//table of alignment property: 

See an example where all the nodes get centered: 

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Button constructor with default text
        Button button1 = new Button("Button");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        //creating HBox constructor that doesn't take any node
        VBox hbox = new VBox();
        vbox.getChildren().addAll(button1, button2, button3);

        //adding space to the hbox children nodes
        vbox.setSpacing(20);
        //adding centered alignment to the hbox child nodes
        vbox.setAlignment(Pos.BASELINE_CENTER);

        Scene scene = new Scene(vbox,300,250);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```
All the child nodes get centered, you can see in the window below: 

//image: child nodes get cenetered align


```js
//for aligning the child nodes to the bottom_center
vbox.setAlignment(Pos.BOTTOM_CENTER);
//left align bottom of the screen
vbox.setAlignment(Pos.BOTTOM_Left);

```

## Adding margin to the VBox child nodes (for specific node)

We just have to implement the setMargin static method that adds margin to a specefic or particular node in the HBox container contains.

```js
//syntax
VBox.setMargin(node, new Insets(0, 0, 0, 0,));
//here new Insects(0,0,0,0) is the margin(top, left, bottom, right) of the child node property, you can also check out css documentaion to see how margin properties work.
```

See the example below how setMargin() static method works: 

```js

```