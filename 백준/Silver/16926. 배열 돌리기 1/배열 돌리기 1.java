import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int layerR = R % ((N + M - 2 - 4 * layer) * 2); 
            for (int r = 0; r < layerR; r++) {
                rotateLayer(layer);
            }
        }

        printArray();
    }

    private static void rotateLayer(int layer) {
        int temp = arr[layer][layer];
        for (int i = layer; i < M - 1 - layer; i++) {
            arr[layer][i] = arr[layer][i + 1];
        }
        for (int i = layer; i < N - 1 - layer; i++) {
            arr[i][M - 1 - layer] = arr[i + 1][M - 1 - layer];
        }
        for (int i = M - 1 - layer; i > layer; i--) {
            arr[N - 1 - layer][i] = arr[N - 1 - layer][i - 1];
        }
        for (int i = N - 1 - layer; i > layer + 1; i--) {
            arr[i][layer] = arr[i - 1][layer];
        }
        arr[layer + 1][layer] = temp;
    }

    private static void printArray() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}