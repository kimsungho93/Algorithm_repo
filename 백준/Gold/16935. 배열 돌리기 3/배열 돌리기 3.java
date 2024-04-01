import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] matrix;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        int R = Integer.parseInt(firstLine[2]);

        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        String[] operations = br.readLine().split(" ");
        for (int i = 0; i < R; i++) {
            int operation = Integer.parseInt(operations[i]);
            performOperation(operation);
        }

        print();
    }

    // 각 연산을 수행하는 메소드
    static void performOperation(int number) {
        switch (number) {
            case 1:
                calc1();
                break;
            case 2:
                calc2();
                break;
            case 3:
                calc3();
                break;
            case 4:
                calc4();
                break;
            case 5:
                calc5();
                break;
            case 6:
                calc6();
                break;
        }
    }

    // 상하 반전 로직
    static void calc1() {
        for (int i = 0; i < N / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[N - 1 - i];
            matrix[N - 1 - i] = temp;
        }
    }

    // 좌우 반전 로직
    static void calc2() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][M - 1 - j];
                matrix[i][M - 1 - j] = temp;
            }
        }
    }

    // 오른쪽으로 90도 회전 로직
    static void calc3() {
        int[][] tempMatrix = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMatrix[j][N - 1 - i] = matrix[i][j];
            }
        }
        matrix = tempMatrix;
        int temp = N;
        N = M;
        M = temp;
    }

    // 왼쪽으로 90도 회전 로직
    static void calc4() {
        int[][] tempMatrix = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMatrix[M - 1 - j][i] = matrix[i][j];
            }
        }
        matrix = tempMatrix;
        int temp = N;
        N = M;
        M = temp;
    }

    // 부분 행렬을 시계 방향으로 이동 로직
    static void calc5() {
        int[][] tempMatrix = new int[N][M];
        int halfN = N / 2, halfM = M / 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < halfN && j < halfM) tempMatrix[i][j + halfM] = matrix[i][j];
                else if (i < halfN && j >= halfM) tempMatrix[i + halfN][j] = matrix[i][j];
                else if (i >= halfN && j >= halfM) tempMatrix[i][j - halfM] = matrix[i][j];
                else tempMatrix[i - halfN][j] = matrix[i][j];
            }
        }
        matrix = tempMatrix;
    }

    // 부분 행렬을 반시계 방향으로 이동 로직
    static void calc6() {
        int[][] tempMatrix = new int[N][M];
        int halfN = N / 2, halfM = M / 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < halfN && j < halfM) tempMatrix[i + halfN][j] = matrix[i][j];
                else if (i < halfN && j >= halfM) tempMatrix[i][j - halfM] = matrix[i][j];
                else if (i >= halfN && j >= halfM) tempMatrix[i - halfN][j] = matrix[i][j];
                else tempMatrix[i][j + halfM] = matrix[i][j];
            }
        }
        matrix = tempMatrix;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
