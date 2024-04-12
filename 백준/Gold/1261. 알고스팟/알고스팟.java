import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[][] cost;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        cost = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = line[j].charAt(0) - '0';
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs(0, 0, N, M));
    }

    private static int bfs(int startX, int startY, int N, int M) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, maze[startX][startY]));
        cost[startX][startY] = maze[startX][startY];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int curCost = cur.cost;

            if (x == N - 1 && y == M - 1) {
                return curCost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int newCost = curCost + maze[nx][ny];
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean canMove(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
