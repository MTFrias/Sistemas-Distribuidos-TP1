package ubi.di.sd.Fornecedor;

import ubi.di.sd.Model.*;
import ubi.di.sd.Servidor.Interface_Servidor_Fornecedor;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.Objects;

public class Fornecedor_Metodos_Auxiliares {

    public static String escreverNome() {
        System.out.print("Nome do produto:");
        return Validacao.readString();
    }

    public static int escreverStock() {
        int num = 0;
        System.out.print("Número de Stock:");
        do {
            try {
                num = Integer.parseInt(Validacao.readString());
            }catch(Exception e){
                num = 0;
            }
        } while (num <= 0);
        return num;
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
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
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
            if (s == null) s = "sair";
            switch (s) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    nome = escreverNome();
                    pc = escreverPrecoCompra();
                    pv = escreverPrecoVenda();
                    st = escreverStock();
                    qm = escreverQuantidadeMinima();
                    v = escreverValidade();
                    servidor.adicionarProduto(nome, st, pc, pv, v, qm, fornecedor, s);
                    break;
                case "Sair":
                    return;
            }
        }
    }


    public static void consultarHistoricoVendasServidorTotal(Interface_Servidor_Fornecedor servidor) throws RemoteException {
        System.out.println(servidor.consultarTodasVendas());
    }

    public static void consultarHistoricoVendasServidor(Interface_Servidor_Fornecedor servidor, Interface_Fornecedor_Servidor fornecedor) throws RemoteException {
        System.out.println(servidor.consultarVendas(fornecedor));
    }
}
