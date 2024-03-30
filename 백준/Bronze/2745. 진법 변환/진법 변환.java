import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        String N = input[0]; 
        int B = Integer.parseInt(input[1]); 

        long decimal = Long.parseLong(N, B);
        System.out.println(decimal);
    }
}