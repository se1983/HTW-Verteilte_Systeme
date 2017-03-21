package org.geblubber.sebsch.network.client;


public interface RMI_ClientCallbackInterface extends java.rmi.Remote {
    public String notifyMe(String message) throws java.rmi.RemoteException;
}
