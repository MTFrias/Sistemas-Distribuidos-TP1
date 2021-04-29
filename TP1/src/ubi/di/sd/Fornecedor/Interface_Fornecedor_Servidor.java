package ubi.di.sd.Fornecedor;

public interface Interface_Fornecedor_Servidor  extends java.rmi.Remote {
    public void printOnServidor(String s) throws java.rmi.RemoteException;
    public String getNomeFornecedor() throws java.rmi.RemoteException;
}
