/**각 요소 arr[i]에 대해, 그 앞의 모든 요소 arr[j] (0 <= j < i) 중에서 arr[j]보다 작은 값이 있다면,
 * dp[i] 값을 갱신한다. dp[i]는 dp[j] + 1로 설정됩니다.
 * 즉, arr[i]를 끝으로 하는 가장 긴 감소하는 부분 수열의 길이는
 * arr[j]를 끝으로 하는 가장 긴 감소하는 부분 수열의 길이에 1을 더한 값
 모든 dp 배열의 요소 중 최댓값을 구합니다. 이 값이 가장 긴 감소하는 부분 수열의 길이가 된다.
 *  14584kb	152ms
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int N;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        IntStream.range(0, 3).forEach(i -> dp[0][i] = cost[0][i]);

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }
        
        int min = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
        System.out.println(min);
    }
}