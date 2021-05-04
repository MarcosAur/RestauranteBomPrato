package model.services;

import model.entities.Item;
import model.entities.ItemDePedido;

/**
 *
 * @author marcos
 */
public class FabricaItensDePedido {
    
    private static Item acharItem(String item){
        String[] manobra = item.split("-");
        Double valor = Double.parseDouble(manobra[2].replace("R$", ""));
        Item produtoSelecionado = new Item(Integer.parseInt(manobra[0]),manobra[1],valor);
        return produtoSelecionado;
    }
    
    public static ItemDePedido gerarItemDePedido(String item, Integer quantidade){
        Item itemSelecionado = acharItem(item);
        ItemDePedido ordem = new ItemDePedido(itemSelecionado,quantidade);
        return ordem;
    }
}
