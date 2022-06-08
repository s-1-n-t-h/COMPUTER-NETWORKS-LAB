package CRC;
import java.util.Scanner;

class CRC {

    String cdw;
    String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < b.length(); i++) {
            if (a.charAt(i) == b.charAt(i))
                result.append('0');
            else
                result.append('1');

        }
        return result.toString();
    }

    String crc(String message, String key) {
        int pick = key.length();
        String tmp = message.substring(0, key.length());
        String zeroes = "";
        while (pick < message.length()) {
            if (tmp.charAt(0) == '1'){
                tmp = this.xor(key, tmp) + message.charAt(pick);
            }
            else{
                for (int i = 1; i <= key.length(); i++)
                    zeroes += "0";
                tmp = this.xor(zeroes, tmp) + message.charAt(pick);
            }
    
            pick++;
        }
        if (tmp.charAt(0) == '1') {
            tmp = this.xor(key, tmp);
        } else {
            for (int i = 1; i <= key.length(); i++)
                zeroes += "0";
            tmp = this.xor(zeroes, tmp);
        }
        return tmp;

    }

    void encodedData(String data, String key) {
        int l_key = key.length();
        String appended_zeroes = "";
        for (int i = 1; i < l_key; i++)
            appended_zeroes += "0";
        
        String append_data = data + appended_zeroes;
        String remainder = this.crc(append_data, key);
        String code_word = data + remainder;
        System.out.println("Code word: " + code_word);
        System.out.println("Remainder: " + remainder);
        this.cdw = code_word;
    }

    void reciverSide(String data,String key){

        int l_key = key.length();
        String remainder = this.crc(data, key);
        String appended_zeroes = "";
        for (int i = 1; i < l_key; i++)
            appended_zeroes += "0";
        if( remainder.equals(appended_zeroes ))
        {
            System.out.println("Data is Correct");
        }
        else
        {
            System.out.println("Data is Incorrect");
        }
        System.out.println("Code word: " + data);
        System.out.println("Remainder: " + remainder);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the data: ");
        String data = sc.nextLine();
        System.out.print("Enter the generator polynomial: ");
        String key = sc.nextLine();
        System.out.println("------------");
        System.out.println("Encoding Sender Side: ");
        CRC c = new CRC();
        c.encodedData(data, key);
        System.out.println("------------");
        System.out.println("Decoding Receiver Side:");
        c.reciverSide(c.cdw, key);
    }
}