import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 1; i <= 9; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <= 9; j++) {
                int value = Integer.parseInt(row[j-1]);
                if (value > max) {
                    max = value;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxRow + " " + maxCol);
    }
}