import java.io.*;

public class FOSE {

    public static void main(String... args)
    {
        try{
            FileOutputStream  fout = new FileOutputStream("C:/Users/YASH/Downloads/FOSE.txt");
            fout.write(121);
            fout.close();
            System.out.println("sucess...");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
