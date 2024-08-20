package ClientSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            System.out.println("Connected to the server");

            // Create input and output streams to communicate with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;

            while (true) {
                System.out.print("You: ");
                clientMessage = userInput.readLine();
                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting chat.");
                    break;
                }

                serverMessage = in.readLine();
                if (serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Server has left the chat.");
                    break;
                }
                System.out.println("Server: " + serverMessage);
            }

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
