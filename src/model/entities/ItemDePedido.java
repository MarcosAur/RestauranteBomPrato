package model.entities;

/**
 *
 * @author marcos
 */
public class ItemDePedido {

    private Item item;
    private Integer quantidadeDeItens;

    public ItemDePedido(Item item, Integer quantidadeDeItens) {
        this.item = item;
        this.quantidadeDeItens = quantidadeDeItens;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantidadeDeItens() {
        return quantidadeDeItens;
    }

    public void setQuantidadeDeItens(Integer quantidadeDeItens) {
        this.quantidadeDeItens = quantidadeDeItens;
    }

    public Double subtotal() {
        double subtotal = item.getPreco() * quantidadeDeItens;
        return subtotal;
    }

}
