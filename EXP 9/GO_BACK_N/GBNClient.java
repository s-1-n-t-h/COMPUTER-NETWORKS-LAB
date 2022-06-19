package GBN;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class GBNClient {

    static Socket s ;
    static OutputStreamWriter os;
    static PrintWriter out ;
    static BufferedReader br;


    static void sendFrame(int s,int ws){
        int i = s;
        while(i<=ws){
            System.out.println("Sending Frame " + i);
            out.println(i);
            out.flush();
            i++;
        }
    }
    public static void main(String... args) throws Exception{
        s = new Socket("localhost", 6363);
        os = new OutputStreamWriter(s.getOutputStream());
        out = new PrintWriter(os);
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size Of Window: ");
        int ws = Integer.parseInt(sc.nextLine());
        // sending window size to server
        out.println(ws);
        out.flush();
        sendFrame(1, ws);
        // for re transmitting
        System.out.print("\nEnter the last ack recived: ");
        sendFrame(Integer.parseInt(sc.nextLine()),ws);

    }
}
