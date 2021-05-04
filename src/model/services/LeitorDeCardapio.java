package model.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.exceptions.ArquivoCorrompidoException;

/**
 *
 * @author marcos
 */
public class LeitorDeCardapio {

    private static List<String> lerPratos(String tipoCardapio) {
        String caminhoParaArquivo = null;
        BufferedReader br = null;
        List<String> listaCardapio = new ArrayList();

        try {
            caminhoParaArquivo = acharCaminho(tipoCardapio);
            br = new BufferedReader(new FileReader(caminhoParaArquivo));
            String textoPuro = br.readLine();
            while (textoPuro != null) {
                String[] colunasCardapio = textoPuro.split(",");//0 - Id, 1 - Nome, 2 - Valor
                listaCardapio.add(colunasCardapio[0] + "-" + colunasCardapio[1] + "-R$" + colunasCardapio[2]);
                textoPuro = br.readLine();

            }

            return listaCardapio;

        } catch (IOException e) {
            throw new ArquivoCorrompidoException(e.getMessage());
        }
    }

    public static String[] retornarVetorCardapio() {
        String[] cardapio = null;

        List<String> listaPratosPrincipais = lerPratos("PratosPrincipais");
        List<String> listaSobremesas = lerPratos("Sobremesas");
        List<String> listaSucos = lerPratos("Sucos");
        final int TAMANHO_CARDAPIO = listaPratosPrincipais.size() + listaSobremesas.size() + listaSucos.size();

        cardapio = new String[TAMANHO_CARDAPIO];
        int contador = 0;

        for (String alimento : listaPratosPrincipais) {
            cardapio[contador] = alimento;
            contador++;
        }
        for (String alimento : listaSobremesas) {
            cardapio[contador] = alimento;
            contador++;
        }
        for (String alimento : listaSucos) {
            cardapio[contador] = alimento;
            contador++;
        }

        return cardapio;
    }

    private static String acharCaminho(String tipoCardapio) throws IOException {
        if (tipoCardapio.replace(" ", "").equals("PratosPrincipais")) {
            return "BancoDeDados/PratosPrincipais.txt";
        } else if (tipoCardapio.equals("Sobremesas")) {
            return "BancoDeDados/Sobremesas.txt";
        } else if (tipoCardapio.equals("Sucos")) {
            return "BancoDeDados/Sucos.txt";
        } else {
            String mensagemErro = "Arquivo \"" + tipoCardapio + "\" Inexestente";
            throw new IOException(mensagemErro);
        }
    }

}
