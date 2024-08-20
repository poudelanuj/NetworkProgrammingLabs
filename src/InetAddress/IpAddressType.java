package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class IpAddressType {
    public static void main(String[] args) {
        // List of IP addresses to test
        List<String> ipAddresses = Arrays.asList(
                "192.168.1.1",   // IPv4
                "8.8.8.8",       // IPv4
                "2001:0db8:85a3:0000:0000:8a2e:0370:7334", // IPv6
                "2607:f8b0:4004:809::200e",                // IPv6
                "127.0.0.1",     // IPv4 (loopback)
                "::1"            // IPv6 (loopback)
        );

        for (String ipAddress : ipAddresses) {
            try {
                InetAddress address = InetAddress.getByName(ipAddress);
                if (address instanceof java.net.Inet4Address) {
                    System.out.println(ipAddress + " is an IPv4 address.");
                } else if (address instanceof java.net.Inet6Address) {
                    System.out.println(ipAddress + " is an IPv6 address.");
                } else {
                    System.out.println(ipAddress + " is of unknown type.");
                }
            } catch (UnknownHostException e) {
                System.err.println("Invalid IP address: " + ipAddress);
                e.printStackTrace();
            }
        }
    }
}
