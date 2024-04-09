import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] lab;
    static int maxSafeArea = 0;
    static LinkedList<Position> virusList = new LinkedList<>();
    static LinkedList<Position> emptyList = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) virusList.add(new Position(i, j));
                else if (lab[i][j] == 0) emptyList.add(new Position(i, j));
            }
        }

        placeWalls(0, 0);
        System.out.println(maxSafeArea);
    }

    private static void placeWalls(int start, int count) {
        if (count == 3) {
            maxSafeArea = Math.max(maxSafeArea, simulate());
            return;
        }

        for (int i = start; i < emptyList.size(); i++) {
            Position cell = emptyList.get(i);
            lab[cell.x][cell.y] = 1;
            placeWalls(i + 1, count + 1);
            lab[cell.x][cell.y] = 0;
        }
    }

    static int simulate() {
        Queue<Position> queue = new ArrayDeque<>(virusList);
        boolean[][] visited = new boolean[N][M];
        virusList.forEach(virus -> visited[virus.x][virus.y] = true);

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (isPossible(nx, ny, visited)) {
                    visited[nx][ny] = true;
                    queue.add(new Position(nx, ny));
                }
            }
        }

        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0 && !visited[i][j]) safeArea++;
            }
        }
        return safeArea;
    }

    private static boolean isPossible(int nx, int ny, boolean[][] visited) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M && lab[nx][ny] == 0 && !visited[nx][ny];
    }
}

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
