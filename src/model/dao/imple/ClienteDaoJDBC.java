package model.dao.imple;

import model.dao.ClienteDao;
import model.entities.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import model.db.DbException;
import model.db.ObjetosDB;
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
        
        try{
            pst = conec.prepareStatement(comando);
            
            pst.setString(1,tentandoLogar.getNome());
            pst.setString(2,tentandoLogar.getSenha());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                retorno = new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("senha"),rs.getString("endereco"));
            }
            
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        
        return retorno;
        
    }

    @Override
    public void cadastro(Cliente cadastrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
