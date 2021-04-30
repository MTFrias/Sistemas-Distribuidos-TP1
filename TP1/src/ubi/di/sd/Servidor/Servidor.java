package ubi.di.sd.Servidor;

import ubi.di.sd.Fornecedor.Fornecedor_Metodos_Auxiliares;
import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;
import ubi.di.sd.Model.*;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.*;

public class Servidor extends java.rmi.server.UnicastRemoteObject implements Interface_Servidor_Vendedor, Interface_Servidor_Fornecedor {


    private static ArrayList<Interface_Fornecedor_Servidor> former;
    private static ArrayList<Bebidas> bebidas;
    private static ArrayList<Carne> carnes;
    private static ArrayList<Peixe> peixes;
    private static ArrayList<Mercearia> mercearias;
    private static ArrayList<Frutos> frutos;
    private static ArrayList<Limpeza> limpezas;
    private static ArrayList<Produto> obj;

    public static ArrayList<Interface_Fornecedor_Servidor> getFormer() {
        return former;
    }

    public static ArrayList<Bebidas> getBebidas() {
        return bebidas;
    }

    public static ArrayList<Carne> getCarnes() {
        return carnes;
    }

    public static ArrayList<Peixe> getPeixes() {
        return peixes;
    }

    public static ArrayList<Mercearia> getMercearias() {
        return mercearias;
    }

    public static ArrayList<Frutos> getFrutos() {
        return frutos;
    }

    public static ArrayList<Limpeza> getLimpezas() {
        return limpezas;
    }

    public static ArrayList<Produto> getObj() {
        return obj;
    }

    public Servidor() throws java.rmi.RemoteException {
        super();

        former = new ArrayList<>();
        bebidas = new ArrayList<>();
        carnes = new ArrayList<>();
        peixes = new ArrayList<>();
        mercearias = new ArrayList<>();
        limpezas = new ArrayList<>();
        frutos = new ArrayList<>();
        obj = new ArrayList<>();
        if(Ficheiros.CarregarBebidas() != null)
        {
            bebidas = Ficheiros.CarregarBebidas();
            for (Bebidas b: Ficheiros.CarregarBebidas()) {
                System.out.println(b);
                obj.add(b);
            }
        }

        frutos.add(new Frutos("Sardinha", 20, 2.5, 3.0, LocalDateTime.now(), 10, "Fornecedor 1"));
        obj.add(frutos.get(0));
        frutos.add(new Frutos("Bagri", 50, 3, 4.0, LocalDateTime.now(), 12, "Fornecedor 1"));
        obj.add(frutos.get(1));
        /*bebidas.add(new Bebidas("Cerveja", 100, 1.2, 1.6, LocalDateTime.now(), 24, "Fornecedor 1"));
        obj.add(bebidas.get(0));
        bebidas.add(new Bebidas("Vinho", 100, 1.2, 1.6, LocalDateTime.now(), 24, "Fornecedor 1"));
        obj.add(bebidas.get(1));
        bebidas.add(new Bebidas("Cidra", 100, 1.2, 1.6, LocalDateTime.now(), 24, "Fornecedor 1"));
        obj.add(bebidas.get(2));*/
    }

    /* ================================================================ */
    /*Metodos criados para o cliente ================================== */
    @Override
    public void printOnClient(String s) throws RemoteException {
        System.out.println(s);
    }

    /* ================================================================ */
    /*Metodos criados para o fornecedor =============================== */
    @Override
    public void printOnFornecedor(String s) throws RemoteException {
        System.out.println(s);
    }

