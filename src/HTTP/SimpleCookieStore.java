package HTTP;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleCookieStore implements CookieStore {
    private List<HttpCookie> cookieJar;

    public SimpleCookieStore() {
        cookieJar = new ArrayList<>();
    }

    @Override
    public void add(URI uri, HttpCookie cookie) {
        cookieJar.add(cookie);
    }

    @Override
    public List<HttpCookie> get(URI uri) {
        List<HttpCookie> result = new ArrayList<>();
        for (HttpCookie cookie : cookieJar) {
            result.add(cookie);
            if (uri.getHost().endsWith(cookie.getDomain())) {
                result.add(cookie);
            }
        }
        return result;
    }

    @Override
    public List<HttpCookie> getCookies() {
        return Collections.unmodifiableList(cookieJar);
    }

    @Override
    public List<URI> getURIs() {
        List<URI> uris = new ArrayList<>();
        for (HttpCookie cookie : cookieJar) {
            try {
                uris.add(new URI(cookie.getDomain()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return uris;
    }

    @Override
    public boolean remove(URI uri, HttpCookie cookie) {
        return cookieJar.remove(cookie);
    }

    @Override
    public boolean removeAll() {
        cookieJar.clear();
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        SimpleCookieStore store = new SimpleCookieStore();
        URI uri = URI.create("http://example.com");
        HttpCookie cookie = new HttpCookie("name", "prateeeeeeek");

        HttpCookie newCookie = new HttpCookie("age", "3444444");
        cookie.setDomain("example.com");

        // Add cookie
        store.add(uri, cookie);
        store.add(uri, newCookie);
        System.out.println("Added cookie: " + cookie);

        // Read cookies
        List<HttpCookie> cookies = store.get(uri);
        System.out.println("Read cookies: " + cookies);

        // Delete cookie
        store.remove(uri, cookie);
        System.out.println("Removed cookie: " + cookie);

        // Confirm removal
        cookies = store.get(uri);
        System.out.println("Cookies after removal: " + cookies);
    }
}
