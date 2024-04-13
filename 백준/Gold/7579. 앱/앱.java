import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N+1];
        int[] cost = new int[N+1];
        int[] dp = new int[10001];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            for(int j=10000; j>=cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-cost[i]] + memory[i]);
            }
        }

        int result = 0;
        while(dp[result] < M) {
            result++;
        }

        System.out.println(result);
    }
}