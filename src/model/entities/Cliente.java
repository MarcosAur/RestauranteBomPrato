package model.entities;

import java.util.Objects;

/**
 *
 * @author marcos
 */
public class Cliente {

    private Integer id;
    private String nome;
    private String senha;
    private String endereco;

    public Cliente(Integer id, String nome, String senha, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.senha = senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.senha);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente: " + id
                + "\nNome: " + nome
                + "\nEndereco: " + endereco;
    }

}
