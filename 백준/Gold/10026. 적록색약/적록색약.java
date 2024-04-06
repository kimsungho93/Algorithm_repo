import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] grid;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        
        System.out.println(countArea(false) + " " + countArea(true));
    }
    
    private static int countArea(boolean isColorBlind) {
        visited = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j], isColorBlind);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y, char color, boolean isColorBlind) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                if (isColorBlind && (color == 'R' || color == 'G')) {
                    if (grid[nextX][nextY] == 'R' || grid[nextX][nextY] == 'G') {
                        dfs(nextX, nextY, color, isColorBlind);
                    }
                } else if (grid[nextX][nextY] == color) {
                    dfs(nextX, nextY, color, isColorBlind);
                }
            }
        }
    }
}
