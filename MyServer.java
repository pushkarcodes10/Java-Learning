import java.net.*;
import java.io.*;
import java.util.*;
class MyServer
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter Port No. of My Server");
int p=sc.nextInt();
try{
System.out.println("Starting Server at Port No."+p);
ServerSocket ss=new ServerSocket(p);
System.out.println("Server is active and waiting for connection at Port No."+ss.getLocalPort());
Socket s=ss.accept();
System.out.println("Server is connected to client having Address"+s.getRemoteSocketAddress()+ " using port no. "+s.getPort());
s.close();
}catch(Exception o)
{
System.out.println(o);
}
}
}