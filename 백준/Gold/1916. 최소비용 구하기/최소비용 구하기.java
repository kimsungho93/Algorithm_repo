import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startCity] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startCity, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.city == endCity) {
                break;
            }

            if (current.cost > dist[current.city]) {
                continue;
            }

            for (Node next : graph.get(current.city)) {
                if (dist[next.city] > dist[current.city] + next.cost) {
                    dist[next.city] = dist[current.city] + next.cost;
                    pq.offer(new Node(next.city, dist[next.city]));
                }
            }
        }

        System.out.println(dist[endCity]);
    }
}

     class Node implements Comparable<Node> {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
