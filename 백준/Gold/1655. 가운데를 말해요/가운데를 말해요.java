import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 최대 힙: 작은 수들을 관리
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 최소 힙: 큰 수들을 관리
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            // 두 힙의 크기를 균등하게 유지
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            
            // 최대 힙의 루트가 최소 힙의 루트보다 크면 두 값을 교환
            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int temp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(temp);
            }
            
            // 최대 힙의 루트는 항상 중간값
            sb.append(maxHeap.peek()).append('\n');
        }
        
        System.out.print(sb.toString());
    }
}
