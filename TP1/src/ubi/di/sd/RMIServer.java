package ubi.di.sd;

public class RMIServer {

    //public Ficheiros




    public static void main(String[] args) {
        //Ficheiro de permissão: Alterar para a vossa directoria
        System.setProperty("java.security.policy", "file:/home/frias/MEGAsync/EI/20_21/2º Semestre/Sistemas Distribuidos/Pratica/Ficha 6/grant.policy");
        System.setSecurityManager(new SecurityManager());

        try{
            //Ficheiros fp = new Ficheiros();

            java.rmi.registry.LocateRegistry.createRegistry(1091); //ATENÇÂO ao porto
            System.out.println("O registo do RMI está pronto.");

        }catch (Exception e){
            System.out.println("Start RMI excepção: " + e.getMessage());
        }

        try {
            RMIImp implementaInterface = new RMIImp("RMIImp"); //Instanciar o objecto remoto
            System.out.println("Servidor foi Iniciado com sucesso.");

        }catch (Exception e){
            System.out.println("Ocurreu um erro no servidor " + e);
        }


    }
}
