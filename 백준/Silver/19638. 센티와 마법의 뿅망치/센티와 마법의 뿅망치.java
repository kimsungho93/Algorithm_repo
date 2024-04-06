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
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (!pq.isEmpty() && T > 0) {
            int top = pq.poll();

            if (top >= H) {
                if (top == 1) {
                    pq.add(top);
                    break;
                }
                top /= 2;
                pq.add(top);
                T--;
                count++;
            } else {
                pq.add(top);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (!pq.isEmpty() && pq.peek() >= H) {
            sb.append("NO\n");
            sb.append(pq.peek()).append("\n");
        } else {
            sb.append("YES\n");
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
