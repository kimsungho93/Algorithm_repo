import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");

        IntStream.range(0, N).forEach(i -> arr[i] = Integer.parseInt(input[i]));
        Arrays.sort(arr);
        int result = IntStream.range(0, N).map(i -> arr[i] * (N - i)).sum();
        System.out.println(result);
    }
}