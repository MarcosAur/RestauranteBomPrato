package application;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Cliente;
import model.services.ServicoDeLogin;
import model.services.LeitorDeCardapio;

/**
 *
 * @author marcos
 */
public class Programa {

    public static void main(String[] args) {
        final List<String> TIPOS_CARDAPIO = Arrays.asList("Pratos Principais", "Sobremesas", "Sucos");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Faça login na plataforma");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String Senha = sc.nextLine();
        
        Cliente clienteLogado = ServicoDeLogin.validarLogin(login, Senha);
        
        if(clienteLogado == null){
            System.out.println("Login ou senha invalidos");
            System.exit(0);
        }
        
        for (String caminho : TIPOS_CARDAPIO) {
            LeitorDeCardapio.lerPratos(caminho);
        }
        
        System.out.println("");
        
        System.out.print("Informe o id do Produto que deseja comprar: ");
        int idProduto = sc.nextInt();
        System.out.print("Informe a quantidade: ");
        int quantidade = sc.nextInt();

    }
}
