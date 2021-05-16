package model.dao;

import model.dao.imple.ClienteDaoJDBC;
import model.dao.imple.ItemDaoJDBC;

/**
 *
 * @author marcos
 */
public class DaoFactory {

    public static ClienteDao createClienteDao() {
        return new ClienteDaoJDBC();
    }
    
    public static ItemDao createItemDao(){
        return new ItemDaoJDBC();
    }

}
