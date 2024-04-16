import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        int[] sensors = new int[N];
        int totalMinLength = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        if (K < N) {
            int[] gaps = new int[N - 1];
            Arrays.sort(sensors);
            for (int i = 0; i < sensors.length - 1; i++) {
                gaps[i] = sensors[i + 1] - sensors[i];
                totalMinLength += gaps[i];
            }
            Arrays.sort(gaps);

            for (int i = 0; i < K - 1; i++) {
                if (i <= gaps.length - 1) {
                    totalMinLength -= gaps[gaps.length - 1 - i];
                }
            }
        }
        System.out.println(totalMinLength);
    }
}
