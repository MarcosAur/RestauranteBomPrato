/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import application.Programa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.db.DbException;
import model.entities.Cliente;
import views.util.Alerts;
import views.util.MudarTela;

/**
 * FXML Controller class
 *
 * @author marcos
 */
public class TelaCadastroController implements Initializable {

    @FXML
    private VBox vbox;
    
    @FXML
    private TextField tfLogin;
    
    @FXML
    private PasswordField tfSenha;
    
    @FXML
    private TextField tfEndereco;
    
    @FXML
    private Button btnCadastrar;
    
    @FXML
    public void onBtnCadastrarAction() throws Exception{
        ClienteDao clienteDao = DaoFactory.createClienteDao();
        Cliente cadastrado = new Cliente(null, tfLogin.getText(), tfSenha.getText(), tfEndereco.getText());
        
        boolean cadastrou = clienteDao.cadastro(cadastrado);
        
        if(cadastrou){
            Scene scene = Programa.getScene();
            Stage stage = (Stage)scene.getWindow();
            stage.close();
            Programa programa = new Programa();
            programa.start(new Stage());
            Alerts.showAlert("Cliente Cadastrado", "Informações", cadastrado.toString(), Alert.AlertType.CONFIRMATION);
        }else{
            Alerts.showAlert("Erro ao cadastrar", null, "Favor tentar novamente", Alert.AlertType.ERROR);
            throw new DbException("Arquivo Corrompido");
        }
        
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
