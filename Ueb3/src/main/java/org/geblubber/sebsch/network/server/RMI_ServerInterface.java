package org.geblubber.sebsch.network.server;

import org.geblubber.sebsch.network.client.RMI_ClientCallbackInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_ServerInterface extends Remote {

    String getTemperatureList(String day) throws RemoteException;

    void registerForCallback(RMI_ClientCallbackInterface callbackClientObject) throws java.rmi.RemoteException;

    void unregisterForCallback(RMI_ClientCallbackInterface callbackClientObject) throws java.rmi.RemoteException;
}
