import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        while ((line = br.readLine()) != null) {
            int x = Integer.parseInt(line) * 10000000; // 센티미터를 나노미터로 변환
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int l = Integer.parseInt(br.readLine());
                map.put(l, map.getOrDefault(l, 0) + 1);
            }
            boolean found = map.entrySet().stream().anyMatch(entry -> {
                int l1 = entry.getKey();
                int l2 = x - l1;
                if (map.containsKey(l2)) {
                    if (l1 == l2 && entry.getValue() < 2) {
                        return false;
                    }
                    System.out.println("yes " + Math.min(l1, l2) + " " + Math.max(l1, l2));
                    return true;
                }
                return false;
            });
            if (!found) {
                System.out.println("danger");
            }
        }
    }
}
