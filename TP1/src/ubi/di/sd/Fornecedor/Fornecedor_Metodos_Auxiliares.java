package ubi.di.sd.Fornecedor;

import ubi.di.sd.Model.*;
import ubi.di.sd.Servidor.Interface_Servidor_Fornecedor;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Fornecedor_Metodos_Auxiliares {

    public static String escreverNome() {
        System.out.print("Nome do produto:");
        return Validacao.readString();
    }

    public static int escreverStock() {
        System.out.print("Número de Stock:");

        return Integer.parseInt(Objects.requireNonNull(Validacao.readString()));
    }

    public static int escreverId() {
        System.out.print("ID do produto:");
        return Integer.parseInt(Objects.requireNonNull(Validacao.readString()));
    }

    public static double escreverPrecoCompra() {
        System.out.print("Preco do produto par se comprar:");
        return Double.parseDouble(Objects.requireNonNull(Validacao.readString()));
    }

    public static double escreverPrecoVenda() {
        System.out.print("Preco do produto para se vender:");
        return Double.parseDouble(Objects.requireNonNull(Validacao.readString()));
    }

    public static LocalDateTime escreverValidade() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDateTime now = LocalDateTime.now();
        return LocalDateTime.now();
    }

    public static int escreverQuantidadeMinima() {
        System.out.print("Quantidade minima:");
        return Integer.parseInt(Objects.requireNonNull(Validacao.readString()));
    }


    public static void adicionarProdutoServidor(Interface_Servidor_Fornecedor servidor, Interface_Fornecedor_Servidor fornecedor) throws RemoteException {
        String s, nome;
        double pc, pv;
        int st, qm;
        LocalDateTime v;
        while (true) {
            System.out.println("=======================================");
            System.out.println("============== Opções =================");
            System.out.println("====== (1) Adicionar Peixe ============");
            System.out.println("====== (2) Adicionar Carne ============");
            System.out.println("====== (3) Adicionar Limpeza ==========");
            System.out.println("====== (4) Adicionar Bebidas ==========");
            System.out.println("====== (5) Adicionar Frutos ===========");
            System.out.println("====== (6) Adicionar Mercearia ========");
            System.out.println("====== (sair) - Finalizar =============");
            System.out.println("=======================================");
            System.out.print("Opção:");
            s = Validacao.readString();
            if (s!= null && (s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6"))) {
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


    public static void consultarHistoricoCompras(Interface_Servidor_Fornecedor servidor, Interface_Fornecedor_Servidor fornecedor) throws RemoteException {
        while (true) {
            System.out.println("======================================================");
            System.out.println("=========== Lista de Produtos Comprados ==============");
            System.out.println("====== (1) Listar por Decrescente (Preço de compra) ==");
            System.out.println("====== (2) Listar por Crescente (Preço de compra) ====");
            System.out.println("====== (3) Listar por Alfabetica (Nome) ==============");
            System.out.println("====== (4) Listar por Alfabetica (Invertido) =========");
            System.out.println("====== (5) Listar Todos os Produtos Comprados =========");
            System.out.println("================== (sair)- Finalizar =================");
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

    public static void removeProduto(Interface_Servidor_Fornecedor servidor, Interface_Fornecedor_Servidor fornecedor) throws RemoteException {
        System.out.println(servidor.consultarVendas(fornecedor,1));
        System.out.println(servidor.removeProduto(fornecedor, escreverId()));
        System.out.println("Para continuar aperte alguma tecla!");
        String s = Validacao.readString();
    }
}
