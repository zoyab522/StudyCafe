/**
 * Authors: Anika S. & Zoya B.
 * Date: 4/11/2022
 * Class: CTIS 310
 * Assignment: Final Project
 */

package com.mycompany.studycafe;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    
    /**
     * 
     * @param stage
     * @throws IOException 
     */
    @Override
    //Starts the Stage and Application
    public void start(Stage stage) throws IOException {
        View view = new View();
        Model model = new Model(view.getTimerLbl(), view.getStudySessionNumLbl(), view.getWhatsNextLbL());
        new Controller(model, view);
        view.getScene().getStylesheets().add("application.css");
        stage.setTitle("Study Cafe");
        stage.setScene(view.getScene());
        stage.show();

    }
    
    /**
     * 
     * @param args 
     */
    //Launches/Runs the Application
    public static void main(String[] args) {
        launch();
    }

}
