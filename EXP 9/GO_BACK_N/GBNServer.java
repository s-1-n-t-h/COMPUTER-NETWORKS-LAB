package GBN;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class GBNServer {
    
    static ServerSocket ss;
    static Socket s;
    static OutputStreamWriter os ;
    static PrintWriter out;
    static BufferedReader br;

    static void receiveFrame(int ws) throws Exception{
        int  i = 1;
        while(i<= ws){
            int fno = Integer.parseInt(br.readLine());
            System.out.println("Recived Frame "+fno);
            System.out.println("Sending Ack for frame "+(fno+1));
            i++;
        }
    }
    public static void main(String... args) throws Exception{
        System.out.println("Server Starting...");
        ss = new ServerSocket(6363);
        s = ss.accept();
        System.out.println("Client Connected...");
        os = new OutputStreamWriter(s.getOutputStream());
        out = new PrintWriter(os);
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        receiveFrame(Integer.parseInt(br.readLine()));
    }
}
