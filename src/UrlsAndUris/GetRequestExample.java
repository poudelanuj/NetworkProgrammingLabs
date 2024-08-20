package UrlsAndUris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequestExample {
    public static void main(String[] args) {
        String urlString = "https://api.mcqhall.com/api/v1/tags";

        try {
            // Create a URL object
            URL url = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Check if the request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the input stream
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Close the input stream
                in.close();

                // Print the response
                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }

            // Disconnect the connection
            connection.disconnect();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
