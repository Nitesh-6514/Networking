import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;
public class ClientSocketBroadCasting2
{
	public static void main(String[] args ) throws IOException,ArrayIndexOutOfBoundsException
	{
		try
		{
			InetAddress group =InetAddress.getByName("224.25.55.55");
			MulticastSocket mc=new MulticastSocket(6666);
			mc.joinGroup(group);
			byte bt[]=new byte[1024];
			DatagramPacket dp=new DatagramPacket(bt,bt.length);
			mc.receive(dp);
			System.out.println(new String(bt));
			mc.close();
		}
		




		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
