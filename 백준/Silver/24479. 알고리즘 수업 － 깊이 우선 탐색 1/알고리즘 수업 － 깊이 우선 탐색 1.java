import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] order;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertexSize; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        for (ArrayList<Integer> adjacent : graph) {
            Collections.sort(adjacent);
        }

        boolean[] visited = new boolean[vertexSize + 1];
        order = new int[vertexSize + 1];
        dfs(graph, visited, startVertex);

        for (int i = 1; i <= vertexSize; i++) {
            System.out.println(order[i]);
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int startVertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                order[currentVertex] = count++;

                ArrayList<Integer> adjacent = graph.get(currentVertex);
                for (int i = adjacent.size() - 1; i >= 0; i--) {
                    int vertex = adjacent.get(i);
                    if (!visited[vertex]) {
                        stack.push(vertex);
                    }
                }
            }
        }
    }
}
