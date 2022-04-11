/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studycafe;

/**
 *
 * @author zoya
 */
public class Controller {
    
    public Controller(Model model, View view) {
        view.getStartPauseBtn().setOnAction((e) -> {
            if (model.isRunning()) {
                model.pauseTimer();
                model.setRunning(false);
            } else {
                model.startTimer();
                model.setRunning(true);
            }
        });
    }
}
   