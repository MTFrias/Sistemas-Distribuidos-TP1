package ubi.di.sd.Model;

import java.io.Serializable;
import java.util.Date;

public class Peixe extends Produto implements Serializable {
    private String nome;

    public Peixe(int _stock, double _preco, Date _validade, int _quantidadeMinima) {
        super(_stock, _preco,_validade,_quantidadeMinima);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
