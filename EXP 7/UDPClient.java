package UDP;
import java.io.*;
import java.net.*;

class UDPClient{
    static DatagramSocket ds;
    static DatagramPacket dp;
    static BufferedReader br;
    static InetAddress ia;
    static byte[] b = new byte[1024];
    static int cport = 6363, sport = 6464;

    public static void main(String... args) throws Exception{
        ds = new DatagramSocket(cport);
        dp = new DatagramPacket(b,b.length);
        br = new BufferedReader(new InputStreamReader(System.in));
        ia = InetAddress.getLocalHost();
        System.out.println("Client is Running ... Type'STOP' to Quit");
        while(true){
            String str = new String(br.readLine());
            b = str.getBytes();
            if( str.equals("STOP"))
            {
                System.out.println("Terminated...");
                ds.send(new DatagramPacket(b,b.length,ia,sport));
                break;
            }
            ds.send(new DatagramPacket(b, b.length,ia,sport));
            ds.receive(dp);
            str = new String(dp.getData());
            System.out.println("Server: "+str);
        }
    }

}