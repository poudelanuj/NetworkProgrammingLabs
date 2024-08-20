package UrlsAndUris;

import java.net.URL;
import java.net.URLConnection;

public class SupportedProtocolChecker {
    public static void main(String[] args) {
        String[] protocols = {
                "http",
                "https",
                "ftp",
                "file",
                "jar",
                "mailto",
                "netdoc",
                "gopher",
                "nntp",
                "telnet",
                "ldap",
                "ldaps"
        };

        for (String protocol : protocols) {
            checkProtocolSupport(protocol);
        }
    }

    private static void checkProtocolSupport(String protocol) {
        try {
            URL url = new URL(protocol, "www.example.com", "/");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Protocol supported: " + protocol);
        } catch (Exception e) {
            System.out.println("Protocol not supported: " + protocol);
        }
    }
}
