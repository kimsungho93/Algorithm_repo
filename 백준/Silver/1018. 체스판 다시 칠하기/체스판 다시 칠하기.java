import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int minRecolor = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minRecolor = Math.min(minRecolor, findMinRecolor(board, i, j));
            }
        }

        System.out.println(minRecolor);
    }

    private static int findMinRecolor(char[][] board, int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count1 = 0;
        int count2 = 0;

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') count1++;
                    else count2++;
                } else {
                    if (board[i][j] != 'B') count1++;
                    else count2++;
                }
            }
        }

        return Math.min(count1, count2);
    }
}