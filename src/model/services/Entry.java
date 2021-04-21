package model.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.entities.Client;

/**
 *
 * @author marcos
 */
public class Entry {
        
    public static Client validarLogin(String nome, String senha) {
        try (BufferedReader bw = new BufferedReader(new FileReader("../Arquivos/users.txt"))) {
            Stream s = bw.lines();
            List<String> r = (List<String>) s.collect(Collectors.toList());
            
            for (String cliente: r){
                String[] manobra = cliente.split(",");
                if ((manobra[1].equals(nome)) && (manobra[2].equals(senha))){
                    return new Client(manobra[1], manobra[3], Integer.parseInt(manobra[0]));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(GenerateLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
