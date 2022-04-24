import java.io.*;

public class FISE {

    public static void main(String... args) throws IOException {
        //try{
            FileInputStream fin = new FileInputStream("C:/Users/YASH/Downloads/FOSE.txt");
            int i = fin.read();
            System.out.println((char)i);
        //}
        //catch(Exception e)
        /*{
            System.out.println(e);
        }*/
    }

}
