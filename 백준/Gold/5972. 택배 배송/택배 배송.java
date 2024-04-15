import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        int minFood = dijkstra(graph, N);
        System.out.println(minFood);
    }

    private static int dijkstra(List<Edge>[] graph, int N) {
        final int INF = Integer.MAX_VALUE;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        int[] dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }

        dist[1] = 0;

        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            for (Edge next : graph[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        return dist[N];
    }
}

class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
