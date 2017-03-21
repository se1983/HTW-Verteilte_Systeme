package network.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class TCPClient {

    private String sentence;
    private Socket clientSocket;
    private BufferedReader instream;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;

    public TCPClient() throws IOException {
        clientSocket = new Socket("localhost", 6789);
        this.cliUI();
    }

    private void cliUI() throws IOException {
        Boolean done = false;
        Scanner reader;

        reader = new Scanner(System.in);
        System.out.print("Bitte Datum Eingeben [YYYY-MM-DD] \n\t>>> ");
        String userinput = reader.next();

        this.send(userinput);
        System.out.println(this.rcv());
    }


    private void send(String msg) throws IOException {
        instream =
                new BufferedReader(new InputStreamReader(
                        new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8))));
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        sentence = instream.readLine();
        outToServer.writeBytes(sentence + '\n');
    }


    private String StringIn(BufferedReader buffIn) throws IOException {
        int c;
        StringBuilder response = new StringBuilder();

        while ((c = buffIn.read()) != -1) {
            response.append((char) c);
        }
        return response.toString();
    }


    private String rcv() throws IOException {
        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        return StringIn(inFromServer);
    }
}