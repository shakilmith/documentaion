## Javafx ComboBox

ComboBox in javafx is a list of predefined choices(buttons) that can be selected by a user. But a ComboBox can be editable (by calling the setEditable(bool)) method.

In javafx ComboBox class is represented by the this class javafx.scene.controll.ComboBox. So we must import it to work with javafx ComboBox.

## Creating ComboBox

We can create a ComboBox in javafx by creating it's instance variable.

```js
//creating ComboBox
ComboBox comboBox = new  ComboBox();
//Or
ComboBox<String> comboBox = new ComboBox<>();
```

## Adding choices or items to ComboBox

We can add items or choices to ComboBox by usgin getItems().add() method. See the example below.

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating ComboBox
        ComboBox<String> comboBox = new ComboBox<>();

        //adding choices or items to ComboBox
        comboBox.getItems().add("Item 1");
        comboBox.getItems().add("Item 2");
        comboBox.getItems().add("Item 3");
        comboBox.getItems().add("Item 4");

        //then, create HBox layout component and add ComboBox instance variable to it
        HBox root = new HBox(comboBox);

        Scene scene = new Scene(root, 300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```
After running the example above you see the following window.

//image: comboBox

Here, you can only one item at a time.

## Make ComboBox Editable

We can also make our ComboBox editable by calling setEditable(true) boolean method. 

```js
//editable ComboBox
comboBox.setEditable(true);
```
The following window shows that, now the items or choices can be editable.

## Read the Selected value

It is also possible to read the value of the selected choice in the ComboBox. Just for this we will call the ComboBOX getValue() method.

```js
//readint the value of the selected choice
comboBox.getValue();
```
Here, if no value is seleted, it return null. 

## Select a predefined value

In the ComboBox instacen, we can add predefined value by calling setValue() method. Than, it returns the value we have added in the setValue() method. See the example below.

```js
//Item 3  as a predefined value.
comboBox.setValue("Item 3");
```
//image: In the console Item 3 return.

## Define the rows length of the choices

If you have a list of items or large number of choices, then for adjusting the widht or height of the ComboBox, you can use setVisibleRowCount(int) method to add externally, how many rows you ComboBox will be expanded. If the ComboBox is larger width than the int number you have provided, it will be shrinked and slider will be shown that can be up and down to show the other items of the list. Now see the example below

```js
package com.javaondemand.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //creating ComboBox
        ComboBox<String> comboBox = new ComboBox<>();
        
        //adding choices or items to ComboBox
        comboBox.getItems().add("Item 1");
        comboBox.getItems().add("Item 2");
        comboBox.getItems().add("Item 3");
        comboBox.getItems().add("Item 4");
        comboBox.getItems().add("Item 5");
        comboBox.getItems().add("Item 6");
        comboBox.getItems().add("Item 7");

        //if the items is more than 4, then the width of the ComboBox will be shrinked
        comboBox.setVisibleRowCount(4);

        //ComboBox is now editable
        comboBox.setEditable(true);
        
       
        //then, create HBox layout component and add ComboBox instance variable to it
        HBox root = new HBox(comboBox);

        Scene scene = new Scene(root, 300,300);
        stage.setTitle("Sample JavaFX Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

```
//image: comboBox that is shrinked


