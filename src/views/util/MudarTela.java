/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.util;

import application.Programa;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author marcos
 */
public class MudarTela {
    private FXMLLoader loader ;
    public void loadView(String path) {
        try {
            loader = new FXMLLoader(getClass().getResource(path));
            VBox newVbox = loader.load();
            
            Scene oldScene = Programa.getScene();
            VBox oldVBox = (VBox)((ScrollPane)oldScene.getRoot()).getContent();
            
            oldVBox.getChildren().clear();
            oldVBox.getChildren().addAll(newVbox.getChildren());
            
        } catch (IOException ex) {
            Alerts.showAlert("Open Error", "Error: ", ex.getMessage(), Alert.AlertType.ERROR);
            ex.printStackTrace();
        }
        
    }
    
}
