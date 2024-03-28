import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, String> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] records = br.readLine().split(" ");
            if (!map.containsKey(records[0])) {
                map.put(records[0], records[1]);
            }

            if (records[1].equals("leave")) {
                map.remove(records[0]);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(key);
        }

        result.sort(Collections.reverseOrder());
        for (String name : result) {
            bw.write(name + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}