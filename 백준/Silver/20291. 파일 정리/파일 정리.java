import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String fileName = st.nextToken();
            String extension = st.nextToken();

            if (!map.containsKey(extension)) {
                map.put(extension, map.getOrDefault(extension, 0) + 1);
            } else {
                map.put(extension, map.get(extension) + 1);
            }
        }

        map.entrySet().stream()
            .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
            .forEach(e -> {
                try {
                    bw.write(e.getKey() + " " + e.getValue() + "\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        bw.flush();
        br.close();
        bw.close();
    }
}