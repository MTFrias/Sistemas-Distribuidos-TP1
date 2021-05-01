package ubi.di.sd.Vendedor;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;
import ubi.di.sd.Model.Validacao;
import ubi.di.sd.Servidor.Interface_Servidor_Fornecedor;
import ubi.di.sd.Servidor.Interface_Servidor_Vendedor;
import ubi.di.sd.Servidor.Servidor;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class Vendedor_Metodos_Auxiliares {


    public static void consultarProdutosEmStock(Interface_Servidor_Vendedor servidor, Interface_Vendedor_Servidor vendedor, int _opcao) throws RemoteException {
        //System.out.println("FLAG222");
        System.out.println(servidor.consultarProduto(vendedor, _opcao));
    }

    public static void consultarProdutoServidor(Interface_Servidor_Vendedor servidor, Interface_Vendedor_Servidor vendedor) throws RemoteException {
        String s;
        while (true) {
            System.out.println("=======================================");
            System.out.println("============== Opções =================");
            System.out.println("====== (1) Consultar Peixes ===========");
            System.out.println("====== (2) Consultar Carnes ===========");
            System.out.println("====== (3) Consultar Limpeza ==========");
            System.out.println("====== (4) Consultar Bebidas ==========");
            System.out.println("====== (5) Consultar Frutos ===========");
            System.out.println("====== (6) Consultar Mercearia ========");
            System.out.println("====== (7) Listar Todos Produtos ======");
            System.out.println("====== (sair) - Finalizar =============");
            System.out.println("=======================================");
            System.out.print("Opção: ");
            s = Validacao.readString();
            if(s == null) s = "sair";
            switch (s) {
                case "1":
                    //System.out.println("BINGO 222222222");
                    consultarProdutosEmStock(servidor, vendedor, 1);
                    break;
                case "2":
                    consultarProdutosEmStock(servidor, vendedor, 2);
                    break;
                case "3":
                    consultarProdutosEmStock(servidor, vendedor, 3);
                    break;
                case "4":
                    consultarProdutosEmStock(servidor, vendedor, 4);
                    break;
                case "5":
                    consultarProdutosEmStock(servidor, vendedor, 5);
                    break;
                case "6":
                    consultarProdutosEmStock(servidor, vendedor, 6);
                    break;
                case "7":
                    consultarProdutosEmStock(servidor, vendedor, 7);
                    break;
                case "Sair":
                    return;
            }
            System.out.println("Para continuar aperte alguma tecla!");
            s = Validacao.readString();
        }
    }

    public static void venderProdutoServidor(Interface_Servidor_Vendedor servidor, Interface_Vendedor_Servidor vendedor) throws RemoteException {
        String s;
        while (true) {
            System.out.println("=======================================");
            System.out.println("============== Opções =================");
            System.out.println("====== (1) Vender Peixe ===============");
            System.out.println("====== (2) Vender Carne ===============");
            System.out.println("====== (3) Vender Produto de Limpeza ==");
            System.out.println("====== (4) Vender Bebidas =============");
            System.out.println("====== (5) Vender Frutos ==============");
            System.out.println("====== (6) Vender Mercearia ===========");
            System.out.println("====== (sair) - Finalizar =============");
            System.out.println("=======================================");
            System.out.print("Opção: ");
            s = Validacao.readString();

            if(s == null) s = "sair";
            switch (s) {
                case "1":
                    System.out.println(servidor.venderProduto(vendedor, 1,servidor));
                    break;
                case "2":
                    System.out.println(servidor.venderProduto(vendedor, 2,servidor));
                    break;
                case "3":
                    System.out.println(servidor.venderProduto(vendedor, 3,servidor));
                    break;
                case "4":
                    System.out.println(servidor.venderProduto(vendedor, 4,servidor));
                    break;
                case "5":
                    System.out.println(servidor.venderProduto(vendedor, 5,servidor));
                    break;
                case "6":
                    System.out.println(servidor.venderProduto(vendedor, 6,servidor));
                    break;
                case "Sair":
                    return;
            }
            System.out.println("Para continuar aperte alguma tecla!");
            s = Validacao.readString();
        }
    }

    public static void verificarDataValidadeProdutos(Interface_Servidor_Vendedor servidor, Vendedor vendedor) throws RemoteException {
        System.out.println(servidor.verificarDataValidade(vendedor,servidor));
    }
}
