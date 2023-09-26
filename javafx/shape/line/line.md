## Javafx Line

Line in javafx is a geometric shape that represents a line segment in(x,y) coordinate space. Line in javafx resides in javafx.scene.shape.Line package. So we have to import it in our application to draw a Line. 

## Creating a Line: 
We can create a line by instantiating an empty constructor of Line class or with appropriate properties.

```js
//creating a Line instance variable
Line line = new Line();
//creating a Line with (startX, startY, endX, endY) properties
Line line = new Line(0, 0, 100, 100);
```

## Line Properties 
The following are the Line class properties those are mainly responsible to draw a Line geometric shape

startX = The X coordinate of the start point of the line segment.
startY = The Y coordinate of the start point of the line segment
endX   = The X coordinate of the end point of the line shape.
endY   = The Y coordinate of the end point of the line shape.


## Draw a straigt Line and add it to Scene Graph

Let's see how we can draw a straight line and place it to the scene graph. 

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class LineExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //creating Line
        Line line = new Line();
        //adding (startX, startY, endX, endY) properties for the straight line
        line.setStartX(10);
        line.setStartY(100);
        line.setEndX(150);
        line.setEndY(100);


        //creating a root container
        Group root = new Group();
        root.getChildren().add(line);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Line");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```
If you run the example you can see a straight line segment that startting positon is (10, 100)px and ending postion is (150, 100) 

//image: a straight line

Little description about the code above: After creating emptry line constructor we have added the line properties, where to start and end. Basically, the start position of the line is (0,0) means, top left upper corner. If you set (10, 100) then the staring points will be 10px right and 100 px down from top. And if you set (150, 100) for the endX and endY then the line goes horizontally to 150px and the go down to 100px from that point. 

## Adding line Stroke

Line contains several stroke methods. If you want to set the line srokeColor you can call setStroke(Pain paint) method and also, adding stroke width by calling setStrokeWidht method. Let's propagate line stroke color and stroke widht method.

```js
//add stroke color and width to line
line.setStroke(Color.BLUE);
line.setStrokeWidth(5);
```
Run the example again and you see a blue line with 10px widht.

//image: blue line 10px width

Note: Though there is a setFill(Pain paint) method to color the line but seems it does't work prperly. So, if you color the line, just call the setStroke(Paint paint) method.

## Creating and Vertical Line

We can simply create a vertical line but for this, we have to chagne our line endX property. And it should be the same as line startX property. 

Note: For horizontal straight line, the endX and andY property value have to be same.

```js
//vertical line
line.setStartX(50);
line.setStartY(0);
line.setEndX(50);
line.setEndY(200);
```
//image: vertical line


## Add a text top of the line

Let's create a line instance and add a text node top of the line shape and again create another vertical line shape and add few texts besides it.

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LineExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //creating Line
        Line line1 = new Line();

        //vertical line
        line1.setStartX(50);
        line1.setStartY(0);
        line1.setEndX(50);
        line1.setEndY(150);
        line1.setStrokeWidth(3);
        line1.setStroke(Color.DARKBLUE);

        //creating a text node
        Text text1 = new Text("In javafx Line is a geometrical shape that represents (x, y) coordinate space.");
        text1.setLayoutX(60);
        text1.setLayoutY(20);
        text1.setWrappingWidth(65);
        //add stroke color and width to line


        //straight horizontal line with text
        Line line2 = new Line(150, 80, 280, 80);
        line2.setStrokeWidth(3);
        line2.setStroke(Color.ORANGERED);

        Text text2 = new Text("Javafx is not silly!");
        text2.setLayoutX(160);
        text2.setLayoutY(70);


        //creating a root container
        Group root = new Group();
        root.getChildren().addAll(line1, line2, text1, text2);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Line");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

If you now run the example you can see, two lines (vertical and horizontal) text included.

//image: vertical and horizontal line with appropriate texts.

