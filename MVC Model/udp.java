import java.net.*;

public class udp {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            String messgae = "Hello Server";
            byte[] data = messgae.getBytes();
            InetAddress address = InetAddress.getByName("localhost");

            DatagramPacket packet = new DatagramPacket(data, data.length, address, 5000);
            socket.send(packet);
            System.out.println("Packet Sent");
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}