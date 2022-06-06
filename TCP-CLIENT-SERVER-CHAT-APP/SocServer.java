import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class SocServer {
    public static void main(String... args) throws Exception{
        System.out.println("Server is started: ");
        ServerSocket ss = new ServerSocket(6363);

        System.out.println("Server is waiting for client request");
        Socket s = ss.accept();

        System.out.println("Client is connected");
      
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = br.readLine();
        System.out.println("Client sent: " + str);
        // for 2 way communication
        String nickName = str.substring(0,4);
        // since it's tcp again we need to require to connect until client closes his socket (connection oriented)
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);
        out.println(nickName);
        out.flush();

    }
}
