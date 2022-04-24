import java.io.*;

class BISE {
    public static void main(String[] args) throws IOException {

        FileInputStream fin = new FileInputStream("C:/Users/YASH/Downloads/BOSE.txt");
        BufferedInputStream bin = new BufferedInputStream(fin);
        int i;
        while((i=bin.read()) != -1)
        {
            System.out.print((char)i);
        }
        
        bin.close();
        fin.close();
      
    }
}