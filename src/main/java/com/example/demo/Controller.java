package com.example.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Controller {
    @FXML
    public GridPane theGrid;

    @FXML
    public Button submitInFile;

    ObservableList<String> lengths = FXCollections.observableArrayList("week/s", "month/s", "year/s");

    /**
     * Initial amount to calculate interest on.
     */
    @FXML
    private TextField amount;

    /**
     * final amount and instructions label.
     */
    @FXML
    private Label finalAmount, instructions;

    /**
     * Interest to be applied to amount.
     */
    @FXML
    private TextField interest;

    /**
     * The time fraction to calculate interest on, week/s, month/s, year/s.
     */
    @FXML
    private ChoiceBox timeLength;

    /**
     * The amount of fractions to calculate interest on. e.g. 2 x weeks
     */
    @FXML
    private TextField amountOfTime;

    /**
     * Submit button for calculation.
     */
    @FXML
    private Button submit;

    /**
     * set array for choice box and assigned present value on load.
     * disables submit button until amount entered.
     */
    @FXML
    private void initialize() {
        timeLength.setItems(lengths);
        timeLength.setValue(lengths.get(0));
        submit.setDisable(true);
    }

    /**
     * When amount entered submit becomes available.
     */
    @FXML
    public void handleRelease() {
        String text = amount.getText();
        submit.setDisable(text.isEmpty());
    }

    /**
     * Take entered figures and calculate amount of interest earned
     * This only calculates based on p/a interest with no compounding.
     *
     * @param event The submit button being pressed.
     */
    @FXML
    public void Submit(Event event) {
        boolean isValid = true;

        if (validatePositiveNumber(amount)) isValid = false;
        if (validatePositiveNumber(interest)) isValid = false;
        if (validatePositiveNumber(amountOfTime)) isValid = false;

        if (isValid) {
            double amountInt = Double.parseDouble(amount.getText());
            double annualInterestRate = Double.parseDouble(interest.getText()) / 100;
            double amountOfTimeInt = Double.parseDouble(amountOfTime.getText());
            double timeLengthInMonths = switch (timeLength.getValue().toString()) {
                case "year/s" -> 12;
                case "month/s" -> 1;
                case "week/s" -> (double) 1 /4;
                default -> 1;
            };


            timeLengthInMonths = amountOfTimeInt * timeLengthInMonths;


            double finalInterest = amountInt * Math.pow(1 + annualInterestRate / 12, timeLengthInMonths) - amountInt;
            String s = String.format("%.2f", finalInterest);
            finalAmount.setText("Your income is: " + s);
        } else {
            instructions.setText("Please complete all fields with positive numbers!");
        }
    }

    private boolean validatePositiveNumber(TextField textField) {
        try {
            double number = Double.parseDouble(textField.getText());
            if (number < 0) {
                textField.setStyle("-fx-border-color: red;");
                return true;
            } else {
                textField.setStyle("-fx-border-color: ;");
                return false;
            }
        } catch (NumberFormatException nfe) {
            textField.setStyle("-fx-border-color: red;");
            return true;
        }
    }

    @FXML
    public void SubmitInFile(MouseEvent mouseEvent) {
        String text = finalAmount.getText();
        if (!text.isEmpty()) {
            try {

                File file = new File("text.txt");

                FileWriter writer = new FileWriter(file, true);
                writer.write(text + "\n");
                instructions.setText("Data successfully written to file.");
                writer.close();

            } catch (IOException e) {
                instructions.setText(e.toString());
            }
        }
    }
}