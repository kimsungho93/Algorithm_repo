import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] A = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        r = Integer.parseInt(inputs[0]);
        c = Integer.parseInt(inputs[1]);
        k = Integer.parseInt(inputs[2]);

        for (int i = 1; i <= 3; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(inputs[j-1]);
            }
        }

        System.out.println(process());
    }

    static int process() {
        int y = 3, x = 3;

        for (int t = 0; t <= 100; t++) {
            if (A[r][c] == k) {
                return t;
            }
            if (y >= x) {
                x = 0;
                for (int i = 1; i <= y; i++) {
                    x = Math.max(x, R(i));
                }
            } else {
                y = 0;
                for (int i = 1; i <= x; i++) {
                    y = Math.max(y, C(i));
                }
            }
        }
        return -1;
    }

    static int R(int i) {
        int[] cnt = new int[101];
        for (int j = 1; j <= 100; j++) {
            cnt[A[i][j]]++;
            A[i][j] = 0;
        }

        List<int[]> list = new ArrayList<>();
        for (int j = 1; j <= 100; j++) {
            if (cnt[j] > 0) {
                list.add(new int[]{j, cnt[j]});
            }
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int idx = 1;
        for (int[] a : list) {
            A[i][idx++] = a[0];
            A[i][idx++] = a[1];
        }

        return idx - 1;
    }

    static int C(int j) {
        int[] cnt = new int[101];
        for (int i = 1; i <= 100; i++) {
            cnt[A[i][j]]++;
            A[i][j] = 0;
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] > 0) {
                list.add(new int[]{i, cnt[i]});
            }
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int idx = 1;
        for (int[] a : list) {
            A[idx++][j] = a[0];
            A[idx++][j] = a[1];
        }

        return idx - 1;
    }
}
