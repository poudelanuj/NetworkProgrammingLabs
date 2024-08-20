package UrlsAndUris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UrlEncodedPostRequest {
    public static void main(String[] args) {
        String urlString = "https://example.com/api/submit";
        String urlParameters = "param1=value1&param2=value2";



        try {
            // Create URL object
            URL url = new URL(urlString);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to POST
            connection.setRequestMethod("POST");

            // Set request headers
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.length()));
            connection.setDoOutput(true); // Indicates POST method

            // Write data to the request body
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = urlParameters.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

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
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response: " + response.toString());

            // Disconnect the connection
            connection.disconnect();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
