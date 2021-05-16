/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.entities.Item;

/**
 *
 * @author marcos
 */
public interface ItemDao {
    public boolean criarItem(Item item);
    public Item procurarItem(Integer id);
    public List<Item> procurarTudo();
}
