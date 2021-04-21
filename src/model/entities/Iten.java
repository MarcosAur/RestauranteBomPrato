package model.entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class Iten {
    private String name;
    private Integer id;
    private Double value;

    public Iten(String name, Integer id, Double valor) {
        this.name = name;
        this.id = id;
        this.value = valor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }
    
    public static Iten acharIten(int id){
        File file = new File("../Arquivos/itens.txt");
        try(Scanner sc = new Scanner(file)){
            while(sc.hasNext()){
                String[] manobra = sc.nextLine().split(",");
                if(Integer.parseInt(manobra[0]) == id ){
                    return new Iten(manobra[1],Integer.parseInt(manobra[0]), Double.parseDouble(manobra[2]));
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Iten.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
