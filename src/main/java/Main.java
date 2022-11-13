import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8989);) {
            MaxCategory maxCategory = new MaxCategory();
            maxCategory.readTsvFile();
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream());) {
                    maxCategory.readJsonFile(in.readLine());
                    maxCategory.saveJsonFile();
                    out.println(maxCategory.getOutJsonFile());
                }
            }
        } catch (IOException e) {
            System.out.println("Внимание! Сервер не запущен!");
            e.printStackTrace();
        }
    }
}
