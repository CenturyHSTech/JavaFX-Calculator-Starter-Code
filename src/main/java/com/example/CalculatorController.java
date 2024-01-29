package com.example;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class CalculatorController implements Initializable {
    
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

    int temperature;
    int windspeed;
    double windchill;

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

        windspeed = windSpinner.getValue();
        temperature = (int) tempSlider.getValue();

        // Calculate windchill
        windchill = getWindChill(temperature, windspeed);

        // Format output
        String output = new String();
        output = "A windspeed of " + windspeed + " mph at a temperature of ";
        output += temperature + "°F feels like " + windchill + "°F.";

        // Display results
        outputLabel.setText(output);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Set initial values
        tempLabel.setText("0°F");
        windSpinner.setValueFactory(windValueFactory);
        tempSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                temperature = (int) tempSlider.getValue();
                tempLabel.setText( Integer.toString(temperature) + "°F"); // Alt + 0176 (for degree sign)
            }
        });
        outputLabel.setWrapText(true);
    }

    private double getWindChill(int t, int w) {
        double windchill;
        if (t == 0 && w == 0) {
            windchill = 0.0;
        }
        else {
            windchill = 35.74 + 0.6215 * t - 35.75 * Math.pow(w, 0.16) + 0.4275 * t * Math.pow(w, 0.16);
        }
        windchill = Math.round(windchill);
        return windchill;
    }
}
