package network.server;

import java.io.IOException;

/**
 * Created by sebsch on 28.10.16.
 */
public class ServerFactory {

    private static ServerFactory ourInstance;

    static {
        try {
            ourInstance = new ServerFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ServerInterface serv;

    ServerFactory() throws IOException {
        serv = new TCPServer();
        serv.run();
    }

    public static ServerFactory getInstance() {
        return ourInstance;
    }
}
