package network.server;

import calc.TemperatureCalculator;
import data.csvParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;



class TCPServer extends Thread implements ServerInterface{

    private Socket connectionSocket;
    private String csvFILE;

    private String STOPWORD = ";";

    public String PID;

    public TCPServer(Socket connectionSocket) throws IOException {

        this.connectionSocket = connectionSocket;

        csvFILE = "temps.csv";

        this.PID = "[ " + this.getPID() + "  >>> " + this.getId() + " ]";
    }

    public String getPID() throws IOException {
        byte[] bo = new byte[100];
        String[] cmd = {"bash", "-c", "echo $PPID"};
        Process p = Runtime.getRuntime().exec(cmd);
        p.getInputStream().read(bo);
        return new String(bo).trim();
    }

    @Override
    public void run() {

        try {
            System.out.println(this.PID + "Serving thread started.");
            this.handleQuery();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleQuery() throws IOException {
        String query = this.rcv(connectionSocket);

        String header = "Serverthread: " + this.PID + "\n";
        String answer = header + this.generateRcvData(query) + this.STOPWORD;


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.send(answer, connectionSocket);
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
        System.out.println(this.PID + "Received: " + clientSentence);

        return (clientSentence);
    }

    @Override
    public void send(String msg, Socket connectionSocket) throws IOException {
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        outToClient.writeBytes(msg);
    }


}