import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8989);) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream());) {
                    out.println(MaxCategory.maxCategory(in));
                }
            }
        } catch (IOException e) {
            System.out.println("Внимание! Сервер не запущен!");
            e.printStackTrace();
        }
    }
}
