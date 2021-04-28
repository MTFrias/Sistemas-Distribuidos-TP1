package ubi.di.sd;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIImp extends UnicastRemoteObject implements RMIInterface {


    public RMIImp(String name) throws RemoteException {
        super();

     /*
     try {
            Naming.rebind(name, this);

        } catch (Exception e) {
            if (e instanceof RemoteException)
                throw (RemoteException) e;
            else
                throw new RemoteException(e.getMessage());
        }
        */


    }

    public void Inserir() {
        //Ficheiros.InserirNovoPeixe();
    }

}
