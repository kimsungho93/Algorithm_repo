import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0; 
        int pattern = 0;

        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                pattern++; 
                if (pattern >= N) { 
                    count++; 
                }
                i++; 
            } else {
                pattern = 0; 
            }
        }

        System.out.println(count); 
    }
}