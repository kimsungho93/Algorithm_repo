import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static final int ROW = 12;
    static final int COL = 6;
    static char[][] field = new char[ROW][COL];
    static boolean[][] visited = new boolean[ROW][COL];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < ROW; i++) {
            String line = br.readLine();
            for (int j = 0; j < COL; j++) {
                field[i][j] = line.charAt(j);
            }
        }

        int result = 0;
        while (true) {
            visited = new boolean[ROW][COL];
            boolean isPop = false;

            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (field[i][j] != '.' && !visited[i][j]) {
                        if (isPop(i, j)) {
                            isPop = true;
                        }
                    }
                }
            }

            if (!isPop) {
                break;
            }
            result++;
            drop();
        }
        System.out.println(result);
    }

    private static boolean isPop(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> popQueue = new ArrayDeque<>();
        char color = field[x][y];
        queue.offer(new int[]{x, y});
        popQueue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curPos[0] + dx[i];
                int ny = curPos[1] + dy[i];
                if (isPossible(nx, ny) && field[nx][ny] == color && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    popQueue.offer(new int[]{nx, ny});
                }
            }
        }

        if (popQueue.size() >= 4) {
            while (!popQueue.isEmpty()) {
                int[] pos = popQueue.poll();
                field[pos[0]][pos[1]] = '.';
            }
            return true;
        }
        return false;
    }


    private static void drop() {
        for (int i = 0; i < COL; i++) {
            for (int j = ROW - 1; j >= 0; j--) {
                if (field[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (field[k][i] != '.') {
                            field[j][i] = field[k][i];
                            field[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < ROW && ny >= 0 && ny < COL;
    }
}