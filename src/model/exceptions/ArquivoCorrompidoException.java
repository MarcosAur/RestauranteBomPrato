package model.exceptions;

/**
 *
 * @author marcos
 */
public class ArquivoCorrompidoException extends RuntimeException{
    
    public ArquivoCorrompidoException(String mensagem){
        System.out.println("O programa possui arquivos corrompidos\n" + mensagem);
        System.exit(0);
    }
    
}
