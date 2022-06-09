package STUFFING;
import java.util.*;

class bitStuffing{
    String std;
    void bitStuff(String s){
        String flag = "01111110";
        for(int i = 0; i <= s.length()-6; i++){
            if(s.charAt(i) == '1'){
                if( s.substring(i,i+5).equals("11111")){
                    s = s.substring(0,i+5) + "0" + s.substring(i+5); 
                    i+=6;
                }
            }
        }
        s = flag+s+flag;
        System.out.println("\nStuffed Data: "+s);
        System.out.println("\nSending message...");
        this.std = s;
    }

    void bitDeStuff(){
        System.out.println("\nData Received: "+this.std);
        String data = this.std.substring(8,this.std.length()-8);
        
        for(int i = 0; i <= data.length()-6; i++){
            if (data.charAt(i) == '1') {
                if (data.substring(i, i + 6).equals("111110")) {
                    data = data.substring(0,i+5) + data.substring(i+6);
                    i+=6;
                }
            }
        }  
        System.out.println("\nde-stuffed data: "+data);   
    }
    public static void main(String... args){
        // 10000001 is flag byte
        Scanner sc = new Scanner(System.in);
        System.out.print("\nData: ");
        String data = sc.nextLine();

        bitStuffing bs = new bitStuffing();
        bs.bitStuff(data);
        bs.bitDeStuff();
    }
}