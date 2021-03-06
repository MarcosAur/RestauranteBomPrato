package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import model.entities.ItemDePedido;
import model.entities.Pedido;
import model.exceptions.ArquivoCorrompidoException;

/**
 *
 * @author marcos
 */
public class GeradorComanda {

    public static String geradorNotaFiscal(Pedido pedido) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String itens = "";
        for (ItemDePedido ordem : pedido.getItemDePedido()) {
            itens += ordem + "\n-------------------------\n";
        }
        String notaFiscal = "Id Cliente: " + pedido.getComprador().getId()
                + "\nNome: " + pedido.getComprador().getNome()
                + "\nEndereço: " + pedido.getComprador().getEndereco()
                + "\nData: " + sdf.format(pedido.getMomentoDaCompra())
                + "\nValor Total: R$" + pedido.valorTotal()
                + "\nProdutos: \n"
                + itens;
        
        gerarEmail(notaFiscal);
        gerarLog(notaFiscal);
        return notaFiscal;
    }

    public static void gerarEmail(String nota) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../Servicos/Email.txt"))) {

            bw.write(nota);

        } catch (IOException ex) {
            throw new ArquivoCorrompidoException(ex.getMessage());
        }

    }

    public static void gerarLog(String nota) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../Servicos/Log.txt",true))) {

            bw.write(nota);
            bw.newLine();
            bw.newLine();

        } catch (IOException ex) {
            throw new ArquivoCorrompidoException(ex.getMessage());
        }
    }

}
