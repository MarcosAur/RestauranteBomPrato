package views;

import application.Programa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;
import views.util.Alerts;

/**
 * FXML Controller class
 *
 * @author marcos
 */
public class TelaLoginController implements Initializable {

    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField tfSenha;

    @FXML
    public void onBtnLoginAction() {
        ClienteDao clienteDao = DaoFactory.createClienteDao();
        Cliente cliente = clienteDao.login(new Cliente(null, tfLogin.getText(), tfSenha.getText(), null));

        if (cliente != null) {
            Programa.getPedido().setComprador(cliente);
            Programa.mudarTela.loadView("/views/TelaCardapio.fxml");
        } else {
            String msg = "O cliente com os dados informados\nnão foi encontrado";
            Alerts.showAlert("Erro", "Cliente inexistenexistete", msg, Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void onBtnCadastroAction() {
        Programa.mudarTela.loadView("/views/TelaCadastro.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
