import java.io.IOException;
import java.net.*;
public class ServerSocetUDP {
    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket(3002);
        System.out.println("Server is waiting");
            byte bt[] = new byte[1024];
            DatagramPacket dp= new DatagramPacket(bt,bt.length);
            ds.receive(dp);
            String str= new String(dp.getData(),0,dp.getLength());
            System.out.println("Client Message:"+str);
	    String str1="Hello";
            InetAddress add = dp.getAddress();
            DatagramPacket dp1= new DatagramPacket(str1.getBytes(),str.length(),add, dp.getPort());
            ds.send(dp1);
        ds.close();
    }
}
