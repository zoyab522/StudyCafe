/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studycafe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author zoya
 */
public class FirstTab extends Tab {

    HBox hBox = new HBox();
    Image image = null;
    ImageView imageViewTJG = new ImageView(image);
    BorderPane borderPane = new BorderPane();


    public FirstTab(String string) {
        super(string);
        runButtons();

    }
    
    public void runButtons () {
    hBox.getChildren().addAll(imageViewTJG);

        // Use a try-catch loop to get the image to work
        try {
            image = new Image(new FileInputStream("src/main/loficafeTwo.jpg"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        imageViewTJG.setPreserveRatio(true); // so the img isn't distorted
        imageViewTJG.setFitHeight(600); // 800 pixels high within the window


        borderPane.getChildren().addAll(hBox);

        setContent(borderPane);

    }


}
