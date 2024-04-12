import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1}; 
    static int[] dy = {1, -1, 0, 0}; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder(); 
        int problemCnt = 1; 

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            int[][] map = new int[N][N];
            int[][] cost = new int[N][N]; 

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE; 
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(); 
            pq.offer(new Node(0, 0, map[0][0])); 
            cost[0][0] = map[0][0]; 

            while (!pq.isEmpty()) {
                Node cur = pq.poll(); 

                if (cur.x == N - 1 && cur.y == N - 1) { 
                    sb.append("Problem ").append(problemCnt++).append(": ").append(cur.cost).append("\n");
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (canMove(nx, N, ny)) { 
                        int newCost = cur.cost + map[nx][ny];
                        if (cost[nx][ny] > newCost) { 
                            cost[nx][ny] = newCost;
                            pq.offer(new Node(nx, ny, newCost)); 
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean canMove(int nx, int N, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}

class Node implements Comparable<Node> {
    int x, y, cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
