package ubi.di.sd.Servidor;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;
import ubi.di.sd.Model.*;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

public class Servidor extends java.rmi.server.UnicastRemoteObject implements Interface_Servidor_Vendedor, Interface_Servidor_Fornecedor {

    private static ArrayList<Interface_Fornecedor_Servidor> fornecedores;
    private static ArrayList<Bebidas> bebidas;
    private static ArrayList<Carne> carnes;
    private static ArrayList<Peixe> peixes;


    public Servidor() throws java.rmi.RemoteException {
        super();

        fornecedores = new ArrayList<Interface_Fornecedor_Servidor>();
        bebidas = new ArrayList<Bebidas>();
        carnes = new ArrayList<Carne>();
        peixes = new ArrayList<Peixe>();
    }
    /* ================================================================ */
    /*Metodos criados para o cliente ================================== */
    @Override
    public void printOnClient(String s) throws RemoteException {

    }
    /* ================================================================ */
    /*Metodos criados para o fornecedor =============================== */
    @Override
    public void printOnFornecedor(String s) throws RemoteException {
        System.out.println(s);
    }

    public void subscribeFornecedor(String name, Interface_Fornecedor_Servidor fornecedor) throws java.rmi.RemoteException {
        System.out.println("Fornecedor Adicionado: " + name);
        fornecedores.add(fornecedor);
    }
    /* ================================================================ */

    public static void main(String[] args) {
        //Vinícius: grant.policy
        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        System.setSecurityManager(new SecurityManager());
        try {
            LocateRegistry.createRegistry(1099);
            Servidor h = new Servidor();
            Naming.rebind("Servidor", h);
            System.out.println("Servidor ativado");
            while (true) {
                //System.out.println("Mensagem para o cliente:");
                //s= lerString();
                // client.printOnClient(s);
            }
        } catch (RemoteException r) {
            System.out.println("Exception in server" + r.getMessage());
        } catch (java.net.MalformedURLException u) {
            System.out.println("Exception in server - URL");
        }
    }
}
