import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long M = Long.parseLong(input[1]);

        long[] time = new long[N];
        for (int i = 0; i < N; i++) {
            time[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(time);

        long left = 1;
        long maxTime = time[N - 1];
        long right = (maxTime > Long.MAX_VALUE / M) ? Long.MAX_VALUE : maxTime * M;
        long result = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += mid / time[i];
                if (sum >= M) {
                    break;
                }
            }

            if (sum >= M) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
