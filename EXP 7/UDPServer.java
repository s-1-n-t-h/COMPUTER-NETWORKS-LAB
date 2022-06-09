package UDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String... args) throws Exception{
        System.out.println("\nServer is starting...");
        DatagramSocket ds = new DatagramSocket(6363);
        byte[] b1 = new byte[1024];
        System.out.println("\nServer Started...");
        DatagramPacket dp = new DatagramPacket(b1, b1.length);
        ds.receive(dp);
        System.out.println("\nData Received from Client");

        String str = new String(dp.getData());
        int num = Integer.parseInt(str.trim());
        int result = num*num;

        // sending result back to client 
        System.out.println("\nSending data: "+result+" from server to client..");
        // convert data into byte array
        byte[] b2 = Integer.toString(result).getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        // create datagram packet for sending through port
        DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort());
        ds.send(dp1);
    }
}
