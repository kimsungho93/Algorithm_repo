import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.util.PriorityQueue;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            String[] priorities = br.readLine().split(" ");

            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(priorities[i]);
                queue.add(new Document(i, priority));
                pq.add(priority);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();

                if (current.priority == pq.peek()) {
                    count++;
                    pq.poll();
                    if (current.index == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.add(current);
                }
            }
        }
    }
}
class Document {
    int index;
    int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}