import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>(); 
        int count = 0;

        for (int i = 0; i < N; i++) {
            String record = br.readLine();
            if ("ENTER".equals(record)) {
                set.clear(); 
            } else {
                if (!set.contains(record)) { 
                    count++;
                }
                set.add(record);
            }
        }

        System.out.println(count);
    }
}
