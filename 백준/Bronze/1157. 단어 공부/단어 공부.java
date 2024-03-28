import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine().toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            if (key >= 97 && key <= 122)
                key = (char) (key - 32);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = 0;
        char maxKey = '?';
        for (char key : map.keySet()) {
            int keyCount = map.get(key);
            if (keyCount > max) {
                max = keyCount;
                maxKey = key;
            } else if (keyCount == max) {
                maxKey = '?';
            }
        }
        bw.write(String.valueOf(maxKey));
        bw.flush();
        br.close();
        bw.close();
    }
}