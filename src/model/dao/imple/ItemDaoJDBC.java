package model.dao.imple;

import java.io.IOException;
import java.util.List;
import model.dao.ItemDao;
import model.entities.Item;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.db.DbException;
import model.db.ObjetosDB;
import model.entities.enuns.TipoItens;

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
        }

    }

    @Override
    public Item procurarItem(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> procurarTudo() {
        List<Item> cardapio = new ArrayList<>();
        String comando = "SELECT * FROM Pratos";

        try {
            pst = conn.prepareStatement(comando);
            rs = pst.executeQuery();

            while (rs.next()) {
                Item item = new Item(rs.getInt("id"), TipoItens.valueOf(rs.getString("tipo")), rs.getString("nome"), rs.getDouble("valor"));
                cardapio.add(item);
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        return cardapio;

    }

}
