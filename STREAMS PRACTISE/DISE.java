import java.io.*;

public class DISE {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("C:/Users/YASH/Downloads/DOSE.txt");
        DataInputStream din = new DataInputStream(fin);

        int i;
        while ((i = din.read()) != -1) {
            System.out.print((char) i);
        }

        din.close();
        fin.close();
    }
}
