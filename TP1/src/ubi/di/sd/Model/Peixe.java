package ubi.di.sd.Model;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Peixe extends Produto implements Serializable,Cloneable {

    public Peixe(){

    }
    public Peixe(String _nome,int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima, String _fornecedor) {
        super(_nome,_stock,_precoCompra,_precoVenda,_validade,_quantidadeMinima,_fornecedor);
    }
}
