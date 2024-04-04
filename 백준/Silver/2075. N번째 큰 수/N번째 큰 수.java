import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < row.length; j++) {
                pq.add(Integer.parseInt(row[j]));
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                System.out.println(pq.poll());
            } else {
                pq.poll();
            }
        }

    }
}