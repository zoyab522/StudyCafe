package com.mycompany.studycafe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane(); // create a TabPane so we can add tabs
        FirstTab firstTab = new FirstTab("Placeholder Name"); // Our first tab
        tabPane.getTabs().addAll(firstTab);

        var scene = new Scene(tabPane, 640, 480);
        scene.getStylesheets().add("application.css");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}