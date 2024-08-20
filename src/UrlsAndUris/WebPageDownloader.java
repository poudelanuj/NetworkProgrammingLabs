package UrlsAndUris;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebPageDownloader {
    public static void main(String[] args) {

        String webAddress = "https://nesfield.edu.np";
        String outputFileName = "nesfield.html";

        try {
            // Create a URL object
            URL url = new URL(webAddress);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method
            connection.setRequestMethod("GET");

            // Get the input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Create a writer to write to the output file
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.write(inputLine);
                out.newLine();
            }

            // Close the streams
            in.close();
            out.close();

            System.out.println("Web page downloaded successfully.");
        } catch (Exception e) {
            System.err.println("Error downloading the web page: " + e.getMessage());
        }
    }
}
