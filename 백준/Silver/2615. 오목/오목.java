import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static final int SIZE = 19;
    private static int[][] board = new int[SIZE][SIZE]; 
    private static int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}}; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < SIZE; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        if (isWin(i, j, d)) {
                            System.out.println(board[i][j]); 
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean isWin(int x, int y, int dir) {
        int color = board[x][y];
        
        int prevX = x - directions[dir][0];
        int prevY = y - directions[dir][1];
        if (prevX >= 0 && prevX < SIZE && prevY >= 0 && prevY < SIZE && board[prevX][prevY] == color) {
            return false;
        }
        
        int count = 1; 
        int nx = x, ny = y;
        
        while (true) {
            nx += directions[dir][0];
            ny += directions[dir][1];
            
            if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE || board[nx][ny] != color) {
                break;
            }
            count++;
        }
        
        return count == 5;
    }
}
