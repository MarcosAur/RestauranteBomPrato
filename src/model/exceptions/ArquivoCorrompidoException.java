package model.exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class ArquivoCorrompidoException extends RuntimeException{
    
    public ArquivoCorrompidoException(String mensagem){
        JOptionPane.showMessageDialog(null, "O programa possui arquivos corrompidos\n"+"Erro" + 0);
        System.exit(0);
    }
    
}
