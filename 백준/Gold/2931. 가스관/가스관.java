import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static int r;
    public static int c;
    public static char[][] map;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static boolean[] pipe;

    public static void main(String[] args) throws IOException {
        readMap();
        simulate();
    }

    public static void simulate() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '.') {
                    continue;
                }

                pipe = new boolean[4];
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (!isValid(nr, nc)) {
                        continue;
                    }
                    pipe[k] = canLink(k, nr, nc);
                }

                char c = getPipe();
                if (c == '0') {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(i + 1).append(' ').append(j + 1).append(' ').append(c);
                System.out.println(sb);
                return;
            }
        }
    }

    public static char getPipe() {
        if (pipe[0] && pipe[1] && pipe[2] && pipe[3]) {
            return '+';
        } else if (pipe[0] && pipe[3]) {
            return '3';
        } else if (pipe[0] && pipe[1]) {
            return '2';
        } else if (pipe[0] && pipe[2]) {
            return '|';
        } else if (pipe[1] && pipe[3]) {
            return '-';
        } else if (pipe[2] && pipe[3]) {
            return '4';
        } else if (pipe[1] && pipe[2]) {
            return '1';
        } else {
            return '0';
        }
    }

    public static boolean isValid(int nr, int nc) {
        return nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] != '.';
    }

    public static boolean canLink(int k, int nr, int nc) {
        switch (k) {
            case 0:
                return map[nr][nc] == '1' || map[nr][nc] == '4' || map[nr][nc] == '+' || map[nr][nc] == '|';
            case 1:
                return map[nr][nc] == '3' || map[nr][nc] == '4' || map[nr][nc] == '+' || map[nr][nc] == '-';
            case 2:
                return map[nr][nc] == '2' || map[nr][nc] == '3' || map[nr][nc] == '+' || map[nr][nc] == '|';
            case 3:
                return map[nr][nc] == '1' || map[nr][nc] == '2' || map[nr][nc] == '+' || map[nr][nc] == '-';
        }
        return false;
    }

    public static void readMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}