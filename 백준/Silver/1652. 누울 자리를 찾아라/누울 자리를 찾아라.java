import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().toCharArray();
        }

        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) horizontal++;
                    count = 0;
                }
            }
            if (count >= 2) horizontal++;
        }

        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) vertical++;
                    count = 0;
                }
            }
            if (count >= 2) vertical++;
        }

        System.out.println(horizontal + " " + vertical);
    }
}