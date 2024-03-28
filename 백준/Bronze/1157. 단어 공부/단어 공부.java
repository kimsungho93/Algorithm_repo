import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> map = new HashMap<>();

        String word = br.readLine();
        for (String key : word.split("")) {
            key = key.toUpperCase();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = 0;
        String maxKey = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                maxKey = key;
            } else if (map.get(key) == max) {
                maxKey = "?";
            }
        }
        bw.write(maxKey);
        bw.flush();
        bw.close();
        br.close();
    }
}