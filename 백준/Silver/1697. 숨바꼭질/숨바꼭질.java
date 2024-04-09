import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100000; 
    static boolean[] visited = new boolean[MAX + 1]; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 
        System.out.println(bfs(N, K)); 
    }

    private static int bfs(int N, int K) {
        Queue<int[]> queue = new ArrayDeque<>(); 
        queue.offer(new int[]{N, 0}); 
        visited[N] = true; 

        while (!queue.isEmpty()) { 
            int[] current = queue.poll(); 
            int position = current[0]; 
            int time = current[1]; 

            if (position == K) { 
                return time;
            }
          
            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int nextPosition : nextPositions) { 
                if (nextPosition >= 0 && nextPosition <= MAX && !visited[nextPosition]) { 
                    visited[nextPosition] = true; 
                    queue.offer(new int[]{nextPosition, time + 1}); 
                }
            }
        }
        return -1; 
    }
}