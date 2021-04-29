package ubi.di.sd.Model;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;

import java.time.LocalDateTime;

public class Frutos extends Produto{
    public Frutos(String _nome,int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima, Interface_Fornecedor_Servidor _fornecedor) {
        super(_nome,_stock,_precoCompra,_precoVenda,_validade,_quantidadeMinima,_fornecedor);
    }
}
