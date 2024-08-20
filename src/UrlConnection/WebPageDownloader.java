package UrlConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebPageDownloader {
    public static void main(String[] args) {
        String urlString = "https://mcqhall.com"; // Replace with the URL of the web page you want to download

        try {
            // Create a URL object from the string
            URL url = new URL(urlString);

            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();

            // Get the input stream from the URL connection
            InputStream inputStream = urlConnection.getInputStream();

            // Wrap the input stream in a BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            // Read and print each line from the input stream
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the reader and input stream
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
