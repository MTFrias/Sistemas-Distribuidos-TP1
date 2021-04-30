package ubi.di.sd.Vendedor;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;
import ubi.di.sd.Model.Validacao;
import ubi.di.sd.Servidor.Interface_Servidor_Fornecedor;
import ubi.di.sd.Servidor.Interface_Servidor_Vendedor;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class Vendedor_Metodos_Auxiliares {


    public static void consultarProdutosEmStock(Interface_Servidor_Vendedor servidor, Interface_Vendedor_Servidor vendedor) throws RemoteException {
        System.out.println("FLAG222");
        //System.out.println(servidor.consultarProduto(vendedor));
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
            System.out.println("====== (sair) - Finalizar =============");
            System.out.println("=======================================");
            System.out.print("Opção: ");
            s = Validacao.readString();
            if(s == null) s = "sair";
            switch (s) {
                case "1":
                    System.out.println("BINGO 222222222");
                    consultarProdutosEmStock(servidor, vendedor);
                    break;
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    break;
                case "Sair":
                    return;
            }
        }
    }

    public static void venderProdutoServidor(Interface_Servidor_Vendedor servidor, Interface_Vendedor_Servidor vendedor) throws RemoteException {
        String s;
        while (true) {
            System.out.println("=======================================");
            System.out.println("============== Opções =================");
            System.out.println("====== (1) Vender Peixe ===========");
            System.out.println("====== (2) Vender Carne ===========");
            System.out.println("====== (3) Vender Produto de Limpeza ==========");
            System.out.println("====== (4) Vender Bebidas ==========");
            System.out.println("====== (5) Vender Frutos ===========");
            System.out.println("====== (6) Vender Mercearia ========");
            System.out.println("====== (sair) - Finalizar =============");
            System.out.println("=======================================");
            System.out.print("Opção: ");
            s = Validacao.readString();
            if(s == null) s = "sair";
            switch (s) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    break;
                case "Sair":
                    return;
            }
        }
    }
}
