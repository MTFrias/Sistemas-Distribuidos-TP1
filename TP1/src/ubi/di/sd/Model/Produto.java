package ubi.di.sd.Model;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Produto implements Serializable {

    private int stock ;
    private double precoCompra;
    private double precoVenda;
    private LocalDateTime validade;
    private int quantidadeMinima;
    private int ID = 0;
    private static int numProduct = 0;
    private ArrayList<Interface_Fornecedor_Servidor> fornecedores;


    public Produto(int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima) {
            this.stock = _stock;
            this.precoVenda = _precoVenda;
            this.precoCompra = _precoCompra;
            this.validade = _validade;
            this.quantidadeMinima = _quantidadeMinima;
            this.ID = numProduct;
            numProduct++;
    }

}
