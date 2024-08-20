package Multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) throws Exception {
        MulticastSocket socket = new MulticastSocket(4446); // Bind to port 4446
        InetAddress group = InetAddress.getByName("230.0.0.1"); // Join multicast group
        socket.joinGroup(group);

        byte[] buffer = new byte[1000];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet); // Receive data
        System.out.println("Received: " + new String(packet.getData()));

        socket.leaveGroup(group);
        socket.close();
    }
}
