package ubi.di.sd.Model;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.io.Serializable;
import java.util.Date;

public class Produto implements Serializable {

    private int stock ;
    private double preco;
    private Date validade;
    private int quantidadeMinima;
    private int ID = 0;
    private static int numProduct = 0;

    public Produto() {
        this.ID = numProduct;
        numProduct++;
    }

    public Produto(int _stock, double _preco, Date _validade, int _quantidadeMinima) {
            this.stock = _stock;
            this.preco = _preco;
            this.validade = _validade;
            this.quantidadeMinima = _quantidadeMinima;
            this.ID = numProduct;
            numProduct++;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int _stock) {
        this.stock = _stock;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double _preco) {
        this.preco = _preco;
    }

}
