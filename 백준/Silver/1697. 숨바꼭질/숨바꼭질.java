import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100000;
    static boolean[] visited = new boolean[MAX + 1];
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        queue.offer(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            if (position == K) {
                return time;
            }

            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int nextPosition : nextPositions) {
                if (isPossible(nextPosition)) {
                    queue.offer(new int[]{nextPosition, time + 1});
                    visited[nextPosition] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isPossible(int nextPosition) {
        return nextPosition >= 0 && nextPosition <= MAX && !visited[nextPosition];
    }
}