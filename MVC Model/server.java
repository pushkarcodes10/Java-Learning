import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);

            System.out.println("Server is Waiting....");

            Socket socket = server.accept();

            System.out.println("Client Connected");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message = input.readLine();
            System.out.println("Client Says: " + message);

            output.println("Hello Client");

            socket.close();
            server.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}