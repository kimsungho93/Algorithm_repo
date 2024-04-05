import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        long[] houses = new long[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(houses);

        long left = 0;
        long right = houses[N - 1] - houses[0];
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            int count = 1;
            long lastHouse = houses[0];

            for (int i = 1; i < houses.length; i++) {
                if (houses[i] - lastHouse >= mid) {
                    count++;
                    lastHouse = houses[i];
                }
            }

            if (count >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}