package views;

import application.Programa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.entities.ItemDePedido;
import model.entities.Pedido;

/**
 * FXML Controller class
 *
 * @author marcos
 */
public class TelaCarrinhoController implements Initializable {

    @FXML
    private ListView lsView;

    @FXML
    private Button btnRetorno;

    @FXML
    private Label lblValor;

    @FXML
    public void onBtnRetornarAction() {
        Programa.mudarTela.loadView("/views/TelaCardapio.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pedido p = Programa.getPedido();

        ObservableList<ItemDePedido> os = FXCollections.observableArrayList(p.getItemDePedido());
        lsView.setItems(os);
        lblValor.setText(lblValor.getText() + " R$" + p.valorTotal());

    }

}
