package ClientSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams to communicate with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;

            while (true) {
                clientMessage = in.readLine();
                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client has left the chat.");
                    break;
                }
                System.out.println("Client: " + clientMessage);

                System.out.print("You: ");
                serverMessage = userInput.readLine();
                out.println(serverMessage);

                if (serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting chat.");
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
