import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        double avg = getAverage(arr);
        int mid = arr[N / 2];
        int mostFreq = getMostFreq(arr);
        int range = arr[N - 1] - arr[0];

        if (Math.abs(avg) < 0.5) {
            System.out.println("0");
        } else {
            System.out.printf("%.0f\n", avg);
        }

        System.out.println(mid);
        System.out.println(mostFreq);
        System.out.println(range);
    }

    private static double getAverage(int[] arr) {
        return IntStream.of(arr).average().getAsDouble();
    }

    private static int getMostFreq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxFrequency = map.values().stream().max(Integer::compare).orElse(0);
        List<Integer> modes = map.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
        return modes.size() > 1 ? modes.get(1) : modes.get(0);
    }
}
