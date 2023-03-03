import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ClientSocetUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
            String str="Hello";
            InetAddress add = InetAddress.getByName("localhost");
            DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(),add,3002);
            ds.send(dp);
            byte bt[] = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(bt,bt.length);
            

	    ds.receive(dp1);
            String str1 = new String(dp1.getData()).trim();
            System.out.println("Server message:"+str1);
        ds.close();

    }
}
