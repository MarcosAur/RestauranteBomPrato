package model.entities;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author marcos
 */
public class Client {
    private String name;
    private String address;
    private Integer id;
    private Set<OrderIten> itens = new TreeSet<>();

    public Client(String name, String address, Integer id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getId() {
        return id;
    }

    public Set<OrderIten> getItens() {
        return itens;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void addIten(OrderIten i){
        if (!i.equals(null)){
           this.itens.add(i);
        }else{
            System.out.println("Error: Product is null!!!");
        }
        
    }
    public void removeIten(OrderIten i){
        if (this.itens.contains(i)){
           this.itens.remove(i);
        }else{
            System.out.println("Error: Product nonexistent!!!");
        }
        
    }
    
    
    
}
