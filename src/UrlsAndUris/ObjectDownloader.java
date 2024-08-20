package UrlsAndUris;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ObjectDownloader {
    public static void main(String[] args) {
        String fileURL = "https://picsum.photos/id/237/200/300";
        String saveFilePath = "image.jpg";

        try {
            downloadFile(fileURL, saveFilePath);
            System.out.println("File downloaded successfully.");
        } catch (IOException e) {
            System.err.println("Error downloading the file: " + e.getMessage());
        }
    }

    public static void downloadFile(String fileURL, String saveFilePath) throws IOException {
        // Create a URL object
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        // Set request method to GET
        httpConn.setRequestMethod("GET");

        // Get the input stream from the HTTP connection
        try (InputStream inputStream = new BufferedInputStream(httpConn.getInputStream());
             FileOutputStream fileOutputStream = new FileOutputStream(saveFilePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } finally {
            httpConn.disconnect();
        }
    }
}
