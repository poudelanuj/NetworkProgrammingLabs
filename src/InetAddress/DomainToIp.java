package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DomainToIp {
    public static void main(String[] args) {
        // Array of domain names to resolve
        String[] domains = {
                "example.com",
                "google.com",
                "facebook.com",
                "microsoft.com",
                "openai.com"
        };

        for (String domain : domains) {
            try {
                // Get all IP addresses associated with the domain
                InetAddress[] addresses = InetAddress.getAllByName(domain);
                System.out.println("Domain: " + domain);

                // Print both IPv4 and IPv6 addresses
                for (InetAddress address : addresses) {
                    System.out.println("IP Address: " + address.getHostAddress());
                }
                System.out.println(); // Blank line for better readability
            } catch (UnknownHostException e) {
                System.err.println("Unable to resolve domain: " + domain);
                e.printStackTrace();
            }
        }
    }
}
