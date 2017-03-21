// Tobias Dumke s0533422 & LLukasz Zajac s0526268
package spicker;

import java.rmi.*;
import java.io.*;

public class ChatClientMain
{
    public static void main(String[] args)
    {
        // Prüfen ob Kommandozeielenparameter richtig angegeben sind
        if(args.length != 2)
        {
            System.out.println("Nötige Kommandozeilenargumente: "
                               + "<Name des Servers> <eigener Name>");
            return;
        }
        try
        {
          //   ChatServer wird in der RMI-Reg erfragt
            ChatServer server = (ChatServer) Naming.lookup("rmi://" + args[0]
                                                           + "/ChatServer");
            
         /*   ChatServer server = (ChatServer) Naming.lookup("rmi://" + "localhost"
                                                           + "/ChatServer");
           */ 
            
            System.out.println("Kontakt zu Server hergestellt");
            // Hier client erzeugen -> hinzufügen
            ChatClientImpl client = new ChatClientImpl(args[1]);
       //     ChatClientImpl client = new ChatClientImpl("TestUser");
            // Wenn es den Client noch nicht gibt wird true geliefert und der 
            // Client wurde hinzugefügt
            if(server.addClient(client))
            {
                System.out.println("Ende durch Einagbe '\\Ende' " 
                                   + "oder '\\ende'");
                sendInputToServer(server, args[1]);
//                sendInputToServer(server, "TestUser");
                server.removeClient(client);
            }
            else
            {
                System.out.println("Es ist schon jemand unter "
                                   + "diesem Namen angemeldet");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.exit(0);
    }

    private static void sendInputToServer(ChatServer server, String name)
    {
        try
        {
            // Zeilen einlesen
            BufferedReader input = new BufferedReader(
                                       new InputStreamReader(System.in));
            String line;
            // Solange nicht ende oder Ende eingegeben wurde dauerschleife
            while((line = input.readLine()) != null)
            {
                if(line.equals("\\ende") || line.equals("\\Ende"))
                {
                    break;
                }
                server.sendMessage(name, line);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
