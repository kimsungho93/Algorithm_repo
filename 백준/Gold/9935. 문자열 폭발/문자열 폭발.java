import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 주어진 문자열 입력 받기
        String bomb = br.readLine(); // 폭발 문자열 입력 받기
        
        String result = explodeString(input, bomb);
        System.out.println(result.isEmpty() ? "FRULA" : result);
    }
    
    private static String explodeString(String input, String bomb) {
        Stack<Character> stack = new Stack<>();
        int bombLength = bomb.length();
        
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i)); // 문자 하나씩 스택에 추가
            
            // 폭발 문자열이 스택의 끝에 있을 경우 제거
            if (stack.size() >= bombLength && isBombAtStackEnd(stack, bomb)) {
                for (int j = 0; j < bombLength; j++) stack.pop();
            }
        }
        
        // 최종 결과 문자열 생성
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
    
    // 스택의 끝에서 폭발 문자열 확인
    private static boolean isBombAtStackEnd(Stack<Character> stack, String bomb) {
        for (int i = 0; i < bomb.length(); i++) {
            if (stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) {
                return false; // 폭발 문자열과 일치하지 않음
            }
        }
        return true; // 폭발 문자열과 일치
    }
}
