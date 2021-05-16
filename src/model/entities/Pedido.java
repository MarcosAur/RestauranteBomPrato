package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.services.GeradorComanda;

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

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
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
    
    public String comprar(){
        this.momentoDaCompra = new Date();
        return GeradorComanda.geradorNotaFiscal(this);
        
    }

    public void removerItem(ItemDePedido item) {
        if (item != null) {
            this.itemDePedido.remove(item);
        }

    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String produtos = "";
        
        for (ItemDePedido oi : itemDePedido ){
            produtos += oi + "\n";
        }
        String msg = "Cliente: " + comprador.getNome()
                   + "Momento da Compra: " + sdf.format(this.momentoDaCompra)
                   + "Produtos: " + produtos
                   + "Valor Total: R$" + this.valorTotal();
        
        
        
        return msg;
    }
    
    

}
