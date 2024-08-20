package ServerSocket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

public class DaytimeThread extends  Thread{
    private Socket connection;

    public DaytimeThread(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try{
            Writer out = new OutputStreamWriter
                    (connection.getOutputStream());
            Date now = new Date();
            out.write(now.toString() +"\r\n");
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        super.run();
    }
}
