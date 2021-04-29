package ubi.di.sd.Model;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;

import java.time.LocalDateTime;

public class Limpeza extends Produto{
    public Limpeza(){

    }
    public Limpeza(String _nome,int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima, String _fornecedor) {
        super(_nome,_stock,_precoCompra,_precoVenda,_validade,_quantidadeMinima,_fornecedor);
    }
}
