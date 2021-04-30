package ubi.di.sd.Model;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Produto implements Serializable {

    private String nome;
    private int stock;
    private double precoCompra;
    private double precoVenda;
    private LocalDateTime dataValidade;
    private LocalDateTime dataCompra;
    private int quantidadeMinima;
    private int ID = 0;
    private static int numProduct = 0;
    private String fornecedor;

    public Produto() {

    }

    public Produto(String _nome, int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima, String _fornecedor) {
        this.stock = _stock;
        this.nome = _nome;
        this.precoVenda = _precoVenda;
        this.precoCompra = _precoCompra;
        this.dataValidade = _validade;
        this.quantidadeMinima = _quantidadeMinima;
        this.ID = numProduct;
        this.dataCompra = LocalDateTime.now();
        numProduct++;
        this.fornecedor = _fornecedor;
    }

    @Override
    public String toString() {
        return
                "\n========= Produto ========" +
                        "\nNome do Produto: " + nome + " =======" +
                        "\nStock: " + stock + " =======" +
                        "\nPreco de Compra: " + precoCompra +" =======" +
                        "\nPreco de Venda: " + precoVenda +" =======" +
                        "\nValidade: " + dataValidade +" =======" +
                        "\nData de Compra: " + dataCompra +" =======" +
                        "\nQuantidade Minima: " + quantidadeMinima +" =======" +
                        "\nID: " + ID +" =======" +
                        "\nFornecedor: " + fornecedor + " =======";
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getNumProduct() {
        return numProduct;
    }

    public static void setNumProduct(int numProduct) {
        Produto.numProduct = numProduct;
    }

}
