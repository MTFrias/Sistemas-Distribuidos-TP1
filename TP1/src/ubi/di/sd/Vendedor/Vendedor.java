package ubi.di.sd.Vendedor;

import ubi.di.sd.Model.Validacao;
import ubi.di.sd.Servidor.Interface_Servidor_Vendedor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Vendedor extends java.rmi.server.UnicastRemoteObject implements Interface_Vendedor_Servidor {

    public String nomeVendedor;

    protected Vendedor(String _nome) throws java.rmi.RemoteException {
        super();
        nomeVendedor = _nome;
    }

    @Override
    public void printOnServidor(String s) throws RemoteException {
        System.out.println(s);
    }


    @Override
    public String getNomeVendedor() throws RemoteException {
        return nomeVendedor;
    }

    //Método que permite receber input do usuário
    @Override
    public int lerNoVendedor() {
        int i, x;
        i = Ler.Ler.umInt();
        x = Math.abs(i);
        return x;
    }

    public static void main(String[] args) {
        String s;
        //Vinicius Ip
        //String ipServer = "192.168.1.68";

        //Hermenegildo
        String ipServer = "127.0.0.1";
        int portServer = 1099;

        //Vinícius
        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        //System.setProperty("java.security.policy", "C:\\Users\\denis\\IdeaProjects\\Sistemas-Distribuidos-TP1\\TP1\\grant.policy");

        //Miguel
        //System.setProperty("java.security.policy", "/home/frias/GitHub/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        //Hermenegildo
        //System.setProperty("java.security.policy", "/Users/Lenovo/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        System.setSecurityManager(new SecurityManager());
        try {

            Registry registry = LocateRegistry.getRegistry(ipServer, portServer);
            Interface_Servidor_Vendedor servidor = (Interface_Servidor_Vendedor) registry.lookup("Servidor");
            LocateRegistry.getRegistry(1099);
            Vendedor vendedor = new Vendedor("Vendedor 1");
            //Menu principal para o vendedor, com as opções de operações que o mesmo pode fazer
            servidor.inscreverVendedor(vendedor.nomeVendedor, vendedor);
            while (true) {
                System.out.println("==============================================");
                System.out.println("====== Opções de Comunicação =================");
                System.out.println("====== (0) Comunicar Servidor ================");
                System.out.println("====== (1) Consultar Produto =================");
                System.out.println("====== (2) Vender Produto ====================");
                System.out.println("====== (3) Verificar Validade dos Produtos ===");
                System.out.println("====== (4) Consultar Historico de Vendas =====");
                System.out.println("=======(sair)- Finalizar =====================");
                System.out.println("==============================================");
                System.out.print("Opção:");
                s = Validacao.readString();
                if (s == null) s = "sair";
                switch (s) {
                    case "0":
                        servidor.printOnVendedor(Validacao.readString());
                        break;
                    case "1":
                        Vendedor_Metodos_Auxiliares.consultarProdutoServidor(servidor, vendedor);
                        break;
                    case "2":
                        Vendedor_Metodos_Auxiliares.venderProdutoServidor(servidor, vendedor);
                        break;
                    case "3":
                        Vendedor_Metodos_Auxiliares.verificarDataValidadeProdutos(servidor, vendedor);
                        break;
                    case "4":
                        Vendedor_Metodos_Auxiliares.consultarHistoricoVendidos(servidor, vendedor);
                        break;
                    case "sair":
                        System.exit(0);
                }
                System.out.println("Para continuar aperte alguma tecla!");
                s = Validacao.readString();
            }
        } catch (Exception r) {
            System.out.println("Exception in client " + r.getMessage());
        }
    }
}
