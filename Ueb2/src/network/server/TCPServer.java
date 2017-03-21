package network.server;

import calc.TemperatureCalculator;
import data.csvParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


class TCPServer implements ServerInterface {

    private ServerSocket welcomeSocket;
    private String csvFILE;

    public TCPServer() throws IOException {
        welcomeSocket = new ServerSocket(6789);
        csvFILE = new String("temps.csv");
    }

    @Override
    public void run() throws IOException {
        while (true) {
            Socket connectionSocket = connectionSocket = welcomeSocket.accept();

            String query = this.rcv(connectionSocket);
            String answer = this.generateRcvData(query);
            this.send(answer, connectionSocket);
            //connectionSocket.close();
        }
    }

    private String generateRcvData(String query) {
        csvParser csvdate = new csvParser(this.csvFILE, query);

        if (!csvdate.validate()) {
            return ("Call is not valid! Please send the date in this format: YYYY-MM-DD\n");
        }

        ArrayList<String[]> data = csvdate.getTempAtTime();
        TemperatureCalculator calc = new TemperatureCalculator(csvdate.getTemperatures());

        data.add(new String[]{"max", Integer.toString(calc.max())});
        data.add(new String[]{"min", Integer.toString(calc.min())});
        data.add(new String[]{"avg", Double.toString(calc.avg())});

        String rcvData = "";
        for (String[] line : data) {
            rcvData += String.join(":\t", line) + "\n";
        }

        return (rcvData);
    }

    @Override
    public String rcv(Socket connectionSocket) throws IOException {
        BufferedReader inFromClient =
                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

        String clientSentence = inFromClient.readLine();
        System.out.println("Received: " + clientSentence);

        return (clientSentence);
    }

    @Override
    public void send(String msg, Socket connectionSocket) throws IOException {
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        outToClient.writeBytes(msg);
    }
}