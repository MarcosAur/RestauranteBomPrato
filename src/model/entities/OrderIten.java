package model.entities;
/**
 *
 * @author marcos
 */
public class OrderIten implements Comparable<OrderIten> {
    private Integer quantity;
    private Iten iten;

    public OrderIten(Integer quantity, Iten iten) {
        this.quantity = quantity;
        this.iten = iten;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Iten getIten() {
        return iten;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double subtotal(){
        return iten.getValue() * this.quantity;
    }

    @Override
    public int compareTo(OrderIten o) {
        return this.getIten().getName().compareTo(o.getIten().getName());
    }
}
