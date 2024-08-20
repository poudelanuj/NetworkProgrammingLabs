package ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateTimeClientSocket {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2030);
            socket.sendUrgentData(10000);
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
            reader.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
