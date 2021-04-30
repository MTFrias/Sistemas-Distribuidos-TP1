package ubi.di.sd.Vendedor;

public interface Interface_Vendedor_Servidor extends java.rmi.Remote {
    public void printOnServidor(String s) throws java.rmi.RemoteException;
    public String getNomeVendedor() throws java.rmi.RemoteException;
    public int lerNoVendedor() throws java.rmi.RemoteException;;
}
