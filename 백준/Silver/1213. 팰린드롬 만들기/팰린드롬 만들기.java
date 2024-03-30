import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine(); 
        int[] counts = new int[26];
        for (char c : name.toCharArray()) {
            counts[c - 'A']++; 
        }

        int oddCount = 0; 
        char mid = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 == 1) {
                oddCount++;
                mid = (char) (i + 'A');
                counts[i]--;
            }
            if (oddCount > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
            for (int j = 0; j < counts[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        String front = sb.toString();
        String back = sb.reverse().toString();
        System.out.println(front + (mid == 0 ? "" : mid) + back);
    }
}