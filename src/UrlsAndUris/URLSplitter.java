package UrlsAndUris;

import java.net.MalformedURLException;
import java.net.URL;

public class URLSplitter {
    public static void main(String[] args) {
        String urlString = "https://www.example.com:8080/path/to/resource?query=param#section";

        try {
            URL url = new URL(urlString);

            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort(); // returns -1 if the port is not set
            String path = url.getPath();
            String query = url.getQuery();
            String fragment = url.getRef();

            System.out.println("URL: " + urlString);
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + host);
            System.out.println("Port: " + (port != -1 ? port : "default"));
            System.out.println("Path: " + path);
            System.out.println("Query: " + query);
            System.out.println("Fragment: " + fragment);

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        }
    }
}
