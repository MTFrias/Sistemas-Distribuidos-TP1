package ubi.di.sd.Servidor;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;
import ubi.di.sd.Vendedor.Interface_Vendedor_Servidor;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface Interface_Servidor_Vendedor extends java.rmi.Remote {

    public void printOnVendedor(String s) throws java.rmi.RemoteException;

    public void inscreverVendedor(String name, Interface_Vendedor_Servidor vendedor) throws java.rmi.RemoteException;

    public String consultarProduto(Interface_Vendedor_Servidor vendedor, int _opcao) throws java.rmi.RemoteException;

    public String venderProduto(Interface_Vendedor_Servidor _vendedor, int opc, Interface_Servidor_Vendedor servidor) throws java.rmi.RemoteException;

    public String verificarDataValidade(Interface_Vendedor_Servidor _vendedor, Interface_Servidor_Vendedor servidor) throws java.rmi.RemoteException;

    public String vendedorConsultarVendas(Interface_Vendedor_Servidor _vendedor, int _ordenar) throws RemoteException;

    public void printOnFornecedor(String s, Interface_Fornecedor_Servidor _fornecedor) throws RemoteException;

    public void AnotarMensagen(String mensagem, String fornecedor) throws java.rmi.RemoteException;

}