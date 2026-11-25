import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to Server");
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            output.println("Hello Server");

            String response = input.readLine();
            System.out.println("Server Says: " + response);
            socket.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}