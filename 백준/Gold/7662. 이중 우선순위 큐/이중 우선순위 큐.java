import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < k; i++) {
                String[] line = br.readLine().split(" ");
                char op = line[0].charAt(0);
                int num = Integer.parseInt(line[1]);

                if (op == 'I') {
                    minHeap.offer(num);
                    maxHeap.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (op == 'D' && !minHeap.isEmpty()) {
                    if (num == 1) {
                        remove(maxHeap, map);
                    } else {
                        remove(minHeap, map);
                    }
                }
            }

            cleanHeaps(minHeap, maxHeap, map);

            if (minHeap.isEmpty() || maxHeap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxHeap.peek() + " " + minHeap.peek());
            }
        }
    }

    private static void remove(PriorityQueue<Integer> heap, HashMap<Integer, Integer> map) {
        while (!heap.isEmpty()) {
            int top = heap.peek();
            if (map.getOrDefault(top, 0) == 0) {
                heap.poll();
            } else {
                map.put(top, map.get(top) - 1);
                if (map.get(top) == 0) {
                    map.remove(top);
                }
                heap.poll();
                break;
            }
        }
    }

    private static void cleanHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, HashMap<Integer, Integer> map) {
        while (!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(), 0) == 0) {
            minHeap.poll();
        }
        while (!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(), 0) == 0) {
            maxHeap.poll();
        }
    }
}
