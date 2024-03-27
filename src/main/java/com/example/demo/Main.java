package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * The Main class serves as the entry point for the JavaFX application.
 */
public class Main extends Application {

    /**
     * The start method is called by the JavaFX framework to initialize the application.
     *
     * @param primaryStage the primary stage for the application
     * @throws Exception if an error occurs during initialization
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));

        // Set the title of the stage
        primaryStage.setTitle("Calculate Interest");

        // Set the scene with the loaded FXML content
        primaryStage.setScene(new Scene(root));

        // Disable resizing of the stage
        primaryStage.setResizable(false);

        // Show the primary stage
        primaryStage.show();
    }

    /**
     * The main method, which launches the JavaFX application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
