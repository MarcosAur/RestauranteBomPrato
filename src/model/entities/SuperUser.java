package model.entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.services.GenerateLogs;

/**
 *
 * @author marcos
 */
public class SuperUser {

    private static int generateId(String path) {
        try (BufferedReader bw = new BufferedReader(new FileReader(path))) {
            Stream s = bw.lines();
            List<String> r = (List<String>) s.collect(Collectors.toList());
            return r.size() + 2;

        } catch (IOException ex) {
            Logger.getLogger(GenerateLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void createIten(String name, double value) {
        int id = 0;
        
        id = SuperUser.generateId("../Arquivos/itens.txt");
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../Arquivos/itens.txt", true))) {
            bw.write(id + "," + name + "," + value);
            bw.newLine();

        } catch (IOException ex) {
            Logger.getLogger(GenerateLogs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void createClient(String name, String address, String senha) {
        int id = 0;
        
        id = SuperUser.generateId("../Arquivos/users.txt");
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../Arquivos/users.txt", true))) {
            bw.write(id + "," + name + "," + senha + "," + address);
            bw.newLine();

        } catch (IOException ex) {
            Logger.getLogger(GenerateLogs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void lerCardapio(){
        try(BufferedReader br = new BufferedReader(new FileReader("../Arquivos/itens.txt"))){
            String iten = br.readLine();
            System.out.println("Cardapio:");
            while(iten != null){
                String[] manobra = iten.split(",");
                System.out.println(manobra[0] + " - " + manobra[1] + " - $" + manobra[2]);
                iten = br.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SuperUser.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            Logger.getLogger(SuperUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
