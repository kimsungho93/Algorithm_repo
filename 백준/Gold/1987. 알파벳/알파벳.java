import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, maxCount = 0;
    static char[][] board;
    static boolean[][] visited;
    static boolean[] alphabetVisited = new boolean[26];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

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

        dfs(0, 0, 0);
        System.out.println(maxCount);
    }

    private static void dfs(int x, int y, int count) {
        if (!isPossible(x, y) || visited[x][y] || alphabetVisited[board[x][y] - 'A']) {
            return;
        }

        visited[x][y] = true;
        alphabetVisited[board[x][y] - 'A'] = true;
        maxCount = Math.max(maxCount, count + 1);

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i], count + 1);
        }

        visited[x][y] = false;
        alphabetVisited[board[x][y] - 'A'] = false; 
    }

    private static boolean isPossible(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}
