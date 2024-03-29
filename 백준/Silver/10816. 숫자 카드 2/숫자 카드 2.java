import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        while (st.hasMoreTokens()) {
            String key = st.nextToken();
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        
        while (st.hasMoreTokens()) {
            String key = st.nextToken();
            if (!map.containsKey(key)) {
                bw.write("0 ");
            } else {
                bw.write(map.get(key) + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
