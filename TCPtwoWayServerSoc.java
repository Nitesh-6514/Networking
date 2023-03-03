import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class TCPtwoWayClientSoc 
{
	public static void main(String args[]) throws IOException 
	{
		System.out.println("Server is waiting to client...");
		ServerSocket ss = new ServerSocket(1234);
		Socket s = ss.accept();
		System.out.println("Connection Established.");
		DataInputStream dIs = new DataInputStream(s.getInputStream());
		DataOutputStream dSOut = new DataOutputStream(s.getOutputStream()); 
		Scanner sc = new Scanner(System.in); 
		String Smsg = "";
		while(!Smsg.equals("stop")) 
		{
			String clientMessage = "";
			clientMessage = dIs.readUTF();
			System.out.print("Client Message: "+clientMessage);
			System.out.print("\nEnter the Message:"); 
			Smsg = sc.nextLine(); 
			dSOut.writeUTF(Smsg); 	
		}
		dIs.close();
		s.close();
		ss.close();
	}
}
