package InetAddress;

import java.net.InetAddress;

public class HostName {
    public static void main(String[] args) {
        try {
// Retrieve the InetAddress of a hostname
            InetAddress address = InetAddress.getByName("www.example.com");
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("Host Address: " + address.getHostAddress());
            System.out.println("Canonical Host Name: " + address.getCanonicalHostName());
// Retrieve all IP addresses associated with a hostname
            InetAddress[] addresses = InetAddress.getAllByName("www.example.com");
            for (InetAddress addr : addresses) {
                System.out.println("Address: " + addr);
            }
// Retrieve the local host address
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local Host Address: " + localAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}