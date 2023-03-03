import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;
public class ServerSocketBroadCasting
{
	public static void main(String[] args ) throws IOException
	{
		try
		{
			InetAddress group =InetAddress.getByName("224.25.55.55");
			MulticastSocket mc=new MulticastSocket();
			String msg="Hello!!!";
			DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.length(),group,6666);
			mc.send(dp);
			mc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
