package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        byte[] buffer = "Hello, Server".getBytes();

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, 9876);
        socket.send(packet);

        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket);

        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Server Response: " + response);
        socket.close();
    }
}
