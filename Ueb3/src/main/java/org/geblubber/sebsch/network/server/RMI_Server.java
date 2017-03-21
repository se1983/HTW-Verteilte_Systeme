package org.geblubber.sebsch.network.server;

import org.geblubber.sebsch.data.DayTabular;
import org.geblubber.sebsch.data.csvParser;
import org.geblubber.sebsch.network.client.RMI_ClientCallbackInterface;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class RMI_Server implements RMI_ServerInterface {

    private String query;
    private String csvFILE;
    private DayTabular dayTab1;
    private RMI_ClientCallbackInterface client;


    public RMI_Server() {
        new RMI_Server(1099);
    }

    public RMI_Server(int port) {
        this.csvFILE = ("temps.csv");

        try {

            RMI_ServerInterface stub = (RMI_ServerInterface) UnicastRemoteObject.exportObject(this, 0);

            LocateRegistry.createRegistry(port);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("RMI_ServerInterface", stub);

            System.err.println("Server ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public String getTemperatureList(String day) throws RemoteException {
        this.query = day;
        return this.generateRcvData();
    }

    @Override
    public void registerForCallback(RMI_ClientCallbackInterface callbackClientObject) throws RemoteException {
        this.client = callbackClientObject;
        System.out.println("Client für Callback registriert.");
        doCallback();
    }

    private void doCallback() throws RemoteException {
        csvParser csvdate2 = new csvParser(this.csvFILE, this.query);
        System.out.println("Callback wird ausgeführt");

        RMI_ClientCallbackInterface cli = (RMI_ClientCallbackInterface) this.client;
        cli.notifyMe(this.dayTab1.compare(this.dayTab1));
    }

    @Override
    public void unregisterForCallback(RMI_ClientCallbackInterface callbackClientObject) throws RemoteException {
        this.client = null;
        System.out.println("Client für Callback entfernt.");
    }

    private String generateRcvData() {

        csvParser csvdate1 = new csvParser(this.csvFILE, this.query);

        if (!csvdate1.validate()) {
            return ("Call is not valid! Please send the date in this format: YYYY-MM-DD\n");
        }

        this.dayTab1 = new DayTabular(csvdate1);
        return dayTab1.getString();
    }

}