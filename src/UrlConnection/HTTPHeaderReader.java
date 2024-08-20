package UrlConnection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HTTPHeaderReader {
    public static void main(String[] args) {
        String urlString = "https://mcqhall.com"; // Replace with the URL of the web page

        try {
            // Create a URL object from the string
            URL url = new URL(urlString);

            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();

            // Get the headers from the URLConnection
            Map<String, List<String>> headers = urlConnection.getHeaderFields();

            // Iterate over the headers and print each key-value pair
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue();

                // Print the header name and its corresponding values
                if (headerName != null) {
                    System.out.println(headerName + ": " + String.join(", ", headerValues));
                } else {
                    // This is the status line (HTTP/1.1 200 OK)
                    System.out.println("Status: " + String.join(", ", headerValues));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
