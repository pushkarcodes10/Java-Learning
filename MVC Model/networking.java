import java.net.*;

// public class networking {
//     public static void main(String[] args) {
//         try {
//             InetAddress address = InetAddress.getByName("google.com");
//             System.out.println("Host Name: " + address.getHostName());
//             System.out.println("IP Address: " + address.getHostAddress());
//         } catch (UnknownHostException e) {
//             System.out.println("Host not found");
//         }
//     }
// }

public class networking {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:3000/");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        }
    }
}