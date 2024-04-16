import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Edge(a, s));
            }

            int[] timeToInfect = dijkstra(graph, n, c);

            int count = 0;
            int lastTime = 0;
            for (int i = 1; i <= n; i++) {
                if (timeToInfect[i] != Integer.MAX_VALUE) {
                    count++;
                    if (lastTime < timeToInfect[i]) {
                        lastTime = timeToInfect[i];
                    }
                }
            }
            sb.append(count).append(" ").append(lastTime).append("\n");
        }
        System.out.print(sb);
    }

    private static int[] dijkstra(List<List<Edge>> graph, int n, int start) {
        int[] infectTime = new int[n + 1];
        Arrays.fill(infectTime, Integer.MAX_VALUE);
        infectTime[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.time > infectTime[current.to]) continue;

            for (Edge next : graph.get(current.to)) {
                if (infectTime[next.to] > infectTime[current.to] + next.time) {
                    infectTime[next.to] = infectTime[current.to] + next.time;
                    pq.offer(new Edge(next.to, infectTime[next.to]));
                }
            }
        }
        return infectTime;
    }
}

class Edge {
    int to, time;

    Edge(int to, int time) {
        this.to = to;
        this.time = time;
    }
}
