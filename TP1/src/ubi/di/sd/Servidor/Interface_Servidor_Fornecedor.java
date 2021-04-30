package ubi.di.sd.Servidor;

import ubi.di.sd.Fornecedor.Fornecedor;
import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;
import ubi.di.sd.Model.Produto;

import java.time.LocalDateTime;

public interface Interface_Servidor_Fornecedor extends java.rmi.Remote {

    public void subscribeFornecedor(String name, Interface_Fornecedor_Servidor fornecedor) throws java.rmi.RemoteException;

    public String adicionarProduto(String _nome, int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima, Interface_Fornecedor_Servidor _fornecedor, String pos) throws java.rmi.RemoteException;

    public String consultarCompras(Interface_Fornecedor_Servidor _fornecedor, int _ordenar) throws java.rmi.RemoteException;

    public String consultarVendas(Interface_Fornecedor_Servidor _fornecedor, int _ordenar) throws java.rmi.RemoteException;

    public void printOnFornecedor(String s) throws java.rmi.RemoteException;

    public String removeProduto(Interface_Fornecedor_Servidor _fornecedor, int _idProduto) throws java.rmi.RemoteException;
}