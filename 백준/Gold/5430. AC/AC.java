import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        while (T-- > 0) {
            String functions = br.readLine(); 
            int n = Integer.parseInt(br.readLine()); 
            String nums = br.readLine(); 
            nums = nums.substring(1, nums.length() - 1);
            String[] splitNums = nums.split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.addLast(Integer.parseInt(splitNums[i]));
            }

            boolean isReversed = false;
            boolean hasError = false;

            for (char function : functions.toCharArray()) {
                if (function == 'R') {
                    isReversed = !isReversed;
                } else if (function == 'D') {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        hasError = true;
                        break;
                    } else {
                        if ((isReversed)) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                }
            }

            if (!hasError) {
                printResult(deque, isReversed);
            }
        }
    }

    static void printResult(Deque<Integer> deque, boolean isReversed) {
        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
            if (deque.size() >= 1) sb.append(",");
        }
        sb.append("]");
        System.out.println(sb);
    }
}