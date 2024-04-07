import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (map[nextX][nextY] == 0 && !visited[nextX][nextY][current.wall]) {
                        visited[nextX][nextY][current.wall] = true;
                        queue.offer(new Point(nextX, nextY, current.distance + 1, current.wall));
                    } else if (map[nextX][nextY] == 1 && current.wall == 0) {
                        visited[nextX][nextY][1] = true;
                        queue.offer(new Point(nextX, nextY, current.distance + 1, 1));
                    }
                }
            }
        }
        return -1;
    }
}

class Point {
    int x, y, distance, wall;

    public Point(int x, int y, int distance, int wall) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.wall = wall;
    }
}
