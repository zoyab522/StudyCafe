package com.mycompany.studycafe;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
         View view = new View();
        Model model = new Model(view.getTimerLbl(), view.getStudySessionNumLbl(), view.getWhatsNextLbL());
        new Controller(model, view);
        view.getScene().getStylesheets().add("application.css");
        stage.setTitle("Pomodoro Timer");
        stage.setScene(view.getScene());
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}