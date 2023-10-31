## Javafx Tab

Tab is a javafx controller component and it is placed with javafx TabPane. In fact, each Tab in TabPane represents a single page and can contain any type of node as UI controls like Text, Button, Label, Image etc or group of nodes added to a layout controller. When a user click on a Tab, it displayes the content (like text or button) in it.

## Creating Tab

We can create Tab simply instantiating it's constructor.

```js
Tab tab = new Tab();
```

For adding contents or nodes in a Tab we can call setContent(String value) or (Node node) method. 

There is also a method called setText(String value), it is responsible of the title of the Tab.

But, we also create TabPane in order to display tab's data on the screen.

```js
TabPane tabPane = new TabPane();
tabPane.getTabs().add(tab);
```
The TabPane can accepts a single Tab or list of Tabs.

## Tab and TabPane full example 

We are going to create three tabs with text based data and create a TabPane and those in it. At last we have created a HBox layout container and the TabPane instance to it.

```js
package com.javaondemand;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        //create 3 tab with default String data
        Tab tab1 = new Tab("First Tab");
        Tab tab2 = new Tab("Second Tab");
        Tab tab3 = new Tab("Third Tab");

        //create TabPane instance
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(tab1, tab2, tab3);


        HBox root = new HBox();

        Scene scene = new Scene(root,250, 250);
        stage.setTitle("JavaFX TableView");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

```

If you run the ExampleApplication, you will see three tabs at the top level of the scene. Click on each Tab. You will see no content in them as we did't yet add any content to our Tabs. Also note that, the first Tab in a TabPane has been opened by default.

![Alt text](img-1.jpg)

## Add Node to the Tab

Call the setContent() method to add node in javafx Tab. Here, we are going to add Button ndoe in our Tabs

```js
//add Button node in our tabs
tab1.setContent(new Button("Tab 1"));
tab2.setContent(new Button("Tab 2"));
tab3.setContent(new Button("Tab 3"));
```

Now run the application again please. And then judge the follwing images

![Alt text](img-2.jpg) ![Alt text](img-3.jpg)

If you click on the fist Tab it will show Tab 1 and if you clikc respectably second and third Tab it will show Tab 2 and Tab 3. 

By default, the Tabs content displayed in the Top upper left corner of the scene (Basically nodes those are used in tabs). Implement specific mehods to modify them based on your requirements. Also, ther TabPane is inherited the Side.LEFT method by default. You can implement alternative Side methods too. Like if I want to display my TabPane bottom of the contaner or sceene, I will just call Side.BOTTOM in our TabPane instance. 

```js
//default one
tabPane.setSide(Side.TOP);
//modyfy the default one
tabPane.setSide(Side.BOTTOM);
```
If you run the application, you will see the TabPane with Tabs title has been placed on the bottom of the scene. But the Tabs content still displayed top upper left corner of the scene.
![Alt text](img-4.jpg)


## Change the Layout of TabPane
