package InetAddress;

import java.net.HttpCookie;
import java.util.List;

public class HTTPCookieExample {

    public static void main(String[] args) {
        // Create a new cookie with the name "username" and value "john_doe"
        HttpCookie cookie = new HttpCookie("username", "john_doe");

        // Set various properties of the cookie
        cookie.setDomain(".example.com");
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hour
        cookie.setSecure(true);
        cookie.setComment("This cookie stores the username.");
        cookie.setCommentURL("http://example.com/cookie-info");
        cookie.setDiscard(true);
        cookie.setPortlist("80,443");
        cookie.setVersion(1);

        // Print out various properties of the cookie
        System.out.println("Cookie: " + cookie);
        System.out.println("Name: " + cookie.getName());
        System.out.println("Value: " + cookie.getValue());
        System.out.println("Domain: " + cookie.getDomain());
        System.out.println("Path: " + cookie.getPath());
        System.out.println("Max Age: " + cookie.getMaxAge());
        System.out.println("Secure: " + cookie.getSecure());
        System.out.println("Comment: " + cookie.getComment());
        System.out.println("Comment URL: " + cookie.getCommentURL());
        System.out.println("Discard: " + cookie.getDiscard());
        System.out.println("Portlist: " + cookie.getPortlist());
        System.out.println("Version: " + cookie.getVersion());

        // Check if the cookie has expired
        System.out.println("Has Expired: " + cookie.hasExpired());

        // Clone the cookie
        HttpCookie clonedCookie = (HttpCookie) cookie.clone();
        System.out.println("Cloned Cookie: " + clonedCookie);

        // Parse a "Set-Cookie" header string
        String header = "username=john_doe; Domain=.example.com; Path=/; Max-Age=3600; Secure; Version=1";
        List<HttpCookie> cookies = HttpCookie.parse(header);
        for (HttpCookie parsedCookie : cookies) {
            System.out.println("Parsed Cookie: " + parsedCookie);
        }

        // Compare cookies for equality
        System.out.println("Cookies equal: " + cookie.equals(clonedCookie));

        // Hash code of the cookie
        System.out.println("Cookie Hash Code: " + cookie.hashCode());
    }
}
