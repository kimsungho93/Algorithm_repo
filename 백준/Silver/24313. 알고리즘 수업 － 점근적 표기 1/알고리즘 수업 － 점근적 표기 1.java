import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int a1 = Integer.parseInt(line[0]); 
        int a0 = Integer.parseInt(line[1]); 
        int c = Integer.parseInt(br.readLine()); 
        int n0 = Integer.parseInt(br.readLine());

        if (checkOnotation(a1, a0, c, n0)) {
            System.out.println(1); 
        } else {
            System.out.println(0); 
        }
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
