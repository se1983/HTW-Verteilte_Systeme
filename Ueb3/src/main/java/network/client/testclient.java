package network.client;


import network.server.TestRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 * Created by sebsch on 11.11.16.
 */
public class testclient{
    public static void main(String args[]) {

    try {
        String name = "TESTRMI";
        Registry registry = LocateRegistry.getRegistry(args[0]);
        TestRMI comp = (TestRMI) registry.lookup(name);
        //Pi task = new Pi(Integer.parseInt(args[1]));
        //BigDecimal pi = comp.executeTask(task);

        String hellostring = comp.sayHello("foobar");
        System.out.println(hellostring);
    } catch (Exception e) {
        System.err.println("ComputePi exception:");
        e.printStackTrace();
    }
}
}
