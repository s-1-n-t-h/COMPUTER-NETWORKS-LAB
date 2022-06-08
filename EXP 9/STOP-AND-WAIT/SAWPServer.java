package SAWP;

import java.net.*;
import java.util.*;
import java.io.*;

class SAWPServer {
    public static void main(String[] args) throws Exception {

        System.out.println("Server Starting...\n");

        // creating server socket (receiver)
        ServerSocket ss = new ServerSocket(6363);

        System.out.println("Server Started...\n");

        // creating socket for conneting to client
        Socket s = ss.accept(); // initialises socket as soon as client is connected
        System.out.println("Client connected to Server..\n");
        // Creating stream to send data through socket
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);

        // creating input stream to read data from socket
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // receiving data using for loop
        while(true){
            String dataString = br.readLine();
            if(dataString == null)
                break;
            String data = dataString.substring(0, dataString.length()-1);
            int frameNo = Integer.parseInt(dataString.substring(dataString.length()-1));
            System.out.println("\nReceived data: " + data + " for frame : " + frameNo);
            System.out.println("\nSending Acknowledgement for frame: "+(frameNo+1)%2);
            out.println(Integer.toString((frameNo+1) % 2));
            out.flush();
        }
    }
}
