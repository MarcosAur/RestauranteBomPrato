/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.util;

import javafx.scene.control.TextField;

/**
 *
 * @author marcos
 */
public class Constraints {

    public static void setTextFieldInteger(TextField tx) {
        tx.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                tx.setText(oldValue);
            }
        });

    }

    public static void setTextFieldMaxLength(TextField tx, int max) {
        tx.textProperty().addListener((obs, oldValue, newValue) -> {
            if (tx.getText() != null && tx.getText().length() > max) {
                tx.setText(oldValue);
            }
        });
    }

    public static void settextFieldDouble(TextField tx) {
        tx.textProperty().addListener((obs, oldValue, newValue) -> {
            if(newValue != null && newValue.matches("\\d*([\\.]\\d*)?")){
                tx.setText(oldValue);
            }
        });
    }

}
