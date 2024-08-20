package HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpHeaderExample {
    public static void main(String[] args) {
        try {
            // URL to connect to
            URL url = new URL("https://api.mcqhall.com/api/v1/tags");

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Add request headers
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            // Print request headers
            System.out.println("Request Headers:");
            Map<String, List<String>> requestHeaders = connection.getRequestProperties();
            for (Map.Entry<String, List<String>> entry : requestHeaders.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("\nResponse Code: " + responseCode);
            System.out.println("\nResponse Message: " + connection.getResponseMessage());

            // Print response headers
            System.out.println("Response Headers:");
            Map<String, List<String>> responseHeaders = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Read response body
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            connection.disconnect();
            // Print response body
            System.out.println("\nResponse Body:");
            System.out.println(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
