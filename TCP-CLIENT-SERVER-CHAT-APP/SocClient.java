import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class SocClient {
    public static void main(String... args) throws Exception{
        String ip = "localhost";
        int port = 6363;
        Socket s = new Socket(ip,port);

        String str = "Yaswanth";
        // converts data into stream format
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream()); //mention from where u want to send the data
        // to actually send the data use print writer class
        PrintWriter out = new PrintWriter(os);
        out.println(str);
        out.flush();
         // forcefully aends data even if 512 bytes buffer is not filled
        // for 2 way communication
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String nickName = br.readLine();
        System.out.println("Server says: " + nickName);
    }   
}
 