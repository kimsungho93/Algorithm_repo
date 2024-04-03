import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            String functions = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열의 크기
            String nums = br.readLine(); // 배열 원소
            nums = nums.substring(1, nums.length() - 1);
            String[] splitNums = nums.split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.addLast(Integer.parseInt(splitNums[i])); // Deque에 원소 추가
            }

            boolean isReversed = false; // 뒤집힘 상태 표시
            boolean hasError = false; // 에러 발생 여부

            for (char function : functions.toCharArray()) {
                if (function == 'R') {
                    isReversed = !isReversed; // 뒤집힘 상태 토글
                } else if (function == 'D') {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        hasError = true;
                        break;
                    } else {
                        if (isReversed) {
                            deque.removeLast(); // 뒤에서 원소 제거
                        } else {
                            deque.removeFirst(); // 앞에서 원소 제거
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
