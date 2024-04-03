import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        boolean[][] apples = new boolean[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apples[r][c] = true;
        }

        int L = Integer.parseInt(br.readLine());
        LinkedList<DirectionChange> moves = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            moves.add(new DirectionChange(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        System.out.println(simulateSnake(N, apples, moves));
    }

    static int simulateSnake(int N, boolean[][] apples, LinkedList<DirectionChange> moves) {
        int time = 0, dir = 1; 
        LinkedList<Position> snake = new LinkedList<>();
        snake.add(new Position(1, 1)); 

        while (true) {
            if (!moves.isEmpty() && time == moves.peek().time) {
                dir = changeDirection(dir, moves.poll().direction);
            }

            time++;
            Position head = snake.peekFirst();
            int nextRow = head.row + dy[dir];
            int nextCol = head.col + dx[dir];

            if (nextRow < 1 || nextRow > N || nextCol < 1 || nextCol > N || contains(snake, nextRow, nextCol)) {
                break;
            }

            snake.addFirst(new Position(nextRow, nextCol)); 

            if (!apples[nextRow][nextCol]) {
                snake.removeLast(); 
            } else {
                apples[nextRow][nextCol] = false; 
            }
        }
        return time;
    }

    static int changeDirection(int dir, char C) {
        if (C == 'L') {
            dir = (dir + 3) % 4;
        } else if (C == 'D') {
            dir = (dir + 1) % 4;
        }
        return dir;
    }

    static boolean contains(LinkedList<Position> snake, int row, int col) {
        for (Position pos : snake) {
            if (pos.row == row && pos.col == col) {
                return true;
            }
        }
        return false;
    }
}

class Position {
    int row, col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class DirectionChange {
    int time;
    char direction;

    DirectionChange(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }
}