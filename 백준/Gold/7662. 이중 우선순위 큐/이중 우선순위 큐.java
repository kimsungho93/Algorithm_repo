import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char operation = input[0].charAt(0);
                int num = Integer.parseInt(input[1]);

                if (operation == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (operation == 'D') {
                    if (map.isEmpty()) continue;

                    int key = (num == 1) ? map.lastKey() : map.firstKey();
                    int count = map.get(key) - 1;

                    if (count > 0) {
                        map.put(key, count);
                    } else {
                        map.remove(key);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
            map.clear();
        }
        System.out.println(sb);
    }
}
