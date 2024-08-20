package UrlsAndUris;

import java.net.URI;
import java.net.URISyntaxException;

public class URIRelativeResolver {
    public static void main(String[] args) {
        String baseUriString = "http://example.com/path/";
        String relativeUriString = "subpath/resource.html";

        try {
            // Create URI objects
            URI baseUri = new URI(baseUriString);
            URI relativeUri = new URI(relativeUriString);

            // Resolve the relative URI against the base URI
            URI resolvedUri = baseUri.resolve(relativeUri);

            // Print the resolved URI
            System.out.println("Base URI: " + baseUri);
            System.out.println("Relative URI: " + relativeUri);
            System.out.println("Resolved URI: " + resolvedUri);
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        }
    }
}
