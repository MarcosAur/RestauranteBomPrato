/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.dao.DaoFactory;
import model.dao.ItemDao;
import model.entities.Item;

/**
 * FXML Controller class
 *
 * @author marcos
 */
public class TelaCardapioController implements Initializable {

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
    public void onBtnCarrinhoAction(){
    
    }
    
    @FXML
    public void onBtnFinalizarAction(){
        
    }
    
    @FXML
    public void onBtnOkAction(){
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ItemDao itemDao = DaoFactory.createItemDao();
        List<Item> itens = itemDao.procurarTudo();
        ObservableList<Item> cardapio = FXCollections.observableArrayList(itens);
        LvCardapio.setItems(cardapio);
    }    
    
}
