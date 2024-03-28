import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            st.nextToken(); 
            String extension = st.nextToken(); 

            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        for (String key : map.keySet()) {
            bw.write(key + " " + map.get(key) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}