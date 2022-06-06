import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {
    public static void main(String[] args) throws Exception{
        System.out.print("Enter a number: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt((br.readLine()));
        System.out.println("You entered: " + n);

    }
}
