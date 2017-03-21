package spicker;

import spicker.ChatClient;
import spicker.ChatServer;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

@SuppressWarnings("serial")
public class ChatServerImpl extends UnicastRemoteObject implements ChatServer
{
    private ArrayList<ChatClient> allClients;

    public ChatServerImpl() throws RemoteException
    {
        // Liste aller ClientReferencen
        allClients = new ArrayList<ChatClient>();
    }

    
    public synchronized boolean addClient(ChatClient objRef)
                                                            throws RemoteException
    {
        // Clientname des Objekts holen und setzten
        String name = objRef.getName();
        
        // Solange in der Liste Objekte sind wird durchgegangen
        for(Iterator<ChatClient> iter = allClients.iterator(); iter.hasNext();)
        {
            ChatClient cc = iter.next();
            try
            {
                // Wenn der Clientname bereits exsistiert FALSE
                if(cc.getName().equals(name))
                {
                    return false;
                }
            }
            catch(RemoteException exc)
            {
                iter.remove();
            }
        }
        // Wenn es ihn nicht gibt wird er der Liste hinzugefügt und gibt TRUE zurück
        allClients.add(objRef);
        return true;
    }

    public synchronized void removeClient(ChatClient objRef)
                                                            throws RemoteException
    {
        // Unter angabe der ObjektReference kann der Client gelöscht werden 
        allClients.remove(objRef);
    }

    public synchronized void sendMessage(String name, String msg)
                                                                 throws RemoteException
    {
        // Hier wird an alle Clients in der Liste die Nachricht gesendet
        for(Iterator<ChatClient> iter = allClients.iterator(); iter.hasNext();)
        {
            ChatClient cc = iter.next();
            try
            {
                cc.print(name + ": " + msg);
            }
            catch(RemoteException exc)
            {
                // letzte was mit next aufgerufen wurde wird gelöscht
                iter.remove();
            }
        }
    }
}