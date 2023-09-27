## Label in javafx

Label is controller component or node in javafx. We can use Label to display text or image in javafx scene. 

## Creating Label

We have to import javafx.scene.control.Label in order to use label componet.

then we can set text, image to it. 



## Label constructor.

```JS
 Label label = new Label();
```

## Set text to the label or constructor or implement setter method

```js
Label label = new Label("Simple Label Text");

//Or implement the setText setter method to set the label text;
Label another_label = new Label();
another_label.setText("Javafx label");

```

## How to display an image in a label or use image with label text

First of all we create image and then we pass that image as an argument on that label.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FileInputStream inputStream = new FileInputStream("D:/resources/images/universe/sun-fireball-solar-flare-sunlight-87611.jpeg");

        ImageView imageView = new ImageView(new Image(inputStream));
        
        Label label = new Label("Label", imageView);

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root,500,500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```

//image

Here the Label constructor takes image as another parameter. 

We can also setGraphic as well in label.

## Set text in label in javafx.

We can call the setText method to add label text.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating a Label
        Label label = new Label(); //Label constructor
        label.setText("JavaFX label");

        //add label to the stackPane container
        StackPane root = new StackPane(label);

        Scene scene = new Scene(root,500,500);
        stage.setTitle("Sample Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

## Adding style to the label text

We can add font_size, color, background_cole or other styles to javafx label text by implementing javafx setStyle method.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating a Label
        Label label = new Label(); //Label constructor
        label.setText("JavaFX label");

        //add css to label text
        label.setStyle("-fx-font-size: 40; -fx-font-family: arial; -fx-text-fill: white; -fx-background-color: black ");

        //add label to the stackPane container
        StackPane root = new StackPane(label);

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

//image

Here, in setStyle method, instead of writing -fx-color: white; css we use -fx-text-fill: white; both are same in javafx css. In label text, we use -fx-text-fill to color the label text. And in different nodes, like in Text node, we use -fx-color component.

## Set the text color in javafx label

First of all, creating a label constructor and and set text to it. Then, call the setFill method and use any appropriate color value.


```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating a Label
        Label label = new Label("Label Text"); //Label constructor

        //set color
        label.setTextFill(Color.DARKRED);
        label.setFont(Font.font("Arial", FontWeight.NORMAL, 40));

        //add label to the stackPane container
        StackPane root = new StackPane(label);

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

## Adding effects to the label text

Is it possible to add effects to the label text.

Yes, we just genrate effect and call the setEffect method in the label node.

```js
//creating a Label
Label label = new Label("Label Text"); //Label constructor
label.setFont(Font.font("Arial", 40));
//setEffect method
label.setEffect(new DropShadow(20, Color.BLUE));

```
Here, we implement setEffect method and use the dropShadow effect.

----
Moreover, we can add plenty of functionality to any type of nodes in javafx. 

## Here are the few setter methods that you can use to any individual node in javafx.


