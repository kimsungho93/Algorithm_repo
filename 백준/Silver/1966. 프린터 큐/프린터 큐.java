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
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // 문서의 수
            int M = Integer.parseInt(line[1]); // 관심 있는 문서의 위치
            String[] priorities = br.readLine().split(" ");

            Queue<Document> queue = new LinkedList<>(); // FIFO 큐
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 중요도를 내림차순으로 정렬하는 우선순위 큐

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(priorities[i]);
                queue.add(new Document(i, priority));
                priorityQueue.add(priority);
            }

            int printCount = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();

                // 현재 문서가 가장 중요도가 높다면 인쇄
                if (current.priority == priorityQueue.peek()) {
                    printCount++;
                    priorityQueue.poll(); // 인쇄되었으므로 우선순위 큐에서도 제거
                    if (current.index == M) { // 관심 있는 문서가 인쇄되었다면
                        System.out.println(printCount);
                        break;
                    }
                } else {
                    queue.add(current); // 중요도가 더 높은 문서가 있다면 큐의 끝으로 다시 추가
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