import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = heights[i + 1] - heights[i];
        }

        Arrays.sort(diff);

        int min = 0;
        for (int i = 0; i < N - K; i++) {
            min += diff[i];
        }
        System.out.println(min);
    }
}