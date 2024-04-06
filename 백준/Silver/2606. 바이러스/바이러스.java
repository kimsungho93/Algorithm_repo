import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexSize = Integer.parseInt(br.readLine());
        int edgeSize = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vertexSize + 1];

        int[][] graph = new int[vertexSize + 1][vertexSize + 1];
        for (int i = 0; i < edgeSize; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int from = Integer.parseInt(edgeInfo[0]);
            int to = Integer.parseInt(edgeInfo[1]);

            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        dfs(graph, visited, 1);

        int result = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                if (i == 1) {
                    continue;
                }
                result++;
            }
        }
        System.out.println(result);

    }

    private static void dfs(int[][] graph, boolean[] visited, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int i = 1; i < graph.length; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }

    }
}


