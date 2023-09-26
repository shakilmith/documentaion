## Javafx Box.

Box in Javafx is a 3 dimentional shape with the specified size. The initial properties are depth, widht and height. But to drowing javafx Box we must import the class javafx.scene.shape.Box;

## Creating Javafx Box

We can simply create javafx Box by creating an Box empty constructor or a contructor with the specified size. Like width, height and the depth. 

```js
//creting Box
Box box = new Box();
//or
Box box = new Box(width, height, depth); //all are double value
```

## Add width, height and depth

As described earlier, we can call setter methods to add width, height and depth in a box object or we can provide that values as arguments at the time of cretion of a Box.

```js
//creting Box object
Box box = new Box();
//add width, height, and depth to box object
box.setWidth(150.5);
box.setHeight(100.5);
box.setDepth(140.5);
```

Then, please add layoutX/Y properties too so that the box node should be displayed in specified co-ordinates.

```js
box.setLayoutX(100);
box.setLayoutY(100);
```

## Add the box object to the scene graph

If we want to display the box in the scene we must add it the scene graph overall. First of all we create Group container node then add the box object node to the Group as children and then add that group node to the scene. See the full example below and run it.

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Box box = new Box();
        //add width, height, and depth to box object
        box.setWidth(150.5);
        box.setHeight(100.5);
        box.setDepth(140.5);

        box.setLayoutX(100);
        box.setLayoutY(200);

        //creating a root container
        Group root = new Group();
        root.getChildren().add(box);

        Scene scene = new Scene(root,300,300);
        stage.setTitle("JavaFX Box");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

```

If you now the above example you see a blury box image(not depth visible) in the window.

//image: box, no color

## Let's add color to box

We can create specific material(like color) and add to box as to make the box colorful.

```js
//using setMaterial method
box.setMaterial(new PhongMaterial(Color.BLACK));
```

Run the app again, you now see a black box (rectangular) on the scene.

//image: black box

## Let's add PhongMaterial to Box

For styling or adding specific graphics color to box object node, we can create PhongeMaterial add it the the box object.

```js
//creating PhongMaterial
final PhongMaterial redMaterial = new PhongMaterial();
redMaterial.setDiffuseColor(Color.RED);
redMaterial.setSpecularColor(Color.BLUE);
box.setMaterial(redMaterial);
```
Here the DiffuseColor add a color on the Box node and SpecularColor add highlights.

//box: with specularColor

## Create 3 dimentional Box.

For making our Box shpae 3 dimentional, we have to add specific Camera node to the box and also create an subscene. Let's propagate the following example.

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        Box box = new Box(5,5,5);
        //add width, height, and depth to box object

       //DoawMode.FILL
       box.setDrawMode(DrawMode.LINE);


        //using setMaterial method
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.RED);
        box.setMaterial(redMaterial);


        //create camera and position it
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Rotate(-20, Rotate.Y_AXIS),
                new Rotate(-20, Rotate.X_AXIS),
                new Translate(0, 0, -15)
        );


        //creating a root container
        Group root = new Group();
        root.getChildren().add(camera);
        root.getChildren().add(box);

        //create subScene
        SubScene subScene = new SubScene(root, 300, 300);
        subScene.setFill(Color.ALICEBLUE);
        subScene.setCamera(camera);


        //creating another group and add subScene as children
        Group group = new Group();
        group.getChildren().add(subScene);



        Scene scene = new Scene(group);
        stage.setTitle("JavaFX Box");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

```

If you now run the above example you should see the following 3d image in the scene.

//image: 3d box shape

## Using DrawMode.fill

Instead of using DrawMode.LINE if we use DrawMode.FILL we will get a filled Box shape.

```js
//DoawMode.FILL
box.setDrawMode(DrawMode.LINE);
```

//image: filled box 3D shape shape.


## Few more Box 3d shapes

```js
     //create camera and position it
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Rotate(-30, Rotate.Y_AXIS),
                new Rotate(-20, Rotate.X_AXIS),
                new Translate(0, 0, -15)
        );
```

//image: change the rotation

```js
     //create camera and position it
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Rotate(-30, Rotate.Y_AXIS),
                new Rotate(-15, Rotate.X_AXIS),
                new Translate(0, 0, -15)
        );
```

//image: 


```js
      //create camera and position it
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Rotate(-45, Rotate.Y_AXIS),
                new Rotate(-30, Rotate.X_AXIS),
                new Translate(0, 0, -18)
        );
```

//image: 

```js
     //create camera and position it
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Rotate(-60, Rotate.Y_AXIS),
                new Rotate(-35, Rotate.X_AXIS),
                new Translate(0, 0, -18)
        );

```

//image: drawmode.line

So, we can simply create different type Box 3d shape just by changing the specific roation properties value in Camera node. (Like here, in perspectiveCamera)

