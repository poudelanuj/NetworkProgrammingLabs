package ClientSocket;

import java.io.*;
import java.net.Socket;

public class DictionaryDemo {

    public static  void main(String[] args){
        try {
            Socket socket = new Socket("dict.org",2628);
            socket.setSoTimeout(10000);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer.write("DEFINE fd-eng-ara hello\n");
            writer.flush();
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                System.out.println(line);
            }
            writer.write("quit\r\n");
            writer.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
