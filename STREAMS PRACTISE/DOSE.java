import java.io.*;
public class DOSE {
    public static void main(String[] args) throws IOException
    {
        FileOutputStream fout = new FileOutputStream("C:/Users/YASH/Downloads/DOSE.txt");
        DataOutputStream dout = new DataOutputStream(fout);

        dout.write(89);
        dout.flush();
        dout.close();
        fout.close();

        System.out.println("success..");
    }
}
