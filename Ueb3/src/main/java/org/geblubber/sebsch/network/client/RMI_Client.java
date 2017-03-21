package org.geblubber.sebsch.network.client;

import org.geblubber.sebsch.network.server.RMI_ServerInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMI_Client {

    public RMI_Client() {
        new RMI_Client(null);
    }

    public RMI_Client(String host) {

        try {

            Registry registry = LocateRegistry.getRegistry(host);
            RMI_ServerInterface stub = (RMI_ServerInterface) registry.lookup("RMI_ServerInterface");

            String response = stub.getTemperatureList(uii());
            System.out.println(response);

            if (!response.equals("Call is not valid! Please send the date in this format: YYYY-MM-DD\n")) {
                RMI_ClientCallbackInterface callBackObj = new RMI_ClientCallback();
                stub.registerForCallback(callBackObj);
                Thread.sleep(3000);
                stub.unregisterForCallback(callBackObj);
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public static String uii() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Bitte Datum Eingeben [YYYY-MM-DD] \n\t>>> ");
        return reader.next();
    }

}