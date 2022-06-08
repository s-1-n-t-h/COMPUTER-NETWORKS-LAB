package ARP;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class ARPServer {
    public static void main(String[] args) throws Exception{
        String ipArray[] = {"165.165.80.80","165.165.79.1"};
        String macArray[] = {"6A:08:AA:C2","8A:BC:E3:FA"};
        ServerSocket ss = new ServerSocket(6363);
        System.out.println("Server is running...");

        System.out.println("Waiting for client to connect...");
        Socket s = ss.accept();

        System.out.println("Client connected...");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String ip = br.readLine();
        System.out.println("IP Address received: "+ip);
        
        // for sending MAC address to client
        // Verify if any ip matches with available ipArray
        for( int i = 0; i<ipArray.length; i++){
            if(ip.equals(ipArray[i])){
                OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
                PrintWriter out = new PrintWriter(os);
                out.println(macArray[i]);
                out.flush();
                break;
            }
        }
        s.close();
        ss.close();

    }
}
