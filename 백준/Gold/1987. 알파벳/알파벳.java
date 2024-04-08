import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int maxCount = 0;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0);
        System.out.println(maxCount);
    }

    private static void dfs(int x, int y) {
        if (!isPossible(x, y) || visited[x][y] || set.contains(board[x][y])) {
            return;
        }

        visited[x][y] = true;
        set.add(board[x][y]);

        maxCount = Math.max(maxCount, set.size()); 

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }

        visited[x][y] = false; 
        set.remove(board[x][y]); 
    }

    private static boolean isPossible(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}
