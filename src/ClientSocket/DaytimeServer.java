package ClientSocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaytimeServer {

    private static final int PORT = 5000;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Daytime Server is running...");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    threadPool.execute(new DaytimeService(clientSocket));
                } catch (IOException e) {
                    System.err.println("Connection error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private static class DaytimeService implements Runnable {
        private final Socket clientSocket;

        public DaytimeService(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                out.println("Current date and time: " + currentTime);
            } catch (IOException e) {
                System.err.println("Service error: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Failed to close client socket: " + e.getMessage());
                }
            }
        }
    }
}