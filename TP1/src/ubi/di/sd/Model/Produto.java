package ubi.di.sd.Model;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Produto implements Serializable,Cloneable {

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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        this.dataCompra = LocalDateTime.now();
        numProduct++;
        this.fornecedor = _fornecedor;
    }

    public String toString() {
        return
                "\n========= Produto ========" +
                "\nNome do Produto: " + nome +
                "\nStock: " + stock +
                "\nPreco de Compra: " + precoCompra +
                "\nPreco de Venda: " + precoVenda +
                "\nValidade: " + dataValidade +
                "\nData de Compra: " + dataCompra +
                "\nQuantidade Minima: " + quantidadeMinima +
                "\nID: " + ID +
                "\nFornecedor: " + fornecedor ;
    }

    public String printProduto() {
        return
                "\n========= Produto ========" +
                        "\nID: " + ID +
                        "\nNome do Produto: " + nome +
                        "\nStock: " + stock +
                        "\nPreco de Venda: " + precoVenda +
                        "\nValidade: " + dataValidade;
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

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDateTime dataValidade) {
        this.dataValidade = dataValidade;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Object Clone () {
        try {
            return this.clone();
        }
        catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
