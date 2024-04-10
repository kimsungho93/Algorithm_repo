import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static final int MAX = 999999;
    static boolean[] buttons = new boolean[10];
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if (M > 0) {
            String[] numbers = br.readLine().split(" ");
            for (String num : numbers) {
                buttons[Integer.parseInt(num)] = true;
            }
        }

        min = Math.abs(N - 100);
        for (int i = 0; i <= MAX; i++) {
            String channel = String.valueOf(i);
            if (canPress(channel)) {
                int count = Math.abs(N - i) + channel.length();
                min = Math.min(min, count);
            }
        }
        System.out.println(min);
    }

    private static boolean canPress(String channel) {
        for (char c : channel.toCharArray()) {
            if (buttons[c - '0']) {
                return false;
            }
        }
        return true;
    }
}
