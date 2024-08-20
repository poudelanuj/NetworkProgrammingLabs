package HTTP;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;

public class NoAIPolicy implements CookiePolicy {
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        if (uri.getAuthority().toLowerCase().endsWith(".ai") ||
                cookie.getDomain().toLowerCase().endsWith(".ai")) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        // Example usage
        try{
            NoAIPolicy policy = new NoAIPolicy();
            URI testUri = new URI("https://example.gov");
            HttpCookie testCookie = new HttpCookie("name", "value");
            testCookie.setDomain("example.gov");
            System.out.println(policy.shouldAccept(testUri, testCookie)); // Should print false
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
