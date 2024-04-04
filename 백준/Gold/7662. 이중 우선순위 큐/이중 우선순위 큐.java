import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            // 요소의 유효성(삽입된 횟수 - 삭제된 횟수)을 추적
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    minHeap.offer(value);
                    maxHeap.offer(value);
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else if (op.equals("D")) {
                    if (value == 1) {
                        // 최댓값 삭제 처리
                        remove(maxHeap, map);
                    } else {
                        // 최솟값 삭제 처리
                        remove(minHeap, map);
                    }
                }
            }

            // 최종 결과 확인 및 출력
            printResult(minHeap, maxHeap, map);
        }
    }

    private static void remove(PriorityQueue<Integer> heap, HashMap<Integer, Integer> map) {
        while (!heap.isEmpty() && map.getOrDefault(heap.peek(), 0) == 0) {
            heap.poll(); // 이미 삭제된 요소는 건너뛴다
        }
        if (!heap.isEmpty()) {
            int top = heap.poll();
            map.put(top, map.get(top) - 1);
        }
    }

    private static void printResult(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, HashMap<Integer, Integer> map) {
        while (!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(), 0) == 0) {
            minHeap.poll();
        }
        while (!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(), 0) == 0) {
            maxHeap.poll();
        }

        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            System.out.println(maxHeap.peek() + " " + minHeap.peek());
        }
    }
}
