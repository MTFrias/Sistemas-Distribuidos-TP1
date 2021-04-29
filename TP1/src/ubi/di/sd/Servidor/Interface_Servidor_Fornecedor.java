package ubi.di.sd.Servidor;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;

public interface Interface_Servidor_Fornecedor extends java.rmi.Remote {

    public void subscribeFornecedor(String name, Interface_Fornecedor_Servidor fornecedor) throws java.rmi.RemoteException;

    public void printOnFornecedor(String s) throws java.rmi.RemoteException;
}