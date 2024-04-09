import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] box;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        box = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int days = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    
                    if (isPossible(nx, ny)) {
                        box[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            days++;
        }
        if (isRipeAll()) {
            return days;
        } else {
            return -1;
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < R && ny >= 0 && ny < C && box[nx][ny] == 0;
    }
    
    private static boolean isRipeAll() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}