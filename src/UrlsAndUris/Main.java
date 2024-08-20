package UrlsAndUris;

import java.net.URLEncoder;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("URL+"+ URLEncoder.encode("https://nef.com.np/new /class?new = 0"));
    }
}