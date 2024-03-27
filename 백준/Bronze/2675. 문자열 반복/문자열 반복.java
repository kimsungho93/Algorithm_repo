import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[0]);
            String S = input[1];

            StringBuilder P = new StringBuilder();
            for (char c : S.toCharArray()) {
                for (int j = 0; j < R; j++) {
                    P.append(c);
                }
            }
            System.out.println(P);
        }
    }
}