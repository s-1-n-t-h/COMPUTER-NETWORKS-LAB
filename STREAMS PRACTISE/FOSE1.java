import java.io.*;

public class FOSE1 {

    public static void main(String... args) {
        try {
            FileOutputStream fout = new FileOutputStream("C:/Users/YASH/Downloads/FOSE1.txt");
            String s = "Welcome to My Reality!";
            byte[] b = s.getBytes();
            fout.write(b);
            fout.close();
            System.out.println("sucess...");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
