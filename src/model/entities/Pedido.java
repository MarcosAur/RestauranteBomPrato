package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Pedido {

    private List<ItemDePedido> itemDePedido = new ArrayList<>();
    private Cliente comprador;
    private Date momentoDaCompra;

    public Pedido(Cliente comprador) {
        this.comprador = comprador;
    }

    public List<ItemDePedido> getItemDePedido() {
        return itemDePedido;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public Date getMomentoDaCompra() {
        return momentoDaCompra;
    }

    public void addItem(ItemDePedido item) {
        if (item != null) {
            this.itemDePedido.add(item);
        }

    }
    public double valorTotal(){
        double valor = 0;
        
        for (ItemDePedido ordem : this.itemDePedido){
            valor += ordem.subtotal();
        }
        
        return valor;
    }
    
    public void comprar(){
        this.momentoDaCompra = new Date();
    }

    public void removerItem(ItemDePedido item) {
        if (item != null) {
            this.itemDePedido.remove(item);
        }

    }

}
