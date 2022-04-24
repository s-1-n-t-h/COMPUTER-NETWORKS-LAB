import java.io.*;

class BOSE {
    public static void main(String[] args) throws IOException {

        FileOutputStream fout = new FileOutputStream("C:/Users/YASH/Downloads/BOSE.txt");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        String s = "Welcome to The Reality!!";

        byte[] b = s.getBytes();
        bout.write(b);
        bout.flush();
        bout.close();
        fout.close();
        System.out.println("success");
    }
}