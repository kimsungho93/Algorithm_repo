import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adjList; // 인접 리스트
    static boolean[] visited; // 방문 여부 확인 배열
    static int[] order; // 각 정점의 방문 순서
    static int count = 1; // 방문 순서 카운트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // 인접 리스트 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int node) {
        visited[node] = true;
        order[node] = count++;
        for (int nextNode : adjList[node]) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}
