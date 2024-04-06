import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Hcenti = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> giants = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            giants.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (!giants.isEmpty() && T > 0) {
            int top = giants.poll();
            
            // 센티보다 키가 큰 거인만 처리
            if (top >= Hcenti) {
                if (top == 1) { // 키가 1인 경우 더 이상 줄어들지 않음
                    giants.add(top);
                    break;
                }
                top /= 2; // 마법의 뿅망치 사용
                giants.add(top);
                T--;
                count++;
            } else { // 센티보다 작은 거인은 다시 추가할 필요 없음
                giants.add(top);
                break;
            }
        }

        if (giants.stream().anyMatch(h -> h >= Hcenti)) {
            System.out.println("NO");
            System.out.println(giants.peek()); // 가장 큰 거인의 키 출력
        } else {
            System.out.println("YES");
            System.out.println(count); // 사용한 뿅망치 횟수 출력
        }
    }
}
