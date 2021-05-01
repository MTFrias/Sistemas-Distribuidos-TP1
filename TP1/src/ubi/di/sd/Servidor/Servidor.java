package ubi.di.sd.Servidor;

import ubi.di.sd.Fornecedor.Fornecedor;
import ubi.di.sd.Fornecedor.Fornecedor_Metodos_Auxiliares;
import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;
import ubi.di.sd.Model.*;
import ubi.di.sd.Vendedor.Interface_Vendedor_Servidor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.*;

public class Servidor extends java.rmi.server.UnicastRemoteObject implements Interface_Servidor_Vendedor, Interface_Servidor_Fornecedor {


    private static ArrayList<Interface_Fornecedor_Servidor> fornecedores;
    private static ArrayList<Bebidas> bebidas;
    private static ArrayList<Carne> carnes;
    private static ArrayList<Peixe> peixes;
    private static ArrayList<Mercearia> mercearias;
    private static ArrayList<Frutos> frutos;
    private static ArrayList<Limpeza> limpezas;
    private static ArrayList<Produto> obj;
    private static ArrayList<Produto> vendas;

    public static ArrayList<Interface_Fornecedor_Servidor> getFormer() {
        return fornecedores;
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

        fornecedores = new ArrayList<>();
        bebidas = new ArrayList<>();
        carnes = new ArrayList<>();
        peixes = new ArrayList<>();
        mercearias = new ArrayList<>();
        limpezas = new ArrayList<>();
        frutos = new ArrayList<>();
        obj = new ArrayList<>();
        vendas = new ArrayList<>();
        peixes.add(new Peixe("sardinha", 20, 2, 3, LocalDateTime.now(), 10, "Fornecedor 1"));
        peixes.add(new Peixe("sardinha1", 23, 4, 3, LocalDateTime.now(), 5, "Fornecedor 1"));
        peixes.add(new Peixe("sardinha2", 20, 2, 3, LocalDateTime.now(), 6, "Fornecedor 1"));
        obj.add(peixes.get(0));
        obj.add(peixes.get(1));
        obj.add(peixes.get(2));
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
    public void printOnServidor(String mensagem) throws java.rmi.RemoteException {
        System.out.println(mensagem);
    }

    public String removeProduto(Interface_Fornecedor_Servidor _fornecedor, int _idProduto) throws RemoteException {
        for (Peixe item : peixes) {
            if (item.getID() == _idProduto) {
                removerProdutoStocks(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Carne item : carnes) {
            if (item.getID() == _idProduto) {
                removerProdutoStocks(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Frutos item : frutos) {
            if (item.getID() == _idProduto) {
                removerProdutoStocks(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Mercearia item : mercearias) {
            if (item.getID() == _idProduto) {
                removerProdutoStocks(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Bebidas item : bebidas) {
            if (item.getID() == _idProduto) {
                removerProdutoStocks(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        for (Limpeza item : limpezas) {
            if (item.getID() == _idProduto) {
                removerProdutoStocks(item);
                return item.getNome() + " Removido com sucesso!";
            }
        }
        return "ID do produto não encontrado!";
    }


    public void subscribeFornecedor(String name, Interface_Fornecedor_Servidor fornecedor) throws java.rmi.RemoteException {
        System.out.println("Fornecedor Adicionado: " + name);
        fornecedores.add(fornecedor);
    }

    public String adicionarProduto(String _nome, int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima, Interface_Fornecedor_Servidor _fornecedor, String pos) throws RemoteException {
        Produto p;
        switch (pos) {
            case "1":
                p = new Peixe(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                adicionarProdutoStocks(p);
                break;
            case "2":
                p = new Carne(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                adicionarProdutoStocks(p);
                break;
            case "3":
                p = new Limpeza(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                adicionarProdutoStocks(p);
                break;
            case "4":
                p = new Bebidas(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                adicionarProdutoStocks(p);
                break;
            case "5":
                p = new Frutos(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                adicionarProdutoStocks(p);
                break;
            case "6":
                p = new Mercearia(_nome, _stock, _precoCompra, _precoVenda, _validade, _quantidadeMinima, _fornecedor.getNomeFornecedor());
                adicionarProdutoStocks(p);
                break;
            case "Sair":
                return "Saindo...";
        }
        return "Adicionado com Sucesso!";
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
                s = s + "\nNome do produto: " + item.getNome() + ", Categoria de produto: " + item.getClass().getSimpleName() + ", Preço de venda: " + item.getPrecoVenda() + "€, Quantidade comprada: " + item.getStock() + ", Quantidade minima: " + item.getQuantidadeMinima() + ", ID: " + item.getID();
            }
        }
        return s;
    }

    public String consultarVendas(Interface_Fornecedor_Servidor _fornecedor, int _ordenar) throws RemoteException {
        String s = "";
        switch (_ordenar) {
            case 1:
                vendas.sort((o1, o2) -> Double.compare(o2.getPrecoCompra(), o1.getPrecoCompra()));
                break;
            case 2:
                vendas.sort(Comparator.comparingDouble(Produto::getPrecoCompra));
                break;
            case 3:
                vendas.sort(Comparator.comparing(Produto::getNome));
                break;
            case 4:
                vendas.sort((p1, p2) -> p2.getNome().compareTo(p1.getNome()));
                break;
            case 5:
                return vendas.toString();
        }
        for (Produto item : vendas) {
            if (item.getFornecedor().equals(_fornecedor.getNomeFornecedor())) {
                s = s + "\nNome do produto: " + item.getNome() + ", Categoria de produto: " + item.getClass().getSimpleName() + ", Preço vendido: " + item.getPrecoVenda() + "€, Quantidade vendida: " + item.getStock() + ", Lucro: " + (item.getStock() * (item.getPrecoVenda() - item.getPrecoCompra())) + "€, ID: " + item.getID();
            }
        }
        return s;
    }

    public void printOnFornecedor(String s, Interface_Fornecedor_Servidor _fornecedor) throws RemoteException {
        _fornecedor.printOnServidor(s);
    }

    public String consultarProduto(Interface_Vendedor_Servidor _vendedor, int _opcao) throws RemoteException {

        switch (_opcao) {
            case 1:
                for (Peixe item : peixes) {
                    _vendedor.printOnServidor(item.toString());
                }
                break;
            case 2:
                for (Carne item : carnes) {
                    _vendedor.printOnServidor(item.toString());
                }
                break;
            case 3:
                for (Limpeza item : limpezas) {
                    _vendedor.printOnServidor(item.toString());
                }
                break;
            case 4:
                for (Bebidas item : bebidas) {
                    _vendedor.printOnServidor(item.toString());
                }
                break;
            case 5:
                for (Frutos item : frutos) {
                    _vendedor.printOnServidor(item.toString());
                }
            case 6:
                for (Mercearia item : mercearias) {
                    _vendedor.printOnServidor(item.toString());
                }
                break;
            case 7:
                for (Produto item : obj) {
                    _vendedor.printOnServidor(item.toString());
                }
                break;
        }
        return null;
    }

    public String venderProduto(Interface_Vendedor_Servidor _vendedor, int _opc, Interface_Servidor_Vendedor servidor) throws java.rmi.RemoteException {

        switch (_opc) {
            case 1:
                System.out.println(consultarProduto(_vendedor, 1));
                _vendedor.printOnServidor(vendInput(_vendedor, 1, servidor));
                break;
            case 2:
                System.out.println(consultarProduto(_vendedor, 2));
                _vendedor.printOnServidor(vendInput(_vendedor, 2, servidor));
                break;
            case 3:
                System.out.println(consultarProduto(_vendedor, 3));
                _vendedor.printOnServidor(vendInput(_vendedor, 3, servidor));
                break;
            case 4:
                System.out.println(consultarProduto(_vendedor, 4));
                _vendedor.printOnServidor(vendInput(_vendedor, 4, servidor));
                break;
            case 5:
                System.out.println(consultarProduto(_vendedor, 5));
                _vendedor.printOnServidor(vendInput(_vendedor, 5, servidor));
                _vendedor.printOnServidor(vendas.toString());
                break;
            case 6:
                System.out.println(consultarProduto(_vendedor, 6));
                _vendedor.printOnServidor(vendInput(_vendedor, 6, servidor));
                break;
            default:
                break;
        }

        return "";
    }

    public static String vendInput(Interface_Vendedor_Servidor vend, int opcao, Interface_Servidor_Vendedor servidor) throws RemoteException {
        int qtd = 0;
        int id = 0;
        int flag = 0;
        vend.printOnServidor("\n======================================================");
        vend.printOnServidor("============== Introduz a quantidade =================");
        qtd = vend.lerNoVendedor();
        vend.printOnServidor("============== Introduz o ID =========================");
        id = vend.lerNoVendedor();

        switch (opcao) {
            case 1:
                for (Peixe item : peixes) {
                    if ((item.getID() == id) && (item.getStock() >= qtd)) {
                        flag = 1;

                        Peixe pe = (Peixe) item.Clone();
                        int v = item.getStock() - qtd;
                        pe.setStock(qtd);
                        item.setStock(v);
                        vendas.add(pe);
                        VerificacaoValidadeStock(servidor, pe);
                        return qtd + " " + item.getNome() + " vendido com sucesso!";
                    }
                }
                break;
            case 2:
                for (Carne item : carnes) {
                    if ((item.getID() == id) && (item.getStock() >= qtd)) {
                        flag = 1;
                        Carne ca = (Carne) item.Clone();
                        int v = item.getStock() - qtd;
                        ca.setStock(qtd);
                        item.setStock(v);
                        vendas.add(ca);
                        VerificacaoValidadeStock(servidor, ca);
                        return qtd + " " + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
            case 3:
                for (Limpeza item : limpezas) {
                    if ((item.getID() == id) && (item.getStock() >= qtd)) {
                        flag = 1;
                        Limpeza li = (Limpeza) item.Clone();
                        int v = item.getStock() - qtd;
                        li.setStock(qtd);
                        item.setStock(v);
                        vendas.add(li);
                        VerificacaoValidadeStock(servidor, li);
                        return qtd + " " + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
            case 4:
                for (Bebidas item : bebidas) {
                    if ((item.getID() == id) & (item.getStock() >= qtd)) {
                        flag = 1;
                        Bebidas be = (Bebidas) item.Clone();
                        int v = item.getStock() - qtd;
                        be.setStock(qtd);
                        item.setStock(v);
                        vendas.add(be);
                        VerificacaoValidadeStock(servidor, be);
                        return qtd + " " + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
            case 5:
                for (Frutos item : frutos) {
                    if ((item.getID() == id) & (item.getStock() >= qtd)) {
                        flag = 1;
                        Frutos fe = (Frutos) item.Clone();
                        int v = item.getStock() - qtd;
                        fe.setStock(qtd);
                        fe.setStock(v);
                        vendas.add(fe);
                        VerificacaoValidadeStock(servidor, fe);
                        return qtd + " " + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
            case 6:
                for (Mercearia item : mercearias) {
                    if ((item.getID() == id) & (item.getStock() >= qtd)) {
                        flag = 1;
                        Mercearia me = (Mercearia) item.Clone();
                        int v = item.getStock() - qtd;
                        me.setStock(qtd);
                        item.setStock(v);
                        vendas.add(me);
                        VerificacaoValidadeStock(servidor, me);
                        return qtd + " " + item.getNome() + " Vendido com sucesso!";
                    }
                }
                break;
        }
        if (flag == 0) {
            return "#Produto Inexistente ou Stock insuficiente";
        }
        return "";
    }

    public String verificarDataValidade(Interface_Vendedor_Servidor _vendedor, Interface_Servidor_Vendedor servidor) throws java.rmi.RemoteException {
        String s = "";
        ArrayList<Produto> aux = (ArrayList<Produto>) obj.clone();
        for (Produto produto : aux) {
            if (LocalDateTime.now().isAfter(produto.getDataValidade())) {
                System.out.println("Loop");
                s = s + "\nValidade do produto " + produto.getNome() + " com ID " + produto.getID() + " esta vencida!";
                VerificacaoValidade(servidor, produto);
            }
        }
        return s;
    }

    //==================================================================================================================
    //Função responsavel por verificar se o produto alcançou a quantidade minima de stock ==============================
    public static void VerificacaoValidadeStock(Interface_Servidor_Vendedor servidor, Produto produto) throws RemoteException {
        int quatidadeMinima = produto.getQuantidadeMinima();
        int stock = produto.getStock();
        if (quatidadeMinima <= stock) {
            String fornecedor = produto.getFornecedor();
            for (Interface_Fornecedor_Servidor f : fornecedores) {
                if (f.getNomeFornecedor().equals(fornecedor)) {
                    servidor.printOnFornecedor("Stock do produto " + produto.getNome() + " com ID " + produto.getID() + " chegou na quantidade de stock minima!", f);
                    VerificacaoValidade(servidor, produto);
                }
            }
        }
    }

    //==================================================================================================================
    //Função responsavel por verificar se o produto pedeu a validade ===================================================
    public static void VerificacaoValidade(Interface_Servidor_Vendedor servidor, Produto produto) throws RemoteException {
        if (LocalDateTime.now().isAfter(produto.getDataValidade())) {
            String fornecedor = produto.getFornecedor();
            System.out.println(getFormer()+ "  fornecedores");
            for (Interface_Fornecedor_Servidor f : getFormer()) {
                if (f.getNomeFornecedor().equals(fornecedor)) {
                    //System.out.println("Validade do produto " + produto.getNome() + " com ID " + produto.getID() + " está vencida!");
                    servidor.printOnFornecedor("Validade do produto " + produto.getNome() + " com ID " + produto.getID() + " está vencida!", f);
                    removerProdutoStocks(produto);
                }
            }
        }
    }
    //==================================================================================================================
    //Função responsavel por remover um produto do arraylist ===========================================================
    public static void removerProdutoStocks(Produto produto) throws RemoteException {
        //System.out.println("Resultado: " + produto.getClass().getSimpleName().equals((Carne.class).getSimpleName()) + "\n"+produto.getClass().getSimpleName() +"      " + (Carne.class).getSimpleName());
        if (produto.getClass().getSimpleName().equals((Bebidas.class).getSimpleName())) {
            bebidas.remove(produto);
        } else if (produto.getClass().getSimpleName().equals((Frutos.class).getSimpleName())) {
            frutos.remove(produto);
        } else if (produto.getClass().getSimpleName().equals((Peixe.class).getSimpleName())) {
            peixes.remove(produto);
        } else if (produto.getClass().getSimpleName().equals((Carne.class).getSimpleName())) {
            carnes.remove(produto);
        } else if (produto.getClass().getSimpleName().equals((Mercearia.class).getSimpleName())) {
            mercearias.remove(produto);
        } else if (produto.getClass().getSimpleName().equals((Limpeza.class).getSimpleName())) {
            limpezas.remove(produto);
        }
        obj.remove(produto);
        System.out.println(produto.getNome() + " removido!");
    }
    //==================================================================================================================
    //Função responsavel por adicionar um produto em um arraylist ======================================================
    public static void adicionarProdutoStocks(Produto produto) throws RemoteException {
        if (produto.getClass().getSimpleName().equals((Bebidas.class).getSimpleName())) {
            bebidas.add((Bebidas) produto);
        } else if (produto.getClass().getSimpleName().equals((Frutos.class).getSimpleName())) {
            frutos.add((Frutos) produto);
        } else if (produto.getClass().getSimpleName().equals((Peixe.class).getSimpleName())) {
            peixes.add((Peixe) produto);
        } else if (produto.getClass().getSimpleName().equals((Carne.class).getSimpleName())) {
            carnes.add((Carne) produto);
        } else if (produto.getClass().getSimpleName().equals((Mercearia.class).getSimpleName())) {
            mercearias.add((Mercearia) produto);
        } else if (produto.getClass().getSimpleName().equals((Limpeza.class).getSimpleName())) {
            limpezas.add((Limpeza) produto);
        }
        obj.add(produto);
        System.out.println(produto.getNome() + " adicionado!");
    }

    //==================================================================================================================
    //Função main do Servidor ==========================================================================================
    public static void main(String[] args) {
        //Vinícius: grant.policy
        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        System.setProperty("java.security.policy", "C:\\Users\\denis\\IdeaProjects\\Sistemas-Distribuidos-TP1\\TP1\\grant.policy");

        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        //Miguel
        // System.setProperty("java.security.policy", "->Path do seu policy<-");
        //System.setProperty("java.security.policy", "/home/frias/GitHub/Sistemas-Distribuidos-TP1/TP1/grant.policy");

        //Hermenegildo: grant.policy
        //System.setProperty("java.security.policy", "/Users/Lenovo/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        System.setSecurityManager(new SecurityManager());
        try {
            LocateRegistry.createRegistry(1099);
            Servidor h = new Servidor();
            Naming.rebind("Servidor", h);
            System.out.println("Servidor ativado");
            String s = "";
            while (true) {
                System.out.println("============================================");
                System.out.println("======= Opções de Comunicação ==============");
                System.out.println("====== (0) Escrever algo ===================");
                System.out.println("====== (sair)- Finalizar ===================");
                System.out.println("============================================");
                System.out.print("Opção:");
                s = Validacao.readString();
                if (s == null) s = "Sair";
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
