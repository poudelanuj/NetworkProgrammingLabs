package UDP;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class NonBlockingUDPServer {
    public static void main(String[] args) throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9876));
        channel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            buffer.clear();
            InetSocketAddress clientAddress = (InetSocketAddress) channel.receive(buffer);
            if (clientAddress != null) {
                buffer.flip();
                System.out.println("Received: " + new String(buffer.array(), 0, buffer.limit()));
                buffer.flip();
                channel.send(buffer, clientAddress);
            }
        }
    }
}
