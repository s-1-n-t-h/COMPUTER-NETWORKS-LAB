package GBN;
import java.io.*;
class GO_BACK_N {
    public static void main(String... args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nPlease enter the Window size: ");
        int window = Integer.parseInt(br.readLine());

        boolean flag = true;
        int sent = 0;

        while(flag){
            for(int i = 0;i < window; i++){
                System.out.println("Frame "+sent+" has been transmitted.");
                sent++;
                if(sent==window){
                    break;
                }
            }

            System.out.print("\nPlease enter the last Acknowledgement received.");
            int ack = Integer.parseInt(br.readLine());
            if ( ack == window)
                flag = false;
            else
                sent = ack;

        }
    }
}