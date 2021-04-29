package ubi.di.sd.Servidor;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;
import ubi.di.sd.Model.*;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Servidor extends java.rmi.server.UnicastRemoteObject implements Interface_Servidor_Vendedor, Interface_Servidor_Fornecedor {

    private static ArrayList<Interface_Fornecedor_Servidor> fornecedores;
    private static ArrayList<Bebidas> bebidas;
    private static ArrayList<Carne> carnes;
    private static ArrayList<Peixe> peixes;
    private static ArrayList<Mercearia> mercearias;
    private static ArrayList<Frutos> frutos;
    private static ArrayList<Limpeza> limpezas;


    public Servidor() throws java.rmi.RemoteException {
        super();

        fornecedores = new ArrayList<>();
        bebidas = new ArrayList<>();
        carnes = new ArrayList<>();
        peixes = new ArrayList<>();
        mercearias = new ArrayList<>();
        limpezas = new ArrayList<>();
        frutos = new ArrayList<>();
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

    public void adicionarProduto(String _nome, int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima, Interface_Fornecedor_Servidor _fornecedor, String pos) {
        switch (pos) {
            case "1":
                Peixe p = new Peixe(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor);
                peixes.add(p);
                break;
            case "2":
                Carne c = new Carne(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor);
                carnes.add(c);
                break;
            case "3":
                Limpeza l = new Limpeza(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor);
                limpezas.add(l);
                break;
            case "4":
                Bebidas b = new Bebidas(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor);
                bebidas.add(b);
                break;
            case "5":
                Frutos f = new Frutos(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor);
                frutos.add(f);
                break;
            case "6":
                Mercearia m = new Mercearia(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor);
                mercearias.add(m);
                break;
            case "Sair":
                return;
        }
    }

    public String consultarVendas(Interface_Fornecedor_Servidor _fornecedor) throws RemoteException {
        return peixes + " " + carnes + " " + limpezas + " " + mercearias + " " + frutos + " " + bebidas;
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
