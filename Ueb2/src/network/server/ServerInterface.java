package network.server;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by sebsch on 28.10.16.
 */
public interface ServerInterface {

    public void run() throws IOException;

    public String rcv(Socket connectionSocket) throws IOException;

    public void send(String msg, Socket connectionSocket) throws IOException;

}
