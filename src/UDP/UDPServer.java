package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9876);
        byte[] receiveBuffer = new byte[1024];

        while (true) {
            DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + message);

            String response = "Hello, Client";
            byte[] responseData = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
        }
    }
}
