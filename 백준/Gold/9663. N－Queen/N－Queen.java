import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int count = 0;
    static boolean[] visitedCol;
    static boolean[] visitedDiag1;
    static boolean[] visitedDiag2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        visitedCol = new boolean[N];
        visitedDiag1 = new boolean[2 * N - 1];
        visitedDiag2 = new boolean[2 * N - 1];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int row) {
        if (row == N) {
            count++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (!visitedCol[col] && !visitedDiag1[row + col] && !visitedDiag2[row - col + N - 1]) {
                visitedCol[col] = visitedDiag1[row + col] = visitedDiag2[row - col + N - 1] = true;
                nQueen(row + 1);
                visitedCol[col] = visitedDiag1[row + col] = visitedDiag2[row - col + N - 1] = false;
            }
        }
    }
}