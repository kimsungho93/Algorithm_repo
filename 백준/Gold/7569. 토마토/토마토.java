import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static Queue<int[]> queue = new LinkedList<>();
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
        int totalCount = 0, ripeCount = 0;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] != -1) totalCount++;
                    if (box[h][n][m] == 1) {
                        queue.add(new int[]{m, n, h});
                        ripeCount++;
                    }
                }
            }
        }

        int days = 0;
        while (!queue.isEmpty() && ripeCount < totalCount) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int nx = cur[0] + dx[j], ny = cur[1] + dy[j], nz = cur[2] + dz[j];
                    if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H && box[nz][ny][nx] == 0) {
                        queue.add(new int[]{nx, ny, nz});
                        box[nz][ny][nx] = 1;
                        ripeCount++;
                    }
                }
            }
            days++;
        }

        System.out.println(ripeCount == totalCount ? days : -1);
    }
}
