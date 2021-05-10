package model.dao;

import model.entities.Cliente;

/**
 *
 * @author marcos
 */
public interface ClienteDao {

    public Cliente login(Cliente tentandoLogar);
    public void cadastro(Cliente cadastrado);
    
}
