package NonBlockingIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NonBlockingIOExample {

    public static void main(String[] args) {
        try {
            // Create a non-blocking socket channel
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            // Attempt to connect to a server
            socketChannel.connect(new InetSocketAddress("localhost", 5000));

            // Wait until the connection is established
            while (!socketChannel.finishConnect()) {
                System.out.println("Connecting to the server...");
                // You can do other tasks here
            }

            System.out.println("Connected to the server!");

            // Create a buffer to hold the data
            ByteBuffer buffer = ByteBuffer.allocate(256);

            // Prepare a message to send
            String message = "Hello from the non-blocking client!";
            buffer.put(message.getBytes());

            // Flip the buffer to switch from writing to reading mode
            buffer.flip();

            // Write the data to the channel
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }

            // Clear the buffer for reading the response
            buffer.clear();

            // Read the server's response into the buffer
            int bytesRead = socketChannel.read(buffer);
            while (bytesRead == 0) {
                // You can perform other tasks while waiting for data
                bytesRead = socketChannel.read(buffer);
            }

            // Flip the buffer to read the server's response
            buffer.flip();
            byte[] responseBytes = new byte[buffer.remaining()];
            buffer.get(responseBytes);

            System.out.println("Received from server: " + new String(responseBytes));

            // Close the channel
            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
