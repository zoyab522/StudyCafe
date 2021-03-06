package com.mycompany.studycafe;

public class Controller {
    
    /**
     * 
     * @param model
     * @param view 
     */
    
    //Provides the functionality to start and stop (pause) the timer
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
   
