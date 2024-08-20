package ServerSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NewPhoneNumberServer {

    private static Map<String, String> phoneNumbers;
    static {
        Map <String, String> newNumbers = new HashMap<>();
        newNumbers.put("anuj", "9849933272");
        newNumbers.put("prabin", "9840684253");
        newNumbers.put("jeena", "9866290037");
        newNumbers.put("anush", "9826732804");
        newNumbers.put("suman", "9818471629");

        phoneNumbers = Collections.unmodifiableMap(newNumbers);
    }

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(3040);
            while(true) {
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "ASCII");
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    if(line.startsWith("PN")){
                        String[] commandList = line.split(" ");
                        if(commandList.length==2){
                            String name = commandList[1];
                            if(phoneNumbers.containsKey(name)){
                                writer.write("Name: "+ name + " Phone Number: "+ phoneNumbers.get(name)+"\r\n");
                            }else{
                                writer.write("Name not found \r\n");
                            }
                            writer.flush();
                        }else{
                            writer.write("Command format is \"PN name\"\r\n");
                            writer.flush();
                        }
                    }else{
                        writer.write("Sorry, you put wrong command\r\n");
                        writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


// PN anuj