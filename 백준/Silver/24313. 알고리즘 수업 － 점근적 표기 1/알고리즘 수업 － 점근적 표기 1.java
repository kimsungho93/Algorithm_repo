import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        if (checkOnotation(a1, a0, c, n0)) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean checkOnotation(int a1, int a0, int c, int n0) {
        for (int n = n0; n <= n0 + 100; n++) {
            if (a1 * n + a0 > c * n) {
                return false;
            }
        }
        return true;
    }
}
