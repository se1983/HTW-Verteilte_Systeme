package spicker;


// Interface ChatClient -> ist ein RMI Objekt - dient für "Call by Reference"
public interface ChatClient extends java.rmi.Remote
{
    // Übergabeparameter Reference eines Objektes deswegen Schnittstelle angegeben
    public String getName() throws java.rmi.RemoteException;
    public void print(String msg) throws java.rmi.RemoteException;
}