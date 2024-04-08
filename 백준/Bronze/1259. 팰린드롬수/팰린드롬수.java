import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            int left = 0, right = input.length() - 1;
            while (left <= right) {
                if (input.charAt(left) != input.charAt(right)) {
                    sb.append("no\n");
                    break;
                }
                left++;
                right--;
                
                if (left > right) {
                    sb.append("yes\n");
                }
            }
        }
        System.out.println(sb);
    }
}