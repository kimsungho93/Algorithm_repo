import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] grid;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        Shark shark = null;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
                if (grid[i][j] == 9) {
                    shark = new Shark(i, j);
                    grid[i][j] = 0;
                }
            }
        }

        int totalTime = 0;
        while (true) {
            int time = moveAndEat(shark);
            if (time == -1) break;
            totalTime += time;
        }

        System.out.println(totalTime);
    }

    private static int moveAndEat(Shark shark) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> eatable = new ArrayDeque<>();
        queue.add(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1], dist = current[2];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && grid[nx][ny] <= shark.size) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                    if (grid[nx][ny] > 0 && grid[nx][ny] < shark.size && dist + 1 <= minDist) {
                        minDist = dist + 1;
                        eatable.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        if (eatable.isEmpty()) return -1;

        int eatX = N, eatY = N, eatDist = Integer.MAX_VALUE;
        for (int[] fish : eatable) {
            if (fish[2] == minDist && (fish[0] < eatX || (fish[0] == eatX && fish[1] < eatY))) {
                eatX = fish[0];
                eatY = fish[1];
                eatDist = fish[2];
            }
        }

        shark.eatCount++;
        if (shark.eatCount == shark.size) {
            shark.size++;
            shark.eatCount = 0;
        }
        grid[eatX][eatY] = 0;
        shark.x = eatX;
        shark.y = eatY;
        return eatDist;
    }
}

class Shark {
    int x, y, size = 2, eatCount = 0;

    Shark(int x, int y) {
        this.x = x;
        this.y = y;
    }
}