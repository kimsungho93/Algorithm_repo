import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(arr);
        
        int left = 0;
        int right = N - 1;
        long cursorL = arr[left], cursorR = arr[right];
        long min = Math.abs(cursorL + cursorR);

        while (left < right) {
            long sum = arr[left] + arr[right];
            long diff = Math.abs(sum);

            if (diff < min) {
                min = diff;
                cursorL = arr[left];
                cursorR = arr[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(cursorL + " " + cursorR);
    }
}