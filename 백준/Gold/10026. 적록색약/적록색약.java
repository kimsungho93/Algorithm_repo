import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[][] grid;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        
        System.out.println(countZones(false) + " " + countZones(true));
    }
    
    static int countZones(boolean colorBlindness) {
        visited = new boolean[N][N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j], colorBlindness);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    static void dfs(int x, int y, char color, boolean colorBlindness) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                if (colorBlindness && (color == 'R' || color == 'G')) {
                    if (grid[nx][ny] == 'R' || grid[nx][ny] == 'G') {
                        dfs(nx, ny, color, colorBlindness);
                    }
                } else if (grid[nx][ny] == color) {
                    dfs(nx, ny, color, colorBlindness);
                }
            }
        }
    }
}
