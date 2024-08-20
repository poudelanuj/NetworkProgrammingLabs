package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DetectSpam {

    // DNSBL server
    private static final String DNSBL_SERVER = "zen.spamhaus.org";

    public static boolean isSpam(String domainOrIp) {
        try {
            InetAddress address = InetAddress.getByName(domainOrIp);
            byte[] quad = address.getAddress();
            String query = DNSBL_SERVER;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test domains/IPs
        String[] testInputs = {
                "8.8.8.8",                // Google's public DNS
                "spamdomain.com",
                "192.168.1.1",
                "phishingdomain.org",
                "198.51.100.2"
        };

        for (String input : testInputs) {
            if (isSpam(input)) {
                System.out.println(input + " is considered spam.");
            } else {
                System.out.println(input + " is not spam.");
            }
        }
    }
}
