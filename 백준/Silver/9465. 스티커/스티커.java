import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine().trim());  // 스티커 열의 수
            String[] top = br.readLine().trim().split(" ");
            String[] bottom = br.readLine().trim().split(" ");

            if (n == 1) {
                int result = Math.max(Integer.parseInt(top[0]), Integer.parseInt(bottom[0]));
                sb.append(result).append("\n");
                continue;
            }

            int[] dp0 = new int[n];
            int[] dp1 = new int[n];
            int[] dp2 = new int[n];

            // 초기화
            dp1[0] = Integer.parseInt(top[0]);
            dp2[0] = Integer.parseInt(bottom[0]);

            for (int i = 1; i < n; i++) {
                int topScore = Integer.parseInt(top[i]);
                int bottomScore = Integer.parseInt(bottom[i]);

                dp0[i] = Math.max(dp0[i-1], Math.max(dp1[i-1], dp2[i-1]));
                dp1[i] = Math.max(dp0[i-1], dp2[i-1]) + topScore;
                dp2[i] = Math.max(dp0[i-1], dp1[i-1]) + bottomScore;
            }

            int maxResult = Math.max(dp0[n-1], Math.max(dp1[n-1], dp2[n-1]));
            sb.append(maxResult).append("\n");
        }

        System.out.print(sb);
    }
}
