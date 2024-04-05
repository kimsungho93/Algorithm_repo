import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] before = new int[N];
        for (int i = 0; i < N; i++) {
            before[i] = Integer.parseInt(input[i]);
        }

        int[] compArr = Arrays.copyOf(before, N);
        Arrays.sort(compArr);

        int[] distinctArr = Arrays.stream(compArr).distinct().toArray();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < distinctArr.length; i++) {
            map.put(distinctArr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(before[i])).append(' ');
        }

        System.out.println(sb);
    }
}
