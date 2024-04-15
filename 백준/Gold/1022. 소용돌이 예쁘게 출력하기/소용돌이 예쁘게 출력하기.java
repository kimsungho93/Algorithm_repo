import java.io.*;
import java.util.Scanner;

public class Main {
    static int r1, c1, r2, c2, max = 0;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        map = new int[r2 - r1 + 1][c2 - c1 + 1];
        fill();
        print();
    }

    public static void fill() {
        int x = 0, y = 0, dir = 0;
        int num = 1, len = 1, cnt = 0;
        while (!endCheck()) {
            if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                map[x - r1][y - c1] = num;
            }
            num++;
            cnt++;
            x = x + dx[dir];
            y = y + dy[dir];
            if (cnt == len) {
                cnt = 0;
                if (dir == 1 || dir == 3) {
                    len++;
                }
                dir = (dir + 1) % 4;
            }
        }
        max = num - 1;
    }

    public static boolean endCheck() {
        return map[0][0] != 0 && map[r2 - r1][0] != 0 && map[0][c2 - c1] != 0 && map[r2 - r1][c2 - c1] != 0;
    }

    public static void print() {
        int maxLen = (int) Math.log10(max);
        int len;
        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                len = maxLen - (int) Math.log10(map[i][j]);
                for (int k = 0; k < len; k++) {
                    System.out.print(" ");
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
