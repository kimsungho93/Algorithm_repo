import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        HashMap<String, Integer> before = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String carNumber = br.readLine(); 
            before.put(carNumber, i);
        }

        String[] after = new String[N]; 
        for (int i = 0; i < N; i++) {
            after[i] = br.readLine();
        }

        int count = 0; 
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (before.get(after[i]) > before.get(after[j])) {
                    count++; 
                    break; 
                }
            }
        }
        System.out.println(count);
    }
}