## Ellipse in Javafx

Ellipse in javafx is almost like a circle but additonal radiousX and radiousY property. Means, if you you set radiousX and radiousY value same in ellipse then it will be a circle. In javafx the Ellipse class creates a new ellipse with the specified size and location. 

## Creating Ellipse

We can create Ellipse by instantiating an Ellipse constructor with or withou predefined parameters.

```js
//creating Ellipse
Ellipse ellipse = new Ellipse();
//with parameters
Ellipse ellipse1 = new Ellipse(150, 120, 100, 50);
```

There are also setter methods to implement on ellipse.

## Add ellipse on scene graph

For displaying our ellipse on the window, we must add it to the scene graph. Before adding the ellipse to the scene graph, we first set the centerX, cetnerY and radiusX and radiusY properties value which are mainly responsible to draw the ellipse in the application. Please note that, unlike Circle class, ellipse has 2 radius properties to set. The centerx and centerY properties respectively indicate horizontal and vertical radius of the ellipse shape. Here is a full example 

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;

public class EllipseExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating Ellipse
        Ellipse ellipse = new Ellipse();
        //set appropriate properties value
        ellipse.setCenterX(150);
        ellipse.setCenterY(120);
        ellipse.setRadiusX(100);
        ellipse.setRadiusY(50);


        //creating a root container
        Group root = new Group();
        root.getChildren().add(ellipse);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Ellipse");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

Run the EllipseExample application. You must see the ellipse on the window which has rediusX(horizontal radius) and radiusY(vertical radius) properties added.

//image: redius

## Ellipse can be a Circle

If you just same the radiusX and radiusY properties value, you see the application produces a Circle instead of Ellipse.

```js
//radiusX and radiusY are now same value
ellipse.setRadiusX(100);
ellipse.setRadiusY(50);
```
//image: ellipse that is circle now

## Change the color of the Ellipse

We can also change the default color of the ellipse. Just call the setFill(Paint paint) method with respective color values.

```js
//override ellipse default color
ellipse.setFill(Color.DARKBLUE);
```

//ellipse: darkblue ellipse

## Add StrokeColor, StrokeWidth to Ellipse

We can also add strokeColor, width properties to Ellipse by calling setStroke, setStrokeWidth methods. 

```js
//change the ellipse defalut color and stroke widths
ellipse.setFill(Color.DARKBLUE);
ellipse.setStroke(Color.BLACK);
ellipse.setStrokeWidth(5);
```
If you now run the application, you must see the ellipse border widht and color. The stroke property actually describes the border the Ellipse shape.

//image: ellipse border property

## Text inside an Ellipse. 

We can also set text based content inside an ellipse easily. Just for this, we have to create another node like Text and change the layout of the text so that it resided inside the ellipse. 

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class EllipseExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating Ellipse
        Ellipse ellipse = new Ellipse();
        //set appropriate properties value
        ellipse.setCenterX(150);
        ellipse.setCenterY(120);
        ellipse.setRadiusX(100);
        ellipse.setRadiusY(50);

        ellipse.setFill(Color.OLIVEDRAB);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(5);

        //creating text node
        Text text = new Text();
        text.setText("Javafx Ellipse");
        text.setLayoutX(100);
        text.setLayoutY(120);
        text.setStyle("-fx-font: 20 arial");



        //creating a root container
        Group root = new Group();
        root.getChildren().addAll(ellipse, text);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Ellipse");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

Run the example again. You can now see an ellipse with text content inside it.

//image: ellipse with text cotent

## Add Effects to Ellipse in javafx

We can call setEffect method in Ellipse to certain effects to ellipse node.

```js
//add effects in ellipse
 ellipse.setEffect(new DropShadow(5.3,5.0, 3.5, Color.ORANGE));
```

Now you see an ellipse with DropShadow effect.

//image: dropwshadow effect

## MouseEvents on Ellipse Shape

We can also add different mouse effents to ellipse by adding EventHanler to ellipse node. Let's see an example where the ellipse color will be changed when we click on it. For this, we use mousePressed event.

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;

public class EllipseExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating Ellipse
        Ellipse ellipse = new Ellipse();
        //set appropriate properties value
        ellipse.setCenterX(150);
        ellipse.setCenterY(120);
        ellipse.setRadiusX(100);
        ellipse.setRadiusY(50);

        //add mouseEvents to Ellipse
      ellipse.setOnMouseClicked(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
              ellipse.setFill(Color.DARKBLUE);
              ellipse.setStroke(Color.RED);
              ellipse.setStrokeWidth(5);
          }
      });

        //the above code can be written like this
        // ellipse.setOnMouseClicked(mouseEvent -> ellipse.setFill(Color.DARKBLUE));




      //creating a root container
        Group root = new Group();
        root.getChildren().addAll(ellipse);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Ellipse");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

Okay, now we have added mouseClicked event handler to the ellipse. And after running the application if you clicked the ellipse you should see that, the ellipse color, stroke width and stroke color has been updated.

//image: ellipse mouse clicked event.

## MouseEntered and MouseExited Events

What if we want to that when the mouse enters in the ellipse, the color of the ellipse should be changed and when the mouse out of the ellipse immediately it will get it's previous look. For achieving this feature, we have to add mouseEntered and mouseExited event handler method.

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;

public class EllipseExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating Ellipse
        Ellipse ellipse = new Ellipse();
        //set appropriate properties value
        ellipse.setCenterX(150);
        ellipse.setCenterY(120);
        ellipse.setRadiusX(100);
        ellipse.setRadiusY(50);


        //add mouseEvents to Ellipse
       ellipse.setOnMouseEntered(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
              ellipse.setFill(Color.DARKBLUE);
              ellipse.setStroke(Color.RED);
              ellipse.setStrokeWidth(5);
          }
      });


      ellipse.setOnMouseExited(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
              ellipse.setFill(Color.BLACK);
              ellipse.setStrokeWidth(0.0);
          }
      });
        //the above code can be written like this
        // ellipse.setOnMouseClicked(mouseEvent -> ellipse.setFill(Color.DARKBLUE));




      //creating a root container
        Group root = new Group();
        root.getChildren().addAll(ellipse);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Ellipse");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

After running the example application, you see ellipse with black background. But when the mouse enters in it, the color and border has been updated and if you out the mouse from the ellipse, it get's it's previous look. Means, we can simply add hoverable events on Ellipse even any type of Shpes or merely any nodes. 