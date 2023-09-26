## Javafx Rectangle

Rectangle is a geometric shape in javafx. The package javafx.scene.shape.Shape is the responsible to draw a rectangel. So we have to import it or the Rectangle class from this package. The Rectangle class defines a rectangle with the specified size and location. By default, the Rectangle class  has shaprp corners. But we can also make the rectangle rounded by calling arcWidth and arcHeight. 

Here is a list of important properties those are responsible to draw a rectangle.

X (setX) : Defines the X coordinate of the upper left corner of the rectangle.
Y (setY) : Defines the Y coordinate of the upper left corner of the rectangle.
Width (setWidht): Width of the rectangle
Height (setHeight): Height of the rectangle
ArcWidth and ArcHeight : Make the rectangle rounded corners.

Additional properties can also be applied to a rectangle. Like,
fill, smooth, strokeWidth, strokeOffset, strokeLineJoin etc.

## Creating a Rectagle: 
We can create a Rectangle by creating a rectangle constructor, then draw it by calling respected setter methods.

```js
//empty rectangle constructor
Rectangle rectangle = new Rectangle();
//a rectangle with respective properties
Rectangle rectangle1 = new Rectangle(10, 100, 60, 40);
//widht, and paint value
Rectangle rectangle1 = new Rectangle(60, 40, Color.BLUE);
```
Here all of them are default constructor of Recatangle class.

## Add Rectangle to the Scene Graph

For displaing the Recatagle shape, we have to add it to the container node like in Group container. Below is a complete example that shows a rectangle shape on the scene.

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class RectanlgleExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating a rectangle instance variable
        Rectangle rectangle = new Rectangle();

        //add appropriate setter methods (x, y, width, height)
        rectangle.setX(90);
        rectangle.setY(50);
        rectangle.setWidth(120);
        rectangle.setHeight(100);

        //creating a root container
        Group root = new Group();
        //call getChildren().add() method
        root.getChildren().add(rectangle);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Rectangle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

After runng the application, you see a black filled rectangle, that coordinating position is (x, y) = (90, 50) and widht and height is 120 and 80 respectively. Note that, by default, the rectanle color is black. You can call setFill(Paint paint) method to change the Rectangle color.

//image: a black rectangle


## Change the Rectanle Color

Earlier said that, black is the default color of any rectangle of javafx Shape package. We can call setFill(Paint paint) method to change the default color.

```js
//now rectangle should be Green
rectangle.setFill(Color.GREEN);
```
//image: green rectangle

## Change StrokeWidth and StrokeColor

There are methods available in javafx, to work with rectanle stroke. Like, we can change the stroke default width by calling setStrokeWidth() method and cange stroke color by calling the setStroke(Paint paint) method. See the following example

```js
//make the storke 5px width and color is red
rectangle.setStrokeWidth(5);
rectangle.setStroke(Color.RED);
```
Now the stroke color and width should be changed if you add the above code in your application.

//image: red and 5px widht rectangle.

## Rounded Rectangle

Let's create a rounded corner rectangle by calling arcWidth() and arcHeight double type methods to our rectangle class.

```js
//make the rectangle corner rounded width=20, height=15
rectangle.setArcWidth(20);
rectangle.setArcHeight(15);
```
After adding the above two lins of code, kinly run the example application again you should now a rectangle that all the corners are rounded. (I changed the color of the rectanlge)

//image: a rounded corner rectangle. 


## Add text inside rectangle

We can also add text inside a rectangle. For this, we will create a Text node with default text and then changed the Text default position so that it resides inside the recatangle shape. See a full example that shows rectanle with texts.

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class RectanlgleExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //create a rectangle with (x, y, width, height) properties
        Rectangle rectangle = new Rectangle(80, 50, 150, 120);
        //set the rectangle color
        rectangle.setFill(Color.rgb(255, 255, 200, 0.7));

        //set stroke with and color
        rectangle.setStrokeWidth(3);
        rectangle.setStroke(Color.BLACK);

        //create a text node
        var text_node = """
                Rectangle is a geometric shape in javafx. Call the Rectangle class to draw a rectangle.
               """;

        //creating Text node with appropriate methods call
        Text text = new Text(text_node);
        text.setFill(Color.BLACK);
        text.setLayoutX(100);
        text.setLayoutY(65);
        text.setWrappingWidth(120);
        text.setTextAlignment(TextAlignment.LEFT);

        //creating a root container
        Group root = new Group();

        //call getChildren().addAll() method
        root.getChildren().addAll(rectangle, text);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Rectangle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

Run the above example application. You now see a rectangle with texts inside it.

//image: rectangle with texts

## Make Square

A javafx Rectangle can be a square too if the width and height are same. See the below example where we give same width and height to rectangular object.

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //create a rectangle with same width and height - square
        Rectangle rectangle = new Rectangle();

        rectangle.setX(100);
        rectangle.setY(50);
        rectangle.setWidth(120);
        rectangle.setHeight(120);

        //color the rectangle(square)
        rectangle.setFill(Color.ORANGERED);
        rectangle.setStrokeWidth(2);
        rectangle.setStroke(Color.BLACK);

   
        
        
        //creating a root container
        Group root = new Group();
        //call getChildren().addAll() method
        root.getChildren().addAll(rectangle);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Square");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```
If you see the below image you can see now that if we add same width and height to the rectangle instance, then it will be square.

//image: square

## Make the rectangle Invisible

By default Rectangle shape is visible to the scene. But if you don't want to display it to the scene graph, just call setVisible(bool) method and provide false boolean value. Then, your rectangle shape will not be visible.

```js
//the shape will not visible now.
rectangle.setVisible(false);
```

