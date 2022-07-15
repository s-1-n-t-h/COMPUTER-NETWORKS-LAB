package SAW;
import java.io.*;
import java.net.*;
import java.util.*;

public class SAWServer {
    static ServerSocket ss;
    static Socket s;
    static BufferedReader br;
    static OutputStreamWriter os;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        ss = new ServerSocket(6363);
        System.out.println("Server Started..");

        s = ss.accept();
        System.out.println("Client Connected..");
        int i = 1;
        os = new OutputStreamWriter(s.getOutputStream());
        out = new PrintWriter(os);
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        int n = Integer.parseInt(br.readLine());

        while (i <= n) {
            int cf = Integer.parseInt(br.readLine());
            System.out.println("Recived frame : " + (cf) % 2);
            out.println((cf+1)%2);
            out.flush();
            System.out.println("Sending Ack " + (cf + 1) % 2);
            i++;
        }
    }
}
