import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(l, startX, startY, endX, endY));
        }
    }

    private static int bfs(int l, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[l][l];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.x == endX && current.y == endY) {
                return current.moveCount;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Position(nextX, nextY, current.moveCount + 1));
                }
            }
        }
        return -1;
    }
}

class Position {
    int x, y;
    int moveCount;

    public Position(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }
}