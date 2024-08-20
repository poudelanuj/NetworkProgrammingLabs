package Multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) throws Exception {
        InetAddress group = InetAddress.getByName("230.0.0.1");
        MulticastSocket socket = new MulticastSocket();

        String message = "Hello, multicast group!";
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), group, 4446);
        socket.send(packet); // Send data to the group

        socket.close();
    }
}
