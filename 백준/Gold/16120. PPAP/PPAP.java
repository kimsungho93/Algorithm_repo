import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c); // 스택에 문자를 추가합니다.
            // 스택의 마지막 4개 문자가 "PPAP"인지 확인합니다.
            if (stack.size() >= 4) {
                boolean isPPAP = true;
                for (int i = 0; i < 4; i++) {
                    if (stack.get(stack.size() - 4 + i) != "PPAP".charAt(i)) {
                        isPPAP = false;
                        break;
                    }
                }
                // "PPAP" 패턴을 만족하면, 해당 부분을 'P' 하나로 대체합니다.
                if (isPPAP) {
                    for (int i = 0; i < 3; i++) stack.pop(); // 'P', 'P', 'A' 제거
                }
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP"); // 스택에 'P' 하나만 남은 경우
        } else {
            System.out.println("NP");
        }
    }
}
