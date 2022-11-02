import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ClientSale {
    private static final int PORT = 8989;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()))
        ) {
            Basket gson = Basket.loadFromJson(new File("sale.json"));
            Map<String, String> tsv = Basket.loadFromTsvFile(new File("categories.tsv"));
            gson.setCategories("другое");
            for (String key : tsv.keySet()) {
                String value = tsv.get(key);
                if (gson.getTitle().equals(key)) {
                    gson.setCategories(value);
                    break;
                }
            }
            out.println(gson);
            System.out.println(in.readLine());
        }
    }
}
