import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static Point hedgehog, destination;
    static Queue<Point> water = new LinkedList<>();
    static Queue<Point> hedgehogQueue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    hedgehog = new Point(i, j);
                    hedgehogQueue.offer(hedgehog);
                    visited[i][j] = true;
                } else if (map[i][j] == '*') {
                    water.offer(new Point(i, j));
                } else if (map[i][j] == 'D') {
                    destination = new Point(i, j);
                }
            }
        }
        int escapeTime = escape();
        System.out.println((escapeTime == -1) ? "KAKTUS" : escapeTime);
    }

    private static int escape() {
        int time = 0;
        while (!hedgehogQueue.isEmpty()) {
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                Point current = water.poll();
                spreadWater(current.x, current.y);
            }

            int hedgehogSize = hedgehogQueue.size();
            for (int i = 0; i < hedgehogSize; i++) {
                Point currentHedgehog = hedgehogQueue.poll();
                if (move(currentHedgehog.x, currentHedgehog.y)) {
                    return time + 1;
                }
            }
            time++;
        }
        return -1;
    }

    private static void spreadWater(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && map[nextX][nextY] == '.') {
                map[nextX][nextY] = '*';
                water.offer(new Point(nextX, nextY));
            }
        }
    }

    private static boolean move(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
                if (map[nextX][nextY] == 'D') {
                    return true;
                }
                if (map[nextX][nextY] == '.' && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    hedgehogQueue.offer(new Point(nextX, nextY));
                }
            }
        }
        return false;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}