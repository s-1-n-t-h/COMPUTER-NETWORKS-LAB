
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStreamReader;
public class DNSClient {
    public static void main(String... args) throws Exception{
        // use socket to send dat gram packets
        Socket s = new Socket("localhost", 6363);
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);

        System.out.println("Enter the Domain Name:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String domainName = br.readLine();
        out.println(domainName);
        out.flush();
       // for receiving IP address from DNS server
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String ip = in.readLine();
        System.out.println("IP Address of the Domain: "+domainName+" is: "+ip);
        s.close();
    }
}