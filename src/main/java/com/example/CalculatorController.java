package com.example;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
    private Slider tempSlider;

    @FXML
    private Label tempLabel;

    @FXML
    private Label outputLabel;

    // Clear the screen
    @FXML
    void clearScreen(ActionEvent event) {
        windValueFactory.setValue(0);
        tempSlider.setValue(0);

        String output = "You cleared the screen!!!!!\n";
        output += " Temperature is now " + tempSlider;
        outputLabel.setText(output);
    }

    @FXML
    void calculateWindchill(ActionEvent event) {
        // Get wind and temp
        int wind = windSpinner.getValue();
        double temperature = tempSlider.getValue();

        // Calculate windchill
        double windchill = 0.0;

        // Format output
        String output = new String();
        output = "A windspeed of " + wind + " mph at a temperature of ";
        output += temperature + " degrees F feels like " + windchill + " degrees F.";

        // Display results
        outputLabel.setText(output);
    }

    // When the GUI loads (init)
    @FXML
    void initialize() {
        // Value Factories
        windSpinner.setValueFactory(windValueFactory);
        tempSlider = new Slider(-200, 50, 0);
        
    }

}
