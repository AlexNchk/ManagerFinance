import java.io.*;
import java.net.Socket;
import java.util.Map;

import static org.json.simple.JSONValue.parse;

public class ClientSale {
    private static final int PORT = 8989;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()))
        ) {
            out.println("sale.json");
            System.out.println(parse(new FileReader(in.readLine())).toString());
        }
    }
}
