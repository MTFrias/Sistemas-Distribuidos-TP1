package ubi.di.sd;

import java.io.Serializable;
import java.sql.SQLOutput;

public class Produto implements Serializable {
    public int stock ;
    public double preco ;

    public Produto() {

    }

    public Produto(int _stock, double _preco) {
            this.stock = _stock;
            this.preco = _preco;
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
