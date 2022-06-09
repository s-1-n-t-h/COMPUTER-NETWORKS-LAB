
package DNS;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

class DNSServer {
    public static void main(String... args) throws Exception{

        String[] domainNames = {"www.amazon.in","www.apple.com","www.flipkart.com","wwww.google.com"};
        String[] ipAddress = {"52.95.120.67","17.253.144.10","163.53.78.110","173.194.198.139"};

        ServerSocket ss = new ServerSocket(6363);
        System.out.println("Server is running...");

        System.out.println("Waiting for client to connect...");
        Socket s = ss.accept();

        System.out.println("Client connected...");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String domainName = br.readLine();
        System.out.println("Domain Name received: " + domainName);
        
        for( int i = 0; i<domainNames.length; i++){
            if(domainName.equals(domainNames[i])){
                OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
                PrintWriter out = new PrintWriter(os);
                out.println(ipAddress[i]);
                out.flush();
                break;
            }
        }
        s.close();
        ss.close();

        
    }
}