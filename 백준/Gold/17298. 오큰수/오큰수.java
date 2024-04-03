import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 배열의 크기 입력 받기
        int[] A = new int[N]; // 배열 A 선언
        int[] NGE = new int[N]; // 결과 저장할 배열 선언
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]); // 배열 A 초기화
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                // 스택이 비어있지 않고, 현재 요소가 스택의 top 요소보다 클 때
                NGE[stack.pop()] = A[i]; // NGE 업데이트
            }
            stack.push(i); // 현재 인덱스 스택에 push
        }

        while (!stack.isEmpty()) {
            // 스택에 남아있는 요소들의 NGE는 -1
            NGE[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(NGE[i]).append(' '); // 결과 문자열 생성
        }

        System.out.println(sb); // 결과 출력
    }
}
