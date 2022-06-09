package UDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
class UDPClient{
    public static void main(String[] args) throws Exception{
       
        // data is sent using datagram socket
        DatagramSocket ds = new DatagramSocket();
        
        int i = 16;
  
        // data should in bytes 
        String data = Integer.toString(i);
        byte[] b = data.getBytes();

        // for getting host address
        InetAddress ia = InetAddress.getLocalHost();
        // pass data, data length, IP address, port number using datagram packet
        DatagramPacket dp = new DatagramPacket(b, b.length, ia, 6363);
        System.out.println("\nData Sent: "+i);
        ds.send(dp); // pass the packet through socket

        /// receive data from server
        byte[] b1 = new byte[1024];
        // creating objct for copying the data from packet
        DatagramPacket dp1 = new DatagramPacket(b1,b1.length);
        ds.receive(dp1);// receive the packet from server

        System.out.println("\nData received from server: " + new String(dp1.getData()));

    }
}