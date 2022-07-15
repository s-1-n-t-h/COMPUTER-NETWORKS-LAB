package SAW;
import java.io.*;
import java.net.*;
import java.util.*;
public class SAWClient {
    static Socket s;
    static BufferedReader br;
    static OutputStreamWriter os;
    static PrintWriter out;
    static int n;

    public static void main(String[] args) throws Exception{
        s = new Socket("localhost",6363);
        Scanner sc = new Scanner(System.in);
        System.out.println("Client Started..");
        System.out.println("Enter No of Frames: ");
        
        n = Integer.parseInt(sc.nextLine());

        int i = 1, frameNo = 0;
        os = new OutputStreamWriter(s.getOutputStream());
        out = new PrintWriter(os);

        out.println(n);
        out.flush();
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        while( i <= n){
            int cf = frameNo;
            System.out.println("Sending frame : "+(cf%2));
            out.println(cf%2);
            out.flush();
            System.out.println("Recived Ack "+br.readLine());
            i++; frameNo++;
        }
    }
}
