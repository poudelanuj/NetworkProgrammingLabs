package ServerSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTimeServerSocket {

    public static void main(String[] args){

        try {
            ServerSocket serverSocket = new ServerSocket(2030);
            Socket connection = serverSocket.accept();
            OutputStream outputStream = connection.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream,"ASCII");
            Date date = new Date();
            writer.write(date.toString()+ "\r\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
