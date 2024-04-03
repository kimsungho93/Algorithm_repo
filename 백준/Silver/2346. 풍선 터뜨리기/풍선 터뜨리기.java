import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 풍선의 수
        String[] input = br.readLine().split(" "); // split 메소드로 입력 분할

        int[] distance = new int[N]; // 각 풍선에서 다음 풍선까지 이동하는 거리
        boolean[] popped = new boolean[N]; // 풍선이 터졌는지 여부를 저장하는 배열

        for (int i = 0; i < N; i++) {
            distance[i] = Integer.parseInt(input[i]); // 문자열을 정수로 변환하여 저장
        }

        int current = 0; // 현재 풍선의 위치
        for (int i = 0; i < N; i++) {
            System.out.print((current + 1) + " "); // 터트린 풍선 출력 (인덱스는 1부터 시작)
            popped[current] = true; // 현재 풍선을 터트림으로 표시

            if (i == N - 1) break; // 마지막 풍선을 터트렸다면 종료

            int step = distance[current]; // 현재 풍선에서의 이동 거리
            int count = 0; // 이동할 풍선 수 카운팅

            while (count < Math.abs(step)) { // 이동 거리만큼 다음 풍선으로 이동
                current += step > 0 ? 1 : -1; // 양수면 오른쪽, 음수면 왼쪽으로 이동

                if (current >= N) current = 0; // 순환 처리
                else if (current < 0) current = N - 1;

                if (!popped[current]) count++; // 아직 터지지 않은 풍선을 만나면 카운트 증가
            }
        }
    }
}
