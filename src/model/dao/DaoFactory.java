package model.dao;

import model.dao.imple.ClienteDaoJDBC;

/**
 *
 * @author marcos
 */
public class DaoFactory {

    public static ClienteDao createClienteDao() {
        return new ClienteDaoJDBC();
    }

}
