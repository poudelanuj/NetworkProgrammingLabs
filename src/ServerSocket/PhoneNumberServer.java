package ServerSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberServer {

    private static   Map<String, String> phoneNumbers = new HashMap<String, String>();
    static {
        Map<String, String> aMap = new HashMap<>();
        aMap.put("anuj", "9849933272");
        aMap.put("anup", "9849933273");
        aMap.put("anuk", "9849933274");
        phoneNumbers = Collections.unmodifiableMap(aMap);
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2050);
            Socket connection = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            OutputStream outputStream = connection.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream,"ASCII");
            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                if(phoneNumbers.containsKey(line)){
                    System.out.println(line);
                    writer.write("Name: "+ line + " phoneNumber: " +phoneNumbers.get(line)+"\n");
                }else{
                    writer.write("Name: "+ line + " phoneNumber not found \n ");
                }
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
