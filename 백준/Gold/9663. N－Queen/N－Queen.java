import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] row; 
    static int N; 
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        row = new int[N];
        nQueen(0); 
        System.out.println(count); 
    }

    private static void nQueen(int x) {
        if (x == N) { 
            count++; 
            return;
        }

        for (int i = 0; i < N; i++) {
            row[x] = i; 
            if (isPossible(x)) { 
                nQueen(x + 1); 
            }
        }
    }

    private static boolean isPossible(int x) {
        for (int i = 0; i < x; i++) {
            if (row[x] == row[i] || Math.abs(x - i) == Math.abs(row[x] - row[i])) {
                return false;
            }
        }
        return true; 
    }
}
