package spicker;

import java.rmi.*;
// Interface ChatServer -> ist ein RMI Objekt - dient für "Call by Reference"
public interface ChatServer extends Remote
{
    // Übergabeparameter Reference eines Objektes deswegen Schnittstelle angegeben
    public boolean addClient(ChatClient objRef) throws RemoteException;
    public void removeClient(ChatClient objRef) throws RemoteException;
    public void sendMessage(String name, String msg) throws RemoteException;
}