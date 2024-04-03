import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 타워의 수

        String[] heights = br.readLine().split(" ");
        Stack<Tower> stack = new Stack<>();
        int[] answer = new int[N]; // 각 타워에서 수신하는 타워의 번호를 저장할 배열

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(heights[i]); // 현재 타워의 높이

            while (!stack.isEmpty()) {
                // 스택이 비어있지 않고, 현재 타워의 높이가 스택의 top에 있는 타워의 높이보다 크면
                // 스택에서 해당 타워를 제거
                if (stack.peek().height < height) {
                    stack.pop();
                } else {
                    // 현재 타워의 높이가 스택의 top에 있는 타워의 높이보다 작거나 같으면
                    // 스택의 top에 있는 타워가 현재 타워의 신호를 수신
                    answer[i] = stack.peek().index + 1;
                    break;
                }
            }

            // 현재 타워를 스택에 추가
            stack.push(new Tower(i, height));
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

class Tower {
    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}