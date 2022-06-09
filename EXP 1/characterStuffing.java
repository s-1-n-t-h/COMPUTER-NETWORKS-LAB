package STUFFING;
import java.util.*;
class characterStuffing {
    String std;
    // considering 'E' as escape Sequence and 'F' as flag byte

    void charStuff(String data){
        data = "F"+data+"F";
        int length = data.length();
        for(int i = 1; i < length-1; i++){ // exclude first and last flag indexes
           if( data.charAt(i) == 'F' || data.charAt(i) == 'E'){
               data = data.substring(0, i) + "E" + data.substring(i);
               i++; // for avoiding pointing to same byte again
               length = data.length();
           }
        }
        System.out.println("\nStuffed Data: "+data);
        System.out.println("\nSending message...");
        this.std  = data;
    }
    
    void charDeStuff(){
        System.out.println("\nReceived message: "+this.std);
        String data = this.std.substring(1,this.std.length()-1);
        int length = data.length();
        for (int i = 0; i < length - 1; i++) { // exclude first and last flag indexes
            if ( data.charAt(i) == 'E') {
                String verify = data.substring(i, i+2);
                if( verify.equals("EF") || verify.equals("EE")){
                    data = data.substring(0, i) + data.substring(i+1);
                }
                length = data.length();
            }
        }
        System.out.println("\nData after de-stuffing: "+data);    
    }
    public static void main(String[] args) throws Exception{
        characterStuffing cs = new characterStuffing();
        System.out.print("\nData: ");
        Scanner sc = new Scanner(System.in);

        String data = sc.nextLine();

        cs.charStuff(data);
        cs.charDeStuff();
    }
    
}
