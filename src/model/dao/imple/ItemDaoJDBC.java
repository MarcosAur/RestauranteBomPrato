package model.dao.imple;

import java.util.List;
import model.dao.ItemDao;
import model.entities.Item;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import model.db.DbException;
import model.db.ObjetosDB;
import model.entities.enuns.TipoItens;
import views.util.Alerts;

/**
 *
 * @author marcos
 */
public class ItemDaoJDBC implements ItemDao {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;

    public ItemDaoJDBC() {
        conn = ObjetosDB.getConnection();
    }

    @Override
    public boolean criarItem(Item item) {
        String comando = "INSERT INTO Pratos "
                + "(nome, valor, tipo) "
                + "VALUES "
                + "(?,?,?)";

        try {
            pst = conn.prepareStatement(comando);
            pst.setString(1, item.getNome());
            pst.setDouble(2, item.getPreco());
            pst.setString(3, item.getTipo().toString());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected == 0) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            fecharTudo();
        }

    }

    @Override
    public Item procurarItem(Integer id) {
        Item item = null;
        String comando = "SELECT * FROM Pratos "
                + "WHERE id = ?";

        try {
            pst = conn.prepareStatement(comando);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                item = instanciarItem(rs);
            }

        } catch (SQLException e) {
            Alerts.showAlert("Erro no Banco", "Possivel Corrupção de dados", e.getMessage(), Alert.AlertType.NONE);
        }finally{
            fecharTudo();
        }

        return item;
    }

    @Override
    public List<Item> procurarTudo() {
        List<Item> cardapio = new ArrayList<>();
        String comando = "SELECT * FROM Pratos";

        try {
            pst = conn.prepareStatement(comando);
            rs = pst.executeQuery();

            while (rs.next()) {
                Item item = instanciarItem(rs);
                cardapio.add(item);
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            fecharTudo();
        }

        return cardapio;

    }

    private Item instanciarItem(ResultSet rs) throws SQLException {
        return new Item(rs.getInt("id"), TipoItens.valueOf(rs.getString("tipo")), rs.getString("nome"), rs.getDouble("valor"));
    }

    private void fecharTudo() {
        ObjetosDB.closeResultSet(rs);
        ObjetosDB.closeStatement(pst);
    }

}
