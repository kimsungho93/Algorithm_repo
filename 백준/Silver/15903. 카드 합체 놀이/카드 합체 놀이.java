import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.LongStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int m = Integer.parseInt(input[1]);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        String[] cards = br.readLine().split(" ");
        Arrays.stream(cards).mapToLong(Long::parseLong).forEach(pq::add);

        LongStream.range(0, m).forEach(i -> {
            long first = pq.poll();
            long second = pq.poll();
            pq.add(first + second);
            pq.add(first + second);
        });

        long sum = pq.stream().mapToLong(Long::longValue).sum();
        System.out.println(sum);
    }
}