package UrlConnection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class PrintURLConnectionURL {
    public static void main(String[] args) {
        String urlString = "http://nesfield.com.np"; // The URL you want to connect to

        try {
            // Create a URL object from the string
            URL url = new URL(urlString);

            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();

            // Print the URL of the URLConnection
            System.out.println("URL of the URLConnection: " + urlConnection.getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