    public String removeProduto(Interface_Fornecedor_Servidor _fornecedor, int _idProduto) throws RemoteException {
        for (Peixe item : peixes) {
            if (item.getID() == _idProduto) {
                peixes.remove(item);
                obj.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Carne item : carnes) {
            if (item.getID() == _idProduto) {
                carnes.remove(item);
                obj.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Frutos item : frutos) {
            if (item.getID() == _idProduto) {
                frutos.remove(item);
                obj.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Mercearia item : mercearias) {
            if (item.getID() == _idProduto) {
                mercearias.remove(item);
                obj.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Bebidas item : bebidas) {
            if (item.getID() == _idProduto) {
                bebidas.remove(item);
                obj.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Limpeza item : limpezas) {
            if (item.getID() == _idProduto) {
                limpezas.remove(item);
                obj.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        return "ID do produto não encontrado!";
    }

    public void subscribeFornecedor(String name, Interface_Fornecedor_Servidor fornecedor) throws java.rmi.RemoteException {
        System.out.println("Fornecedor Adicionado: " + name);
        former.add(fornecedor);
    }

    public String adicionarProduto(String _nome, int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima, Interface_Fornecedor_Servidor _fornecedor, String pos) throws RemoteException {
        Produto p;
        switch (pos) {
            case "1":
                p = new Peixe(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                peixes.add((Peixe) p);
                obj.add(p);
                break;
            case "2":
                p = new Carne(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                carnes.add((Carne) p);
                obj.add(p);
                break;
            case "3":
                p = new Limpeza(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                limpezas.add((Limpeza) p);
                obj.add(p);
                break;
            case "4":
                p = new Bebidas(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                bebidas.add((Bebidas) p);
                obj.add(p);
                break;
            case "5":
                p = new Frutos(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                frutos.add((Frutos) p);
                obj.add(p);
                break;
            case "6":
                p = new Mercearia(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                mercearias.add((Mercearia) p);
                obj.add(p);
                break;
            case "Sair":
                return "Saindo...";
        }
        return " Adicionado com Sucesso!";
    }


    public String consultarCompras(Interface_Fornecedor_Servidor _fornecedor, int _ordenar) throws RemoteException {
        String s = "";
        switch (_ordenar) {
            case 1:
                obj.sort((o1, o2) -> Double.compare(o2.getPrecoCompra(), o1.getPrecoCompra()));
                break;
            case 2:
                obj.sort(Comparator.comparingDouble(Produto::getPrecoCompra));
                break;
            case 3:
                obj.sort(Comparator.comparing(Produto::getNome));
                break;
            case 4:
                obj.sort((p1, p2) -> p2.getNome().compareTo(p1.getNome()));
                break;
            case 5:
                return obj.toString();
        }
        for (Produto item : obj) {
            if (item.getFornecedor().equals(_fornecedor.getNomeFornecedor())) {
                s = s + "\nNome do produto: " + item.getNome() + ", Preço de compra: " + item.getPrecoCompra() + "€, ID: " + item.getID();
            }
        }
        return s;
    }

    public String consultarVendas(Interface_Fornecedor_Servidor _fornecedor, int _ordenar) throws RemoteException {
        String s = "";
        return s;
    }
    /* ================================================================ */

    public static void main(String[] args) {
        //Vinícius: grant.policy
        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        //System.setProperty("java.security.policy", "C:\\Users\\denis\\IdeaProjects\\Sistemas-Distribuidos-TP1\\TP1\\grant.policy");

        //Miguel
        //System.setProperty("java.security.policy", "/home/frias/GitHub/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        System.setSecurityManager(new SecurityManager());
        try {
            LocateRegistry.createRegistry(1099);
            Servidor h = new Servidor();
            Naming.rebind("Servidor", h);
            System.out.println("Servidor ativado");
            String s= "";
            while (true) {
                System.out.println("============================================================");
                System.out.println("=============== Opções de Comunicação ======================");
                System.out.println("====== (0) Comunicar Servidor ==============================");
                System.out.println("====== (1) Adicionar Produto ===============================");
                System.out.println("================= (sair)- Finalizar ========================");
                System.out.println("============================================================");
                System.out.print("Opção:");
                s = Validacao.readString();
                if(s == null ) s = "Sair";
                switch (s) {
                    case "0":
                        break;
                    case "1":
                        break;
                    case "sair":
                        Ficheiros.GuardaInformacao(Servidor.getCarnes());
                        Ficheiros.GuardaInformacao(Servidor.getBebidas());
                        Ficheiros.GuardaInformacao(Servidor.getFrutos());
                        Ficheiros.GuardaInformacao(Servidor.getLimpezas());
                        Ficheiros.GuardaInformacao(Servidor.getMercearias());
                        Ficheiros.GuardaInformacao(Servidor.getPeixes());
                        System.exit(0);
                }
            }
        } catch (RemoteException r) {
            System.out.println("Exception in server" + r.getMessage());
        } catch (java.net.MalformedURLException u) {
            System.out.println("Exception in server - URL");
        }
    }
}
