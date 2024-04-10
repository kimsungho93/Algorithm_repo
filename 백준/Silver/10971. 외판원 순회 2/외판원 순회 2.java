import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] cost;
    static int[][] dp;
    static final int MAX = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1));
    }

    static int tsp(int pos, int bitmask) {
        if (bitmask == (1 << N) - 1) {
            if (cost[pos][0] == 0) return MAX;
            return cost[pos][0];
        }
        if (dp[pos][bitmask] != -1) return dp[pos][bitmask];

        dp[pos][bitmask] = MAX;
        for (int nxt = 0; nxt < N; nxt++) {
            if ((bitmask & (1 << nxt)) == 0 && cost[pos][nxt] != 0) {
                int nextCost = tsp(nxt, bitmask | (1 << nxt)) + cost[pos][nxt];
                dp[pos][bitmask] = Math.min(dp[pos][bitmask], nextCost);
            }
        }
        return dp[pos][bitmask];
    }
}