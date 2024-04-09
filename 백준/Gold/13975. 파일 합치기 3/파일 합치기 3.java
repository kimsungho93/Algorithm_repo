import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            TreeMap<Long, Integer> map = new TreeMap<>();

            for (int i = 0; i < K; i++) {
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            long totalCost = 0;
            while (map.size() > 1) {
                long firstNum = map.firstKey();
                map.put(firstNum, map.get(firstNum) - 1);
                if (map.get(firstNum) == 0) {
                    map.remove(firstNum);
                }

                long secondNum = map.firstKey();
                map.put(secondNum, map.get(secondNum) - 1);
                if (map.get(secondNum) == 0) {
                    map.remove(secondNum);
                }

                long sum = firstNum + secondNum;
                totalCost += sum;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            System.out.println(totalCost);
        }
    }
}