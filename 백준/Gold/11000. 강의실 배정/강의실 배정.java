import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Class implements Comparable<Class> {
        int start, end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class o) {
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Class[] classes = new Class[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            classes[i] = new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(classes, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Class> pq = new PriorityQueue<>();

        for (Class c : classes) {
            if (!pq.isEmpty() && pq.peek().end <= c.start) {
                pq.poll();
            }
            pq.offer(c);
        }

        System.out.println(pq.size());
    }
}
