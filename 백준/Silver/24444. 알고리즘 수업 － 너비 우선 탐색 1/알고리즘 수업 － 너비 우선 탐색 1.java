import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] order;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        graph = new ArrayList[vertexSize + 1];
        order = new int[vertexSize + 1];
        visited = new boolean[vertexSize + 1];

        for (int i = 1; i <= vertexSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph[vertex1].add(vertex2);
            graph[vertex2].add(vertex1);
        }

        for (int i = 1; i <= vertexSize; i++) {
            Collections.sort(graph[i]);
        }

        bfs(startVertex);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= vertexSize; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;
        int count = 1;
        order[startVertex] = count;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph[currentVertex]) {
                if (!visited[nextVertex]) {
                    queue.add(nextVertex);
                    visited[nextVertex] = true;
                    order[nextVertex] = ++count;
                }
            }
        }
    }
}
