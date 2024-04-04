import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        int[] sum = new int[N * (N + 1) / 2];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum[count++] = num[i] + num[j];
            }
        }

        Arrays.sort(sum, 0, count - 1);

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int target = num[i] - num[j];
                if (Arrays.binarySearch(sum, 0, count - 1, target) >= 0) {
                    answer = Math.max(answer, num[i]);
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
