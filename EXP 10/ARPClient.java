import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStreamReader;

public class ARPClient {
    public static void main(String... args)throws Exception{
        Socket s = new Socket("localhost",6363);
       // for sending IP to ARP server
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);

        System.out.println("Enter the IP Address:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();
        out.println(ip);
        out.flush();        

        // for receiving MAC address from ARP server
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String mac = in.readLine();
        System.out.println("MAC Address of the IP: "+ip+" is: "+mac);
        s.close();
    }
}
