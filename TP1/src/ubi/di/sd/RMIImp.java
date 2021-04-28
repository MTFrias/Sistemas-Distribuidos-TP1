package ubi.di.sd;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class RMIImp extends UnicastRemoteObject implements RMIInterface {


    public RMIImp(String name) throws RemoteException {
        super();

        try {
            Naming.rebind(name, this);
        } catch (Exception e) {
            if (e instanceof RemoteException)
                throw (RemoteException) e;
            else
                throw new RemoteException(e.getMessage());
        }


        Ficheiros.InserirNovoPeixe();
    }




}
