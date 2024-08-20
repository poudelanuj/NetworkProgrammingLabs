package UrlConnection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class URLLastModified {
    public static void main(String[] args) {
        String urlString = "https://mcqhall.com"; // Replace with the URL of the web page

        try {
            // Create a URL object from the string
            URL url = new URL(urlString);

            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();

            // Get the last modified time from the header
            long lastModified = urlConnection.getLastModified();

            if (lastModified == 0) {
                System.out.println("The Last-Modified header is not available.");
            } else {
                // Convert the last modified time to a readable format
                Date date = new Date(lastModified);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("The URL was last modified on: " + formatter.format(date));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
