import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            
            sb.append(getCost(pq)).append('\n');
        }
        System.out.println(sb);
    }

    private static long getCost(PriorityQueue<Long> pq) {
        if (pq.size() == 1) {
            return pq.poll();
        }

        long result = 0;
        while (pq.size() > 1) {
            long sum = pq.poll() + pq.poll();
            result += sum;
            pq.offer(sum);
        }
        
        return result;
    }
}
    
