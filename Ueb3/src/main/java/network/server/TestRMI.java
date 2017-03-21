package network.server;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by sebsch on 11.11.16.
 */
public interface TestRMI extends Remote {
    public String sayHello (String name) throws RemoteException;
}
