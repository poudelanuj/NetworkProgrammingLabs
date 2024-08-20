package SecuredSocket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SecuredServer {
    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(9999);

            System.out.println("SSL Server started on port 9999");

            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;
            while (true) {
                // Check for incoming messages
                if (in.ready()) {
                    inputLine = in.readLine();
                    if (inputLine == null || inputLine.equalsIgnoreCase("bye")) {
                        break;
                    }
                    System.out.println(inputLine);
                }

                // Check for user input to send
                if (userInput.ready()) {
                    String message = userInput.readLine();
                    out.write(message);
                    if (message.equalsIgnoreCase("bye")) {
                        break;
                    }
                }
            }

            clientSocket.close();
            sslServerSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}