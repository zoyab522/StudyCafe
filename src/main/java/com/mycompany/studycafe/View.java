package com.mycompany.studycafe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
//import javafx.scene.web.WebView;

public class View {
    
    private final Label studySessionNumLbl, whatsNextLbL, timerLbl, introLbl, introLblTwo, introLabelThree, toDoLbl;
    private final Button startPauseBtn;
    private final Scene scene;
    private final TabPane tabPane;
    private final Tab tabTimer;
    private final Tab tabWelcome;
    private final Tab tabBackground;
    private final Tab tabBackground2;
    private final Tab tabTasks;
    private final Tab tabMusic;
    private final Tab tabWhiteboard;
    private final Tab tabCalendar;
    private final Canvas canvas;
    private final Canvas canvas2;

    // GUI Setup
    public View() {
        tabPane = new TabPane();
        tabTimer = new Tab("Timer");
        tabWelcome = new Tab("Welcome - Background 1");
        tabBackground = new Tab("Background 2");
        tabBackground2 = new Tab("Background 3");
        tabTasks = new Tab("Tasks");
        tabMusic = new Tab("Music");
        tabWhiteboard = new Tab("Whiteboard");
        tabCalendar = new Tab("Calendar");
        canvas = new Canvas(1440, 700);
        canvas2 = new Canvas(1440, 700);
        tabPane.getTabs().add(tabWelcome);
        tabPane.getTabs().add(tabBackground);
        tabPane.getTabs().add(tabBackground2);
        tabPane.getTabs().add(tabTimer);
        tabPane.getTabs().add(tabTasks);
        tabPane.getTabs().add(tabMusic);
        tabPane.getTabs().add(tabWhiteboard);
        tabPane.getTabs().add(tabCalendar);
        
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Set up the timer tab
        timerLbl = new Label("25:00");
        timerLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 180));
        startPauseBtn = new Button("Start • Pause");
        startPauseBtn.setStyle("-fx-background-color: rgb(59,47,47); -fx-text-fill: white;"); 
        
        studySessionNumLbl = new Label();
        studySessionNumLbl.setFont(Font.font("Noteworthy", FontWeight.BOLD, 30));
        whatsNextLbL = new Label();
        whatsNextLbL.setFont(Font.font("Noteworthy", FontWeight.BOLD, 30));
        HBox hboxOne = new HBox(timerLbl);
        HBox hboxTwo = new HBox(startPauseBtn);
        HBox hboxThree = new HBox(studySessionNumLbl, whatsNextLbL);
        
        hboxOne.setAlignment(Pos.CENTER);
        hboxTwo.setAlignment(Pos.CENTER);
        hboxThree.setAlignment(Pos.CENTER);
        hboxThree.setSpacing(20);
        
        VBox vBoxTimer = new VBox(hboxOne, hboxTwo, hboxThree);
        vBoxTimer.setSpacing(40);
        vBoxTimer.setAlignment(Pos.CENTER);
        tabTimer.setStyle("-fx-background-color: rgb(208, 187, 148); -fx-background-radius: 10;");
        vBoxTimer.setStyle("-fx-background-color: rgba(201, 136, 96, 0.5)");
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
        introLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        introLbl.setTextFill(Color.web("#ffffff"));
        introLbl.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, new Insets(0))));
        
        HBox iHBox = new HBox(introLbl);
        
        VBox stackBox = new VBox(iHBox);
        stackBox.setAlignment(Pos.CENTER);
        stackBox.setSpacing(20);
        
        HBox hStack = new HBox(stackBox);
        hStack.setAlignment(Pos.CENTER);

        ImageView imageViewTJG = new ImageView(image);
        imageViewTJG.setPreserveRatio(true); // so the img isn't distorted
        imageViewTJG.setFitHeight(810);
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageViewTJG, hStack);
        bHBox.getChildren().add(stackPane); 
        tabWelcome.setStyle("-fx-background-color: rgb(137, 91, 74); -fx-text-base-color: white; -fx-background-radius: 10;");
        
        tabWelcome.setContent(bHBox);
        
        //Set up Background Tab (first)
        HBox backHBox = new HBox();
        Image imageOne = null;
        
        try {
            imageOne = new Image(new FileInputStream("src/main/nightcafe.gif"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        introLblTwo = new Label("StudyCafe");
        introLblTwo.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        introLblTwo.setTextFill(Color.web("ffffff"));
        introLblTwo.setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, new Insets(0))));
        
        HBox iHBox2 = new HBox(introLblTwo);
        VBox stackBox2 = new VBox(iHBox2);
        stackBox2.setAlignment(Pos.CENTER);
        stackBox2.setSpacing(20);
        
        HBox hStack2 = new HBox(stackBox2);
        hStack2.setAlignment(Pos.CENTER);
        
        ImageView imageViewTJG2 = new ImageView(imageOne);
        imageViewTJG2.setPreserveRatio(true);
        imageViewTJG2.setFitHeight(840);
        
        StackPane stackPane2 = new StackPane();
        stackPane2.getChildren().addAll(imageViewTJG2, hStack2);
        backHBox.getChildren().add(stackPane2);
        tabBackground.setStyle("-fx-background-color: rgb(137, 91, 74); -fx-text-base-color: white; -fx-background-radius: 10;");
        tabBackground.setContent(backHBox);
        
        //Set up Background Tab (second)
        HBox backHBox2 = new HBox();
        Image imageTwo = null;
        
        try {
            imageTwo = new Image(new FileInputStream("src/main/coffee.gif"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        introLabelThree = new Label("StudyCafe");
        introLabelThree.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        introLabelThree.setTextFill(Color.web("ffffff"));
        introLabelThree.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, new Insets(0))));
        
        HBox iHBox3 = new HBox(introLabelThree);
        VBox stackBox3 = new VBox(iHBox3);
        stackBox3.setAlignment(Pos.CENTER);
        stackBox3.setSpacing(20);
        
        HBox hStack3 = new HBox(stackBox3);
        hStack3.setAlignment(Pos.CENTER);
        
        ImageView imageViewTJG3 = new ImageView(imageTwo);
        imageViewTJG3.setPreserveRatio(true);
        imageViewTJG3.setFitHeight(840);
        
        StackPane stackPane3 = new StackPane();
        stackPane3.getChildren().addAll(imageViewTJG3, hStack3);
        backHBox2.getChildren().add(stackPane3);
        tabBackground2.setStyle("-fx-background-color: rgb(137, 91, 74); -fx-text-base-color: white; -fx-background-radius: 10;");
        tabBackground2.setContent(backHBox2);


        //Sets up the Task Tab
        toDoLbl = new Label("To-Do List");
        toDoLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        toDoLbl.setStyle("-fx-text-fill: rgb(59,47,47);");
        
        //Checkboxes
        CheckBox box1 = new CheckBox("CTIS 310 Final Project");
        CheckBox box2 = new CheckBox("Study for French Exam");
        CheckBox box3 = new CheckBox("Read 30 pages of Macbeth");
        CheckBox box4 = new CheckBox("Create a post for the Code Club Insta");
        CheckBox box5 = new CheckBox("Do Calc Homework");
        CheckBox box6 = new CheckBox("Watch 10 Hours of Netflix");
        CheckBox box7 = new CheckBox("Finish Phase 3 of Aerospace Project");
        
        ArrayList<CheckBox> allTasks = new ArrayList<CheckBox>(); 
        allTasks.add(box1);
        allTasks.add(box2);
        allTasks.add(box3);
        allTasks.add(box4);
        allTasks.add(box5);
        allTasks.add(box6);
        allTasks.add(box7);
        
        TextField addTaskField = new TextField();
        addTaskField.setPromptText("Enter New Task");
        Button addTask = new Button("Add Task");
        addTask.setStyle("-fx-background-color: rgb(59,47,47); -fx-text-fill: white;"); 
        Button removeAllTasks = new Button("Remove All Tasks —————— CONFIRM?");
        removeAllTasks.setStyle("-fx-background-color: rgb(59,47,47); -fx-text-fill: white;"); 
        HBox hBoxTasks = new HBox(addTaskField, addTask);
        
        VBox vBoxTasks = new VBox(10);
        vBoxTasks.setPadding(new Insets(40,30,30,30));
        vBoxTasks.setSpacing(20);
        vBoxTasks.getChildren().addAll(toDoLbl, hBoxTasks, removeAllTasks, box1, box2, box3, box4, box5, box6, box7);
        
        HBox centerTasks = new HBox(vBoxTasks);
        centerTasks.setAlignment(Pos.CENTER);
        
        addTask.setOnAction(e -> addTaskOptions(addTaskField, vBoxTasks, allTasks));
        removeAllTasks.setOnAction(e -> removeAllTaskOptions(vBoxTasks, allTasks));
        tabTasks.setStyle("-fx-background-color: rgb(59, 38, 33); -fx-text-base-color: white; -fx-background-radius: 10");
        
        centerTasks.setStyle("-fx-background-color: rgba(154, 206, 235, 0.25)");
        
        tabTasks.setContent(centerTasks);  
        
        //Sets up the Music Tab
        /* Following Code Does Not Work due to the Bug with WebView "not existing"
        WebView musicView = new WebView();
        musicView.getEngine().load("https://youtu.be/-9yoQ39F6TA");
        VBox vBoxMusic = new VBox(musicView);
        */
        
        tabMusic.setStyle("-fx-background-color: rgb(62, 55, 53); -fx-text-base-color: white; -fx-background-radius: 10;");
        
        //Sets up the Whiteboard Tab
        Label titleWhiteboard = new Label("Whiteboard");
        titleWhiteboard.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        HBox hWhite = new HBox(titleWhiteboard);
        hWhite.setAlignment(Pos.CENTER);
        hWhite.setSpacing(20);
        
        GridPane grid = new GridPane();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        
        // 
        canvas.setOnMousePressed(e -> {
            gc.beginPath();
            gc.lineTo(e.getSceneX(), e.getSceneY()-100);
            gc.stroke();
        });
        
        canvas.setOnMouseDragged(e -> {
            gc.lineTo(e.getSceneX(), e.getSceneY()-100);
            gc.stroke();
        });
        
        //Creates Color Picker for the Marker Color
        ColorPicker cp = new ColorPicker();
        cp.setValue(Color.BLACK);
        cp.setOnAction(e -> {
            gc.setStroke(cp.getValue());
        });
        
        //Creates the Slider for the Marker Size
        Slider slider = new Slider();
        slider.setMin(1);
        slider.setMax(100);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        
        Label strokeVal = new Label();
        slider.valueProperty().addListener(e->{
            double value = slider.getValue();
            String strokeValStr = String.format("%.1f", value);
            strokeVal.setText(strokeValStr);
            gc.setLineWidth(value);
        });
        
        Button darkMode = new Button("Dark Mode");
        Button lightMode = new Button("Light Mode");
        
        grid.addRow(0, cp, slider, strokeVal, darkMode, lightMode);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20,0,0,0));
        
        VBox whiteboard = new VBox();
        whiteboard.setAlignment(Pos.CENTER);
                
        //Sets button to allow to change to dark or light mode
        darkMode.setOnAction(e -> {
            whiteboard.setStyle("-fx-background-color: rgb(0, 0, 0);");
            titleWhiteboard.setStyle("-fx-text-fill: white;");
        });
        lightMode.setOnAction(e -> {
            whiteboard.setStyle("-fx-background-color: rgb(255, 255, 255);");
            titleWhiteboard.setStyle("-fx-text-fill: black;");
        });
        
        whiteboard.getChildren().addAll(hWhite, grid, canvas);
        tabWhiteboard.setContent(whiteboard);
        tabWhiteboard.setStyle("-fx-background-color: rgb(137, 91, 74); -fx-text-base-color: white; -fx-background-radius: 10;");
        
        //Sets up the Calendar Tab
        HBox calBox = new HBox();
        Image imgCal = null;

        // Use a try-catch loop to get the image to work
        try {
            imgCal = new Image(new FileInputStream("src/main/april2022calendar.jpg"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        VBox stackBox1 = new VBox();
        stackBox1.setAlignment(Pos.CENTER);
        stackBox1.setSpacing(20);
        
        HBox hStack1 = new HBox(stackBox1);
        hStack1.setAlignment(Pos.CENTER);

        ImageView imageViewCal = new ImageView(imgCal);
        imageViewCal.setPreserveRatio(true); // so the img isn't distorted
        imageViewCal.setFitHeight(810);
        
        GraphicsContext gc1 = canvas2.getGraphicsContext2D();
        gc1.setStroke(Color.BLACK);
        gc1.setLineWidth(3);
        
        // 
        canvas2.setOnMousePressed(e -> {
            gc1.beginPath();
            gc1.lineTo(e.getSceneX(), e.getSceneY()-100);
            gc1.stroke();
        });
        
        canvas2.setOnMouseDragged(e -> {
            gc1.lineTo(e.getSceneX(), e.getSceneY()-100);
            gc1.stroke();
        });
        
        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().addAll(imageViewCal, hStack1, canvas2);
        calBox.getChildren().add(stackPane1); 
        calBox.setAlignment(Pos.CENTER);
        calBox.setStyle("-fx-background-color: rgb(255, 255, 255);");
        tabCalendar.setContent(calBox);
        tabCalendar.setStyle("-fx-background-color: rgb(208, 187, 148); -fx-background-radius: 10;");
       
        //Adds the tabPane of tabs to one VBox aand initializes the scene
        VBox vbox = new VBox(tabPane);
        scene = new Scene(vbox, 1440, 810);
        

    }
    
    
    //Relevant Methods
    /**
     * 
     * @param task
     * @param vBoxTasks
     * @param allTasks 
     */
    public void addTaskOptions(TextField task, VBox vBoxTasks, ArrayList allTasks){
        String taskName = task.getText();
        CheckBox box = new CheckBox(taskName);
        vBoxTasks.getChildren().add(box);
        allTasks.add(box);
    }
    
    /**
     * 
     * @param vBoxTasks
     * @param allTasks 
     */
    public void removeAllTaskOptions(VBox vBoxTasks, ArrayList allTasks){
        for (int i = 0; i < allTasks.size(); i++){
            vBoxTasks.getChildren().remove(allTasks.get(i));
        } 
    }
    
    /**
     * 
     * @return 
     */
    public TabPane gettabPane() {
        return tabPane;
    }

    /**
     * 
     * @return 
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * 
     * @return 
     */
    public Label getStudySessionNumLbl() {
        return studySessionNumLbl;
    }

    /**
     * 
     * @return 
     */
    public Label getWhatsNextLbL() {
        return whatsNextLbL;
    }

    /**
     * 
     * @return 
     */
    public Button getStartPauseBtn() {
        return startPauseBtn;
    }

    /**
     * 
     * @return 
     */
    public Label getTimerLbl() {
        return timerLbl;
    }

}
