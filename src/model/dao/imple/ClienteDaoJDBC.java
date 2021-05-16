package model.dao.imple;

import model.dao.ClienteDao;
import model.entities.Cliente;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import model.db.DbException;
import model.db.ObjetosDB;
import views.util.Alerts;

/**
 *
 * @author marcos
 */
public class ClienteDaoJDBC implements ClienteDao {

    private PreparedStatement pst;
    private Connection conec;
    private ResultSet rs;

    public ClienteDaoJDBC() {
        conec = ObjetosDB.getConnection();
    }

    @Override
    public Cliente login(Cliente tentandoLogar) {
        Cliente retorno = null;
        String comando = "SELECT * FROM Clientes "
                + "WHERE nome = ? and senha = ?";

        try {
            pst = conec.prepareStatement(comando);

            pst.setString(1, tentandoLogar.getNome());
            pst.setString(2, tentandoLogar.getSenha());

            rs = pst.executeQuery();

            if (rs.next()) {
                retorno = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("senha"), rs.getString("endereco"));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ObjetosDB.closeStatement(pst);
            ObjetosDB.closeResultSet(rs);
        }

        return retorno;

    }

    @Override
    public boolean cadastro(Cliente cadastrar) {
        if (cadastrar.getNome().equals("") && cadastrar.getSenha().equals("") && cadastrar.getEndereco().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vazios", "Error", 0);
            throw new DbException("Campos vazios");
        }
        try {
            pst = conec.prepareStatement("INSERT INTO Clientes "
                    + "(nome, endereco, senha) "
                    + "VALUES "
                    + "(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, cadastrar.getNome());
            pst.setString(2, cadastrar.getEndereco());
            pst.setString(3, cadastrar.getSenha());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected == 0) {
                return false;
            } else {
                rs = pst.getGeneratedKeys();

                if (rs.next()) {
                    cadastrar.setId(rs.getInt(1));
                }
                return true;

            }

        } catch (SQLException e) {
            Alerts.showAlert("Erro ao cadastrar", null, "Erro ao cadastrar cliente\nFavor tentar novamente", Alert.AlertType.ERROR);
            throw new DbException(e.getMessage());
        } finally {
            ObjetosDB.closeResultSet(rs);
            ObjetosDB.closeStatement(pst);
        }

    }

}
