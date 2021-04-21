package model.services;

import model.entities.Client;
import model.entities.OrderIten;

/**
 *
 * @author marcos
 */
public class Buy {
    public static String generateInvoice(Client c){
        double totalValue = 0;
        String products = "";
        for (OrderIten oi : c.getItens()){
            totalValue += oi.subtotal();
            products += oi.getQuantity() + " - " + oi.getIten().getName() + " - $" + oi.subtotal() + "\n";
        }
        
        return "Name: "+ c.getName()
                +"\nAddress: " + c.getAddress()
                +"\nTotal Value: " + totalValue
                +"\nProducts:\n"
                +products;
    }
}
