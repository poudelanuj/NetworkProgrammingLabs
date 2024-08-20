package UrlsAndUris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ProxySelectorDemo {

    public static void main(String[] args) throws IOException {
        // Set the default ProxySelector
        ProxySelector.setDefault(new CustomProxySelector());

        // Real website URL
        URL url = new URL("https://www.wikipedia.org");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Print connection details
        System.out.println("Proxy: " + connection.usingProxy());
        System.out.println("Response Code: " + connection.getResponseCode());

        // Read response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }

    // Custom ProxySelector implementation
    public static class CustomProxySelector extends ProxySelector {

        @Override
        public List<Proxy> select(URI uri) {
            List<Proxy> proxyList = new ArrayList<>();

            // Specify the proxy for HTTP/HTTPS connections
            if ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme())) {
                Proxy httpProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080));
                proxyList.add(httpProxy);
            } else {
                // Direct connection for other types of connections
                proxyList.add(Proxy.NO_PROXY);
            }

            return proxyList;
        }

        @Override
        public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
            System.out.println("Proxy connection failed: " + uri);
        }
    }


}