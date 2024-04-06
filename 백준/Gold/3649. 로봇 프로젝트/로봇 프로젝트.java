import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int x = Integer.parseInt(input) * 10000000;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] pieces = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                pieces[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(pieces);

            boolean isExist = false;
            for (int i = 0; i < n && !isExist; i++) {
                int target = x - pieces[i];
                int index = Arrays.binarySearch(pieces, target);
                if (index >= 0 && index != i) {
                    System.out.println("yes " + pieces[i] + " " + target);
                    isExist = true;
                }
            }

            if (!isExist) {
                System.out.println("danger");
            }
        }
    }
}