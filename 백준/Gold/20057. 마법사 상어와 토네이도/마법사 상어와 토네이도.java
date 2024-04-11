import java.io.*;
import java.util.*;

public class Main {
    static int gridSize, total = 0;
    static int[][] grid;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] nextDirection = {2, 3, 1, 0};
    static int[][] sandX = {{1, 1, 0, 0, -2, 0, 0, -1, -1, -1}, {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1},
            {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}};
    static int[][] sandY = {{-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0},
            {1, 1, 0, 0, -2, 0, 0, -1, -1, -1}, {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1}};
    static int[] rates = {1, 1, 2, 2, 5, 7, 7, 10, 10};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gridSize = Integer.parseInt(br.readLine());
        grid = new int[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < gridSize; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }
        simulate();
        System.out.println(total);
    }

    private static void simulate() {
        int currentX = gridSize / 2;
        int currentY = gridSize / 2;
        int curDirection = 2;
        int nx = 0;
        int ny = 0;
        int moveCount = 1;
        int moved = 0;
        int check = 0;

        while (true) {
            if (currentX == 0 && currentY == 0) {
                break;
            }
            nx = currentX + dx[curDirection];
            ny = currentY + dy[curDirection];
            moved++;
            spreadSand(currentX, currentY, nx, ny, curDirection);

            if (moveCount == moved) {
                moved = 0;
                curDirection = nextDirection[curDirection];
                check++;
            }
            if (check == 2) {
                check = 0;
                moveCount++;
            }
            currentX = nx;
            currentY = ny;
        }
    }

    private static void spreadSand(int curX, int curY, int nx, int ny, int curDirection) {
        grid[nx][ny] += grid[curX][curY];
        grid[curX][curY] = 0;
        int sand = grid[nx][ny];
        int remainingSand = sand;
        int spreadX = 0;
        int spreadY = 0;

        for (int i = 0; i < 9; i++) {
            spreadX = nx + sandX[curDirection][i];
            spreadY = ny + sandY[curDirection][i];
            int amount = (int) (sand * (rates[i] * 0.01));

            checkAndAddSand(spreadX, spreadY, amount);
            remainingSand -= amount;
        }
        int remainSandX = nx + sandX[curDirection][9];
        int remainSandY = ny + sandY[curDirection][9];
        checkAndAddSand(remainSandX, remainSandY, remainingSand);
        grid[nx][ny] = 0;
    }

    private static void checkAndAddSand(int spreadX, int spreadY, int amount) {
        if (canMove(spreadX, spreadY))
            total += amount;
        else {
            grid[spreadX][spreadY] += amount;
        }
    }

    private static boolean canMove(int spreadX, int spreadY) {
        return spreadX < 0 || spreadX >= gridSize || spreadY < 0 || spreadY >= gridSize;
    }
}