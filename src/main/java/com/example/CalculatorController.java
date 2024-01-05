package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class CalculatorController {
    
    @FXML
    private Button calculateButton;

    @FXML
    private Button clearButton;

    @FXML
    private Spinner<Integer> windSpinner;
    SpinnerValueFactory<Integer> windValueFactory = //
    new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200, 0);

    @FXML
    private Spinner<Integer> tempSpinner;
    SpinnerValueFactory<Integer> tempValueFactory = //
    new SpinnerValueFactory.IntegerSpinnerValueFactory(-200, 60, 0);

    @FXML
    private Label outputLabel;

    // Clear the screen
    @FXML
    void clearScreen(ActionEvent event) {
        windValueFactory.setValue(0);
        tempValueFactory.setValue(0);

        int tempValue = tempValueFactory.getValue();

        String output = "You cleared the screen!!!!!";
        output += " Temperature is now " + tempValue;
        outputLabel.setText(output);
    }

    // When the GUI loads (init)
    @FXML
    void initialize() {
        // Value Factories
        windSpinner.setValueFactory(windValueFactory);
        tempSpinner.setValueFactory(tempValueFactory);
    }

}
