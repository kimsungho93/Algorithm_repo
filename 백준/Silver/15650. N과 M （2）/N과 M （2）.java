import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] arr; 
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 0, 1); 
        System.out.println(sb.toString());
    }

    private static void dfs(int N, int M, int depth, int start) {
        if (depth == M) { 
            for (int val : arr) {
                sb.append(val).append(' '); 
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(N, M, depth + 1, i + 1);
        }
    }
}
