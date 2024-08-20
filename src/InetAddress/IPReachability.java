package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPReachability {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an IP address or domain name (or type 'exit' to quit):");

        while (true) {
            String input = scanner.nextLine().trim();

            // Exit condition
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                InetAddress address = InetAddress.getByName(input);
                testReachability(address);

            } catch (UnknownHostException e) {
                System.err.println(input + " is not a valid IP address or domain name.");
            }

            System.out.println("\nEnter another IP address or domain name (or type 'exit' to quit):");
        }

        scanner.close();
        System.out.println("Program terminated.");
    }

    private static void testReachability(InetAddress address) {
        try {
            boolean reachable = address.isReachable(5000); // Timeout set to 5000 ms (5 seconds)
            if (reachable) {
                System.out.println(address.getHostAddress() + " is reachable.");
            } else {
                System.out.println(address.getHostAddress() + " is not reachable.");
            }
        } catch (Exception e) {
            System.err.println("Error while trying to reach " + address.getHostAddress());
            e.printStackTrace();
        }
    }
}