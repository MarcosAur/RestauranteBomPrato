package model.entities;

import java.util.Objects;
import model.entities.enuns.TipoItens;

/**
 *
 * @author marcos
 */
public class Item {

    private Integer id;
    private TipoItens tipo;
    private String nome;
    private Double preco;

    public Item(Integer id, TipoItens tipo, String nome, Double preco) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.preco = preco;
    }

    public TipoItens getTipo() {
        return tipo;
    }

    public void setTipo(TipoItens tipo) {
        this.tipo = tipo;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " + nome + " - " + preco + " - " + tipo.toString();
    }

}
