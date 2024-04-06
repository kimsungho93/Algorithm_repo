import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long X = Long.parseLong(input[0]);
        long Y = Long.parseLong(input[1]);

        long initialRate = (Y * 100) / X;

        if (initialRate >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = X;
        long result = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long newRate = ((Y + mid) * 100) / (X + mid);

            if (newRate > initialRate) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}