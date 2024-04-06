import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.offer(new Tomato(m, n, h));
                        visited[h][n][m] = true;
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int days = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tomato current = queue.poll();

                for (int j = 0; j < 6; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];
                    int nz = current.z + dz[j];

                    if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                        if (!visited[nz][ny][nx] && box[nz][ny][nx] == 0) {
                            visited[nz][ny][nx] = true;
                            box[nz][ny][nx] = 1;
                            queue.offer(new Tomato(nx, ny, nz));
                        }
                    }
                }
            }
            days++;
        }

        if (checkAllRipen()) return days;
        else return -1;
    }

    static boolean checkAllRipen() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) return false;
                }
            }
        }
        return true;
    }
}

 class Tomato {
    int x, y, z;

    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
