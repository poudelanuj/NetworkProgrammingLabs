package SecuredSocket;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;

public class SecuredClient {
    public static void main(String[] args) {
        try {
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 9999);

            System.out.println("Connected to SSL Server");

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            Writer out = new PrintWriter(sslSocket.getOutputStream(), true);
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

            sslSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}