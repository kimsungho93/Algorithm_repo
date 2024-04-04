import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 숫자 카드 묶음의 수
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙

        // 입력 받은 카드 묶음 크기를 우선순위 큐에 추가
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0; // 비교 횟수 합계

        // 우선순위 큐에서 가장 작은 두 개의 묶음을 계속해서 꺼내어 합침
        while (pq.size() > 1) {
            int first = pq.poll(); // 가장 작은 묶음
            int second = pq.poll(); // 두 번째로 작은 묶음

            result += first + second; // 두 묶음을 합치는데 필요한 비교 횟수를 더함
            pq.add(first + second); // 합친 묶음을 다시 우선순위 큐에 추가
        }

        System.out.println(result); // 최소 비교 횟수 출력
    }
}
