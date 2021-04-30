package ubi.di.sd.Fornecedor;

import ubi.di.sd.Model.Ficheiros;
import ubi.di.sd.Model.Validacao;
import ubi.di.sd.Servidor.Interface_Servidor_Fornecedor;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Fornecedor extends java.rmi.server.UnicastRemoteObject implements Interface_Fornecedor_Servidor {

    public String nomeFornecedor;
    protected Fornecedor(String _nome) throws java.rmi.RemoteException {
        super();
        nomeFornecedor = _nome;
    }

    @Override
    public void printOnServidor(String s) throws RemoteException {
        System.out.println(s);
    }

    @Override
    public String getNomeFornecedor() throws RemoteException {
        return nomeFornecedor;
    }

    public static void main(String[] args) {
        String s;
        //Vinícius: grant.policy
        //System.setProperty("java.security.policy", "/Users/vinciusrodriguessilvacosta/IdeaProjects/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        System.setProperty("java.security.policy", "C:\\Users\\denis\\IdeaProjects\\Sistemas-Distribuidos-TP1\\TP1\\grant.policy");
        //Miguel
        //System.setProperty("java.security.policy", "/home/frias/GitHub/Sistemas-Distribuidos-TP1/TP1/grant.policy");
        System.setSecurityManager(new SecurityManager());
        try {


            LocateRegistry.getRegistry(1099);
            Interface_Servidor_Fornecedor servidor = (Interface_Servidor_Fornecedor) Naming.lookup("Servidor");
            Fornecedor fornecedor = new Fornecedor("Fornecedor 1");
            servidor.subscribeFornecedor(fornecedor.nomeFornecedor, fornecedor);
            while (true) {
                System.out.println("============================================================");
                System.out.println("=============== Opções de Comunicação ======================");
                System.out.println("====== (0) Comunicar Servidor ==============================");
                System.out.println("====== (1) Adicionar Produto ===============================");
                System.out.println("====== (2) Adicionar Produtos (já existentes) ==============");
                System.out.println("====== (3) Remover Produtos ================================");
                System.out.println("====== (4) Consultar Historico de Compras ==================");
                System.out.println("====== (5) Consultar Historico de Vendas ===================");
                System.out.println("================= (sair)- Finalizar ========================");
                System.out.println("============================================================");
                System.out.print("Opção:");
                s = Validacao.readString();
                if(s == null ) s = "Sair";
                switch (s) {
                    case "0":
                        servidor.printOnFornecedor(Validacao.readString());
                        break;
                    case "1":
                        Fornecedor_Metodos_Auxiliares.adicionarProdutoServidor(servidor,fornecedor);
                        break;
                    case "2":
                        break;
                    case "3":
                        Fornecedor_Metodos_Auxiliares.removeProduto(servidor,fornecedor);
                        break;
                    case "4":
                        Fornecedor_Metodos_Auxiliares.consultarHistoricoCompras(servidor,fornecedor);
                        break;
                    case "5":
                        break;
                    case "sair":
                        System.exit(0);
                }
            }
        } catch (Exception r) {
            System.out.println("Exception in client" + r.getMessage());
        }
    }

}
