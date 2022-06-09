package STUFFING;
import java.util.*;
class dataFrame {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the data: ");
        BitStuffing bs = new BitStuffing(sc.nextLine());
        StringBuilder stuffedString = bs.stuff();
        System.out.print("\nStuffed Data: "+stuffedString);

        Frame f = new Frame(stuffedString);
        stuffedString = f.DataFrame();
        System.out.println("\nData Frame: "+stuffedString);

        BitDeStuffing bds = new BitDeStuffing(stuffedString);
        bds.destuff();


    }
}
class Frame{
    String s = "01111110";
    StringBuilder sb1 = new StringBuilder(s);

    Frame(StringBuilder sb)
    {
        sb1.append(sb.append(sb1));
    }
    StringBuilder DataFrame()
    {
        return sb1;
    }

}
class BitDeStuffing
{
    StringBuilder sb;
    BitDeStuffing(StringBuilder s)
    {
        sb = new StringBuilder(s.substring(8, s.length() - 8));
    }
    boolean check(String s)
    {
        String match = "11111";
        if (s.equals(match))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    void destuff()
    {
        int length = sb.length();
        int i=0;
        while(i+5<=length)
        {
            String s = sb.substring(i,i+5);
            if(check(s)){
                sb.deleteCharAt(i+5);
                i = i+6;
            }
            else
            {
                i++;
            }
        }
        System.out.println("\nFrame After De-Stuffing at Reciever: "+sb);
    }

}

class BitStuffing {
    StringBuilder sb;

    BitStuffing(String s) {
        sb = new StringBuilder(s);
    }

    boolean check(String s) {
        String match = "11111";
        if (s.equals(match)) {
            return true;
        } else {
            return false;
        }
    }

    StringBuilder stuff() {
        int length = sb.length();
        int i = 0;
        while (i + 5 <= length) {
            String s = sb.substring(i, i + 5);
            if (check(s)) {
                sb.insert(i + 5, "0");
                i = i + 6;
            } else {
                i++;
            }
        }
        return sb;
    }

}