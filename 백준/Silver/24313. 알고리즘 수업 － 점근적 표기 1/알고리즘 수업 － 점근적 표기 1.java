import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(br.readLine()); 
        int n0 = Integer.parseInt(br.readLine());

        boolean isSatisfied = true;
        for (int n = n0; n <= n0 + 100; n++) {
            if (a1 * n + a0 > c * n) {
                isSatisfied = false;
                break;
            }
        }

        System.out.println(isSatisfied ? 1 : 0);
    }
}
