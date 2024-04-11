import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static ArrayList<BlockGroup> groups;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int score = 0;

    static class BlockGroup {
        int rainbow, baseX, baseY, totalBlocks;
        ArrayList<int[]> blocks = new ArrayList<>();

        BlockGroup(int baseX, int baseY) {
            this.baseX = baseX;
            this.baseY = baseY;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            groups = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] > 0 && !visited[i][j]) {
                        findBlockGroups(i, j);
                    }
                }
            }

            if (groups.isEmpty()) break;
            removeLargestGroup();
            gravity();
            rotate();
            gravity();
        }

        System.out.println(score);
    }

    static void findBlockGroups(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        BlockGroup group = new BlockGroup(x, y);
        int color = grid[x][y];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1];
            group.blocks.add(new int[]{cx, cy});
            group.totalBlocks++;
            if (grid[cx][cy] == 0) group.rainbow++;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && (grid[nx][ny] == 0 || grid[nx][ny] == color)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        for (int[] block : group.blocks) {
            if (grid[block[0]][block[1]] == 0) visited[block[0]][block[1]] = false;
        }

        if (group.totalBlocks >= 2) groups.add(group);
    }

    static void removeLargestGroup() {
        groups.sort((a, b) -> {
            if (a.totalBlocks == b.totalBlocks) {
                if (a.rainbow == b.rainbow) {
                    if (a.baseX == b.baseX) return b.baseY - a.baseY;
                    return b.baseX - a.baseX;
                }
                return b.rainbow - a.rainbow;
            }
            return b.totalBlocks - a.totalBlocks;
        });

        BlockGroup largest = groups.get(0);
        score += largest.totalBlocks * largest.totalBlocks;
        for (int[] block : largest.blocks) {
            grid[block[0]][block[1]] = -2; 
        }
    }

    static void gravity() {
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (grid[i][j] >= 0) {
                    int nx = i;
                    while (nx + 1 < N && grid[nx + 1][j] == -2) {
                        nx++;
                    }
                    if (nx != i) {
                        grid[nx][j] = grid[i][j];
                        grid[i][j] = -2;
                    }
                }
            }
        }
    }

    static void rotate() {
        int[][] newGrid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newGrid[N - 1 - j][i] = grid[i][j];
            }
        }
        grid = newGrid;
    }
}
