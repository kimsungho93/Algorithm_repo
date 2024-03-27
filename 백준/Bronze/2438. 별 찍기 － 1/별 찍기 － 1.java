import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
        reader.close();
    }
}
