package SRP;
import java.io.*;
import java.lang.*;

class SRP{
    public static void main(String... args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter Window size: ");
        int window = Integer.parseInt(br.readLine());

        int seq = 0;
        for(int i = 0; i< window; i++){
            System.out.println("Frame "+seq+" has been transmtted");
            seq++;
        }
        while(true){
            System.out.print("\nEnter the Acknowledgement lost: ");
            int ack = Integer.parseInt(br.readLine());
            if(ack == window)
                break;
            else
                System.out.println("Frame "+ack+" is sent");

        }
    }
}