package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


//Java.utl.logger

/**
 * Erstellt von  sebsch on 28.11.16.
 */
public class Receiver implements ReceiverInterface {

    private ServerSocket welcomeSocket;

    public Receiver() throws IOException {
        this.welcomeSocket = new ServerSocket(6789);
    }

    @Override
    public void rcv() throws IOException {

        System.out.println("[ Master ] Server ["
                + this.welcomeSocket.getInetAddress()
                + "] started. Awaiting querys on Port "
                + this.welcomeSocket.getLocalPort() + ".");

        while (true){

            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("[ Master ] Receved query from "
                    + connectionSocket.getInetAddress()
                    + ":" + connectionSocket.getLocalPort()
                    + ".");
            Thread srv = new TCPServer(connectionSocket);
            System.out.println("[ Master ] Made a new thread. ID: " + srv.getId() + ", Name: " + srv.getName());
            srv.start();

        }
    }
}
