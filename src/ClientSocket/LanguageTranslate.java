package ClientSocket;

import java.io.*;
import java.net.Socket;

public class LanguageTranslate {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("dict.org", 2628);
            System.out.println("The socket string is:"+ socket.toString());
            socket.setSoTimeout(100000);
            System.out.println("The socket inet address: "+ socket.getInetAddress().getHostAddress());
            System.out.println("Port:"+ socket.getPort());
            System.out.println("LocalAddress: "+ socket.getLocalAddress().getHostAddress());
            System.out.println("LocalPort: "+ socket.getLocalPort());
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream);
            writer.write("DEFINE fd-eng-jpn Beautiful\r\n");
            writer.flush();
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
