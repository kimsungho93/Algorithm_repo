import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] arr;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }

        int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int layerR = R % ((N + M - 2 - 4 * layer) * 2);
            for (int r = 0; r < layerR; r++) {
                rotate(layer);
            }
        }
        print();
    }

    private static void rotate(int layer) {
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

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}