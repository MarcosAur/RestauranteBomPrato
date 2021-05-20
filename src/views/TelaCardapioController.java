/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import application.Programa;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.dao.DaoFactory;
import model.dao.ItemDao;
import model.db.ObjetosDB;
import model.entities.Item;
import model.entities.ItemDePedido;
import model.entities.Pedido;
import views.util.Alerts;
import views.util.Constraints;

/**
 * FXML Controller class
 *
 * @author marcos
 */
public class TelaCardapioController implements Initializable {

    private ItemDao itemDao = DaoFactory.createItemDao();
    private Pedido pedido = Programa.getPedido();

    @FXML
    private ListView LvCardapio;

    @FXML
    private Button btnCarrinho;

    @FXML
    private Button btnFinalizar;

    @FXML
    private ComboBox cbProduto;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private Button btnOk;

    @FXML
    public void onBtnCarrinhoAction() {
        Programa.setPedido(pedido);
        Programa.mudarTela.loadView("/views/TelaCarrinho.fxml");
    }

    @FXML
    public void onBtnFinalizarAction() {

        String nota = pedido.comprar();
        JOptionPane.showMessageDialog(null,nota,"Confirmação de Pedido", 1);
        Scene scene = Programa.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
        ObjetosDB.closeConnection();
        System.exit(0);
    }

    @FXML
    public void onBtnOkAction() {
        if (!cbProduto.getSelectionModel().isEmpty() && !tfQuantidade.getText().isBlank()) {
            Item item = itemDao.procurarItem(cbProduto.getSelectionModel().getSelectedIndex() + 1);
            int quantidade = Integer.parseInt(tfQuantidade.getText());
            ItemDePedido itemDePedido = new ItemDePedido(item, quantidade);
            pedido.addItem(itemDePedido);
            Alerts.showAlert("Item Adicionado", "Item", itemDePedido.toString(), Alert.AlertType.CONFIRMATION);
            cbProduto.getSelectionModel().clearSelection();
            tfQuantidade.setText("");

        } else {
            Alerts.showAlert("Campos Vazios", null, "Campos de preenchimento Obrigatorio\nvazios", Alert.AlertType.WARNING);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemDao = DaoFactory.createItemDao();
        List<Item> itens = itemDao.procurarTudo();
        ObservableList<Item> cardapio = FXCollections.observableArrayList(itens);

        List<String> nomes = new ArrayList();
        for (Item item : itens) {
            nomes.add(item.getNome());
        }

        ObservableList<String> nomesPratos = FXCollections.observableArrayList(nomes);

        LvCardapio.setItems(cardapio);
        cbProduto.setItems(nomesPratos);
        Constraints.setTextFieldInteger(tfQuantidade);
    }

}
