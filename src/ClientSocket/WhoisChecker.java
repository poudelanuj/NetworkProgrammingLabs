package ClientSocket;

import java.io.*;
import java.net.Socket;

public class WhoisChecker {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("whois.internic.net", 43);
            socket.setSoTimeout(100000);
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream);
            writer.write("sajal.com\r\n");
            writer.flush();
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
            reader.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
