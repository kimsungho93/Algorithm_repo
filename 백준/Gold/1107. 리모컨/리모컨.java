import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int targetChannel;
    static int brokenButtonCnt;
    static final int MAX = 999999;
    static boolean[] buttons = new boolean[10];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        targetChannel = Integer.parseInt(br.readLine());
        brokenButtonCnt = Integer.parseInt(br.readLine());

        if (brokenButtonCnt > 0) {
            String[] numbers = br.readLine().split(" ");
            for (String num : numbers) {
                buttons[Integer.parseInt(num)] = true;
            }
        }

        result = Math.abs(targetChannel - 100);
        for (int i = 0; i <= MAX; i++) {
            String channel = String.valueOf(i);
            if (canPress(channel)) {
                int count = Math.abs(targetChannel - i) + channel.length();
                result = Math.min(result, count);
            }
        }
        System.out.println(result);
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
