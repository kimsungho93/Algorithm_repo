import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start, end;
    static ArrayList<Bridge>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int left = 1;
        int right = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Bridge(to, weight));
            graph[to].add(new Bridge(from, weight));
            right = Math.max(right, weight);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (bfs(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean bfs(int weight) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) {
                return true;
            }

            for (Bridge next : graph[current]) {
                if (!visited[next.to] && next.weight >= weight) {
                    visited[next.to] = true;
                    queue.offer(next.to);
                }
            }
        }
        return false;
    }

    static class Bridge {
        int to;
        int weight;

        public Bridge(int destination, int weight) {
            this.to = destination;
            this.weight = weight;
        }
    }
}

