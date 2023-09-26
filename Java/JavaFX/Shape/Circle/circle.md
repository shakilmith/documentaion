## Javafx Circle

The Circle class resides in javafx.scene.shape package. So, we have to import javfx.scene.shape.Circle class to draw a circle on the scene graph. Overall, the Circle class creates a new circle with the specified radious and center location. 

## Creating a Circle 

We can create a circle by instantiating a constructor with or without defined parameters. But for drawing an actual Circle shape, we must add center location details and radious of the circle shape.

```js
//creating a Circle object with parameters

Circle c1 = new Circle(double)
Circle c2 = new Circle(double r, Paint)
Circle c3 = new Circle(double r, double x, double y)
Circle c4 = new Circle(double r, double x, double y, Paint)

//creating a Circle object without parameters
Circle cirlce = new Circle();
//add centerX, centerY and radious property
circle.setCenterX(150);
circle.setCenterY(120);
circle.setRadius(75);
```

The first four are the Circle objects created by providing respective parameters value. The r is radiou, x and y is respectively centerX and centerY.  

## Add Circle to the Scene Graph

After creating a Circle and add it to the container node, we must then, add the container node to the scene so that we actually can see the circle in the window or in our application. Full example has been added below

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        
        //creating circle
        Circle circle = new Circle();
        circle.setCenterX(150);
        circle.setCenterY(120);
        circle.setRadius(75);


        //creating a root container
        Group root = new Group();
        root.getChildren().add(circle);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Circle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

If you now run the example above, you must see a Circle shape in the window scene and the radious of this circle is 75px.

//image: circle default color

## Change the Circle Color

By default the circle is black colored. We can simply call setFill(Paint paint) setter method to change the default color of the circle shape.

```js
//change the default color of the circle
circle.setFill(Color.DARKBLUE);
```
If you run the example application now, you see a darkblue circle. Means, we can change the circle default color by calling setFill(Paint paint) method. 

//image: circle darkblue

## Add Circle Stroke width, color

The edges of the circle shape can also be modified. We can add circle stroke color, width and many more. Let's draw a circle that stroke is balck and 5px width

```js
//add stroke color, width of the circle
circle.setFill(Color.WHEAT);
circle.setStrokeWidth(5);
circle.setStroke(Color.BLACK);
```
Run the application again. Now you see a circle black stroke and wheat background color.

//image: circle with balck stroke



