import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" "); 
                String type = input[1]; 
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int value : map.values()) {
                result *= (value + 1); 
            }
            sb.append(result - 1).append('\n'); 
        }
        System.out.println(sb);
    }
}