package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class GenerateLogs {
    public static void logHistory(String nf){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("../Arquivos/logsVendas.txt",true))){
            bw.newLine();
            bw.write(nf);
            bw.write("__________________________");
            
        } catch (IOException ex) {
            Logger.getLogger(GenerateLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public static void sendEmail(String nf){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("../Arquivos/email.txt"))){
            bw.write(nf);
            
        } catch (IOException ex) {
            Logger.getLogger(GenerateLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
