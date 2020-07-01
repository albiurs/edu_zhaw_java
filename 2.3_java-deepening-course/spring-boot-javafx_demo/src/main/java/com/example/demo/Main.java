package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * "Application" is inherited from javafx.application
 * javafx.Application must have a class that extends this Application class
 * This class will be the entry point for the application.
 * The Application class manages the life cycle of a JavaFX application.
 * Most important methods of javafx.application:
 *
 * 0: Application.launch(args) will be called from the main method when the application is started. This method
 *   launches the JavaFX application and doesn't return until the application has exited.
 *
 * 1: Application.Init() will run first after launching the application. In the Application class, thsi method
 *      is empty, so unless we override it, it won't do anything.
 *
 * 2: Application.Start() runs right after the init method. We have to override this class, as Start() is an abstract
 *      method in the Application class.
 *
 * 3: Application.Stop() usually called when the user closes the app window.
 *      This method is empty in the application class, unless we override it.
 */
public class Main extends Application {

    /**
     * Start():
     *
     * Stage: JavaFX container that extends the window class, so essentially it's a main window.
     * The JavaFX runtime constructs the initial stage and passes into the start method.
     * Only one stage can be created (= only one top-level window).
     *
     * Dialogs: are presented within a stage. We use the dialogue class which wraps the dialogue into a stage forrest.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{

        // load the UI from .fxml file
        Parent root = FXMLLoader.load(getClass().getResource("demo.fxml"));

        // same settings as loaded from demo.fxml
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setVgap(10);
//        root.setHgap(10);
//
//        Label greeting = new Label("Welcome to JavaFX!");
//        greeting.setTextFill(Color.GREEN);
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));
//
//        root.getChildren().add(greeting);


        primaryStage.setTitle("Hello JavaFX!");
        primaryStage.setScene(new Scene(root, 700, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
