package model.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.exceptions.ArquivoCorrompidoException;

/**
 *
 * @author marcos
 */
public class LeitorDeCardapio {

    public static void lerPratos(String tipoCardapio) {
        String caminhoParaArquivo = null;
        BufferedReader br = null;

        try {
            caminhoParaArquivo = acharCaminho(tipoCardapio);
            br = new BufferedReader(new FileReader(caminhoParaArquivo));
            String textoPuro = br.readLine();
            System.out.println("Cardapio de " + tipoCardapio);
            while (textoPuro != null) {
                String[] colunasCardapio = textoPuro.split(",");//0 - Id, 1 - Nome, 2 - Valor
                System.out.print(colunasCardapio[0]);
                System.out.print(" - " + colunasCardapio[1]);
                System.out.println(" R$" + colunasCardapio[2]);
                textoPuro = br.readLine();

            }
            System.out.println("");

        } catch (IOException e) {
            throw new ArquivoCorrompidoException(e.getMessage());
        }
    }

    private static String acharCaminho(String tipoCardapio) throws IOException {
        if (tipoCardapio.replace(" ", "").equals("PratosPrincipais")) {
            return "../BancoDeDados/PratosPrincipais.txt";
        } else if (tipoCardapio.equals("Sobremesas")) {
            return "../BancoDeDados/PratosPrincipais.txt";
        } else if (tipoCardapio.equals("Sucos")) {
            return "../BancoDeDados/Sucos.txt";
        } else {
            String mensagemErro = "Arquivo \"" + tipoCardapio + "\" Inexestente";
            throw new IOException(mensagemErro);
        }
    }
    
    
}
