package model.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.entities.Cliente;
import model.exceptions.ArquivoCorrompidoException;

/**
 *
 * @author marcos
 */
public class ServicoDeLogin {

    private static List<Cliente> coletarInformacoes() {
        List<Cliente> dadosPessoais = new ArrayList<>();
        File file = new File("../BancoDeDados/Clientes.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String textoPuro = sc.nextLine();
                String[] dadosCliente = textoPuro.split(",");
                Cliente cliente = new Cliente(Integer.parseInt(dadosCliente[0]), dadosCliente[1], dadosCliente[2], dadosCliente[3]);
                dadosPessoais.add(cliente);
            }

        } catch (IOException e) {
            throw new ArquivoCorrompidoException(e.getMessage());
        }

        return dadosPessoais;
    }

    public static Cliente validarLogin(String login, String senha) {
        List<Cliente> dadosPessoais = coletarInformacoes();
        Cliente tentandoLogar = new Cliente(null, login, senha, null);
        for (Cliente cliente : dadosPessoais) {
            if (cliente.hashCode() == tentandoLogar.hashCode()) {
                return cliente;
            }
        }

        return null;
    }
}
