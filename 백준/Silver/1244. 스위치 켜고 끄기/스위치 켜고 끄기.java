import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int switchCount = Integer.parseInt(br.readLine());
        String[] state = br.readLine().split(" ");
        int studentCount = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[switchCount + 1];

        for (int i = 1; i <= switchCount; i++) {
            arr[i] = state[i - 1].equals("1");
        }

        for (int i = 0; i < studentCount; i++) {
            String[] input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);

            if (gender == 1) {
                for (int j = num; j <= switchCount; j += num) {
                    arr[j] = !arr[j];
                }
            } else {
                arr[num] = !arr[num];
                int left = num - 1;
                int right = num + 1;
                while (left >= 1 && right <= switchCount && arr[left] == arr[right]) {
                    arr[left] = !arr[left];
                    arr[right] = !arr[right];
                    left--;
                    right++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= switchCount; i++) {
            if (arr[i]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
            if (i % 20 == 0) {
                sb.append("\n");
            } 
        }
        System.out.println(sb);
    }
}