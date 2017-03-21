package org.geblubber.sebsch.network.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RMI_ClientCallback extends UnicastRemoteObject implements RMI_ClientCallbackInterface {

    public RMI_ClientCallback() throws RemoteException {
        super();
    }

    public String notifyMe(String message) {
        String returnMessage = "Call back received: \n" + message;
        System.out.println(returnMessage);
        return returnMessage;
    }

}
