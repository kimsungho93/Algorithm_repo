import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    static int N;
    static int[][] costs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        costs = new int[N][N];
        dp = new int[1 << N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(tsp(1, 0));
    }

    private static int tsp(int visited, int last) {
        if (visited == (1 << N) - 1) {
            return costs[last][0] == 0 ? INF : costs[last][0];
        }
        
        if (dp[visited][last] != -1) {
            return dp[visited][last];
        }
        
        dp[visited][last] = INF;
        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && costs[last][next] != 0) {
                int cost = costs[last][next] + tsp(visited | (1 << next), next);
                dp[visited][last] = Math.min(dp[visited][last], cost);
            }
        }
        return dp[visited][last];
    }
}