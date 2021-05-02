package ubi.di.sd.Fornecedor;

import Ler.Ler;
import ubi.di.sd.Model.*;
import ubi.di.sd.Servidor.Interface_Servidor_Fornecedor;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//======================================================================================================================
//Classe auxiliar para as consultas os metodos do servidor =============================================================
public class Fornecedor_Metodos_Auxiliares {
    //==================================================================================================================
    //Função responsável por pegar o input do nome do produto ==========================================================
    public static String escreverNome() {
        System.out.println("============================================");
        System.out.print("Nome do produto:");
        String s = Validacao.readString();
        if (s == null) {
            s = "Vázio!";
        }
        return s;
    }
    //==================================================================================================================
    //Função responsável por pegar o input da quantidade de stock de um produto ========================================
    public static int escreverStock() {
        int s;
        do {
            System.out.println("============================================");
            System.out.print("Quantos produtos para comprar (tem que ser maior ou iqual a 0!):");
            s = Ler.umInt();
        } while (s < 0);
        return s;
    }
    //==================================================================================================================
    //Função responsável por pegar o input do ID do produto ============================================================
    public static int escreverId() {
        int s;
        do {
            System.out.println("============================================");
            System.out.print("ID do produto (tem que ser maior ou iqual a 0!):");
            s = Ler.umInt();
        } while (s < 0);
        return s;
    }
    //==================================================================================================================
    //Função responsável por pegar o input do preço de compra de um produto ============================================
    public static double escreverPrecoCompra() {
        double s;
        do {
            System.out.println("============================================");
            System.out.print("Preco do produto para se comprar (tem que ser maior que 0!):");
            s = Ler.umDouble();
        } while (s < 0);
        return s;
    }
    //==================================================================================================================
    //Função responsável por pegar o input do preço de venda de um produto =============================================
    public static double escreverPrecoVenda() {
        double s;
        do {
            System.out.println("============================================");
            System.out.print("Preço do produto para se vender (tem que ser maior que 0!):");
            s = Ler.umDouble();
        } while (s < 0);
        return s;
    }
    //==================================================================================================================
    //Função responsável por pegar o input de quanto meses de validade de um produto ===================================
    public static LocalDateTime escreverValidade() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        int s;
        do {
            System.out.println("============================================");
            System.out.print("Quantos meses de validade (ter que ser maior que 0!):");
            s = Ler.umInt();
        } while (s < 0);
        return LocalDateTime.now().plusMonths(s);
    }
    //==================================================================================================================
    //Função responsável por pegar o input da quantidade minima no stock de um produto =================================
    public static int escreverQuantidadeMinima() {
        int s;
        do {
            System.out.print("Quantidade minima (tem que ser maior que 0!):");
            s = Ler.umInt();
        } while (s < 0);
        return s;
    }
    //==================================================================================================================
    //Função responsável por adicionar um produto de uma categoria de produto  =========================================
    public static void adicionarProdutoServidor(Interface_Servidor_Fornecedor servidor, Interface_Fornecedor_Servidor fornecedor) throws RemoteException {
        String s, nome;
        double pc, pv;
        int st, qm;
        LocalDateTime v;
        while (true) {
            System.out.println("=======================================");
            System.out.println("====== Opções para adicionar ==========");
            System.out.println("====== (1) Adicionar Peixe ============");
            System.out.println("====== (2) Adicionar Carne ============");
            System.out.println("====== (3) Adicionar Limpeza ==========");
            System.out.println("====== (4) Adicionar Bebidas ==========");
            System.out.println("====== (5) Adicionar Frutos ===========");
            System.out.println("====== (6) Adicionar Mercearia ========");
            System.out.println("====== (Sair) - Finalizar =============");
            System.out.println("=======================================");
            System.out.print("Opção:");
            s = Validacao.readString();
            if (s != null && (s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6"))) {
                nome = escreverNome();
                pc = escreverPrecoCompra();
                pv = escreverPrecoVenda();
                st = escreverStock();
                qm = escreverQuantidadeMinima();
                v = escreverValidade();
                System.out.println(servidor.adicionarProduto(nome, st, pc, pv, v, qm, fornecedor, s));
            } else {
                return;
            }
            System.out.println("Para continuar aperte alguma tecla!");
            s = Validacao.readString();
        }
    }
    //==================================================================================================================
    //Função responsável por consultar o historico de compras dos produto ==============================================
    public static void consultarHistoricoCompras(Interface_Servidor_Fornecedor servidor, Interface_Fornecedor_Servidor fornecedor) throws RemoteException {
        while (true) {
            System.out.println("======================================================");
            System.out.println("====== Lista de Produtos Comprados ===================");
            System.out.println("====== (1) Listar por Decrescente (Preço de compra) ==");
            System.out.println("====== (2) Listar por Crescente (Preço de compra) ====");
            System.out.println("====== (3) Listar por Alfabetica (Nome) ==============");
            System.out.println("====== (4) Listar por Alfabetica (Invertido) =========");
            System.out.println("====== (5) Listar Todos os Produtos Comprados ========");
            System.out.println("====== (sair) - Finalizar ============================");
            System.out.println("======================================================");
            System.out.print("Opção:");
            String s = Validacao.readString();
            if (s == null) s = "sair";
            switch (s) {
                case "1":
                    System.out.println(servidor.consultarCompras(fornecedor, 1));
                    break;
                case "2":
                    System.out.println(servidor.consultarCompras(fornecedor, 2));
                    break;
                case "3":
                    System.out.println(servidor.consultarCompras(fornecedor, 3));
                    break;
                case "4":
                    System.out.println(servidor.consultarCompras(fornecedor, 4));
                    break;
                case "5":
                    System.out.println(servidor.consultarCompras(fornecedor, 5));
                    break;
                case "sair":
                    return;
            }
            System.out.println("Para continuar aperte alguma tecla!");
            s = Validacao.readString();
        }
    }
    //==================================================================================================================
    //Função responsável por consultar o historico de vendas dos produto ===============================================
    public static void consultarHistoricoVendidos(Interface_Servidor_Fornecedor servidor, Interface_Fornecedor_Servidor fornecedor) throws RemoteException {
        while (true) {
            System.out.println("======================================================");
            System.out.println("====== Lista de Produtos Vendidos ====================");
            System.out.println("====== (1) Listar por Menos vendidos =================");
            System.out.println("====== (2) Listar por Mais Vendidos ==================");
            System.out.println("====== (3) Listar por Alfabetica (Nome) ==============");
            System.out.println("====== (4) Listar por Alfabetica (Invertido) =========");
            System.out.println("====== (5) Listar por ID =============================");
            System.out.println("====== (sair) - Finalizar ============================");
            System.out.println("======================================================");
            System.out.print("Opção:");
            String s = Validacao.readString();
            if (s == null) s = "sair";
            switch (s) {
                case "1":
                    System.out.println(servidor.consultarVendas(fornecedor, 1));
                    break;
                case "2":
                    System.out.println(servidor.consultarVendas(fornecedor, 2));
                    break;
                case "3":
                    System.out.println(servidor.consultarVendas(fornecedor, 3));
                    break;
                case "4":
                    System.out.println(servidor.consultarVendas(fornecedor, 4));
                    break;
                case "5":
                    System.out.println(servidor.consultarVendas(fornecedor, 5));
                    break;
                case "sair":
                    return;
            }
            System.out.println("Para continuar aperte alguma tecla!");
            s = Validacao.readString();
        }
    }
    //==================================================================================================================
    //Função responsável por remover um produto do stock ===============================================================
    public static void removeProduto(Interface_Servidor_Fornecedor servidor, Interface_Fornecedor_Servidor fornecedor) throws RemoteException {
        while (true) {
            System.out.println("======================================================");
            System.out.println("======== Opções de Eliminar um Porduto ===============");
            System.out.println("======= (1) Eliminar um Produto ======================");
            System.out.println("======= (sair) - Finalizar ===========================");
            System.out.println("======================================================");
            System.out.print("Opção:");
            String s = Validacao.readString();
            if (s == null) s = "sair";
            switch (s) {
                case "1":
                    System.out.println(servidor.consultarCompras(fornecedor, 1));
                    System.out.println(servidor.removeProduto(fornecedor, escreverId()));
                case "sair":
                    return;
            }
            System.out.println("Para continuar aperte alguma tecla!");
            s = Validacao.readString();
        }
    }
    //==================================================================================================================
    //Função responsável por consultar as mensagens que o fornecedor recebeu ===========================================
    public static void LerMensagens(Interface_Servidor_Fornecedor servidor, ArrayList<String> mensagens, Fornecedor fornecedor) throws RemoteException {
        servidor.ConsultarMensagens(fornecedor);
        if (mensagens.size() != 0) {
            for (String item : mensagens) {
                System.out.println(item);
            }
        } else {
            System.out.println("Nenhuma mensagem direcionada ao " + fornecedor.getNomeFornecedor() + "!");
        }
    }
}
