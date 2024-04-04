import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        TreeSet<Integer> sumSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sumSet.add(num[i] + num[j]);
            }
        }

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int target = num[i] - num[j];
                if (sumSet.contains(target)) {
                    answer = num[i];
                    break; 
                }
            }
            if (answer > 0) break; 
        }


        System.out.println(answer);
    }
}
