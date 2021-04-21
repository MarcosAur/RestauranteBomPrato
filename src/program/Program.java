package program;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Client;
import model.entities.Iten;
import model.entities.OrderIten;
import model.entities.SuperUser;
import model.services.Buy;
import model.services.Entry;
import model.services.GenerateLogs;

/**
 *
 * @author marcos
 */
public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String nome = "";
        String senha = "";
        System.out.print("Deseja cadastrar ou fazer login? (C/L):");
        Client c = null;
        String cl = sc.nextLine();
        
        if(cl.toUpperCase().charAt(0) == 'L'){
            while(c == null){
            System.out.println("Digite suas informações de Login: ");
            System.out.print("Nome: ");
            nome = sc.nextLine();
            System.out.print("Senha: ");
            senha = sc.nextLine();
            System.out.println("");
            c = Entry.validarLogin(nome, senha);
            }
        }else if(cl.toUpperCase().charAt(0) == 'C'){
            System.out.println("Digite suas informações de Cadastro: ");
            System.out.print("Nome: ");
            nome = sc.nextLine();
            System.out.print("Senha: ");
            senha = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            SuperUser.createClient(nome, address, senha);
            System.exit(0);
        }else{
            System.out.println("Opção inválida!!");
            System.exit(0);
        }
        
        
        
        SuperUser.lerCardapio();
        System.out.println("");
        
        
        String decisao = "S";
        
        while(decisao.toUpperCase().charAt(0) == 'S'){
            System.out.print("Digite o id do produto que deseja comprar: ");
            int idProduto = sc.nextInt();
            Iten i = Iten.acharIten(idProduto);
            if(i != null){
                System.out.print("Quantidade: ");
                int quantity = sc.nextInt();
                c.addIten(new OrderIten(quantity,i));
            }else{
                System.out.println("Produto inexistente!!!");
                continue;
            }
            System.out.println("");
            System.out.print("Deseja pedir um novo produto? (S/N): ");
            sc.nextLine();
            decisao = sc.nextLine();
            System.out.println("");
        }
        
        String invoice = Buy.generateInvoice(c);
        System.out.println(invoice);
        System.out.print("Confirmar compra?(S/N): ");
        decisao = sc.nextLine();
        
        if(decisao.toUpperCase().charAt(0) == 'S'){
            GenerateLogs.logHistory(invoice);
            GenerateLogs.sendEmail(invoice);
            System.out.println("Pedido enviado!!");
        }else{
            System.out.println("Pedido não enviado");
        }
        System.out.println("Muito Obrigado!!");
        
    }

}
