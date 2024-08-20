package HTTP;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ClassDemo {

    public static void main(String[] args) {
        try{
            URL url = new URL("https://api.mcqhall.com/api/v1/tags");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection() ;
            connection.setRequestProperty("Accept", "application/json");
            connection.getDoInput();
            String contentType =  connection.getContentType();
            System.out.println("Content type is: "+ contentType);
            int encodingIndex = contentType.indexOf("charset=");
            System.out.println("The index is: "+ encodingIndex);
            if(encodingIndex != -1){
                String encoding = contentType.substring(encodingIndex + "charset=".length());
                System.out.println("The encoding is: "+ encoding);
            }
        }catch (MalformedURLException e ){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
