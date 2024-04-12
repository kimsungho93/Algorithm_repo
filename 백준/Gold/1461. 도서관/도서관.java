import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer> positive = new ArrayList<>();
    static ArrayList<Integer> negative = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > 0) {
                positive.add(temp);
            } else {
                negative.add(-temp); 
            }
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative, Collections.reverseOrder());

        int maxDistance = 0;
        if (!positive.isEmpty() && !negative.isEmpty()) {
            maxDistance = Math.max(positive.get(0), negative.get(0));
        } else if (!positive.isEmpty()) {
            maxDistance = positive.get(0);
        } else if (!negative.isEmpty()) {
            maxDistance = negative.get(0);
        }

        int totalSteps = 0;

        for (int i = 0; i < positive.size(); i += M) {
            totalSteps += 2 * positive.get(i);
        }
 
        for (int i = 0; i < negative.size(); i += M) {
            totalSteps += 2 * negative.get(i);
        }

        totalSteps -= maxDistance;
        System.out.println(totalSteps);
    }
}
