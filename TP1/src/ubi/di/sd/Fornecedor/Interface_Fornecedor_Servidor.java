package ubi.di.sd.Fornecedor;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Interface_Fornecedor_Servidor extends java.rmi.Remote {
    public void printOnServidor(String mensagem) throws java.rmi.RemoteException;

    public String getNomeFornecedor() throws java.rmi.RemoteException;
}
