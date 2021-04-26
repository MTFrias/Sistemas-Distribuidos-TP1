package ubi.di.sd;

import java.io.Serializable;

public class Peixe extends Produto implements Serializable {
    private String nome;

    public Peixe() {

    }

    public Peixe(String nome, int _stock, double _preco) {
        super(_stock, _preco);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Peixe{" +
                "nome='" + nome + '\'' +
                ", stock=" + stock +
                ", preco=" + preco +
                '}';
    }
}
