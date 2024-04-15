import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
    int x;
    int y;
    int time;

    public Virus(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int N, M;
    static int[][] map; 
    static ArrayList<Virus> virusList = new ArrayList<>();
    
    static Virus[] virus;

    static int empty = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virus = new Virus[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 

                if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j, 0));
                }

                if (map[i][j] == 0) {
                    empty++;
                }
            }
        }

        if (empty == 0) {
            System.out.println(0);
        } else {
            selectActiveVirus(0, 0);
            System.out.println(answer == Integer.MAX_VALUE ? -1 : answer); 
        }

    }

    private static void selectActiveVirus(int start, int depth) {
        if (depth == M) {
            bfs(empty);
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            virus[depth] = virusList.get(i);
            selectActiveVirus(i + 1, depth + 1);
        }
    }

    private static void bfs(int cnt) {
        Queue<Virus> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N]; 
        
        for (Virus v : virus) {
        	q.add(new Virus(v.x, v.y, 0));
        	visited[v.x][v.y] = true;
        }

        while (!q.isEmpty()) {
            Virus cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 1) {
                	continue;
                }
                
                q.add(new Virus(nx, ny, cur.time + 1));
                visited[nx][ny] = true;
                
                if (map[nx][ny] == 0) {
                	cnt--;
                }
                
                if (cnt == 0) {
                	answer = Math.min(answer, cur.time + 1);
                	return;
                }

            }
        }

    }
    
    private static boolean isRange(int x, int y) {
    	return x >= 0 && x < N && y >= 0 && y < N;
    }

}