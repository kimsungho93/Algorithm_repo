import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashSet<String> notHeard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            notHeard.add(br.readLine());
        }

        TreeSet<String> result = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (notHeard.contains(name)) {
                result.add(name);
            }
        }

        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}