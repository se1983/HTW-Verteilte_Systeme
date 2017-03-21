package spicker;


// Tobias Dumke s0533422 & LLukasz Zajac s0526268


import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class ChatServerMain
{
    public static void main(String[] args)
    {
        try
        {
            //  starten der Reg und eintargen des RMI-Servers
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("ChatServer", new ChatServerImpl());
            System.out.println("Server starts !");
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}