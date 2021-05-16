/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exceptions;

import javafx.scene.control.Alert;
import views.util.Alerts;

/**
 *
 * @author marcos
 */
public class ArquivoCorrompidoException extends RuntimeException{
    public ArquivoCorrompidoException(String msg){
        super(msg);
        Alerts.showAlert("Erro", "Possivel Corrupção\nde arquivos", msg, Alert.AlertType.ERROR);
    }
}
