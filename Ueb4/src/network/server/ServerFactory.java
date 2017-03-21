package network.server;

import java.io.IOException;

/**
 * Created by sebsch on 28.10.16.
 */
public class ServerFactory {

    ReceiverInterface rcv;

    private static ServerFactory ourInstance;

    static {
        try {
            ourInstance = new ServerFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ServerFactory getInstance() {
        return ourInstance;
    }

    ServerFactory() throws IOException {
        rcv = new Receiver();
        rcv.rcv();
    }
}
