package ServerSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TodayDateServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2060);
            while (true){
                Socket socket = serverSocket.accept();
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "ASCII");
                Date date = new Date();
                writer.write(date.toString()+"\n");
                writer.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
