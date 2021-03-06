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


    private static ArrayList<String> fornecedores;
    private static ArrayList<Bebidas> bebidas;
    private static ArrayList<Carne> carnes;
    public static ArrayList<Peixe> peixes;
    private static ArrayList<Mercearia> mercearias;
    private static ArrayList<Frutos> frutos;
    private static ArrayList<Limpeza> limpezas;
    private static ArrayList<Produto> obj;
    private static ArrayList<Produto> vendas;
    private static ArrayList<MensagemFornecedor> mensagemFornecedors;

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

    public static ArrayList<Produto> getVendas() {
        return vendas;
    }

    public static ArrayList<Produto> getObj() {
        return obj;
    }

    public Servidor() throws java.rmi.RemoteException {
        super();
        fornecedores = new ArrayList<>();
        if (Ficheiros.CarregarBebidas() != null) {

            bebidas = Ficheiros.CarregarBebidas();
        } else {
            bebidas = new ArrayList<>();
        }

        if (Ficheiros.CarregarCarne() != null) {
            carnes = Ficheiros.CarregarCarne();
        } else {
            carnes = new ArrayList<>();
        }

        if (Ficheiros.CarregarPeixe() != null) {
            peixes = Ficheiros.CarregarPeixe();
        } else {
            peixes = new ArrayList<>();
        }

        if (Ficheiros.CarregarMercearia() != null) {
            mercearias = Ficheiros.CarregarMercearia();
        } else {
            mercearias = new ArrayList<>();
        }

        if (Ficheiros.CarregarLimpeza() != null) {
            limpezas = Ficheiros.CarregarLimpeza();
        } else {
            limpezas = new ArrayList<>();
        }

        if (Ficheiros.CarregarFrutos() != null) {
            frutos = Ficheiros.CarregarFrutos();
        } else {
            frutos = new ArrayList<>();
        }

        if (Ficheiros.CarregarHistoricoVendas() != null) {
            vendas = Ficheiros.CarregarHistoricoVendas();
        } else {
            vendas = new ArrayList<>();
        }


        //Este Array n??o precisa de if porque em ultima instancia esta fun????o retorna um array vazio no caso de n??o haver nada nos ficheiros
        obj = Ficheiros.CarregarTodosProdutos();

        mensagemFornecedors = new ArrayList<>();
    }

    //==================================================================================================================
    //Fun????o respons??vel por printar no servidor =======================================================================
    @Override
    public void printOnVendedor(String s) throws RemoteException {
        printOnServidor(s);
    }

    //==================================================================================================================
    //Fun????o respons??vel por remover um produto dos stocks =============================================================
    @Override
    public void inscreverVendedor(String name, Interface_Vendedor_Servidor vendedor) throws RemoteException {
        printOnServidor("Vendedor Ativo:" + name);
    }

    //==================================================================================================================
    //Metodos criados para o fornecedor ================================================================================
    public void printOnServidor(String mensagem) throws java.rmi.RemoteException {
        mensagemFornecedors.add(new MensagemFornecedor(mensagem, "Servidor 1"));
    }

    //==================================================================================================================
    //Fun????o respons??vel por remover um produto dos stocks =============================================================
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
        return "ID do produto n??o encontrado!";
    }

    //==================================================================================================================
    //Fun????o respons??vel por registrar o fonecedor no sistema ==========================================================
    public void subscribeFornecedor(String name, Interface_Fornecedor_Servidor fornecedor) throws java.rmi.RemoteException {
        printOnServidor("Fornecedor Adicionado: " + fornecedor.getNomeFornecedor());
        if (fornecedores.size() > 0) {
            for (String f : fornecedores) {
                if (f.equals(fornecedor.getNomeFornecedor())) {
                    fornecedores.remove(f);
                    fornecedores.add(fornecedor.getNomeFornecedor());
                    return;
                }
            }
        }
        fornecedores.add(fornecedor.getNomeFornecedor());
    }

    //==================================================================================================================
    //Fun????o respons??vel por registrar o produto no stock do servidor ==================================================
    public static void verificarMensagensServidor() throws java.rmi.RemoteException {
        for (MensagemFornecedor m : mensagemFornecedors) {
            if (m.getNomeForncedor().equals("Servidor 1")) {
                System.out.println(m.getMensgem());
            }
        }
        System.out.println("Para continuar aperte alguma tecla!");
        String s = Validacao.readString();
    }

    //==================================================================================================================
    //Fun????o respons??vel por registrar o produto no stock do servidor ==================================================
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

    //==================================================================================================================
    //Fun????o respons??vel por consultar as compras feitas pelo servidor =================================================
    public String consultarCompras(Interface_Fornecedor_Servidor _fornecedor, int _ordenar) throws RemoteException {
        String s = "Stock v??zio!";
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
            case 6:
                obj.sort(Comparator.comparing(Produto::getID));
                break;
        }
        s = "===========================================================================================================";
        for (Produto item : obj) {
            if (item.getFornecedor().equals(_fornecedor.getNomeFornecedor())) {
                s = s + "\nNome do produto: " + item.getNome() + ", Categoria de produto: " + item.getClass().getSimpleName() + ", Pre??o de venda: " + item.getPrecoVenda() + "???, Quantidade comprada: " + item.getStock() + ", Quantidade minima: " + item.getQuantidadeMinima() + ", ID: " + item.getID();
            }
        }
        return s;
    }

    //==================================================================================================================
    //Fun????o respons??vel por consultar as vendas =======================================================================
    public String consultarVendas(Interface_Fornecedor_Servidor _fornecedor, int _ordenar) throws RemoteException {
        String s;
        double vendidosTotal = 0, prejuisoTotal = 0, compradosTotal = 0;
        int vencidosTotal = 0, quantidadeVendidadTotal = 0;
        switch (_ordenar) {
            case 1:
                vendas.sort((o1, o2) -> Double.compare(o2.getPrecoVenda(), o1.getPrecoVenda()));
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
                vendas.sort(Comparator.comparing(Produto::getID));
                break;
        }
        s = "===========================================================================================================";
        for (Produto item : vendas) {
            if (item.getFornecedor().equals(_fornecedor.getNomeFornecedor())) {
                if (item.getPrecoVenda() < 0) {
                    s = s + "\n=== Produto Vencido === || Nome do produto: " + item.getNome() + ", Categoria de produto: " + item.getClass().getSimpleName() + ", Pre??o vendido: " + item.getPrecoVenda() + "???, Quantidade vendida: " + item.getStock() + ", Lucro: " + (item.getStock() * (item.getPrecoVenda() - item.getPrecoCompra())) + "???, ID: " + item.getID();
                    vencidosTotal = vencidosTotal + item.getStock();
                    prejuisoTotal = prejuisoTotal + (item.getPrecoVenda() * item.getStock());
                } else {
                    s = s + "\nNome do produto: " + item.getNome() + ", Categoria de produto: " + item.getClass().getSimpleName() + ", Pre??o vendido: " + item.getPrecoVenda() + "???, Quantidade vendida: " + item.getStock() + ", Lucro: " + (item.getStock() * (item.getPrecoVenda() - item.getPrecoCompra())) + "???, ID: " + item.getID();
                    quantidadeVendidadTotal = quantidadeVendidadTotal + item.getStock();
                    vendidosTotal = vendidosTotal + (item.getPrecoVenda() * item.getStock());
                }
                compradosTotal = compradosTotal + (item.getPrecoCompra() * item.getStock());
            }
        }
        return s = s + "\nVendidos Totais: " + vendidosTotal + ", Prejuiso Total: " + prejuisoTotal + "???, Compras totais: " + compradosTotal + "???, Lucro: " + (vendidosTotal + prejuisoTotal) + "???" + ", Quantidade de Produtos Vencidos: " + vencidosTotal + ", Quantidade de Produtos Vendidos: " + quantidadeVendidadTotal;
    }

    //==================================================================================================================
    //Fun????o respons??vel por mandar mensagens para um fornecedor =======================================================
    public void printOnFornecedor(String s, Interface_Fornecedor_Servidor _fornecedor) throws RemoteException {
        _fornecedor.printOnServidor(s);
    }
    /* ========================================================================================== */
    /*Metodos criados para o vendedor ===========================================================*/


    /*Metodo que permite a consulta de todas as vendas feitas=====================*/

    public String vendedorConsultarVendas(Interface_Vendedor_Servidor _vendedor, int _ordenar) throws RemoteException {
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
            s = s + "\nNome do produto: " + item.getNome() + ", Categoria de produto: " + item.getClass().getSimpleName() + ", Pre??o vendido: " + item.getPrecoVenda() + "???, Quantidade vendida: " + item.getStock() + ", Lucro: " + (item.getStock() * (item.getPrecoVenda() - item.getPrecoCompra())) + "???, ID: " + item.getID();
        }
        return s;
    }


    /*Metodo que permite a consulta dos produtos ===========================================================*/

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
                break;
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

    /*Metodo que permite a venda de produtos ==========================================================================*/
    public String venderProduto(Interface_Vendedor_Servidor _vendedor, int _opc, Interface_Servidor_Vendedor servidor) throws java.rmi.RemoteException {

        switch (_opc) {
            case 1:
                for (Peixe item : peixes) {
                    _vendedor.printOnServidor(item.printProduto());
                }
                _vendedor.printOnServidor(vendInput(_vendedor, 1, servidor));
                break;
            case 2:
                for (Carne item : carnes) {
                    _vendedor.printOnServidor(item.printProduto());
                }
                _vendedor.printOnServidor(vendInput(_vendedor, 2, servidor));
                break;
            case 3:
                for (Limpeza item : limpezas) {
                    _vendedor.printOnServidor(item.printProduto());
                }
                _vendedor.printOnServidor(vendInput(_vendedor, 3, servidor));
                break;
            case 4:
                for (Bebidas item : bebidas) {
                    _vendedor.printOnServidor(item.printProduto());
                }
                _vendedor.printOnServidor(vendInput(_vendedor, 4, servidor));
                break;
            case 5:
                for (Frutos item : frutos) {
                    _vendedor.printOnServidor(item.printProduto());
                }
                _vendedor.printOnServidor(vendInput(_vendedor, 5, servidor));
                break;
            case 6:
                for (Mercearia item : mercearias) {
                    _vendedor.printOnServidor(item.printProduto());
                }
                _vendedor.printOnServidor(vendInput(_vendedor, 6, servidor));
                break;
            default:
                break;
        }

        return "";
    }

    /*Metodo que auxilia o metodo de vendas =================================================================*/
    //As venda s??o feitas aqui, de acordo com o input que ?? pedido e dado pelo vendedor ======================
    public static String vendInput(Interface_Vendedor_Servidor vend, int opcao, Interface_Servidor_Vendedor servidor) throws RemoteException {
        int qtd = 0;
        int id = 0;
        int flag = 0;
        vend.printOnServidor("\n====================================================");
        vend.printOnServidor("============== Introduz a quantidade =================");
        qtd = vend.lerNoVendedor();
        vend.printOnServidor("============== Introduz o ID =========================");
        id = vend.lerNoVendedor();

        switch (opcao) {
            case 1:
                for (Peixe item : peixes) {
                    if ((item.getID() == id) && (item.getStock() >= qtd)) {  /*Verificamos o ID do produto e o stock; Coisas essas que determinam se a venda ?? feita ou n??o*/
                        flag = 1;

                        Peixe pe = (Peixe) item.Clone();
                        int v = item.getStock() - qtd;                      /*Diminuimos a quantidade do stock*/
                        pe.setStock(qtd);
                        item.setStock(v);
                        vendas.add(pe);                                     /*Adicionamos ao array que cont??m todas as vendas feitas*/
                        VerificacaoValidadeStock(servidor, pe);              /*Verifica????o do stock m??nimo ap??s a venda feita*/
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
            return "# Produto Inexistente ou Stock insuficiente";
        }
        return "";
    }
    /*===================================================================================================================*/


    //==================================================================================================================
    //Fun????o respons??vel por consultar as mensagens ====================================================================
    public void ConsultarMensagens(Interface_Fornecedor_Servidor fornecedor) throws java.rmi.RemoteException {
        ArrayList<MensagemFornecedor> aux = (ArrayList<MensagemFornecedor>) mensagemFornecedors.clone();
        for (MensagemFornecedor m : aux) {
            if (m.getNomeForncedor().equals(fornecedor.getNomeFornecedor())) {
                fornecedor.printOnServidor(m.getMensgem());
                mensagemFornecedors.remove(m);
            }
        }
    }

    @Override
    public boolean consultarStocks() throws RemoteException {
        if (obj.size() > 0) {
            return true;
        }
        return false;
    }

    //==================================================================================================================
    //Fun????o respons??vel para alguem registrado no servidor ============================================================
    public void AnotarMensagen(String mensagem, String fornecedor) throws java.rmi.RemoteException {
        mensagemFornecedors.add(new MensagemFornecedor(mensagem, fornecedor));
    }

    //==================================================================================================================
    //Fun????o respons??vel por verificar se os produtos perderam a validade ==============================================
    public String verificarDataValidade(Interface_Vendedor_Servidor _vendedor, Interface_Servidor_Vendedor servidor) throws java.rmi.RemoteException {
        String s = "";
        ArrayList<Produto> aux = (ArrayList<Produto>) obj.clone();
        for (Produto produto : aux) {
            if (LocalDateTime.now().isAfter(produto.getDataValidade())) {
                s = s + "\nValidade do produto " + produto.getNome() + " com ID " + produto.getID() + " esta vencida!";
                VerificacaoValidade(servidor, produto);
            }
        }
        return s;
    }

    //==================================================================================================================
    //Fun????o respons??vel por verificar se o produto alcan??ou a quantidade minima de stock ==============================
    public static void VerificacaoValidadeStock(Interface_Servidor_Vendedor servidor, Produto produto) throws RemoteException {
        int quatidadeMinima = produto.getQuantidadeMinima();
        int stock = produto.getStock();
        if (quatidadeMinima >= stock) {
            String fornecedor = produto.getFornecedor();
            for (String f : fornecedores) {
                if (f.equals(fornecedor)) {
                    servidor.AnotarMensagen("Stock do produto " + produto.getNome() + " com ID " + produto.getID() + " chegou na quantidade de stock minima!", f);
                    VerificacaoValidade(servidor, produto);
                }
            }
        }
    }

    //==================================================================================================================
    //Fun????o respons??vel por verificar se o produto pedeu a validade ===================================================
    public static void VerificacaoValidade(Interface_Servidor_Vendedor servidor, Produto produto) throws RemoteException {
        if (LocalDateTime.now().isAfter(produto.getDataValidade())) {
            String fornecedor = produto.getFornecedor();
            for (String f : fornecedores) {
                if (f.equals(fornecedor)) {
                    servidor.AnotarMensagen("Validade do produto " + produto.getNome() + " com ID " + produto.getID() + " est?? vencida!", f);
                    vendas.add(produto);
                    removerProdutoStocks(produto);
                    produto.setPrecoVenda(-1 * produto.getPrecoVenda());
                }
            }
        }
    }

    //==================================================================================================================
    //Fun????o respons??vel por remover um produto do arraylist ===========================================================
    public static void removerProdutoStocks(Produto produto) throws RemoteException {
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

        for (Produto item:obj) {
            if(item.getID() == produto.getID()){
                obj.remove(item);
                System.out.println(produto.getNome() + " removido!");
                return;
            }
        }
    }

    //==================================================================================================================
    //Fun????o respons??vel por adicionar um produto em um arraylist ======================================================
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
    //Fun????o main do Servidor ==========================================================================================
    public static void main(String[] args) {
        //Vin??cius: grant.policy
        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        //System.setProperty("java.security.policy", "C:\\Users\\denis\\IdeaProjects\\Sistemas-Distribuidos-TP1\\TP1\\grant.policy");
        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        //System.setProperty("java.security.policy", "C:\\Users\\denis\\IdeaProjects\\Sistemas-Distribuidos-TP1\\TP1\\grant.policy");

        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        //Miguel
        // System.setProperty("java.security.policy", "->Path do seu policy<-");
        System.setProperty("java.security.policy", "/home/frias/GitHub/Sistemas-Distribuidos-TP1/TP1/grant.policy");

        //Hermenegildo: grant.policy
        //System.setProperty("java.security.policy", "/Users/Lenovo/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        System.setSecurityManager(new SecurityManager());
        try {
            System.setProperty("java.rmi.server.hostname", "192.168.1.67"); //resgistar o ip do servidor
            LocateRegistry.createRegistry(1099);
            Servidor h = new Servidor();
            Naming.rebind("Servidor", h);
            System.out.println("Servidor ativado");
            String s;

            while (true) {
                System.out.println("============================================");
                System.out.println("======= Op????es de Comunica????o ==============");
                System.out.println("====== (1) Visualizar Mensagens ============");
                System.out.println("====== (sair)- Finalizar ===================");
                System.out.println("============================================");
                System.out.print("Op????o:");
                s = Validacao.readString();
                if (s == null) s = "Sair";
                switch (s) {
                    case "1":
                        Servidor.verificarMensagensServidor();
                        break;
                    case "sair":
                        Ficheiros.GuardarFcarne(Servidor.getCarnes());
                        Ficheiros.GuardarFbebidas(Servidor.getBebidas());
                        Ficheiros.GuardarFfrutos(Servidor.getFrutos());
                        Ficheiros.GuardarFlimpeza(Servidor.getLimpezas());
                        Ficheiros.GuardarFMercearia(Servidor.getMercearias());
                        Ficheiros.GuardarFpeixe(Servidor.getPeixes());
                        Ficheiros.GuardarHistoricoVendas(Servidor.getVendas());
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
