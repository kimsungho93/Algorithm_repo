import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < T; i++) {
            String signal = br.readLine(); 
            if (signal.matches("(100+1+|01)+")) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}