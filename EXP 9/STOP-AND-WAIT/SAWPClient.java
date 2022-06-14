package SAWP;

import java.net.*;
import java.util.*;
import java.io.*;

class SAWPClient{
    public static void main(String[] args) throws Exception{

        System.out.println("\nClient is Connecting...");
        // creating client socket (sender)
        Socket s = new Socket("localhost", 6363);
        System.out.println("\nClient Connected to server...");

        // Creating stream to send data through socket
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);

        // creating input stream to read data from socket
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // variables of use
        int numberOfFramesToBeSend;
        Scanner sc = new Scanner(System.in);
        // varible used for storing data for frames
        String[] data = new String[10];

        // no of frames to be sent
        System.out.print("\nNo of Frames: ");
        numberOfFramesToBeSend = Integer.parseInt(sc.nextLine());

        // run a for loop to take data as input
        for( int i = 0 ; i < numberOfFramesToBeSend; i++){

            System.out.print("\nEnter data for frame "+(i%2)+" : ");
            data[i] = sc.nextLine();
        }
        
        System.out.println("-------------------------------------");
        // using do while loop for sending data and verifying for acknowledgement
        int frameNo = 1;
        int i = 0;
        int ackNo;
        do{
            frameNo--;
            System.out.println("\nSending data: "+data[i]+" for frame :" +frameNo);
            out.println(data[i]+Integer.toString(frameNo)); // sends data into stream
            out.flush(); // forcefull pushes data drom stream 
            i++; frameNo++;
            Thread.sleep(500);
            ackNo = Integer.parseInt(br.readLine());
            System.out.println("\nReceived Acknowledgement for frame: "+ackNo);
        }while((frameNo == ackNo ) && i<numberOfFramesToBeSend);
       

    }
}