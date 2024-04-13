import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 500;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] lines = new int[MAX + 1];
        int[] dp = new int[MAX + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[a] = b;
        }

        int cnt = 0;
        Arrays.fill(dp, 1);

        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j < i; j++) {
                if (lines[j] != 0 && lines[i] != 0 && lines[j] < lines[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    cnt = Math.max(cnt, dp[i]);
                }
            }
        }

        System.out.println(N - cnt);
    }
}
