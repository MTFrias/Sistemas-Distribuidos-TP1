package ubi.di.sd.Servidor;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;
import ubi.di.sd.Model.*;
import ubi.di.sd.Vendedor.Interface_Vendedor_Servidor;

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
    private static ArrayList<Produto> vendas;


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
        vendas = new ArrayList<>();
        frutos.add(new Frutos("Sardinha", 20, 2.5, 3.0, LocalDateTime.now(), 10, "Fornecedor 1"));
        obj.add(new Frutos("Sardinha", 20, 2.5, 3.0, LocalDateTime.now(), 10, "Fornecedor 1"));
        frutos.add(new Frutos("Bagri", 50, 3, 4.0, LocalDateTime.now(), 12, "Fornecedor 1"));
        obj.add(new Frutos("Bagri", 50, 3, 4.0, LocalDateTime.now(), 12, "Fornecedor 1"));
        bebidas.add(new Bebidas("Cerveja", 100, 1.2, 1.6, LocalDateTime.now(), 24, "Fornecedor 1"));
        obj.add(new Bebidas("Cerveja", 100, 1.2, 1.6, LocalDateTime.now(), 24, "Fornecedor 1"));
        bebidas.add(new Bebidas("Vinho", 100, 1.2, 1.6, LocalDateTime.now(), 24, "Fornecedor 1"));
        obj.add(new Bebidas("Vinho", 100, 1.2, 1.6, LocalDateTime.now(), 24, "Fornecedor 1"));
        bebidas.add(new Bebidas("Cidra", 100, 1.2, 1.6, LocalDateTime.now(), 24, "Fornecedor 1"));
        obj.add(new Bebidas("Cidra", 100, 1.2, 1.6, LocalDateTime.now(), 24, "Fornecedor 1"));
    }

    /* ================================================================ */
    /*Metodos criados para o cliente ================================== */


    @Override
    public void printOnVendedor(String s) throws RemoteException {
        System.out.println(s);
    }

    @Override
    public void subscribeVendedor(String name, Interface_Vendedor_Servidor vendedor) throws RemoteException {
        System.out.println("Vendedor Ativo:" + name);
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
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Carne item : carnes) {
            if (item.getID() == _idProduto) {
                carnes.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Frutos item : frutos) {
            if (item.getID() == _idProduto) {
                frutos.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Mercearia item : mercearias) {
            if (item.getID() == _idProduto) {
                mercearias.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Bebidas item : bebidas) {
            if (item.getID() == _idProduto) {
                bebidas.remove(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Limpeza item : limpezas) {
            if (item.getID() == _idProduto) {
                limpezas.remove(item);
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

    public String consultarProduto(Interface_Vendedor_Servidor _vendedor, int _opcao) throws RemoteException {

         switch (_opcao) {
            case 1:
                for (Peixe item: peixes){

                    _vendedor.printOnServidor(item.toString());

                }
                break;
            case 2:
                for (Carne item: carnes){
                    _vendedor.printOnServidor(item.toString());
                }
                break;
            case 3:
                for (Limpeza item: limpezas){
                    _vendedor.printOnServidor(item.toString());
                }
                break;
            case 4:
                for (Bebidas item: bebidas){
                    _vendedor.printOnServidor(item.toString());
                }
                break;
            case 5:
                for (Frutos item: frutos){
                    _vendedor.printOnServidor(item.toString());
                }
            case 6:
                for (Mercearia item: mercearias){
                    _vendedor.printOnServidor(item.toString());
                }
                break;
             case 7:
                 for (Produto item: obj){
                     _vendedor.printOnServidor(item.toString());
                 }
                 break;
        }

        return "..............................................\n\n\n\n\n\n";
    }






    public String venderProduto(Interface_Vendedor_Servidor _vendedor, int _opc) throws java.rmi.RemoteException{

        switch (_opc) {
            case 1:
                System.out.println(consultarProduto(_vendedor,1));
                _vendedor.printOnServidor(vendInput(_vendedor, 1));
                 break;
            case 2:
                System.out.println(consultarProduto(_vendedor,2));
                _vendedor.printOnServidor(vendInput(_vendedor, 2));
                break;
            case 3:
                System.out.println(consultarProduto(_vendedor,3));
                _vendedor.printOnServidor(vendInput(_vendedor, 3));
                break;
            case 4:
                System.out.println(consultarProduto(_vendedor,4));
                _vendedor.printOnServidor(vendInput(_vendedor, 4));
                break;
            case 5:
                System.out.println(consultarProduto(_vendedor,5));
                _vendedor.printOnServidor(vendInput(_vendedor,5));
                _vendedor.printOnServidor(vendas.toString());
                break;
            case 6:
                System.out.println(consultarProduto(_vendedor,6));
                _vendedor.printOnServidor(vendInput(_vendedor, 6));
                break;
            default:
                break;
        }

        return "...";
    }






    public static String vendInput(Interface_Vendedor_Servidor vend, int opcao) throws RemoteException {
        int qtd = 0;
        int id = 0;
        int flag = 0;
        vend.printOnServidor("\n\n======================================================");
        vend.printOnServidor("============== Introduz a quantidade =================");
        qtd = vend.lerNoVendedor();
        vend.printOnServidor("============== Introduz o ID =========================");
        id = vend.lerNoVendedor();

        switch (opcao) {
            case 1:
                for (Peixe item : peixes) {
                    if ((item.getID() == id) & (item.getStock() >= qtd)) {
                        flag = 1;
                        Peixe pe = item;
                        int a = peixes.indexOf(item);
                        int v = item.getStock() - qtd;
                        pe.setStock(v);

                        peixes.set(a,pe);
                        return qtd+" " + item.getNome() + " vendido com sucesso!";
                    }

                }
                break;
            case 2:
                for (Carne item : carnes) {
                    if ((item.getID() == id) & (item.getStock() >= qtd)) {
                        flag = 1;
                        Carne ca = item;
                        int a = carnes.indexOf(item);
                        int v = item.getStock() - qtd;
                        ca.setStock(v);

                        carnes.set(a,ca);
                        return qtd+" "  + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
            case 3:
                for (Limpeza item : limpezas) {
                    if ((item.getID() == id) & (item.getStock() >= qtd)) {
                        flag = 1;
                        Limpeza li = item;
                        int a = limpezas.indexOf(item);
                        int v = item.getStock() - qtd;
                        li.setStock(v);

                        limpezas.set(a,li);
                        return qtd+" "  + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
            case 4:
                for (Bebidas item : bebidas) {
                    if ((item.getID() == id) & (item.getStock() >= qtd)) {
                        flag = 1;
                        Bebidas be = item;
                        int a = bebidas.indexOf(item);
                        int v = item.getStock() - qtd;
                        be.setStock(v);

                        bebidas.set(a,be);
                        return qtd+" "  + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
            case 5:
                for (Frutos item : frutos) {
                    if ((item.getID() == id) & (item.getStock() >= qtd)) {
                        flag = 1;
                        Frutos fe = item;
                        int a = frutos.indexOf(item);
                        int v = item.getStock() - qtd;
                        fe.setStock(v);

                        frutos.set(a,fe);

                        vendas.add(item);


                        return qtd+" " + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
            case 6:
                for (Mercearia item : mercearias) {
                    if ((item.getID() == id) & (item.getStock() >= qtd)) {
                        flag = 1;
                        Mercearia me = item;
                        int a = mercearias.indexOf(item);
                        int v = item.getStock() - qtd;
                        me.setStock(v);

                        mercearias.set(a,me);
                        return qtd+" " + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
            default:
                break;
        }

        if(flag==0){
            return "#Produto Inexistente ou Stock insuficiente";
        }


    return "";

    }








    /* ================================================================ */

    public static void main(String[] args) {
        //Vinícius: grant.policy
        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        //Miguel
        //System.setProperty("java.security.policy", "/home/frias/GitHub/Sistemas-Distribuidos-TP1/TP1/grant.policy");

        //Hermenegildo: grant.policy
        System.setProperty("java.security.policy", "/Users/Lenovo/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
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
