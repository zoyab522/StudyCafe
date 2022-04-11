/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studycafe;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author zoya
 */
public class View {
    
    private final Label studySessionNumLbl, whatsNextLbL, timerLbl;
    private final Button startPauseBtn;
    private final Scene scene;
    private final TabPane tabPane;
    private final Tab tabOne;

    // UI Setup
    public View() {
        tabPane = new TabPane();
        tabOne = new Tab("Tab");
        tabPane.getTabs().add(tabOne);
        
        //Creating a graphic (image)

        timerLbl = new Label("25:00");
        timerLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        startPauseBtn = new Button("Start • Pause");
        
        studySessionNumLbl = new Label();
        whatsNextLbL = new Label();
        HBox hbox = new HBox(studySessionNumLbl, whatsNextLbL);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        
        VBox vbox = new VBox(tabPane, timerLbl, startPauseBtn, hbox);
        vbox.setAlignment(Pos.CENTER);

        scene = new Scene(vbox, 800, 800);

    }
    
    public TabPane gettabPane() {
        return tabPane;
    }
    
    public Tab getTab() {
        return tabOne;
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
