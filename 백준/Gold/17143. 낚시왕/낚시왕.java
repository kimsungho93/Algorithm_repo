import java.io.*;
import java.util.*;


public class Main {
    static int R, C, M, result = 0;
    static Shark[][] map;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r, c, s, d, z);
        }

        for (int i = 1; i <= C; i++) {
            catchShark(i);
            moveSharks();
        }

        System.out.println(result);
    }

    static void catchShark(int col) {
        for (int i = 1; i <= R; i++) {
            if (map[i][col] != null) {
                result += map[i][col].size;
                map[i][col] = null;
                break;
            }
        }
    }

    static void moveSharks() {
        Shark[][] newMap = new Shark[R + 1][C + 1];
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (map[r][c] != null) {
                    Shark shark = map[r][c];
                    int move = shark.speed;
                    int direction = shark.direction;
                    int nr = shark.r;
                    int nc = shark.c;

                    if (direction == 1 || direction == 2) { 
                        move %= (R - 1) * 2;
                    } else { 
                        move %= (C - 1) * 2;
                    }

                    for (int m = 0; m < move; m++) {
                        if (nr + dr[direction] < 1 || nr + dr[direction] > R || nc + dc[direction] < 1 || nc + dc[direction] > C) {
                            direction = (direction % 2 == 0) ? direction - 1 : direction + 1; 
                        }
                        nr += dr[direction];
                        nc += dc[direction];
                    }

                    shark.direction = direction; 

                    if (newMap[nr][nc] == null || newMap[nr][nc].size < shark.size) {
                        newMap[nr][nc] = new Shark(nr, nc, shark.speed, direction, shark.size);
                    }
                }
            }
        }
        map = newMap; 
    }
}

class Shark {
    int r, c, speed, direction, size;

    Shark(int r, int c, int speed, int direction, int size) {
        this.r = r;
        this.c = c;
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }
}