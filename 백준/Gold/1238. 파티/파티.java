import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int X;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> reverseAdj = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            reverseAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(from).add(new Edge(to, weight));
            reverseAdj.get(to).add(new Edge(from, weight));
        }

        int[] fromParty = dijkstra(N, X, adj);
        int[] toParty = dijkstra(N, X, reverseAdj);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, fromParty[i] + toParty[i]);
        }
        System.out.println(max);
    }

    private static int[] dijkstra(int n, int src, ArrayList<ArrayList<Edge>> adj) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(src, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curNode = cur.to;
            int curDist = cur.weight;

            if (curDist > dist[curNode]) continue;

            for (Edge e : adj.get(curNode)) {
                if (dist[e.to] > dist[curNode] + e.weight) {
                    dist[e.to] = dist[curNode] + e.weight;
                    pq.offer(new Edge(e.to, dist[e.to]));
                }
            }
        }
        return dist;
    }
}

class Edge implements Comparable<Edge> {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
