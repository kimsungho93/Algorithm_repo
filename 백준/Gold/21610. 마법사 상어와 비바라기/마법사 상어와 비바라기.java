import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static boolean[][] clouds;
    static Queue<int[]> cloudQueue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloudQueue.add(new int[] {N - 1, 0});
        cloudQueue.add(new int[] {N - 1, 1});
        cloudQueue.add(new int[] {N - 2, 0});
        cloudQueue.add(new int[] {N - 2, 1});

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            clouds = new boolean[N][N];
            moveAndRain(d, s);
            waterCopyBugMagic();
            makeCloud();
        }

        System.out.println(calcWater());
    }

    private static void moveAndRain(int d, int s) {
        int size = cloudQueue.size();
        for (int i = 0; i < size; i++) {
            int[] cloud = cloudQueue.poll();
            int x = (cloud[0] + dx[d] * s + N * s) % N;
            int y = (cloud[1] + dy[d] * s + N * s) % N;
            map[x][y]++;
            clouds[x][y] = true; 
        }
    }

    private static void waterCopyBugMagic() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (clouds[i][j]) {
                    int count = 0;
                    for (int d = 1; d <= 7; d += 2) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (isPossible(nx, ny)) {
                            count++;
                        }
                    }
                    map[i][j] += count;
                }
            }
        }
    }

    private static void makeCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!clouds[i][j] && map[i][j] >= 2) {
                    cloudQueue.add(new int[] {i, j});
                    map[i][j] -= 2;
                }
            }
        }
    }

    private static int calcWater() {
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total += map[i][j];
            }
        }
        return total;
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > 0;
    }
}
