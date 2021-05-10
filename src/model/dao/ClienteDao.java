package model.dao;

import model.entities.Cliente;

/**
 *
 * @author marcos
 */
public interface ClienteDao {

    public Cliente login(Cliente tentandoLogar);
    public boolean cadastro(Cliente cadastrado);
    
}
