import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int GOAL = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] board = new int[GOAL + 1];
        for (int i = 1; i <= GOAL; i++) {
            board[i] = i;
        }

        int ladderCount = Integer.parseInt(st.nextToken());
        int snakeCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < ladderCount + snakeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }
        System.out.println(bfs(board));
    }

    private static int bfs(int[] board) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[GOAL + 1];
        queue.offer(1);
        visited[1] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == GOAL) {
                    return count;
                }

                for (int j = 1; j <= 6; j++) {
                    int next = current + j;
                    if (next <= GOAL && !visited[next]) {
                        visited[next] = true;
                        queue.offer(board[next]);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}