import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class TCPtwoWayClientSoc 
{
	public static void main(String args[]) throws UnknownHostException, IOException 
	{
		System.out.println("Client has started..");
		Socket s = new Socket("localhost", 1234);
		DataOutputStream dOut = new DataOutputStream(s.getOutputStream());
		DataInputStream dCin = new DataInputStream(s.getInputStream()); 
		Scanner sc = new Scanner(System.in);
		String msg = "";
		while(!msg.equals("stop")) 
		{
			System.out.print("\nEnter the Message:");
			msg = sc.nextLine();
			dOut.writeUTF(msg);
			String serverMsg=""; 
			serverMsg = dCin.readUTF(); 
			System.out.print("Server Message: "+serverMsg); 
		}
		dOut.close(); 
		s.close();
}
}
