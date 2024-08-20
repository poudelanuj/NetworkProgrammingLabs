package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalMachineInfo {
    public static void main(String[] args) {
        try {
            // Get the local host address and name
            InetAddress localHost = InetAddress.getLocalHost();

            // Display the host name and IP address
            System.out.println("Host Name: " + localHost.getHostName());
            System.out.println("IP Address: " + localHost.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Unable to get the local host information.");
            e.printStackTrace();
        }
    }
}
