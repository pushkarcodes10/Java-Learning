import java.net.*;
import java.io.*;
import java.util.*;
class MyClient
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter address of Server and Port No.");
String host=sc.next();
int p=sc.nextInt();
try{
System.out.println("Trying to connect with server having address "+host + " at port no. "+p);
Socket s=new Socket(host,p);
System.out.println("Successfully connected with server using addeess "+s.getRemoteSocketAddress() + " at port no. "+s.getPort());
s.close();
}catch(Exception o)
{
System.out.println(o);
}
}
}