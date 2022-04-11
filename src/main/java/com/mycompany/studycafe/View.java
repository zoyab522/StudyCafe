/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studycafe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author zoya
 */
public class View {
    
    private final Label studySessionNumLbl, whatsNextLbL, timerLbl, introLbl, introTwoLbl;
    private final Button startPauseBtn;
    private final Scene scene;
    private final TabPane tabPane;
    private final Tab tabTimer;
    private final Tab tabWelcome;

    // GUI Setup
    public View() {
        tabPane = new TabPane();
        tabTimer = new Tab("Timer");
        tabWelcome = new Tab("Welcome");
        tabPane.getTabs().add(tabWelcome);
        tabPane.getTabs().add(tabTimer);
        
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Set up the timer tab
        timerLbl = new Label("25:00");
        timerLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        startPauseBtn = new Button("Start • Pause");
        
        studySessionNumLbl = new Label();
        whatsNextLbL = new Label();
        HBox hboxOne = new HBox(timerLbl);
        HBox hboxTwo = new HBox(startPauseBtn);
        HBox hboxThree = new HBox(studySessionNumLbl, whatsNextLbL);
        
        hboxOne.setAlignment(Pos.CENTER);
        hboxTwo.setAlignment(Pos.CENTER);
        hboxThree.setAlignment(Pos.CENTER);
        
        hboxOne.setSpacing(20);
        hboxTwo.setSpacing(20);
        hboxThree.setSpacing(20);
        
        VBox vBoxTimer = new VBox(hboxOne, hboxTwo, hboxThree);
        tabTimer.setContent(vBoxTimer);
        
        // Set up Welcome Tab
        // Adds background image 
        // Have a nice intro image when the GUI is opened 
        HBox bHBox = new HBox();
        Image image = null;

        // Use a try-catch loop to get the image to work
        try {
            image = new Image(new FileInputStream("src/main/lofiOne.gif"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        introLbl = new Label("StudyCafe\n");
        introTwoLbl = new Label("Take a seat. Stay awhile. \nStudy with our Pomodoro Timer.");
        introLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        introTwoLbl.setFont(Font.font("Verdana", 20));
        introLbl.setTextFill(Color.web("#ffffff"));
        introTwoLbl.setTextFill(Color.web("#ffffff"));
        introLbl.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(3), new Insets(8))));
        introTwoLbl.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(3), new Insets(8))));
        
        HBox iHBox = new HBox(introLbl);
        HBox iHBoxTwo = new HBox(introTwoLbl);
        iHBox.setSpacing(20);
        iHBoxTwo.setSpacing(20);
        
        VBox stackBox = new VBox(iHBox, iHBoxTwo);
        stackBox.setAlignment(Pos.CENTER);
        
        HBox hStack = new HBox(stackBox);
        hStack.setAlignment(Pos.CENTER);

        ImageView imageViewTJG = new ImageView(image);
        imageViewTJG.setPreserveRatio(true); // so the img isn't distorted
        imageViewTJG.setFitHeight(810); 
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageViewTJG, hStack);
        bHBox.getChildren().add(stackPane); 
        
        tabWelcome.setContent(bHBox);
        
        VBox vbox = new VBox(tabPane);

        scene = new Scene(vbox, 1440, 810);

    }
    
    public TabPane gettabPane() {
        return tabPane;
    }

    public Scene getScene() {
        return scene;
    }

    public Label getStudySessionNumLbl() {
        return studySessionNumLbl;
    }

    public Label getWhatsNextLbL() {
        return whatsNextLbL;
    }

    public Button getStartPauseBtn() {
        return startPauseBtn;
    }

    public Label getTimerLbl() {
        return timerLbl;
    }

}
